package com.budgeting.PersonalFinance.DTO;

import java.time.LocalDate;

import lombok.Getter;
@Getter
public class ExpenseDTO {

	private String category;
	private Double amount;
	private LocalDate date;
	
}
