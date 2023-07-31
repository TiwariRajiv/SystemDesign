package com.lld.splitwise.services;

import com.lld.splitwise.dao.IDataStorage;
import com.lld.splitwise.dao.IDataStorageLocalImpl;

import java.util.Map;

public class BalanceSheetService {

  private static final String DELIMITER = "-";
  private final IDataStorage db = IDataStorageLocalImpl.getInstance();

  public void printUserBalanceSheet(String userId) {
    boolean printed = true;
    for (Map.Entry<String, Float> entry : db.getBalanceSheet().entrySet()) {
      if (entry.getKey().contains(userId)) {
        String[] users = entry.getKey().split(DELIMITER);
        System.out.println(users[1] + " ows " + users[0] + " : " + entry.getValue());
        printed = false;
      }
    }
    if (printed) {
      System.out.println("No Balances");
    }
  }

  public void printBalanceSheet() {
    boolean printed = true;
    for (Map.Entry<String, Float> entry :  db.getBalanceSheet().entrySet()) {
        String[] users = entry.getKey().split(DELIMITER);
        System.out.println(users[1] + " ows " + users[0] + " : " + entry.getValue());
        printed = false;
    }
    if (printed) {
      System.out.println("No Balances");
    }
  }
}
