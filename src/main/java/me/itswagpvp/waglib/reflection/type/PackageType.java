package me.itswagpvp.waglib.reflection.type;

import me.itswagpvp.waglib.reflection.ReflectionUtil;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public enum PackageType {
    // Some versions didn't have nms version suffix.
    MINECRAFT_SERVER("net.minecraft.server" + (ReflectionUtil.getNmsVersion().isEmpty() ? "" : "." + ReflectionUtil.getNmsVersion())),
    CRAFTBUKKIT(Bukkit.getServer().getClass().getPackage().getName());

    private final @NotNull String name;

    PackageType(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull String toString() {
        return name;
    }
}
