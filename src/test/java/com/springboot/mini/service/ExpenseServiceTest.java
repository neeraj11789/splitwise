package com.springboot.mini.service;

import com.springboot.mini.model.*;
import com.springboot.mini.service.impl.MemoryExpenseServiceImpl;
import com.springboot.mini.service.impl.MemoryPassBookServiceImpl;
import com.springboot.mini.service.impl.MemoryUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class ExpenseServiceTest {

  ExpenseService expenseService;

  PassBookService passBookService;

  UserService userService;

  private static final User u1 = new User("u1", "u1@g.com", 9884387999L);
  private static final User u2 = new User("u2", "u2@g.com", 9898387999L);
  private static final User u3 = new User("u3", "u3@g.com", 9884377999L);
  private static final User u4 = new User("u4", "u4@g.com", 9884677999L);
  private static final User u5 = new User("u5", "u5@g.com", 9884347999L);

  private static final User u11 = new User("u11", "u11@g.com", 9884349099L);
  private static final User u12 = new User("u12", "u12@g.com", 9884347099L);


  @BeforeEach
  void setUp() {
    userService = new MemoryUserServiceImpl();
    passBookService = new MemoryPassBookServiceImpl();
    expenseService = new MemoryExpenseServiceImpl(passBookService);

    userService.create(u1);
    userService.create(u2);
    userService.create(u3);
    userService.create(u4);
    userService.create(u5);

    userService.create(u11);
    userService.create(u12);
  }

  @Test
  void create() {
  	  // Equal Share
      List<User> borrowers = new ArrayList<>();
      borrowers.add(u1);
      borrowers.add(u2);
      borrowers.add(u3);
      Expense e1 = new EqualExpense(u1, 1500F, borrowers);
      expenseService.create(e1);

      // Exact Share
      Map<User, Float> exactShareMap = new HashMap<>();
	  exactShareMap.put(u3, 700F);
	  exactShareMap.put(u2, 300F);
	  Expense e2 = new ExactExpense(u5, 1000F, exactShareMap);
	  expenseService.create(e2);


	  // Percent Share
      Map<User, Float> percentShareMap = new HashMap<>();
      percentShareMap.put(u3, 20F);
      percentShareMap.put(u2, 20F);
      percentShareMap.put(u4, 40F);
      percentShareMap.put(u5, 20F);
      Expense e3 = new PercentExpense(u4, 2000F, percentShareMap);
      expenseService.create(e3);

      // List Expense
	  expenseService.getAll();

	  // All PassBook Records
//      passBookService.allRecords();
      passBookService.displayAllRecords();

      System.out.println("#####################");
      // Expense for U3
//      passBookService.userRecord(u3);
      passBookService.displayUserRecord(u3);

      System.out.println("#####################");
      // Expense for U5
//      passBookService.userRecord(u5);
      passBookService.displayUserRecord(u1);

      passBookService.displayAllBalance();

      passBookService.displayBalance(u5);

      passBookService.displayBalance(u3);


  }
}