package com.coin.monitor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tb_marketlist")
public class MarketList {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer noid;

    @Column
    private String symbol;

    @Column
    private String name;

    @Column
    private String rate;

    @Column
    private String rate_percent;

    @Column
    private String marketcap;

    @Column
    private Integer rank;

    @Column
    private Integer history_rank;

    @Column
    private Integer is_remind;
//    id int(12) NOT NULL AUTO_INCREMENT,
//    noid int(20),
//    symbol char(20),
//    name char(20),
//    rate DECIMAL(21,10),
//    rate_percent DECIMAL(21,10),
//    marketcap DECIMAL(31,5),
//    rank int(5) COMMENT '实时排名',
//    history_rank int(5) COMMENT  '上次排名',
//    is_remind int(2) COMMENT '0：未提醒， 1:已提醒'



}
