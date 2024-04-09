package org.wooper.glovedrpg.Menus;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.wooper.glovedrpg.GlovedRPG;
import java.util.ArrayList;
import java.util.List;

import static org.wooper.glovedrpg.GlovedRPG.*;

public class MenuInv implements InventoryHolder {

    private final Inventory inventory;

    public MenuInv(GlovedRPG plugin) {
        this.inventory = plugin.getServer().createInventory(this, 9 * 6);
        this.inventory.setItem(20, getItem(new ItemStack(Material.NETHER_STAR), "<bold><italics>Warps", "/warps"));
        this.inventory.setItem(21, getItem(new ItemStack(Material.GOLD_INGOT), "<bold><italics>Shop", "/shop"));
        this.inventory.setItem(22, getItem(new ItemStack(Material.GRASS_BLOCK), "<bold><italics>Spawn", "/spawn"));
        this.inventory.setItem(23, getItem(new ItemStack(Material.RED_BED), "<bold><italics>Homes", "/homes"));
        this.inventory.setItem(24, getItem(new ItemStack(Material.COMPASS), "<bold><italics>RTP", "/rtp"));
        this.inventory.setItem(30, getItem(new ItemStack(Material.CRAFTING_TABLE), "<bold><italics>Craft", "/craft"));
        this.inventory.setItem(31, getItem(new ItemStack(Material.WRITABLE_BOOK), "<bold><italics>Skills", "/skills"));
        this.inventory.setItem(32, getItem(new ItemStack(Material.ENDER_CHEST), "<bold><italics>Ender Chest", "/ender"));
        // this.inventory.setItem(13, getItem(new ItemStack(Material.EMERALD), "Jobs", "/jobs browse"));
        logger.info("Menu Created!");
    }

    @Override
    public @NotNull Inventory getInventory() {
        logger.info("Returning menu inventory.");
        return this.inventory;
    }

    public static ItemStack getItem(ItemStack item, String name, String... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.displayName(plugin.makeComponent(name));
        List<Component> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(plugin.makeComponent(s));
        }
        meta.lore(lores);
        // logger.info("Item created: " + item.getType() + " with name: " + name + " and lore: " + lores + ".");

        item.setItemMeta(meta);
        return item;
    }
}
