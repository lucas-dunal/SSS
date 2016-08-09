package com.sss.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Implementation of Stock
 *
 * Created by ludn on 2016-08-07.
 */
@Getter
@AllArgsConstructor
@ToString
public class Stock {
    /**
     * Stock type - COMMON or PREFERRED
     */
    public enum StockType {
        COMMON, PREFERRED
    }

    @NonNull
    private String symbol;
    @NonNull
    private Stock.StockType type;
    @NonNull
    private BigDecimal lastDividend;
    @NonNull
    private BigDecimal fixedDividend;
    @NonNull
    private BigDecimal parValue;
    @NonNull
    private Stack<Trade> trades;

    public Stock(String symbol, StockType type, BigDecimal lastDividend, BigDecimal fixedDividend, BigDecimal parValue) {
        this(symbol, type, lastDividend, fixedDividend, parValue, new Stack<Trade>());
    }

    public BigDecimal getPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal totalQuantity = BigDecimal.ZERO;
        for (Trade t : trades) {
            totalPrice = totalPrice.add(BigDecimal.valueOf(t.getPrice() * t.getQuantity()));
            totalQuantity = totalQuantity.add(BigDecimal.valueOf(t.getQuantity()));
        }
        return totalPrice.divide(totalQuantity);
    }

    public void recordTrading(Trade trade) {
        this.trades.push(trade);
    }
}