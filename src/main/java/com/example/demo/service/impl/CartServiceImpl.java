package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.*;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    private Map<Product, Integer> cartItems = new HashMap<>();

    @Override
    public void addToCard(Product product) {
        if (cartItems.containsKey(product)) {
            cartItems.replace(product, cartItems.get(product) + 1);
        } else {
            cartItems.put(product, 1);
        }
    }

    @Override
    public void removeFromCart(Product product) {
        if (cartItems.containsKey(product)) {
            if (cartItems.get(product) > 1)
                cartItems.replace(product, cartItems.get(product) - 1);
            else
                cartItems.remove(product);
        }
    }

    @Override
    public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(cartItems);
    }

    @Override
    public void makePayment(Customer customer) {
        Order hd = new Order();
        List<OrderDetail> listct = new ArrayList<>();
        hd.setOrderDate(LocalDate.now());
        Product product;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Optional<Product> temp = productRepository.findById(entry.getKey().getProductID());
            product = temp.get();
            OrderDetail cthd = new OrderDetail(product.getUnitPrice(), entry.getValue(), product);
            cthd.setOrder(hd);
            listct.add(cthd);
        }
        hd.setOrderDetails(listct);
        hd.setCustomer(customer);
        orderRepository.save(hd);
        productRepository.saveAll(cartItems.keySet());
        cartItems.clear();
    }

    @Override
    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().getUnitPrice() * entry.getValue();
        }
        return total;
    }

}
