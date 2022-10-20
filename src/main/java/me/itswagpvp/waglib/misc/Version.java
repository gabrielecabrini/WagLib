package me.itswagpvp.waglib.misc;

import org.bukkit.Bukkit;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class Version {

    /**
     * @return The major server version (Like for 1.17.2 it will return 17)
     */
    public static int getMajorServerVersion() {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        String[] versionSplit = version.split("_");
        return Integer.parseInt(versionSplit[1]);
    }
}
