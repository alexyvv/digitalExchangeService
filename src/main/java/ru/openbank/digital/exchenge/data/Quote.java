package ru.openbank.digital.exchenge.data;

import java.io.Serializable;

/**
 * Quote data wrapper.
 */
public class Quote implements Serializable {

    private String currency;
    private double bid;
    private double offer;

    public Quote(String currency, double bid, double offer) {

        this.currency = currency;
        this.bid = bid;
        this.offer = offer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }
}
