package com.deeplab.btcturkandroidapi;

public class Trades {
    private String pair,pairNormalized,numerator,denominator;
    private long date;
    private String tid,price,amount;

    public Trades(String pair, String pairNormalized, String numerator, String denominator, long date, String tid, String price, String amount) {
        this.pair = pair;
        this.pairNormalized = pairNormalized;
        this.numerator = numerator;
        this.denominator = denominator;
        this.date = date;
        this.tid = tid;
        this.price = price;
        this.amount = amount;
    }

    public String getPair() {
        return pair;
    }

    public String getPairNormalized() {
        return pairNormalized;
    }

    public String getNumerator() {
        return numerator;
    }

    public String getDenominator() {
        return denominator;
    }

    public long getDate() {
        return date;
    }

    public String getTid() {
        return tid;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }
}
