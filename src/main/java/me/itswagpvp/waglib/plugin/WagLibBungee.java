package me.itswagpvp.waglib.plugin;

import me.itswagpvp.waglib.plugin.metrics.BungeeMetrics;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public class WagLibBungee extends Plugin {
    private static WagLibBungee plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        plugin.getLogger().info("WagLibBungee " + plugin.getDescription().getVersion() + " has been enabled!");

        // Load bStats metrics
        int pluginId = 16715;
        BungeeMetrics metrics = new BungeeMetrics(this, pluginId);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @SuppressWarnings("unused")
    public static WagLibBungee getInstance() {
        return plugin;
    }

}
