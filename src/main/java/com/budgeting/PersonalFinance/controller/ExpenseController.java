package com.budgeting.PersonalFinance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgeting.PersonalFinance.DTO.ExpenseDTO;
import com.budgeting.PersonalFinance.Entity.Expense;
import com.budgeting.PersonalFinance.Entity.User;
import com.budgeting.PersonalFinance.service.ExpenseService;
import com.budgeting.PersonalFinance.service.UserService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
@Autowired
private ExpenseService expenseService;
@Autowired
private UserService userService;
@PostMapping("/add/{userId}")
public ResponseEntity<Expense> addExpense(@PathVariable Long userId, @RequestBody ExpenseDTO dto){
	try {
		User user=userService.getUserById(userId);
		if(user==null) {
			user=new User();
			user.setUsername("Prity");
			user.setPassword("hello");
			user.setRole("admin");
			
		}
	
	Expense expense=expenseService.addExpense(userId, dto,user);
	return new ResponseEntity<>(expense,HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/user/{userId}")
public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable Long userId){
	return ResponseEntity.ok(expenseService.getUserExpenses(userId));
}
//@PostMapping("/add")
//public ResponseEntity<Expense> createUser(@RequestBody User user){
//	
//}
}
