package com.coin.monitor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tb_coin_market_config")
public class CoinMarketConfig {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String symbol;

    @Column
    private String type;


    @Column
    private Integer upgrade_rank_value;


}
