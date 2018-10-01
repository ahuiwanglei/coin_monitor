package com.coin.monitor;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    /**
     * 二次指数平滑法求预测值
     * @param list 基础数据集合
     * @param year 未来第几期
     * @param modulus 平滑系数
     * @return 预测值
     */

    /**

     原文代码设置，当输入的数据数（list长度）小于10，  则不进行计算

     */
    private static Double getExpect(List<Double> list, int year, Double modulus ) {
        if (list.size() < 10 || modulus <= 0 || modulus >= 1) {
            return null;
        }


        Double modulusLeft = 1 - modulus;

        Double lastIndex = list.get(0);
        Double lastSecIndex = list.get(0);

        for (Double data :list) {
            lastIndex = modulus * data + modulusLeft * lastIndex;
            lastSecIndex = modulus * lastIndex + modulusLeft * lastSecIndex;
        }

        Double a = 2 * lastIndex - lastSecIndex;
        Double b = (modulus / modulusLeft) * (lastIndex - lastSecIndex);

        return a + b * year;
    }


    public static void main(String[] args) {
        List<Double> list = new LinkedList<Double>();
        list.add(30.177);
        list.add(30.1762);
        list.add(30.1761);
        list.add(30.1763);
        list.add(30.1774);
        list.add(30.1766);
        list.add(30.1767);
        list.add(30.177);
        list.add(30.179);
        list.add(30.1799);
        list.add(30.1813);
        list.add(30.1813);
        list.add(30.1816);
        list.add(30.1839);
        list.add(30.1847);
        list.add(30.1841);
        list.add(30.1824);
        list.add(30.1806);
        list.add(30.1802);
        list.add(30.179);
        list.add(30.1773);
        list.add(30.1769);
        list.add(30.1783);
        list.add(30.1822);
        list.add(30.1852);
        Double value = getExpect(list, 1, 0.6);
        System.out.println(value);
    }
}
