package app.domain;


public class Currency {
    private Double fromAmount;
    private Double convertedAmount;
    private String currencySymbol;

    public Currency() {
    }

    public Currency(Double fromAmount, Double convertedAmount, String currencySymbol) {
        this.fromAmount = fromAmount;
        this.convertedAmount = convertedAmount;
        this.currencySymbol = currencySymbol;
    }

    public Double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(Double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "fromAmount=" + fromAmount +
                ", convertedAmount=" + convertedAmount +
                ", currencySymbol='" + currencySymbol + '\'' +
                '}';
    }
}
