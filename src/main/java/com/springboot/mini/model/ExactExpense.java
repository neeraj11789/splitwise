package com.springboot.mini.model;

import com.springboot.mini.util.Constants;
import lombok.NonNull;

import java.lang.annotation.Documented;
import java.util.Map;

/** The type Exact expense. */
public class ExactExpense extends Expense {
  /**
   * Instantiates a new Exact expense.
   *
   * @param lender the lender
   * @param amount the amount
   * @param shareMap the share map
   */
  public ExactExpense(@NonNull User lender, @NonNull Float amount, Map<User, Float> shareMap) {
		super(lender, amount, ExpenseType.EXACT, shareMap);
		setUserAmountMap(calculateAmountPerUser());
		validate();
	}

	@Override
	protected Map<User, Float> calculateAmountPerUser() {
  	    return getUserShareMap();
	}

	/**
	 * Validate the share
	 * @return
	 */
	private boolean validate(){
  	    float amount = 0F;
		for(Map.Entry<User, Float> m: getUserShareMap().entrySet()){
			amount+= m.getValue();
		}
		if (amount != getAmount())
			throw new IllegalArgumentException(Constants.INVALID_SHARE_FOR_EXPENSE);
		return true;
	}
}
