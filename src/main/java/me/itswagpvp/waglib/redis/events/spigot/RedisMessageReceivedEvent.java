package me.itswagpvp.waglib.redis.events.spigot;

import me.itswagpvp.waglib.redis.models.MessageTransferObject;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 * Spigot Event class used when message was received from subscribed channel.
 */
@SuppressWarnings("unused")
public class RedisMessageReceivedEvent extends Event implements me.itswagpvp.waglib.redis.events.RedisMessageReceivedEvent {
    private static final HandlerList HANDLERS = new HandlerList();

    /**
     * Name of the channel the message came from
     */
    private final String channel;

    /**
     * MessageTransferObject containing message's data
     */
    private final MessageTransferObject messageTransferObject;

    /**
     * Constructs the instance of the Event
     *
     * @param channel               Channel in which was the message published
     * @param messageTransferObject {@link MessageTransferObject} object containing data about published message
     */
    public RedisMessageReceivedEvent(String channel, MessageTransferObject messageTransferObject) {
        this.channel = channel;
        this.messageTransferObject = messageTransferObject;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public String getSenderIdentifier() {
        return this.messageTransferObject.getSenderIdentifier();
    }

    @Override
    public String getChannel() {
        return this.channel;
    }

    @Override
    public String getMessage() {
        return this.messageTransferObject.getMessage();
    }

    @Override
    public <T> T getMessageObject(Class<T> objectClass) {
        return this.messageTransferObject.parseMessageObject(objectClass);
    }

    @Override
    public long getTimeStamp() {
        return this.messageTransferObject.getTimestamp();
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
}