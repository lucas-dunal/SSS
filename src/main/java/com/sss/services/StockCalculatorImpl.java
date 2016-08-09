package com.sss.services;

import com.sss.model.Stock;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Implementation of StockCalculator interface
 *
 * Created by ludn on 2016-08-07.
 */
public class StockCalculatorImpl implements StockCalculator {
    private final static Logger logger = Logger.getLogger(StockCalculatorImpl.class.getName());
    private final static int BIGINT_SCALE = 5;

    @Override
    public BigDecimal calculateDividendYield(@NonNull Stock stock, @NonNull BigDecimal price) {
        BigDecimal result = BigDecimal.ZERO;
        switch (stock.getType()) {
            case COMMON:
                result = stock.getLastDividend().divide(price);
                break;
            case PREFERRED:
                result = stock.getFixedDividend().multiply(stock.getParValue()).divide(price);
                break;
        }
        logger.info("calculateDividendYield " + result);
        return result;
    }

    @Override
    public BigDecimal calculatePriceEarningsRatio(@NonNull Stock stock, @NonNull BigDecimal price) {
        final BigDecimal result = price.divide(stock.getLastDividend());
        logger.info("calculatePriceEarningsRatio " + result);
        return result;
    }

    @Override
    public BigDecimal calculateGeometricMean(@NonNull Collection<Stock> stocks) {
        Double mul = 1.0;
        for (Stock stock : stocks) {
            mul *= stock.getPrice().doubleValue();
        }
        // be aware of double precision IEEE754 floating point math (5.0 can end up like 5.000000000000001)
        final BigDecimal result = BigDecimal.valueOf(Math.pow(mul, 1.0 / (stocks.size() > 0 ? stocks.size() : 1.0)))
                .setScale(BIGINT_SCALE, BigDecimal.ROUND_HALF_UP);
        logger.info("calculateGeometricMean " + result);
        return result;
    }
}
