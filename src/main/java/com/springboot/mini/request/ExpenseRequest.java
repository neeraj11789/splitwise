package com.springboot.mini.request;

import lombok.Data;

import java.util.List;

@Data
public class ExpenseRequest {

	private long userMobile;

	private float amount;

	private String expenseType;

	// by mobile
	private List<Long> borrowersList;

	private List<Float> borrowersSplit;
}
