package net.liqht.liqhtlab;

import net.liqht.liqhtlab.admin.items.RizzWand;
import net.liqht.liqhtlab.everyone.listeners.ServerJoinMessage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LiqhtLab extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ServerJoinMessage(), this);

        getCommand("rizzwand").setExecutor(new RizzWand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
