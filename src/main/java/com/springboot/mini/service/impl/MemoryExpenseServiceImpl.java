package com.springboot.mini.service.impl;

import com.springboot.mini.model.Expense;
import com.springboot.mini.service.ExpenseService;
import com.springboot.mini.service.PassBookService;

import java.util.HashMap;
import java.util.Map;

/** The type Memory expense service. */
public class MemoryExpenseServiceImpl implements ExpenseService {

	private static final Map<String, Expense> map = new HashMap<>();

	private PassBookService passBookService;

  /**
   * Instantiates a new Memory expense service.
   *
   * @param passBookService the pass book service
   */
  public MemoryExpenseServiceImpl(PassBookService passBookService) {
		this.passBookService = passBookService;
	}

	@Override
	public void create(Expense expense) {
		map.put(expense.getId(), expense);
		passBookService.newRecord(expense);
	}
}