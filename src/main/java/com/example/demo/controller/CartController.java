package com.example.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Customer;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountService accountService;
	@RequestMapping("/done")
	public String checkout() {
		return "done";
	}
	@GetMapping("/cart")
	public String viewCart(Model model) {
		model.addAttribute("cart", cartService.getProducts());
		model.addAttribute("total", cartService.getTotal());
		return "cart";
	}
	@GetMapping("/cart/add/{id}")
	public String addToCart(@PathVariable("id") String maSanPham) {
		productRepository.findById(maSanPham).ifPresent(cartService::addToCard);
		return "redirect:/cart";
	}
	@GetMapping("/cart/remove/{id}")
	public String removeFromCart(@PathVariable("id") String maSanPham) {
		productRepository.findById(maSanPham).ifPresent(cartService::removeFromCart);
		return "redirect:/cart";
	}
	@GetMapping("/cart/purchase")
	public String makePayment(Authentication authentication) {
		Account account = accountService.findByAccountName(authentication.getName());
		Optional<Customer> customer = customerRepository.findById(account.getAccountID());
		if(customer.isPresent()) {
			cartService.makePayment(customer.get());
			return "redirect:/done";
		}
		return "redirect:/cart";
	}
	@GetMapping("/cart/checkout")
	public String checkOut(Model model) {
		Account account = accountService.findByAccountName(SecurityContextHolder.getContext().getAuthentication().getName());
		Optional<Customer> customer = customerRepository.findById(account.getAccountID());
		model.addAttribute("cart", cartService.getProducts());
		model.addAttribute("total", cartService.getTotal());
		model.addAttribute("customer",customer.get());
		return "checkout";
	}

}
