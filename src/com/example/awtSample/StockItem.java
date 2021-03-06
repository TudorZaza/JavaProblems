package com.example.awtSample;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityStock=0;
    private int reserved=0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        quantityStock=0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {

        return quantityStock- reserved;
    }
    public int reserveStock(int quantity) {
        if (quantity<= quantityInStock()){
        reserved+=quantity;
        return quantity;
    }
        return 0;
    }


    public int unreserveStock(int quantity) {
        if(quantity<= reserved) {
            reserved-= quantity;
            return quantity;
        }
        return 0;
    }


    public void setPrice(double price) {
        if(price>0)
        this.price = price;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public void adjustStock (int quantity) {
        int newQuantity=this.quantityStock + quantity;
        if (newQuantity>=0) {
            this.quantityStock=newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj==this) {
            return true;
        }

        if((obj==null) || (obj.getClass() !=this.getClass())){
            return false;
        }

        String objName= ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() +31;
    }

    @Override
    public String toString() {
        return this.name + ":" +this.price;
    }

    @Override
    public int compareTo(StockItem o) {
            System.out.println("Entering StockItem.compareTo");
            if (this==o)
                return 0;
            if (o!=null) {
                return this.name.compareTo(o.toString());
            }

            throw new NullPointerException();
        }
}
