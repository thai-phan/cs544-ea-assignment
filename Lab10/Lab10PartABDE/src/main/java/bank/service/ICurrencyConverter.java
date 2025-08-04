package bank.service;

public interface ICurrencyConverter {
  double euroToDollars(double amount);

  double dollarsToEuros(double amount);
}
