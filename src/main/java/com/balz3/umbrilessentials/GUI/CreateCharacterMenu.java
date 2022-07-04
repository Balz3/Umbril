package com.balz3.umbrilessentials.GUI;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class CreateCharacterMenu extends PaginatedMenu{

    public CreateCharacterMenu(InventoryType inventoryType, String title) {
        super(inventoryType, title);
    }

    @Override
    public InventoryType getMenuType() {
        return null;
    }

    @Override
    public void menuHandler(InventoryClickEvent e) {

    }

    @Override
    public void setMenuItems() {

    }
}
