package net.liqht.liqhtlab.admin.items;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Objects;

public class HadesScythe implements CommandExecutor, Listener {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.isOp()) {
                player.getInventory().addItem(ItemManager.hadesScythe);
                player.sendMessage(ChatColor.DARK_RED + "You have received the power of Hades");
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            }
        }

        return false;
    }


    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getDisplayName().equals(ChatColor.DARK_RED + "Hades")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 999999999,
                    true, true, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 5,
                    true, true, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 200, 5,
                    true, true, true));
            player.sendMessage(ChatColor.DARK_PURPLE + "You have activated the true powers of Hades for 10 seconds!");
        }
    }
}
