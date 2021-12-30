package com.company;

public class CompanySharePrice {
    private double price;
    private boolean isIncreased;

    public CompanySharePrice(double price, boolean isIncreased) {
        this.price = price;
        this.isIncreased = isIncreased;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIncreased() {
        return isIncreased;
    }

    public void setIncreased(boolean increased) {
        isIncreased = increased;
    }
}
