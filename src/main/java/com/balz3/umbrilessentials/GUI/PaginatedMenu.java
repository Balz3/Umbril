package com.balz3.umbrilessentials.GUI;

import org.bukkit.event.inventory.InventoryType;

public abstract class PaginatedMenu extends Menu {

    //Keep track of what page the menu is on
    protected int page = 0;

    protected int maxItemsPerPage;

    public PaginatedMenu(InventoryType inventoryType, String title) {
        super(inventoryType, title);
        maxItemsPerPage = inventoryType.getDefaultSize();
    }

    //Set the border and menu buttons for the menu
//    public void addMenuBorder(){
//        inventory.setItem(48, );
//
//        inventory.setItem(49, );
//
//        inventory.setItem(50, );
//
//        for (int i = 0; i < 10; i++) {
//            if (inventory.getItem(i) == null) {
//                inventory.setItem(i, super.FILLER_GLASS);
//            }
//        }
//
//        inventory.setItem(17, super.FILLER_GLASS);
//        inventory.setItem(18, super.FILLER_GLASS);
//        inventory.setItem(26, super.FILLER_GLASS);
//        inventory.setItem(27, super.FILLER_GLASS);
//        inventory.setItem(35, super.FILLER_GLASS);
//        inventory.setItem(36, super.FILLER_GLASS);
//
//        for (int i = 44; i < 54; i++) {
//            if (inventory.getItem(i) == null) {
//                inventory.setItem(i, super.FILLER_GLASS);
//            }
//        }
//    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}
