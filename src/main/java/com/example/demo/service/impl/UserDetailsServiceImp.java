package com.example.demo.service.impl;


import com.example.demo.model.Account;
import com.example.demo.model.Role;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Set;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountName(username);
        if (account != null) {
            return toUserDetails(account);
        } else {
            throw new UsernameNotFoundException("Account does not exist!");
        }
    }

    private UserDetails toUserDetails(Account account) {
        Set<Role> roles = account.getRoles();
        ArrayList<String> strs = new ArrayList<String>();
        for (Role role : roles) {
            strs.add(role.getRoleName());
        }
        String[] roleArr = strs.toArray(new String[0]);
        return User.withUsername(account.getAccountName())
                .password(account.getPassword())
                .roles(roleArr).build();
    }

}
