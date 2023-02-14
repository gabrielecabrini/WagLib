package me.itswagpvp.waglib.plugin;

import me.itswagpvp.waglib.misc.MCVersion;
import me.itswagpvp.waglib.plugin.metrics.BukkitMetrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public final class WagLib extends JavaPlugin {

    private static WagLib plugin;

    public static MCVersion version;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        plugin.getLogger().info("WagLib " + plugin.getDescription().getVersion() + " has been enabled!");

        // Load bStats metrics
        int pluginId = 16714;
        BukkitMetrics metrics = new BukkitMetrics(this, pluginId);

        version = MCVersion.fromPackageName(Bukkit.getServer().getClass().getPackage().getName());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @SuppressWarnings("unused")
    public static WagLib getInstance() {
        return plugin;
    }

    public MCVersion getVersion() {
        return version;
    }

}
