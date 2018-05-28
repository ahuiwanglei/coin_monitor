package com.coin.monitor.entity.net;

import java.util.List;

public class GateMarkeList {

    private String result;
    private List<DataBean> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * no : 1
         * symbol : EOS
         * name : EOS
         * name_en : EOS
         * name_cn : EOS
         * pair : eos_usdt
         * rate : 12.22
         * vol_a : 1214122.7456451871
         * vol_b : 15,087,737
         * curr_a : EOS
         * curr_b : USDT
         * curr_suffix :  USDT
         * rate_percent : 1.40
         * trend : up
         * supply : 1000000000
         * marketcap : 12,219,300,000
         */

        private int no;
        private String symbol;
        private String name;
        private String name_en;
        private String name_cn;
        private String pair;
        private String rate;
        private String vol_a;
        private String vol_b;
        private String curr_a;
        private String curr_b;
        private String curr_suffix;
        private String rate_percent;
        private String trend;
        private int supply;
        private String marketcap;

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName_cn() {
            return name_cn;
        }

        public void setName_cn(String name_cn) {
            this.name_cn = name_cn;
        }

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getVol_a() {
            return vol_a;
        }

        public void setVol_a(String vol_a) {
            this.vol_a = vol_a;
        }

        public String getVol_b() {
            return vol_b;
        }

        public void setVol_b(String vol_b) {
            this.vol_b = vol_b;
        }

        public String getCurr_a() {
            return curr_a;
        }

        public void setCurr_a(String curr_a) {
            this.curr_a = curr_a;
        }

        public String getCurr_b() {
            return curr_b;
        }

        public void setCurr_b(String curr_b) {
            this.curr_b = curr_b;
        }

        public String getCurr_suffix() {
            return curr_suffix;
        }

        public void setCurr_suffix(String curr_suffix) {
            this.curr_suffix = curr_suffix;
        }

        public String getRate_percent() {
            return rate_percent;
        }

        public void setRate_percent(String rate_percent) {
            this.rate_percent = rate_percent;
        }

        public String getTrend() {
            return trend;
        }

        public void setTrend(String trend) {
            this.trend = trend;
        }

        public int getSupply() {
            return supply;
        }

        public void setSupply(int supply) {
            this.supply = supply;
        }

        public String getMarketcap() {
            return marketcap;
        }

        public void setMarketcap(String marketcap) {
            this.marketcap = marketcap;
        }
    }
}
