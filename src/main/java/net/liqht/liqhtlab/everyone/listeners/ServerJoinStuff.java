package net.liqht.liqhtlab.everyone.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ServerJoinStuff implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD + event.getPlayer().getDisplayName() + " has joined the server\n\n");

        event.getPlayer().sendMessage(ChatColor.BOLD + "Welcome to the Liqht_'s Lab!\n\n");
        event.getPlayer().sendMessage("We use mods on this server that will enhance your community experience. For more into, go here\n\n");
        event.getPlayer().sendMessage(ChatColor.UNDERLINE + "https://docs.google.com/document/d/1mKJiI4fFXdLH6kIIYt2BeQe27PiKwnlGMbhEWElO6pE/edit?usp=sharing\n");

        event.getPlayer().setResourcePack("https://download.mc-packs.net/pack/6c46e756bda7d12c0844cd49519870ad48b6670a.zip");

    }
}
