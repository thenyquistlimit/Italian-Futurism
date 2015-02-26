package com.ikimuhendis.ldrawer.sample;

public class DrawerItem {

    String ItemName;
    int imgResID;

    public DrawerItem(String itemName, int imgResID) {
        super();
        ItemName = itemName;
        this.imgResID = imgResID;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getImgResID() {
        return imgResID;
    }

}
