package com.springboot.mini.service.impl;

import com.springboot.mini.model.Expense;
import com.springboot.mini.model.PassBookEntry;
import com.springboot.mini.model.TransactionType;
import com.springboot.mini.model.User;
import com.springboot.mini.service.PassBookService;
import lombok.NonNull;

import java.util.*;

/** The type Memory pass book service. */
public class MemoryPassBookServiceImpl implements PassBookService {

	private static final Map<String, PassBookEntry> map = new HashMap<>();

	@Override
	public void newRecord(Expense expense) {
		PassBookEntry debitEntry = getDebitRecord(expense);
		List<PassBookEntry> creditEntry = getCreditRecords(expense);
		map.put(debitEntry.getRowId(), debitEntry);

		for (PassBookEntry entry: creditEntry){
			map.put(entry.getRowId(), entry);
		}
	}

	/**
	 * Get all the credit records for the expense
	 * @param expense
	 * @return
	 */
	private List<PassBookEntry> getCreditRecords(Expense expense) {
		List<PassBookEntry> list = new ArrayList<>();
		Iterator<Map.Entry<User, Float>> iterator = expense.getUserAmountMap().entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry<User, Float> current = iterator.next();
			list.add(new PassBookEntry(Float.valueOf(0F - current.getValue()),
					TransactionType.CREDIT, current.getKey(), expense.getId()));
		}
		return list;
	}

	/**
	 * Get the Debit Record for the expense
	 * @param expense
	 * @return
	 */
	private PassBookEntry getDebitRecord(@NonNull Expense expense) {
		return new PassBookEntry(expense.getAmount(), TransactionType.DEBIT, expense.getLender(), expense.getId());
	}

	@Override
	public List<PassBookEntry> userUserRecord(User user) {
		return null;
	}

	@Override
	public List<PassBookEntry> allRecords() {
		List<PassBookEntry> list = new ArrayList<>();
		for (Map.Entry<String, PassBookEntry> m : map.entrySet()){
            System.out.println("Entry " + m.getKey() + ":: " + m.getValue());
            list.add(m.getValue());
		}
		return list;
	}
}
