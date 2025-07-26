package bank.service.dto;


import java.util.Date;


public record AccountEntryDTO(
    Date date,
    double amount,
    String description,
    String fromAccountNumber,
    String fromPersonName
) {
}

