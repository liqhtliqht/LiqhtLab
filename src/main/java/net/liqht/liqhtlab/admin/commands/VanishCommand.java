package net.liqht.liqhtlab.admin.commands;

import net.liqht.liqhtlab.LiqhtLab;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {
    private List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                    if (vanished.contains(player.getUniqueId())) { // they un-vanish
                        vanished.remove(player.getUniqueId());
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "You have un-vanished!");

                        for (Player target : Bukkit.getOnlinePlayers()) {
                            target.showPlayer(player);
                        }
                    } else { // they vanish

                        vanished.add(player.getUniqueId());
                        player.sendMessage(ChatColor.DARK_PURPLE + "You have vanished!");

                        for (Player target : Bukkit.getOnlinePlayers()) {
                            target.hidePlayer(player);
                        }
                    }
            }
        }

        return false;
    }
}
