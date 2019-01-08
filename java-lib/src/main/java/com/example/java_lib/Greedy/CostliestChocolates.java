package com.example.java_lib.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CostliestChocolates {
    private static List<Chocolate> chocoList = new ArrayList<>();

    public static void main(String[] args) {
        String numKidsStr = "5";
        String chocolates = "Kinder:30:2,Cadbury:15:8";

        Integer kidsCount = Integer.parseInt(numKidsStr);
        List<Chocolate> chocoList = parseChocolates(chocolates);
        System.out.println("buyChocolatesAndGetPrice(): numKids:" + kidsCount + ", chocoList: " +  chocoList);
        int price = buyChocolatesAndGetPrice(kidsCount, chocoList);
        System.out.println("price: " + price);
    }

    //
    public static int buyChocolatesAndGetPrice(int numKids, List<Chocolate> chocoList){
//        System.out.println("buyChocolatesAndGetPrice(): numKids:" + numKids + ", chocoList: " +  chocoList);
        int price =0; int remainingKids = 0;
        price = chocoList.get(0).price;
        System.out.println("buyChocolatesAndGetPrice() price: " + price);
        if (chocoList.get(0).stock > numKids) {
            price = chocoList.get(0).price * numKids;
        }
        else {
//            numKids -= chocoList.get(0).stock;
            chocoList.remove(chocoList.get(0));
            price = buyChocolatesAndGetPrice(numKids, chocoList);
        }
        System.out.println("buyChocolatesAndGetPrice() final price: " + price);
    return price;

    }

    private static List<Chocolate> parseChocolates(String chocolates){
        List<Chocolate> chocoListTmp = new ArrayList<>();
        String [] chocos = chocolates.split(",");

        Arrays.stream(chocos).forEach(v-> {
            String [] chocoDetails = v.split(":");
            chocoListTmp.add(new Chocolate(chocoDetails[0],
                    Integer.parseInt(chocoDetails[1]),
                    Integer.parseInt(chocoDetails[2])));});

        //Approach 1 : COmparator
        Comparator<Chocolate> compChocos = Comparator.comparing(Chocolate::getPrice);
        chocoListTmp.sort(compChocos);

//        //Approach 2 : COmparator
//        Collections.sort(chocoListTmp, new Comparator<Chocolate>() {
//            @Override
//            public int compare(Chocolate o1, Chocolate o2) {
//                return o2.price-o1.price;
//            }
//        });

        return chocoListTmp;
    }

}

    class Chocolate{
        public String name;
        public int price;
        public int stock;
        public Chocolate(){};
        public Chocolate(String name, int price, int stock){
            this.name=name;
            this.price=price;
            this.stock=stock;
        }

        int getPrice(){return price;}

        @Override
        public String toString() {
            return "\nname: " + name + ", price: " + price + ", stock: " + stock;
        }
    }
