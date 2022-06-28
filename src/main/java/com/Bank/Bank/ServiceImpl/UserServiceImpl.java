package com.Bank.Bank.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.Bank.Dao.BankAccountDao;
import com.Bank.Bank.Dao.UserDao;
import com.Bank.Bank.Entities.BankAccount;
import com.Bank.Bank.Entities.BankingService;
import com.Bank.Bank.Entities.User;
import com.Bank.Bank.Entities.Response.UserAccount;
import com.Bank.Bank.Entities.Response.UserDetailResponse;
import com.Bank.Bank.Enum.BankIngServices;
import com.Bank.Bank.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	 Get User Details: show user details + accounts for a user (/user/{userId})
	
	@Autowired
	UserDao userDao;

	@Autowired
	BankAccountDao accountDao;
	
	@Override
	public UserDetailResponse getUserDetails(int userId) {
		Optional<User> user = userDao.findById(userId);
		UserDetailResponse response = new UserDetailResponse();
		response.setEmail(user.get().getEmail());
		response.setName(user.get().getName());
		response.setPhone(user.get().getName());
		List<BankAccount> accountList = accountDao.findBankAcountByUser(user);
		List<UserAccount> responseAccountList = new ArrayList<>();
		for (int i = 0; i < accountList.size(); i++) {
			UserAccount bac = new UserAccount();
			bac.setAccountId(accountList.get(i).getAccountId());
			bac.setAccountNo(accountList.get(i).getAccountNo());
			bac.setBankName(accountList.get(i).getBankName());
			List<BankingService> bankingServiceList = accountList.get(i).getBankingServices();
			List<BankIngServices> bankingServiceEnumList = new ArrayList<BankIngServices>();
			for (int j = 0; j < bankingServiceList.size(); j++) {
				bankingServiceEnumList.add(bankingServiceList.get(j).getBankingService());
			}
			bac.setBankingServices(bankingServiceEnumList);
			responseAccountList.add(bac);
		}
		response.setAccounts(responseAccountList);
//		System.out.println(userDao.findUserByUserId(userId));
		return response;
	}

}
