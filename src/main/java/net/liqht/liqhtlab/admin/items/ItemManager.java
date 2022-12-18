package net.liqht.liqhtlab.admin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemManager {
    public static ItemStack hadesScythe;

    public static void init() {
        createHadesScythe();
    }

    private static void createHadesScythe() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "Hades");
        meta.setLore(Arrays.asList(ChatColor.RED + "The Admin's Most Powerful Weapon"));
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10000, true);
        item.setItemMeta(meta);
        hadesScythe = item;
    }
}
