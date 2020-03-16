package org.pk.cdk.global.main;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.pk.cdk.global.Customer;
import org.pk.cdk.global.CustomerType;
import org.pk.cdk.global.DiscountSlab;
import org.pk.cdk.global.DiscountSlabFactory;
import org.pk.cdk.global.Order;
import org.pk.cdk.global.Product;

public class DiscountCalculator {

    /**
     * 
     * @param id
     * @return
     */
    public static Order getOrderForRegularCustomer1() {
        Customer customer = new Customer(1, "Pravin", "Patil", CustomerType.REGULAR);
        Set<Product> products = new TreeSet<>();
        products.add(new Product(1, "Samsung Mobile", 5000));
        Order order = new Order(1, customer, products);
        return order;
    }

    public static Order getOrderForRegularCustomer2() {
        Customer customer = new Customer(2, "Pravin", "Patil", CustomerType.REGULAR);
        Set<Product> products = new TreeSet<>();
        products.add(new Product(1, "Realm XT Mobile", 10000));
        Order order = new Order(2, customer, products);
        return order;
    }

    public static Order getOrderForRegularCustomer3() {
        Customer customer = new Customer(3, "Pravin", "Patil", CustomerType.REGULAR);
        Set<Product> products = new TreeSet<>();
        products.add(new Product(1, "Realm XT Mobile", 15000));
        Order order = new Order(3, customer, products);
        return order;
    }

    /**
     * 
     * @param id
     * @return
     */
    public static Order getOrderForPrimiumCustomer1() {
        Customer customer = new Customer(1, "Primium", "Primium", CustomerType.PREMIUM);
        Set<Product> products = new TreeSet<>();
        products.add(new Product(1, "Laptop Back Cover", 2000));
        products.add(new Product(2, "Laptop Charger", 2000));
        Order order = new Order(4, customer, products);
        return order;
    }

    public static Order getOrderForPrimiumCustomer2() {
        Customer customer = new Customer(1, "Primium", "Primium", CustomerType.PREMIUM);
        Set<Product> products = new TreeSet<>();
        products.add(new Product(1, "Laptop Back Cover", 4000));
        products.add(new Product(2, "Laptop Charger", 4000));
        Order order = new Order(5, customer, products);
        return order;
    }

    public static Order getOrderForPrimiumCustomer3() {
        Customer customer = new Customer(1, "Primium", "Primium", CustomerType.PREMIUM);
        Set<Product> products = new TreeSet<>();
        products.add(new Product(1, "Laptop Back Cover", 6000));
        products.add(new Product(2, "Laptop Charger", 6000));
        Order order = new Order(6, customer, products);
        return order;
    }

    public static Order getOrderForPrimiumCustomer4() {
        Customer customer = new Customer(1, "Primium", "Primium", CustomerType.PREMIUM);
        Set<Product> products = new TreeSet<>();
        products.add(new Product(1, "Laptop Back Cover", 10000));
        Order order = new Order(7, customer, products);
        return order;
    }

    /**
     * 
     */
    public static Set<Order> getOrders() {
        Set<Order> orders = new TreeSet<>();
        orders.add(getOrderForRegularCustomer1());
        orders.add(getOrderForRegularCustomer2());
        orders.add(getOrderForRegularCustomer3());
        orders.add(getOrderForPrimiumCustomer1());
        orders.add(getOrderForPrimiumCustomer2());
        orders.add(getOrderForPrimiumCustomer3());
        orders.add(getOrderForPrimiumCustomer4());
        return orders;
    }

    /**
     * 
     * @param order
     * @return
     */
    public static double getProductsTotal(Order order) {
        double productsTotal = 0;
        for (Product product : order.getProducts()) {
            productsTotal += product.getPrice();
        }
        return productsTotal;
    }

    public static String formattedCurrency(double amount) {
        try {
            Locale locale = Locale.getDefault();
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
            return numberFormat.format(amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Set<Order> orders = getOrders();

        System.out.println("\n\n");
        for (Order order : orders) {
            order.setProductsTotal(getProductsTotal(order));
            DiscountSlab ds = DiscountSlabFactory.getDiscountSlab(order.getCustomer().getCustomerType(),
                    order.getProductsTotal());

            order.setDiscountPercentage(ds.getDiscount());
            double discountedAmount = order.getProductsTotal() * order.getDiscountPercentage() / 100.0;
            order.setDiscountedAmount(discountedAmount);
            order.setTotalAmount(order.getProductsTotal() - discountedAmount);

            System.out.println("Customer Type " + order.getCustomer().getCustomerType() 
            + " Purchase Amount "
                    + formattedCurrency(order.getProductsTotal()) + " Bill Amount "
                    + formattedCurrency(order.getTotalAmount()));

        }
    }

}
