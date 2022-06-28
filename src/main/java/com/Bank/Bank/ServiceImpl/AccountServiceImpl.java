package com.Bank.Bank.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.Bank.Dao.BankAccountDao;
import com.Bank.Bank.Entities.BankAccount;
import com.Bank.Bank.Entities.Response.AccountDetailResponse;
import com.Bank.Bank.Enum.BankIngServices;
import com.Bank.Bank.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
//	Get Account Details: show account details + services activated for the account (/bank-account/{accountId})
//	 Find accounts by service in active state (/bank-account?service={BackingService}) eg. /bank-account?service=CREDIT_CARD
	
	@Autowired
	BankAccountDao bankAccountDao;

	@Override
	public AccountDetailResponse getAccountDetails(int accountId) {
		Optional<BankAccount> ba = bankAccountDao.findById(accountId);
		AccountDetailResponse response = new AccountDetailResponse();
		response.setAccountId(ba.get().getAccountId());
		response.setAccountNo(ba.get().getAccountNo());
		response.setBankName(ba.get().getBankName());
		response.setUser(ba.get().getUser());
		List<BankIngServices> bankingServiceList = new ArrayList<>();
		for (int i = 0; i < ba.get().getBankingServices().size(); i++) {
			bankingServiceList.add(ba.get().getBankingServices().get(i).getBankingService());
		}
		response.setBankingServices(bankingServiceList);
//		System.out.println(bankAccountDao.findBankAccountsByUserId(1));
//		System.out.println(bankAccountDao.findServicesByAccountId(1));
		return response;
	}

	@Override
	public List<AccountDetailResponse> getAccountsByServiceInActiveState(BankIngServices service) {
		List<AccountDetailResponse> responseList = new ArrayList<>();
		List<BankAccount> bankAccounts = bankAccountDao.findBankAcountIdByBankingService(service.toString());
		for (int i = 0; i < bankAccounts.size(); i++) {
			AccountDetailResponse temp = new AccountDetailResponse();
			List<BankIngServices> serviceList = new ArrayList<BankIngServices>();
			serviceList.add(service);
			temp.setAccountId(bankAccounts.get(i).getAccountId());
			temp.setAccountNo(bankAccounts.get(i).getAccountNo());
			temp.setBankName(bankAccounts.get(i).getBankName());
			temp.setUser(bankAccounts.get(i).getUser());
			temp.setBankingServices(serviceList);
			responseList.add(temp);
		}
		return responseList;
	}

}
