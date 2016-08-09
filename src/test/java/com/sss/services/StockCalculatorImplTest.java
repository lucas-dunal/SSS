package com.sss.services;

import com.sss.model.Stock;
import com.sss.model.Trade;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * Unit tests for StockCalculator
 *
 * Created by ludn on 2016-08-07.
 */
public class StockCalculatorImplTest {
    private StockCalculator calculator;
    private Map<String, Stock> sampleData;

    @org.junit.Before
    public void setUp() throws Exception {
        calculator = new StockCalculatorImpl();
        sampleData = new HashMap<>();
        sampleData.put("TEA", new Stock("TEA", Stock.StockType.COMMON, BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0), BigDecimal.valueOf(100.0)));
        sampleData.put("POP", new Stock("POP", Stock.StockType.COMMON, BigDecimal.valueOf(8.0), BigDecimal.valueOf(0.0), BigDecimal.valueOf(100.0)));
        sampleData.put("ALE", new Stock("ALE", Stock.StockType.COMMON, BigDecimal.valueOf(23.0), BigDecimal.valueOf(0.0), BigDecimal.valueOf(60.0)));
        sampleData.put("GIN", new Stock("GIN", Stock.StockType.PREFERRED, BigDecimal.valueOf(8.0), BigDecimal.valueOf(0.2), BigDecimal.valueOf(100.0)));
        sampleData.put("JOE", new Stock("JOE", Stock.StockType.COMMON, BigDecimal.valueOf(13.0), BigDecimal.valueOf(0.0), BigDecimal.valueOf(250.0)));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        sampleData.clear();
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void calculateDividendYield() throws Exception {
        assertTrue(0 == BigDecimal.valueOf(23.0).compareTo(calculator.calculateDividendYield(sampleData.get("ALE"), BigDecimal.valueOf(1.0))));
        assertTrue(0 == BigDecimal.valueOf(11.5).compareTo(calculator.calculateDividendYield(sampleData.get("ALE"), BigDecimal.valueOf(2.0))));
        assertTrue(0 == BigDecimal.valueOf(20.0).compareTo(calculator.calculateDividendYield(sampleData.get("GIN"), BigDecimal.valueOf(1.0))));
        calculator.calculateDividendYield(null, null);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void calculatePriceEarningsRatio() throws Exception {
        assertTrue(0 == BigDecimal.valueOf(1.0).compareTo(calculator.calculatePriceEarningsRatio(sampleData.get("ALE"), BigDecimal.valueOf(23.0))));
        calculator.calculatePriceEarningsRatio(null, null);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void calculateGeometricMean() throws Exception {
        sampleData.get("TEA").recordTrading(new Trade(Calendar.getInstance().getTime(), Trade.TradeType.BUY, 1, 5.0));
        sampleData.get("POP").recordTrading(new Trade(Calendar.getInstance().getTime(), Trade.TradeType.BUY, 2, 5.0));
        sampleData.get("ALE").recordTrading(new Trade(Calendar.getInstance().getTime(), Trade.TradeType.SELL, 3, 5.0));
        sampleData.get("GIN").recordTrading(new Trade(Calendar.getInstance().getTime(), Trade.TradeType.SELL, 4, 5.0));
        sampleData.get("JOE").recordTrading(new Trade(Calendar.getInstance().getTime(), Trade.TradeType.SELL, 5, 5.0));

        assertTrue(BigDecimal.ZERO.compareTo(calculator.calculateGeometricMean(sampleData.values())) < 0);

        calculator.calculateGeometricMean(null);
    }
}