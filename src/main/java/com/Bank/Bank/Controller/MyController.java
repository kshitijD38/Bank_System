package com.Bank.Bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.Bank.Entities.Response.AccountDetailResponse;
import com.Bank.Bank.Entities.Response.UserDetailResponse;
import com.Bank.Bank.Enum.BankIngServices;
import com.Bank.Bank.Service.AccountService;
import com.Bank.Bank.Service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MyController {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	@GetMapping("/bank-account/{accountId}")
	public AccountDetailResponse getAccountDetails(@PathVariable int accountId) {
		return accountService.getAccountDetails(accountId);
	}

	@GetMapping("/user/{userId}")
	public UserDetailResponse getUserDetails(@PathVariable int userId) {
		return userService.getUserDetails(userId);
	}

	@GetMapping("/bank-account")
	public List<AccountDetailResponse> getAccountsByServiceInActiveState(@RequestParam BankIngServices service) {
		return accountService.getAccountsByServiceInActiveState(service);
	}

}
