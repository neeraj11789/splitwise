package com.springboot.mini.model;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

/** The type Pass book entry. */
@Data
public class PassBookEntry {

	private String rowId = UUID.randomUUID().toString();

	@NonNull
	private Float amount;

	@NonNull
	private TransactionType type;

	@NonNull
	private User user;

	@NonNull
//	private String expenseId;
	private Expense expense;

	private LocalDateTime creationTime = LocalDateTime.now();
}
