package com.deeplab.btcturkandroidapi;

public class Balance {
    private String asset,assetname,balance,locked,free,orderFund,requestFund,precision;

    public Balance(String asset, String assetname, String balance, String locked, String free, String orderFund, String requestFund, String precision) {
        this.asset = asset;
        this.assetname = assetname;
        this.balance = balance;
        this.locked = locked;
        this.free = free;
        this.orderFund = orderFund;
        this.requestFund = requestFund;
        this.precision = precision;
    }

    public String getAsset() {
        return asset;
    }

    public String getAssetname() {
        return assetname;
    }

    public String getBalance() {
        return balance;
    }

    public String getLocked() {
        return locked;
    }

    public String getFree() {
        return free;
    }

    public String getOrderFund() {
        return orderFund;
    }

    public String getRequestFund() {
        return requestFund;
    }

    public String getPrecision() {
        return precision;
    }
}
