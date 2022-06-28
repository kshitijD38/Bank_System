package com.Bank.Bank.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bank.Bank.Entities.BankAccount;
import com.Bank.Bank.Entities.User;
import com.Bank.Bank.Enum.BankIngServices;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer> {

	public List<BankAccount> findBankAcountByUser(Optional<User> user);
	
	@Query(value = "SELECT b.* FROM bank_account b join banking_service bs where b.account_id = bs.account_id AND bs.active = true AND bs.banking_service = ?1", nativeQuery = true)
	public List<BankAccount> findBankAcountIdByBankingService(String BSE);
	
	@Query(value = "select b.* FROM bank_account b join user u where u.user_id = ?1", nativeQuery = true)
	public List<BankAccount> findBankAccountsByUserId(int userId);
	
	@Query(value = "select bs.banking_service FROM bank_account b join banking_service bs where b.account_id = ?1", nativeQuery = true)
	public List<BankIngServices> findServicesByAccountId(int accountId);

}
