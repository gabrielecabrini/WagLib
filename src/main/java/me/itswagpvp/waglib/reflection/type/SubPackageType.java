package me.itswagpvp.waglib.reflection.type;

import org.jetbrains.annotations.NotNull;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
public enum SubPackageType {
    ADVANCEMENT,
    ATTRIBUTE,
    BLOCK,
    BOSS,
    CHUNKIO,
    COMMAND,
    CONFIGURATION,
    CONVERSATIONS,
    ENCHANTMENTS,
    ENTITY,
    EVENT,
    GENERATOR,
    HELP,
    INVENTORY,
    LEGACY,
    MAP,
    METADATA,
    PERSISTENCE,
    POTION,
    PROFILE,
    PROJECTILES,
    SCHEDULER,
    SCOREBOARD,
    STRUCTURE,
    TAG,
    UPDATER,
    UTIL;

    private final @NotNull String name;

    SubPackageType() {
        name = PackageType.CRAFTBUKKIT + "." + name().toLowerCase();
    }

    public @NotNull String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
