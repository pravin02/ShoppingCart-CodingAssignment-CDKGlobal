package org.pk.cdk.global;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class DiscountSlabFactory {

    private DiscountSlabFactory() {
    }

    /**
     * 
     * @param customerType
     * @return
     */
    public static DiscountSlab getDiscountSlab(CustomerType customerType, double totalAmount) {
        List<DiscountSlab> discountSlabs = DiscountSlabFactory.getDiscountSlabs(customerType);
        for (DiscountSlab discountSlab : discountSlabs) {
            // System.out.println("customerType " + customerType + " Total Amount " +
            // totalAmount + ", Minimum "
            // + discountSlab.getMinimum() + ", Maximum " + discountSlab.getMaximum() + " "
            // + (totalAmount >= discountSlab.getMinimum() && totalAmount <=
            // discountSlab.getMaximum()));

            if (totalAmount >= discountSlab.getMinimum() && totalAmount <= discountSlab.getMaximum()) {
                return discountSlab;
            }
        }
        return new DiscountSlab(1, 0, 5000, 0);
    }

    private static List<DiscountSlab> getDiscountSlabs(CustomerType customerType) {
        List<DiscountSlab> discountSlabs = new ArrayList<>();
        if (customerType.name().equals(CustomerType.REGULAR.name())) {
            discountSlabs.add(new DiscountSlab(1, Double.MIN_VALUE, 5000.00, 0));
            discountSlabs.add(new DiscountSlab(2, 5000.00, 10000.00, 10));
            discountSlabs.add(new DiscountSlab(3, 10000.00, Double.MAX_VALUE, 20));
        } else if (customerType.name().equals(CustomerType.PREMIUM.name())) {
            discountSlabs.add(new DiscountSlab(1, Double.MIN_VALUE, 4000.00, 10));
            discountSlabs.add(new DiscountSlab(2, 4000.00, 8000.00, 15));
            discountSlabs.add(new DiscountSlab(3, 8000.00, 12000.0, 20));
            discountSlabs.add(new DiscountSlab(4, 12000.00, Double.MAX_VALUE, 30));
        }
        return discountSlabs;
    }
}
