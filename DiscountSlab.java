package org.pk.cdk.global;

public class DiscountSlab {

    private int id;
    private double minimum;
    private double maximum;
    private float discount;

    public DiscountSlab(int id, double minimum, double maximum, float discount) {
        this.setId(id);
        this.setMinimum(minimum);
        this.setMaximum(maximum);
        this.setDiscount(discount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

}
