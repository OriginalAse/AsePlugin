package me.rishabhvenu.aseplugin.utils;

import org.bukkit.ChatColor;

public class ColorUtil {
    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
