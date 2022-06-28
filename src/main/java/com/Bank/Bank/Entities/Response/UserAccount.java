package com.Bank.Bank.Entities.Response;

import java.util.List;

import com.Bank.Bank.Enum.BankIngServices;

import lombok.Data;

@Data
public class UserAccount {

	private int accountId;
	private String accountNo;
	private String bankName;
	private List<BankIngServices> bankingServices;

}
