package me.itswagpvp.waglib.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class WagLib extends JavaPlugin {

    private static WagLib plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        plugin.getLogger().info("WagLib has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static WagLib getInstance() {
        return plugin;
    }
}
