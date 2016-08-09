package com.sss.services;

import com.sss.model.Stock;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Interface representing stock calculator
 *
 * Created by ludn on 2016-08-07.
 */
public interface StockCalculator {

    /**
     * Calculate the dividend yield based on the specified stock and it's price
     *
     * @param stock The stock to calculate the for
     * @param price The price to use as a base to calculate the dividend
     * @return Calculated dividend
     * @throws IllegalArgumentException if any of arguments is null
     */
    BigDecimal calculateDividendYield(Stock stock, BigDecimal price);


    /**
     * Calculate P/E Ratio based on the specified stock and it's price
     *
     * @param stock The stock to calculate the for
     * @param price The price to use as a base to calculate the ratio
     * @return The P/E Ratio
     * @throws IllegalArgumentException if any of arguments is null
     */
    BigDecimal calculatePriceEarningsRatio(Stock stock, BigDecimal price);

    /**
     * Calculate geometric mean of prices based on the specified stocks
     *
     * @param stocks The stocks to calculate the for
     * @return The geometric mean of prices
     * @throws IllegalArgumentException if any of arguments is null
     */
    BigDecimal calculateGeometricMean(Collection<Stock> stocks);
}
