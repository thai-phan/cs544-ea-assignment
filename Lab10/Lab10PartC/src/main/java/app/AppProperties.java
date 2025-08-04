package app;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Component;

//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "app")
@Validated
public class AppProperties {

  @NotBlank
  private String name;

  @NotBlank
  private String version;

  @Valid
  private Server server;

  @Valid
  private User user;

  @NotEmpty
  private List<@NotBlank String> countries;

  public static class Server {

    @NotBlank
    private String url;

    @NotBlank
    private String name;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
  }

  public static class User {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    @Size(min = 8, max = 15)
    private String username;

    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
  }

  // Getters and Setters for main class
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getVersion() { return version; }
  public void setVersion(String version) { this.version = version; }

  public Server getServer() { return server; }
  public void setServer(Server server) { this.server = server; }

  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }

  public List<String> getCountries() { return countries; }
  public void setCountries(List<String> countries) { this.countries = countries; }
}
