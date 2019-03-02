package com.spaghettiteam.hotelapi.dto;

public class TwoPriceSearch {

    private double lowestPrice;
    private double highestPrice;

    public TwoPriceSearch() {
    }

    public TwoPriceSearch(double lowestPrice, double highestPrice) {
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }
}
