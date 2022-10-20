package me.itswagpvp.waglib.misc;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 * <p>
 * [!] Works only from 1.16.5 or newer!
 */
@SuppressWarnings("unused")
public class PersistentData {
    private final Plugin plugin;
    private final PersistentDataType dataType;

    private ItemMeta meta;

    public PersistentData(Plugin plugin, PersistentDataType dataType) {
        this.plugin = plugin;
        this.dataType = dataType;
    }

    public PersistentData from(ItemMeta meta) {
        this.meta = meta;
        return this;
    }

    private @NotNull NamespacedKey obtainNamespacedKeyWith(@NotNull String key) {
        return new NamespacedKey(plugin, key);
    }

    private @NotNull PersistentDataContainer getContainer() {
        return meta.getPersistentDataContainer();
    }

    public <Z> void set(@NotNull String key, @NotNull Z value) {
        getContainer().set(obtainNamespacedKeyWith(key), dataType, value);
    }

    public <Z> Z get(@NotNull String key) {
        return (Z) getContainer().get(obtainNamespacedKeyWith(key), dataType);
    }

    public boolean has(@NotNull String key) {
        return getContainer().has(obtainNamespacedKeyWith(key), dataType);
    }
}
