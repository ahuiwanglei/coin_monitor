package com.coin.monitor.dao;

import com.coin.monitor.entity.MarketList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MarketListRepository extends JpaRepository<MarketList, Long> {
    @Query("select u from MarketList u where u.noid = ?1 ")
    MarketList findNoId(int no);

    @Query("select u from MarketList u order by rank")
    List<MarketList> findAllMarketList();
}
