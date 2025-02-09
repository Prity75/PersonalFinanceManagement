package com.budgeting.PersonalFinance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgeting.PersonalFinance.DTO.ExpenseDTO;
import com.budgeting.PersonalFinance.Entity.Expense;
import com.budgeting.PersonalFinance.Entity.User;
import com.budgeting.PersonalFinance.exception.UserNotFoundException;
import com.budgeting.PersonalFinance.repository.ExpenseRepository;
import com.budgeting.PersonalFinance.repository.UserRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	public Expense addExpense(Long userId, ExpenseDTO dto, User user) {
		User userOptional=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
User existingUser=userService.getUserById(userId);
if(existingUser==null) {
	existingUser=userService.createUser(user);
	
}
		Expense expense=new Expense();
		expense.setUser(userOptional);
		expense.setCategory(dto.getCategory());
		expense.setAmount(dto.getAmount());
		expense.setDate(dto.getDate());
		
		return expenseRepository.save(expense);
	}
	
	public List<Expense> getUserExpenses(Long userId){
		return expenseRepository.findByUserId(userId);
	}
}
