package search;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class AIRequestLogInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        // Log what we're sending to the AI service
        logAIRequest(request, body);

        // Make the actual call to the AI service
        ClientHttpResponse response = execution.execute(request, body);

        // Create a wrapper that lets us read the response twice
        BufferedResponseWrapper responseWrapper = new BufferedResponseWrapper(response);

        // Log what the AI service sent back
        logAIResponse(responseWrapper);

        return responseWrapper;
    }

    private void logAIRequest(HttpRequest request, byte[] body) {
        System.out.println("AI REQUEST: method ="+ request.getMethod()+" , URL="+ request.getURI());
        String bodyText = new String(body, StandardCharsets.UTF_8);
        System.out.println("BODY: "+ bodyText);
    }

    private void logAIResponse(ClientHttpResponse response) throws IOException {
        System.out.println("AI RESPONSE STATUS: Statuscode ="+ response.getStatusCode()+" Status text ="+ response.getStatusText());
        String responseBody = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println("BODY:"+ responseBody.trim());
    }

    // This wrapper class allows us to read the response body twice
    private static class BufferedResponseWrapper implements ClientHttpResponse {
        private final ClientHttpResponse original;
        private final byte[] body;

        public BufferedResponseWrapper(ClientHttpResponse response) throws IOException {
            this.original = response;
            this.body = StreamUtils.copyToByteArray(response.getBody());
        }

        @Override
        public InputStream getBody() {
            return new ByteArrayInputStream(body);
        }

        @Override
        public HttpStatusCode getStatusCode() throws IOException {
            return original.getStatusCode();
        }


        @Override
        public String getStatusText() throws IOException {
            return original.getStatusText();
        }

        @Override
        public org.springframework.http.HttpHeaders getHeaders() {
            return original.getHeaders();
        }

        @Override
        public void close() {
            original.close();
        }
    }
}