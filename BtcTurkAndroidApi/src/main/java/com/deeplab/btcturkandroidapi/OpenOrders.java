package com.deeplab.btcturkandroidapi;

public class OpenOrders {
    private int id;
    private String numeratorSymbol,price,amount,quantity,stopPrice,pairSymbol,pairSymbolNormalized,type,method,orderClientId;
    private long time,updateTime;
    private String status,leftAmount;

    public OpenOrders(int id, String numeratorSymbol, String price, String amount, String quantity, String stopPrice, String pairSymbol, String pairSymbolNormalized, String type, String method, String orderClientId, long time, long updateTime, String status, String leftAmount) {
        this.id = id;
        this.numeratorSymbol = numeratorSymbol;
        this.price = price;
        this.amount = amount;
        this.quantity = quantity;
        this.stopPrice = stopPrice;
        this.pairSymbol = pairSymbol;
        this.pairSymbolNormalized = pairSymbolNormalized;
        this.type = type;
        this.method = method;
        this.orderClientId = orderClientId;
        this.time = time;
        this.updateTime = updateTime;
        this.status = status;
        this.leftAmount = leftAmount;
    }

    public int getId() {
        return id;
    }

    public String getNumeratorSymbol() {
        return numeratorSymbol;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public String getPairSymbol() {
        return pairSymbol;
    }

    public String getPairSymbolNormalized() {
        return pairSymbolNormalized;
    }

    public String getType() {
        return type;
    }

    public String getMethod() {
        return method;
    }

    public String getOrderClientId() {
        return orderClientId;
    }

    public long getTime() {
        return time;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public String getStatus() {
        return status;
    }

    public String getLeftAmount() {
        return leftAmount;
    }
}
