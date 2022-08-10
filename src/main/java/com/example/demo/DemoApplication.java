package com.example.demo;



import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.AccountRepository;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
    private AccountService accountService;

	@Autowired
	private RoleRepository roleRepository;
	@Autowired 
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
    InitializingBean sendDatabase() {
		return () -> {
//			Account taiKhoan = new Account("admin", "admin");
//			Customer kh = new Customer();
//			kh.setAccount(taiKhoan);
//			taiKhoan.setCustomer(kh);
//			Role role_admin = new Role();
//			role_admin.setRoleID((long) 1);
//			role_admin.setRoleName("admin");
//			Role role_user = new Role();
//			role_user.setRoleID((long) 2);
//			role_user.setRoleName("user");
//			taiKhoan.setRoles(new HashSet<>(Arrays.asList(role_user,role_admin)));
//			roleRepository.save(role_admin);
//			roleRepository.save(role_user);
//			accountService.save(taiKhoan);
//			customerRepository.save(kh);
		};
	}
}
