package com.Bank.Bank.Entities;

import java.time.LocalDate;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Bank.Bank.Enum.BankIngServices;

import lombok.Data;

@Entity
@Data
public class BankingService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int serviceId;
//	@ManyToOne
//	@JoinColumn(name = "account_id")
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
	private BankAccount bankAccount;
	@Enumerated(EnumType.STRING)
	private BankIngServices BankingService;
	private LocalDate activatedOn;
	private boolean Active;
}
