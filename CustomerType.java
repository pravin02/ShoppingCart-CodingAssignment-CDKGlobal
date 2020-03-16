package org.pk.cdk.global;

public enum CustomerType {
    REGULAR, PREMIUM;

    public static CustomerType getCustomerType(String customerType) {
        for (CustomerType cType : CustomerType.values()) {
            if (cType.name().equals(customerType)) {
                return cType;
            }
        }
        return null;
    }
}
