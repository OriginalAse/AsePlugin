package me.rishabhvenu.aseplugin;

import me.rishabhvenu.aseplugin.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AsePlugin extends JavaPlugin {
    private final boolean hasDefaultConfig;

    private ConfigManager configManager;

    public AsePlugin(boolean hasDefaultConfig) {
        this.hasDefaultConfig = hasDefaultConfig;
    }

    public void onEnable() {
        if (this.hasDefaultConfig)
            saveDefaultConfig();
        this.configManager = new ConfigManager(this);
        onStart();
    }

    public void onDisable() {
        onEnd();
    }

    public void onStart() {}

    public void onEnd() {}

    public ConfigManager getConfigManager() {
        return this.configManager;
    }
}
