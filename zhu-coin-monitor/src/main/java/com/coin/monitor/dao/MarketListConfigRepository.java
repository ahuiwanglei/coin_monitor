package com.coin.monitor.dao;

import com.coin.monitor.entity.CoinMarketConfig;
import com.coin.monitor.entity.MarketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarketListConfigRepository  extends JpaRepository<CoinMarketConfig, Long> {
    @Query("select u from CoinMarketConfig u where u.symbol =?1")
    CoinMarketConfig findSymbol(String symbol);
}
