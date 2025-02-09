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
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
	}
}
