package me.itswagpvp.waglib.misc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public class BukkitUtils {

    /**
     * @return Random player from the server
     */
    public static Player getRandomPlayer() {
        final Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();

        if (!players.isEmpty()) {
            final int i = (int) ((players.size()) * Math.random());

            return players.toArray(new Player[0])[i];
        }

        return null;
    }
}
