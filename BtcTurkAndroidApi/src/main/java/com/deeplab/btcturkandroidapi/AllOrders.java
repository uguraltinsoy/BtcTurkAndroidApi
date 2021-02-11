package com.deeplab.btcturkandroidapi;

public class AllOrders {
    private int id;
    private String price,amount,quantity,pairsymbol,pairsymbolnormalized,type, method,orderClientId;
    private long time,updateTime;
    private String status;

    public AllOrders(int id, String price, String amount, String quantity, String pairsymbol, String pairsymbolnormalized, String type, String method, String orderClientId, long time, long updateTime, String status) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.quantity = quantity;
        this.pairsymbol = pairsymbol;
        this.pairsymbolnormalized = pairsymbolnormalized;
        this.type = type;
        this.method = method;
        this.orderClientId = orderClientId;
        this.time = time;
        this.updateTime = updateTime;
        this.status = status;
    }

    public int getId() {
        return id;
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

    public String getPairsymbol() {
        return pairsymbol;
    }

    public String getPairsymbolnormalized() {
        return pairsymbolnormalized;
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
}
