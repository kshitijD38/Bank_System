package com.Bank.Bank.Service;

import java.util.List;

import com.Bank.Bank.Entities.Response.AccountDetailResponse;
import com.Bank.Bank.Enum.BankIngServices;

public interface AccountService {

	public AccountDetailResponse getAccountDetails(int accountId);

	public List<AccountDetailResponse> getAccountsByServiceInActiveState(BankIngServices service);
}
