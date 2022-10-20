package me.itswagpvp.waglib.plugin;

import net.md_5.bungee.api.plugin.Plugin;

public class WagLibBungee extends Plugin {
    private static WagLibBungee plugin;



    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        plugin.getLogger().info("WagLibBungee has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static WagLibBungee getInstance() {
        return plugin;
    }

}
