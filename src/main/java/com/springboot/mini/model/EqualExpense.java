package com.springboot.mini.model;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** The type Equal expense. */
public class EqualExpense extends Expense {

  /**
   * Instantiates a new Equal expense.
   *
   * @param lender the lender
   * @param amount the amount
   * @param users the users
   */
  public EqualExpense(@NonNull User lender, @NonNull Float amount, List<User> users) {
		super(lender, amount, ExpenseType.EQUAL);
		setUserShareMap(calculateUserShareMap(users));
		setUserAmountMap(calculateAmountPerUser());
	}

	/**
	 *
	 * @param users
	 * @return
	 */
	private Map<User, Float> calculateUserShareMap(@NonNull List<User> users){
		float perUser = 100 / users.size();
		Map<User, Float> map = new HashMap<>();
		for (User u : users){
			map.put(u, perUser);
		}
		return map;
	}

	/**
	 *
	 * @return
	 */
	@Override
	protected Map<User, Float> calculateAmountPerUser() {
		float amountPerUser = getAmount() / getUserShareMap().size();
		Map<User, Float> map = new HashMap<>();
		for (Map.Entry<User, Float> m : getUserShareMap().entrySet()){
			map.put(m.getKey(), amountPerUser);
		}
		return map;
	}
}
