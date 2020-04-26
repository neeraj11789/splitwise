package com.springboot.mini.model;

import lombok.NonNull;

import java.util.Map;

/** The type Percent expense. */
public class PercentExpense extends Expense {

  /**
   * Instantiates a new Percent expense.
   *
   * @param lender the lender
   * @param amount the amount
   * @param type the type
   * @param userShareMap the user share map
   */
  public PercentExpense(
      @NonNull User lender,
      @NonNull Float amount,
      @NonNull ExpenseType type,
      @NonNull Map<User, Float> userShareMap) {
		super(lender, amount, type, userShareMap);
	}

	@Override
	protected Map<User, Float> calculateAmountPerUser() {
		return null;
	}
}
