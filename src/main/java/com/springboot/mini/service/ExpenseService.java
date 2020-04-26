package com.springboot.mini.service;

import com.springboot.mini.model.Expense;

import java.util.List;
import java.util.Optional;

/** The interface Expense service. */
public interface ExpenseService {

  /**
   * Create.
   *
   * @param expense the expense
   */
  void create(Expense expense);

  Optional<Expense> findById(String id);

  List<Expense> getAll();
}
