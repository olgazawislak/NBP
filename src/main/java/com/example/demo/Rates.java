package com.example.demo;

class Rates {
    private double bid;
    private double ask;

    public Rates(double bid, double ask) {
        this.bid = bid;
        this.ask = ask;
    }

    public Rates() {
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }
}
