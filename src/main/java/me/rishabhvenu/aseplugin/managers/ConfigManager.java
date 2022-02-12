package me.rishabhvenu.aseplugin.managers;

import me.rishabhvenu.aseplugin.AsePlugin;
import me.rishabhvenu.aseplugin.utils.ColorUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private static AsePlugin plugin;

    public ConfigManager(AsePlugin plugin) {
        ConfigManager.plugin = plugin;
    }

    public String getString(String path) {
        return ColorUtil.translate(getConfig().getString(path));
    }

    public int getInt(String text) {
        return getConfig().getInt(text);
    }

    public ConfigurationSection getConfigSection(String text) {
        return getConfig().getConfigurationSection(text);
    }

    public FileConfiguration getConfig() {
        return plugin.getConfig();
    }

    public void reloadConfig() {
        plugin.reloadConfig();
    }
}
