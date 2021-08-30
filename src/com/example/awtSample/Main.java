package com.example.awtSample;

import java.util.Map;

public class Main {

    private static StockList stockList= new StockList();

    public static void main(String[] args) {
        StockItem temp;
        temp= new StockItem("bread", 0.86,100);
        stockList.addStock(temp);

        temp= new StockItem("cake",1.10,7);
        stockList.addStock(temp);


        temp= new StockItem("car",22,2);
        stockList.addStock(temp);

        temp= new StockItem("chair",62,10);
        stockList.addStock(temp);

        temp= new StockItem("door",32,45);
        stockList.addStock(temp);

        temp= new StockItem("juice",45,34);
        stockList.addStock(temp);

        temp= new StockItem("phone",22,32);
        stockList.addStock(temp);

        temp= new StockItem("towel",13,48);
        stockList.addStock(temp);

        temp= new StockItem("vase",4,20);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket timsBasket= new Basket("Tim");
        sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);

        sellItem(timsBasket,"car",1);

        System.out.println(timsBasket);

        sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);
        sellItem(timsBasket,"spinach",1);

        System.out.println(stockList);

        for(Map.Entry<String,Double> price:stockList.priceList().entrySet()){

        }

//        temp=new StockItem("pen", 1.22);
//        stockList.Items().put(temp.getName(),temp); // not letting the map modified,unless used the methods we want to
        stockList.Items().get("car").adjustStock(2000); // Even if the stockList.Items is an unmodifiable map, the elements in it can be modified
        System.out.println(stockList);
        stockList.Items().get("car").adjustStock(-1000);
        System.out.println(stockList);


    }

    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve item from stock list
        StockItem stockItem= stockList.get(item);
        if (stockItem==null) {
            System.out.println("We don t sell "+ item);
            return 0;
        }
        if (stockList.sellStock(item,quantity) !=0) {
            basket.addToBasket(stockItem,quantity);
            return quantity;
        }
        return 0;
    }
}
