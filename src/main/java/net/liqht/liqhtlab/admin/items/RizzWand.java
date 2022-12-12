package net.liqht.liqhtlab.admin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class RizzWand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (sender.isOp()) {
                ItemStack rizzwanditem = new ItemStack(Material.STICK);
                ItemMeta rizzwanditemmeta = rizzwanditem.getItemMeta();
                rizzwanditemmeta.setDisplayName(ChatColor.DARK_PURPLE + "rizz wand");
                rizzwanditemmeta.setLore(Arrays.asList(ChatColor.LIGHT_PURPLE + ChatColor.ITALIC.toString() + "rizzes up anyone you see"));
                rizzwanditem.setItemMeta(rizzwanditemmeta);

                player.getInventory().addItem(rizzwanditem);
                player.sendMessage(ChatColor.DARK_PURPLE + "The Rizzard of Oz has received a weapon");

            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            }
        }
        return false;
    }
}
