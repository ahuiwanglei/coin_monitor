package com.coin.monitor.dao;

import com.coin.monitor.entity.CoinMarketConfig;
import com.coin.monitor.entity.Orderbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderBookRepository extends JpaRepository<Orderbook, Long> {

    Orderbook findBySymbol(String symbol);

    @Query("select u from Orderbook u order by u.rate desc")
    List<Orderbook> findAllOrderbook();
}
