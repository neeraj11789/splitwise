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
   *
   */
  public ExactExpense(@NonNull User lender, @NonNull Float amount, Map<User,Float> shareMap) {
		super(lender, amount, ExpenseType.EXACT, shareMap);
		setUserAmountMap(calculateAmountPerUser());
	}

	@Override
	protected Map<User, Float> calculateAmountPerUser() {
  	    return getUserShareMap();
	}
}
