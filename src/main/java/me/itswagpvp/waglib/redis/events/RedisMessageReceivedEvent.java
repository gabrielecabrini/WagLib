package me.itswagpvp.waglib.redis.events;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 * <p> Redis incoming message Event interface. Used for handling differences between Spigot and Bungee Event API.
 */
@SuppressWarnings("unused")
public interface RedisMessageReceivedEvent {

    /**
     * Obtains the sender's identifier
     *
     * @return Sender server's name
     */
    String getSenderIdentifier();

    /**
     * Obtains the name of the channel message came from
     *
     * @return Name of the incoming channel
     */
    String getChannel();

    /**
     * Obtains message received
     *
     * @return Message received
     */
    String getMessage();

    /**
     * Obtains message timestamp
     *
     * @return TimeStamp of the message
     */
    long getTimeStamp();

    /**
     * Obtains object from received message by provided type
     *
     * @param objectClass Object class
     * @param <T>         Object type
     * @return Parsed object (null if it cannot be parsed)
     */
    <T> T getMessageObject(Class<T> objectClass);

}
