package com.springboot.mini.model;

import com.springboot.mini.util.Constants;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/** The type Percent expense. */
public class PercentExpense extends Expense {

  /**
   * Instantiates a new Percent expense.
   *
   * @param lender the lender
   * @param amount the amount
   * @param userShareMap the user share map
   */
  public PercentExpense(
      @NonNull User lender, @NonNull Float amount, @NonNull Map<User, Float> userShareMap) {
		super(lender, amount, ExpenseType.PERCENT, userShareMap);
		setUserAmountMap(calculateAmountPerUser());
		validate();
	}

	private boolean validate() {
  	    float percent = 0F;
  	    for (Map.Entry<User, Float> m : getUserShareMap().entrySet()){
  	    	percent+= m.getValue();
        }

  	    if(!Float.valueOf(100F).equals(percent))
  	    	throw new IllegalArgumentException(Constants.INVALID_SHARE_FOR_EXPENSE);

  	    return true;
	}

	@Override
	protected Map<User, Float> calculateAmountPerUser() {
		Map<User, Float> perUser = new HashMap<>();
		for (Map.Entry<User, Float> m : getUserShareMap().entrySet()){
			perUser.put(m.getKey(), m.getValue() / 100 * getAmount());
		}
		return perUser;
	}
}
