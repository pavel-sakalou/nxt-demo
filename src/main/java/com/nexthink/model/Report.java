package com.nexthink.model;

public class Report {
    private final static double TAX = 0.23d;

    private String productType;

    /*
    * fee = price * tax
    * */
    private Double fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

}
