package me.rishabhvenu.aseplugin.managers;

import me.rishabhvenu.aseplugin.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class GuiManager {
    public static Inventory createGUI(Player player, int size, String title) {
        return Bukkit.createInventory((InventoryHolder)player, size, ColorUtil.translate(title));
    }

    public static void setItem(Inventory inventory, int index, ItemStack item) {
        inventory.setItem(index, item);
    }

    public static void openInventory(Player player, Inventory inventory) {
        player.openInventory(inventory);
    }
}
