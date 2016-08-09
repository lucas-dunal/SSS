package com.sss.model;

import java.util.Calendar;

import static junit.framework.TestCase.assertNotNull;

/**
 * Unit tests for Trade class
 *
 * Created by ludn on 2016-08-07.
 */
public class TradeTest {

    @org.junit.Test(expected = java.lang.NullPointerException.class)
    public void allArgsConstructor() throws Exception {
        new Trade(null, null, null, null);
    }

    @org.junit.Test
    public void toStringNonNull() throws Exception {
        assertNotNull(new Trade(Calendar.getInstance().getTime(), Trade.TradeType.BUY, 1, 5.0).toString());
    }
}