package me.rishabhvenu.aseplugin.managers;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class CustomConfig extends YamlConfiguration {
    private final File configFile;

    public CustomConfig(Plugin plugin, String filename) {
        configFile = new File(plugin.getDataFolder(), filename);

        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            plugin.saveResource(filename, false);
        }

        try {
            load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
