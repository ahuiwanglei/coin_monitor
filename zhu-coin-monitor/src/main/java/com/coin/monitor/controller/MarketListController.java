package com.coin.monitor.controller;

import com.coin.monitor.entity.CoinMarketConfig;
import com.coin.monitor.entity.MarketList;
import com.coin.monitor.entity.Orderbook;
import com.coin.monitor.service.MarketListService;
import com.coin.monitor.util.Result;
import com.coin.monitor.util.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/marketlist")
public class MarketListController {

    @Autowired
    MarketListService marketListService;

    @RequestMapping("/list")
    @ResponseBody
    public Result<List<MarketList>> getAllList() {
        List<MarketList> marketLists = marketListService.getAllList();
        return ResultFactory.getSuccessResult(marketLists);
    }

    @RequestMapping("/config/list")
    @ResponseBody
    public List<CoinMarketConfig> getConfigList() {
        List<CoinMarketConfig> marketLists = marketListService.getConfigAllList();
        return marketLists;
    }

    @RequestMapping("/updateRemind")
    @ResponseBody
    public Result<MarketList> updateRemind(@RequestBody MarketList marketList) {
        MarketList remind = marketListService.udpateRemind(marketList);
        return ResultFactory.getSuccessResult(remind);
    }


    @RequestMapping("/orderbooks")
    @ResponseBody
    public Result<List<Orderbook>> getOrderBookList() {
        List<Orderbook> orderbooks = marketListService.getOrderbooksList();
        return ResultFactory.getSuccessResult(orderbooks);
    }





}
