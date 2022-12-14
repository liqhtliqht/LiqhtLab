package net.liqht.liqhtlab.admin.items;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
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
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 999999999,
                    true, true, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 5,
                    true, true, true));
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 5,
                    true, true, true));

            player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 200);
            player.playSound(player.getLocation(), Sound.BLOCK_END_PORTAL_SPAWN, 1, 1);
        }
    }
}
