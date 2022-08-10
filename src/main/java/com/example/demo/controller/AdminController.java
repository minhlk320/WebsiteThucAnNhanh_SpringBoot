package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Supplier;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AdminController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/management")
    public String mangePages(Model model) {

        return "management";
    }

    @RequestMapping(value = "/management/product")
    public String listProducts(Model model, @RequestParam(name = "page", required = false, defaultValue = "1") Optional<Integer> page, @RequestParam(name = "size", required = false, defaultValue = "12") Integer size, @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        int currentPage = page.orElse(1);
        // Page nó đếm từ 0  - > end - Nên phải trừ giá trị hiện tại xuống 1 để khớp với cái Pageable
        Pageable pageable = PageRequest.of(currentPage - 1, size, sortable);
        Page<Product> pageSanPham = productRepository.findProducts(pageable);
        int totalPage = pageSanPham.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        Product newProduct = new Product();
        Random rd = new Random();
        int maSp = rd.nextInt();
        //----
        newProduct.setProductID("" + maSp);
        newProduct.setSupplier(new Supplier("nsx" + maSp, "abc", "odaudo"));
        model.addAttribute("newProduct", newProduct);
        model.addAttribute("products", productRepository.findProducts(pageable));
        return "product-management";
    }

    @RequestMapping(value = "/management/order")
    public String listOrders(Model model, @RequestParam(name = "page", required = false, defaultValue = "1") Optional<Integer> page, @RequestParam(name = "size", required = false, defaultValue = "12") Integer size, @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("orderDate").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("orderDate").descending();
        }
        int currentPage = page.orElse(1);
        Pageable pageable = PageRequest.of(currentPage - 1, size, sortable);
        Page<Order> pageHoaDon = orderRepository.findOrders(pageable);
        int totalPage = pageHoaDon.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        Page<Order> hoaDonList = orderRepository.findOrders(pageable);
        hoaDonList.getSort().descending();
        model.addAttribute("orders", hoaDonList);
        return "order-management";
    }

    @PostMapping("/management/product")
    public String addProduct(@ModelAttribute(name = "product") Product product) {
        if (productRepository.save(product).equals(product)) {
            return "test-result";
        }
        return null;
    }

    @RequestMapping("/management/product/delete/{id}")
    public String editProduct(Model model, @PathVariable(name = "id") String maSanPham) {
        System.out.println(maSanPham);
        if (productRepository.findById(maSanPham).isPresent()) {
            productRepository.delete(productRepository.findById(maSanPham).get());
            return "redirect:/management/product";
        }
        return null;
    }

}
