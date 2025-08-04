package bank.service.adapter;

import bank.domain.AccountEntry;
import bank.service.dto.AccountEntryDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountEntryAdapter {

  public static AccountEntry getAccountEntryFromDTO(AccountEntryDTO accountEntryDTO) {
    return new AccountEntry(accountEntryDTO.date(),
        accountEntryDTO.amount(),
        accountEntryDTO.description(),
        accountEntryDTO.fromAccountNumber(),
        accountEntryDTO.fromPersonName());
  }

  public static AccountEntryDTO getDTOFromAccountEntry(AccountEntry accountEntry) {
    return new AccountEntryDTO(accountEntry.getDate(),
        accountEntry.getAmount(),
        accountEntry.getDescription(),
        accountEntry.getFromAccountNumber(),
        accountEntry.getFromPersonName());
  }

  public static List<AccountEntryDTO> getDTOsFromContacts(List<AccountEntry> accountEntries) {
    List<AccountEntryDTO> accountDTOS = new ArrayList<>();
    for (AccountEntry accountEntry : accountEntries) {
      accountDTOS.add(getDTOFromAccountEntry(accountEntry));
    }
    return accountDTOS;
  }
}