package me.itswagpvp.waglib.misc;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public class ListUtils {

    /**
     * @param list The list to be colorized
     * @return the colorized list
     */
    public static List<String> colorizeList(List<String> list) {
        List<String> colorizedList = new ArrayList<>();
        for (String line : list) colorizedList.add(ChatColor.translateAlternateColorCodes('&', line));
        return colorizedList;
    }
}
