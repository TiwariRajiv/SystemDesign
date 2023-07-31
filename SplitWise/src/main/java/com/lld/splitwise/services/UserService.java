package com.lld.splitwise.services;

import com.lld.splitwise.dao.IDataStorage;
import com.lld.splitwise.dao.IDataStorageLocalImpl;
import com.lld.splitwise.entities.User;

public class UserService {

  private final IDataStorage db = IDataStorageLocalImpl.getInstance();

  public void addUser(User user) {
    db.saveUser(user);
  }

  public void getUser(String userId) {
    db.getUser(userId);
  }

  public void getAllUsers() {
    db.getAllUsers();
  }
}
