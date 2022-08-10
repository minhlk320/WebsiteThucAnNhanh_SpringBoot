package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;

@Controller
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService AccountService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/login")
    public String enterLoginPage() {
        return "login";
    }

    @RequestMapping("/signup")
    public String enterRegister(Model model) {
        Account account = new Account();
        Customer customer = new Customer();
        account.setCustomer(customer);
        customer.setAccount(account);
        model.addAttribute("account", account);
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createNewUser(@ModelAttribute("account") Account account) {
        Customer customer = account.getCustomer();
        customer.setAccount(account);
        account.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByRoleName("user"))));
        account.setCustomer(customer);
        if (AccountService.save(account)) {
            customerRepository.save(customer);
            return "redirect:/";
        }
        return "signup";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String currentUserName(Model model, Authentication authentication) {
        if (authentication != null) {
            String name = authentication.getName();
            Account account = accountRepository.findByAccountName(name);
            model.addAttribute("account", account);
            return "account";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/account/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("account") Account account) {
        AccountService.update(account);
        return "redirect:/account";
    }

}
