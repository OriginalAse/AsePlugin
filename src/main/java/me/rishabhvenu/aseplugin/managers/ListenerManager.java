package me.rishabhvenu.aseplugin.managers;

import me.rishabhvenu.aseplugin.AsePlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ListenerManager implements Listener {
    private final AsePlugin plugin;

    public ListenerManager(AsePlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public AsePlugin getPlugin() {
        return this.plugin;
    }
}
