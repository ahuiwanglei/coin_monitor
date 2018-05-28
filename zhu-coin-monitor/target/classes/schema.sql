DROP TABLE IF EXISTS tb_marketlist;
CREATE TABLE tb_marketlist(
  id int(12) NOT NULL AUTO_INCREMENT,
  noid int(20),
  symbol char(20),
  name char(20),
  rate char(10),
  rate_percent char(20),
  marketcap char(30),
  rank int(5) COMMENT '实时排名',
  history_rank int(5) COMMENT  '上次排名',
  is_remind int(2) COMMENT '0：未提醒， 1:已提醒'
);

DROP TABLE IF EXISTS tb_coin_market_config;
CREATE TABLE tb_coin_market_config(
  id int(12) NOT NULL AUTO_INCREMENT,
  symbol char(20),
  type int(2) DEFAULT 0 COMMENT  '0：排名升级，',
  upgrade_rank_value int(5) COMMENT '排名升级N提醒'
);

DROP TABLE IF EXISTS tb_orderbooks;
CREATE TABLE tb_orderbooks(
  id int(12) NOT NULL AUTO_INCREMENT,
  symbol char(20),
  asks char(30),
  bids char(30),
  rate char(30),
);