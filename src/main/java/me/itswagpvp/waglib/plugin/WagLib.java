package me.itswagpvp.waglib.plugin;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public final class WagLib extends JavaPlugin {

    private static WagLib plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        plugin.getLogger().info("WagLib has been enabled!");

    }

    @SuppressWarnings("unused")
    public static WagLib getInstance() {
        return plugin;
    }

}
