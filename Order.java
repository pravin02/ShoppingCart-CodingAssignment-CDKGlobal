package org.pk.cdk.global;

import java.util.Set;

public class Order implements Comparable<Order> {

    private long id;
    private Customer customer;
    private Set<Product> products;
    private double productsTotal;
    private float discountPercentage;
    private double discountedAmount;
    private double totalAmount;

    public Order(long id, Customer customer, Set<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public Order(long id, Customer customer, Set<Product> products, double totalAmount, float discountPercentage) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.totalAmount = totalAmount;
        this.discountPercentage = discountPercentage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public double getProductsTotal() {
        return productsTotal;
    }

    public void setProductsTotal(double productsTotal) {
        this.productsTotal = productsTotal;
    }

    @Override
    public int compareTo(Order o) {
        return o.getId() == this.getId() ? 0 : 1;
    }

}
