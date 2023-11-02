package com.example.lab6;

public class Item {
   private String itemName;
   private String itemHeight;
   private String itemMass;

   public Item(String name, String height, String mass) {
       this.itemName = name;
       this.itemHeight = name;
       this.itemMass = name;

   }

   public String getItemName() {
       return this.itemName;
   }

    public void putItemName(String name) {
        this.itemName = name;
       return;
    }
    public String getItemHeight() {
        return this.itemHeight;
    }


    public void putItemHeight(String height) {
        this.itemHeight = height;
        return;
    }
    public String getItemMass() {
        return this.itemMass;
    }

    public void putItemMass(String mass) {
        this.itemMass = mass;
        return;
    }
}
