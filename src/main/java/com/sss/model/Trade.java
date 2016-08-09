package com.sss.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Date;


/**
 * Implementation of Trade
 * <p>
 * Created by ludn on 2016-08-07.
 */
@Getter
@AllArgsConstructor
@ToString
public class Trade {

    /**
     * Trade operation type - BUY or SELL
     */
    public enum TradeType {
        BUY, SELL
    }

    @NonNull
    private Date timestamp;

    @NonNull
    private TradeType type;

    @NonNull
    private Integer quantity;

    @NonNull
    private Double price;
}

