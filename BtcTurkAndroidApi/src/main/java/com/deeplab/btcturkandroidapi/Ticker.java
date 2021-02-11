package com.deeplab.btcturkandroidapi;

public class Ticker {
    private String pair,pairNormalized;
    private long timestamp;
    private double last,high,low,bid,ask,open,volume,average,daily,dailyPercent;
    private String denominatorSymbol,numeratorSymbol;

    public Ticker(String pair, String pairNormalized, long timestamp, double last, double high, double low, double bid, double ask, double open, double volume, double average, double daily, double dailyPercent, String denominatorSymbol, String numeratorSymbol) {
        this.pair = pair;
        this.pairNormalized = pairNormalized;
        this.timestamp = timestamp;
        this.last = last;
        this.high = high;
        this.low = low;
        this.bid = bid;
        this.ask = ask;
        this.open = open;
        this.volume = volume;
        this.average = average;
        this.daily = daily;
        this.dailyPercent = dailyPercent;
        this.denominatorSymbol = denominatorSymbol;
        this.numeratorSymbol = numeratorSymbol;
    }

    public String getPair() {
        return pair;
    }

    public String getPairNormalized() {
        return pairNormalized;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getLast() {
        return last;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public double getOpen() {
        return open;
    }

    public double getVolume() {
        return volume;
    }

    public double getAverage() {
        return average;
    }

    public double getDaily() {
        return daily;
    }

    public double getDailyPercent() {
        return dailyPercent;
    }

    public String getDenominatorSymbol() {
        return denominatorSymbol;
    }

    public String getNumeratorSymbol() {
        return numeratorSymbol;
    }
}
