package com.budgeting.PersonalFinance.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="budgets")
@Getter
@Setter
@NoArgsConstructor
public class Budget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	private Integer month;
	private Integer year;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
