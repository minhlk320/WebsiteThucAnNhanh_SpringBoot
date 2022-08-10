package com.example.demo.repository;
import com.example.demo.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String>{
	Account findByAccountName(String ten);
}
