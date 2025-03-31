package com.trading.commonlibrary.model;

public class TradeEvent {

    private String userId;
    private String cryptoSymbol; // e.g. BTC, ETH
    private String tradeType;    // BUY or SELL
    private double amount;       // how much BTC/ETH
    private double pricePerUnit; // fetched from external API laterm
    private long timestamp;

    public TradeEvent() {
        // Required for deserialization
    }

    public TradeEvent(String userId, String cryptoSymbol, String tradeType, double amount, double pricePerUnit, long timestamp) {
        this.userId = userId;
        this.cryptoSymbol = cryptoSymbol;
        this.tradeType = tradeType;
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCryptoSymbol() {
        return cryptoSymbol;
    }

    public void setCryptoSymbol(String cryptoSymbol) {
        this.cryptoSymbol = cryptoSymbol;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
