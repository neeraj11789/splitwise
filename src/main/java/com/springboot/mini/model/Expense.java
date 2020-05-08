package com.springboot.mini.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/** The type Expense. */
@Data
public abstract class Expense {

	private String id = UUID.randomUUID().toString();

	@NonNull
	private User lender;

	@NonNull
	private Float amount;

	@NonNull
	private ExpenseType type;

	@NonNull
	private Map<User, Float> userShareMap;

	private Map<User, Float> userAmountMap;

	private LocalDateTime creationTime = LocalDateTime.now();

  /**
   * Calculate amount per user map.
   *
   * @return the map
   */
  protected abstract Map<User, Float> calculateAmountPerUser();

  /**
   * Instantiates a new Expense.
   *
   * @param lender the lender
   * @param amount the amount
   * @param type the type
   */
  public Expense(@NonNull User lender, @NonNull Float amount, @NonNull ExpenseType type) {
		this.lender = lender;
		this.amount = amount;
		this.type = type;
	}

  /**
   * Instantiates a new Expense.
   *
   * @param lender the lender
   * @param amount the amount
   * @param type the type
   * @param userShareMap the user share map
   */
  public Expense(
      @NonNull User lender,
      @NonNull Float amount,
      @NonNull ExpenseType type,
      @NonNull Map<User, Float> userShareMap) {
		this.lender = lender;
		this.amount = amount;
		this.type = type;
		this.userShareMap = userShareMap;
	}
}
