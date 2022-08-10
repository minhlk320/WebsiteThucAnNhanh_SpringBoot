package com.example.demo.service.impl;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean save(Account account) {
        if (accountRepository.findByAccountName(account.getAccountName()) == null) {
            account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    @Override
    public void update(Account account) {
        Optional<Account> retrievedAccount = Optional.ofNullable(accountRepository.findByAccountName(SecurityContextHolder.getContext().getAuthentication().getName()));
        if (retrievedAccount.isPresent()) {
            Customer customer = account.getCustomer();
            customer.setCustomerID(retrievedAccount.get().getCustomer().getCustomerID());
            retrievedAccount.get().setCustomer(customer);
            accountRepository.save(retrievedAccount.get());
        }
    }

    @Override
    public Account findByAccountName(String accountName) {
        Iterable<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            if (account.getAccountName().equals(accountName))
                return account;
        }
        return null;
    }
}
