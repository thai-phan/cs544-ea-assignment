package bank.service.adapter;

import bank.domain.Account;
import bank.service.dto.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter {

  public static Account getContactFromContactDTO(AccountDTO accountDTO) {
    return new Account(accountDTO.accountnumber());
  }

  public static AccountDTO getContactDTOFromContact(Account account) {
    return new AccountDTO(account.getAccountnumber());
  }

  public static List<AccountDTO> getContactDTOsFromContacts(List<Account> contacts) {
    List<AccountDTO> accountDTOS = new ArrayList<AccountDTO>();
    for (Account contact : contacts) {
      accountDTOS.add(getContactDTOFromContact(contact));
    }
    return accountDTOS;
  }
}