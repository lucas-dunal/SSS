package com.sss.model;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertNotNull;

/**
 * Unit tests for Stock class
 *
 * Created by ludn on 2016-08-07.
 */
public class StockTest {

    @org.junit.Test(expected = java.lang.NullPointerException.class)
    public void allArgsConstructor() throws Exception {
        new Stock(null, null, null, null, null);
    }

    @org.junit.Test
    public void toStringNonNull() throws Exception {
        assertNotNull(new Stock("JOE", Stock.StockType.COMMON, BigDecimal.valueOf(13.0), BigDecimal.valueOf(0.0), BigDecimal.valueOf(250.0)).toString());
    }

}