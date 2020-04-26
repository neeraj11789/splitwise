package com.springboot.mini.model;

import lombok.NonNull;

import java.util.Map;

/** The type Exact expense. */
public class ExactExpense extends Expense {
  /**
   * Instantiates a new Exact expense.
   *
   * @param lender the lender
   * @param amount the amount
   * @param type the type
   */
  public ExactExpense(@NonNull User lender, @NonNull Float amount, @NonNull ExpenseType type) {
		super(lender, amount, type);
	}

	@Override
	protected Map<User, Float> calculateAmountPerUser() {
		return null;
	}
}
