package com.coin.monitor.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="tb_orderbooks")
public class Orderbook {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String symbol;

    @Column
    private String asks;

    @Column
    private String bids;

    @Column
    private BigDecimal rate;

}
