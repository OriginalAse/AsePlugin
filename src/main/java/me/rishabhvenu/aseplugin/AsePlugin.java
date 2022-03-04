package me.rishabhvenu.aseplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class AsePlugin extends JavaPlugin {
    private final boolean hasDefaultConfig;

    public AsePlugin(boolean hasDefaultConfig) {
        this.hasDefaultConfig = hasDefaultConfig;
    }

    public void onEnable() {
        if (this.hasDefaultConfig)
            saveDefaultConfig();
        onStart();
    }

    public void onDisable() {
        onEnd();
    }

    public void onStart() {}

    public void onEnd() {}

}
