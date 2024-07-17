package br.com.alura.challange;

public class CurrencyConverter {
    private ExchangeRateService exchangeRateService;
    private LogService logService;

    public CurrencyConverter() {
        this.exchangeRateService = new ExchangeRateService();
        this.logService = new LogService();
    }

    public String convert(int choice, double amount) {
        String fromCurrency = "";
        String toCurrency = "";

        switch (choice) {
            case 1:
                fromCurrency = "USD";
                toCurrency = "ARS";
                break;
            case 2:
                fromCurrency = "ARS";
                toCurrency = "USD";
                break;
            case 3:
                fromCurrency = "USD";
                toCurrency = "BRL";
                break;
            case 4:
                fromCurrency = "BRL";
                toCurrency = "USD";
                break;
            case 5:
                fromCurrency = "USD";
                toCurrency = "COP";
                break;
            case 6:
                fromCurrency = "COP";
                toCurrency = "USD";
                break;
            default:
                return "Opção inválida";
        }

        double rate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        double convertedAmount = amount * rate;
        ConversionRecord record = new ConversionRecord(fromCurrency, toCurrency, amount, convertedAmount);
        logService.log(record);

        return String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
    }
}

