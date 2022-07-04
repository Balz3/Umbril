package com.balz3.umbrilessentials.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public abstract class Menu implements InventoryHolder {


    //Protected values that can be accessed in the menus
    protected Inventory inventory;
    protected InventoryType inventoryType;
    protected String title;
    final ItemStack FILLER_GLASS = buildItem(Material.GRAY_STAINED_GLASS_PANE, "", "");

    public Menu(InventoryType inventoryType, String title) {}


    public abstract InventoryType getMenuType();

    public abstract void menuHandler(InventoryClickEvent e);

    public abstract void setMenuItems();

    public void open() {
        inventory = Bukkit.createInventory(this, inventoryType, title);

        this.setMenuItems();
    }

    //Overridden method from the InventoryHolder interface
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    //Helpful utility method to fill all remaining slots with "filler glass"
    public void setFillerGlass(){
        for (int i = 0; i < inventoryType.getDefaultSize(); i++) {
            if (inventory.getItem(i) == null){
                inventory.setItem(i, FILLER_GLASS);
            }
        }
    }

    public ItemStack buildItem(Material material, String displayName, String lore) {

        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }


}
