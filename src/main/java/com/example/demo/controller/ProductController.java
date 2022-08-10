package com.example.demo.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.demo.model.Review;
import com.example.demo.model.Account;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = "/products")
	public String listProduct(Model model,
                              @RequestParam(name="page",required = false, defaultValue = "1") Optional<Integer> page ,
                              @RequestParam(name="size",required = false, defaultValue = "6") Integer size,
                              @RequestParam(name="sort",required = false, defaultValue = "ASC") String sort
			) {
		Sort sortable = null;
		if(sort.equals("ASC")) {
			sortable = Sort.by("id").ascending();
		}
		if(sort.equals("DESC")) {
			sortable = Sort.by("id").descending();
		}
		int currentPage = page.orElse(1);
		Pageable pageable = PageRequest.of(currentPage - 1, size, sortable);
		Page<Product> productPage = productRepository.findProducts(pageable);
		int totalPage = productPage.getTotalPages();
		if(totalPage>0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("products", productRepository.findProducts(pageable));
		model.addAttribute("suppliers", supplierRepository.findAll());
		return "products";
	}
	
	@RequestMapping(value = "/product/{id}")
	public String getProductDetails(Model model, Model model2,
                                    @PathVariable(name = "id") String productID) {
		Optional<Product> sp = productRepository.findById(productID);
		Review review = new Review();
		review.setProduct(sp.get());
		if(sp.isPresent()) {
			model.addAttribute("product", sp.get());
			model.addAttribute("newReview",review);
			return "product";
		}
		return "home";
	}
	@RequestMapping(value = "/review/{id}", method = RequestMethod.POST)
	public String reviewProduct(@ModelAttribute("review") Review review) {
		Optional<Account> tk = Optional.ofNullable(accountRepository.findByAccountName(SecurityContextHolder.getContext().getAuthentication().getName()));
		if(tk.isPresent()){
			review.setCustomer(tk.get().getCustomer());
			reviewRepository.save(review);
		}
		return "redirect:/product/{id}";
	}

}
