package com.Bank.Bank.Entities.Response;

import java.util.List;

import com.Bank.Bank.Entities.User;
import com.Bank.Bank.Enum.BankIngServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailResponse {

	private int accountId;
	private String accountNo;
	private String bankName;
	private User user;
	private List<BankIngServices> bankingServices;

}
