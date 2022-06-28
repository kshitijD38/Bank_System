package com.Bank.Bank.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bank.Bank.Entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query(value = "select u.* FROM user u join bank_account ba where ba.user_id = ?1", nativeQuery = true)
	public List<User> findUserByUserId(int userId);
}
