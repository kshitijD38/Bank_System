package com.Bank.Bank.Entities.Response;

import java.util.List;

import lombok.Data;

@Data
public class UserDetailResponse {
	private String Name;
	private String phone;
	private String email;
	private List<UserAccount> Accounts;
}
