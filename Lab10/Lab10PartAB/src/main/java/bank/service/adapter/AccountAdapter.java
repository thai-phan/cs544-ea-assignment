package bank.service.adapter;

import bank.domain.Account;
import bank.service.dto.AccountDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountAdapter {

  public static Account getAccountFromDTO(AccountDTO accountDTO) {
    return new Account(accountDTO.getAccountNumber());
  }

  public static AccountDTO getDTOFromAccount(Account account) {
    AccountDTO accountDTO = new AccountDTO(account.getAccountNumber());
    accountDTO.setCustomerDTO(CustomerAdapter.getDTOFromCustomer(account.getCustomer()));
    accountDTO.setEntryList(account.getEntryList());
    accountDTO.setBalance(account.getBalance());
    return accountDTO;
  }

  public static List<AccountDTO> getDTOsFromAccounts(Collection<Account> contacts) {
    List<AccountDTO> accountDTODTOS = new ArrayList<>();
    for (Account contact : contacts) {
      accountDTODTOS.add(getDTOFromAccount(contact));
    }
    return accountDTODTOS;
  }
}