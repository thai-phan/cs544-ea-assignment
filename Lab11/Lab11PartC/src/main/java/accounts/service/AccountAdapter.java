package accounts.service;

import accounts.domain.Account;

public class AccountAdapter {

	public static AccountDTO getAccountDto(Account account) {
    return new AccountDTO(account.getAccountNumber(), account.getBalance(), account.getAccountHolder());
	}
}
