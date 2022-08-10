package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

public interface CartService {
	void addToCard(Product sanpham);

    void removeFromCart(Product sanpham);

    Map<Product, Integer> getProducts();

    void makePayment(Customer customer);

    double getTotal();
}
