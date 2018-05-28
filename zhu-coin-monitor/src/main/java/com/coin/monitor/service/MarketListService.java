package com.coin.monitor.service;

import com.coin.monitor.entity.CoinMarketConfig;
import com.coin.monitor.entity.MarketList;
import com.coin.monitor.entity.Orderbook;

import java.util.List;

public interface MarketListService {

    List<MarketList> getAllList();

    List<CoinMarketConfig> getConfigAllList();

    void storeMarketList();

    MarketList udpateRemind(MarketList marketList);

    void storeOrderBooks();

    List<Orderbook> getOrderbooksList();
}
