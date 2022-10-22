package me.itswagpvp.waglib.redis.events.spigot;

import me.itswagpvp.waglib.redis.events.RedisMessageReceivedEvent;
import me.itswagpvp.waglib.redis.models.MessageTransferObject;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author _ItsWagPvP
 * @since 1.0.0
 * Asynchronous Spigot Event class used when message was received from subscribed channel.
 * <p>
 * Data can be changed, so sync Spigot Event will be triggered with updated data
 */
@SuppressWarnings("unused")
public class AsyncRedisMessageReceivedEvent extends Event implements RedisMessageReceivedEvent, Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    private boolean cancelled;

    /**
     * Name of the channel the message came from
     */
    private String channel;

    /**
     * MessageTransferObject containing message's data
     */
    private MessageTransferObject messageTransferObject;

    /**
     * Constructs the instance of the Event
     *
     * @param channel               Channel in which was the message published
     * @param messageTransferObject {@link MessageTransferObject} object containing data about published message
     */
    public AsyncRedisMessageReceivedEvent(String channel, MessageTransferObject messageTransferObject) {
        super(true);
        this.cancelled = false;
        this.channel = channel;
        this.messageTransferObject = messageTransferObject;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public MessageTransferObject getMessageTransferObject() {
        return messageTransferObject;
    }

    public void setMessageTransferObject(MessageTransferObject messageTransferObject) {
        this.messageTransferObject = messageTransferObject;
    }

    @Override
    public String getSenderIdentifier() {
        return this.messageTransferObject.getSenderIdentifier();
    }

    @Override
    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
