package net.liqht.liqhtlab;

import net.liqht.liqhtlab.admin.commands.VanishCommand;
import net.liqht.liqhtlab.admin.items.HadesScythe;
import net.liqht.liqhtlab.admin.items.ItemManager;
import net.liqht.liqhtlab.everyone.listeners.ServerJoinStuff;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LiqhtLab extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();

        Bukkit.getPluginManager().registerEvents(new ServerJoinStuff(), this);
        Bukkit.getPluginManager().registerEvents(new HadesScythe(), this);

        getCommand("hades").setExecutor(new HadesScythe());
        getCommand("vanish").setExecutor(new VanishCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
