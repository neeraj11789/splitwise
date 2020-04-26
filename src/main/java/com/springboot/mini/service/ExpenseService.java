package com.springboot.mini.service;

import com.springboot.mini.model.Expense;

import java.util.List;

/** The interface Expense service. */
public interface ExpenseService {

  /**
   * Create.
   *
   * @param expense the expense
   */
  void create(Expense expense);

  List<Expense> getAll();
}
