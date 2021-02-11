package com.deeplab.btcturkandroidapi;

public class Transactions {
    private String numeratorSymbol,denominatorSymbol,orderType;
    private int id;
    private long timestamp;
    private double orderFund ,fee, tax;

    public Transactions(String numeratorSymbol, String denominatorSymbol, String orderType, int id, long timestamp, double orderFund, double fee, double tax) {
        this.numeratorSymbol = numeratorSymbol;
        this.denominatorSymbol = denominatorSymbol;
        this.orderType = orderType;
        this.id = id;
        this.timestamp = timestamp;
        this.orderFund = orderFund;
        this.fee = fee;
        this.tax = tax;
    }

    public String getNumeratorSymbol() {
        return numeratorSymbol;
    }

    public String getDenominatorSymbol() {
        return denominatorSymbol;
    }

    public String getOrderType() {
        return orderType;
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getOrderFund() {
        return orderFund;
    }

    public double getFee() {
        return fee;
    }

    public double getTax() {
        return tax;
    }
}
