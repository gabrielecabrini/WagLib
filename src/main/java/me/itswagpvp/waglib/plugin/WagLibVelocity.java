package me.itswagpvp.waglib.plugin;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

import java.util.logging.Logger;

@Plugin(id = "waglibvelocity", name = "WagLibVelocity", version = "Velocity", authors = {"_ItsWagPvP"})
@SuppressWarnings("unused")
public class WagLibVelocity {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public WagLibVelocity(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;

        logger.info("Started WagLib Velocity");
    }
}
