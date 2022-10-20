package me.itswagpvp.waglib.inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class ItemSerializer {

    /**
     * @param data Base64 String of the serialized ItemStack
     * @return ItemStack object
     */
    public static ItemStack deserializeItemStack(String data) {
        byte[] serializedObject;
        ItemStack i = null;
        try {
            serializedObject = Base64.getDecoder().decode(data);

            //Input stream to read the byte array
            ByteArrayInputStream in = new ByteArrayInputStream(serializedObject);
            //object input stream to serialize bytes into objects
            BukkitObjectInputStream is = new BukkitObjectInputStream(in);

            //Use the object input stream to deserialize an object from the raw bytes
            i = (ItemStack) is.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }

        return i;

    }

    /**
     * @param item ItemStack to be serialized
     * @return the serialized ItemStack as a Base64 String
     */
    public static String serializeItemStack(ItemStack item) {
        String data;
        byte[] serializedObject = new byte[0];
        try {
            ByteArrayOutputStream io = new ByteArrayOutputStream();
            BukkitObjectOutputStream os = new BukkitObjectOutputStream(io);
            os.writeObject(item);
            os.flush();

            serializedObject = io.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Encode the serialized object into to the base64 format
        data = new String(Base64.getEncoder().encode(serializedObject));

        return data;
    }

}

