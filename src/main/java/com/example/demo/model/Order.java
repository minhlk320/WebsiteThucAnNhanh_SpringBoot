package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "[order]")
public class Order implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "orderID")
    private String orderID;
    private LocalDate orderDate;
    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order() {
        super();
    }

    public Order(LocalDate orderDate, Customer customer, List<OrderDetail> orderDetails) {
        super();
        this.orderDate = orderDate;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void addProduct(Product sp, int soluong) {
        if (this.orderDetails == null)
            this.orderDetails = new ArrayList<OrderDetail>();
        OrderDetail chiTietHoaDon = new OrderDetail(this, sp, sp.getUnitPrice(), soluong);
        orderDetails.add(chiTietHoaDon);
    }

    public double getTotal() {
        double sum = 0.0;
        for (OrderDetail orderDetail : orderDetails) sum += orderDetail.getPrice() * orderDetail.getQuantity();
        return sum;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (orderID == null) {
            if (other.orderID != null)
                return false;
        } else if (!orderID.equals(other.orderID))
            return false;
        return true;
    }
}
