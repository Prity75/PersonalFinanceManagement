package com.budgeting.PersonalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.budgeting.PersonalFinance.Entity.Budget;
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
      Budget findByUserIdAndMonthAndYear(Long userId, int month, int year);
}
