package com.example.demo.service;

import com.example.demo.model.Account;

public interface AccountService {
	boolean save(Account account);
    void update(Account account);
    Account findByAccountName(String name);
}
