package me.itswagpvp.waglib.plugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.itswagpvp.waglib.misc.MCVersion;
import me.itswagpvp.waglib.plugin.metrics.BukkitMetrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public final class WagLib extends JavaPlugin {

    private static WagLib plugin;

    public static MCVersion version;
    public static ProtocolManager protocolManager;
    public static List<Pattern> additionalRGBFormats = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        plugin.getLogger().info("WagLib " + plugin.getDescription().getVersion() + " has been enabled!");

        // Load bStats metrics
        int pluginId = 16714;
        BukkitMetrics metrics = new BukkitMetrics(this, pluginId);

        List<String> formats = Arrays.asList("#([0-9a-fA-F])", "([0-9a-fA-F])", "([0-9a-fA-F])", "([0-9a-fA-F])", "([0-9a-fA-F])", "([0-9a-fA-F])");
        for (String format : formats) additionalRGBFormats.add(Pattern.compile(format));

        protocolManager = ProtocolLibrary.getProtocolManager();
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

}
