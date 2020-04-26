package com.springboot.mini.service;

import com.springboot.mini.model.Expense;
import com.springboot.mini.model.PassBookEntry;
import com.springboot.mini.model.User;

import java.util.List;

/** The interface Pass book service. */
public interface PassBookService {

  /**
   * New record.
   *
   * @param expense the expense
   */
  void newRecord(Expense expense);

  /**
   * User user record list.
   *
   * @param user the user
   * @return the list
   */
  List<PassBookEntry> userUserRecord(User user);

  /**
   * User all records list.
   *
   * @return the list
   */
  List<PassBookEntry> userAllRecords();
}
