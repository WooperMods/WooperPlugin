package org.wooper.glovedrpg.handlers;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.wooper.glovedrpg.GlovedRPG;
import org.wooper.glovedrpg.Menus.MenuInv;
import org.wooper.glovedrpg.commands.Menu;

import java.util.Objects;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Material.CHEST;
import static org.wooper.glovedrpg.GlovedRPG.logger;

public class MenuHandler implements Listener {

    public MenuHandler(GlovedRPG plugin) {
        // Register the event
        getPluginManager().registerEvents(this, plugin);
        logger.info("MenuHandler has been registered!");
        logger.info("<###>-------------< Registered MenuHandler! >-------------<###>");
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        // Check if the holder is our MyInventory,
        // if yes, use instanceof pattern matching to store it in a variable immediately.
        assert inventory != null;
        if (!(inventory.getHolder(false) instanceof MenuInv menuInv)) {
            return;
        }
        event.setCancelled(true);

        if (event.getClickedInventory().getType().equals(InventoryType.CHEST)) {
            int slot = event.getSlot();

            if (slot == 20) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("warps");

            } else if (slot == 21) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("shop");

            } else if (slot == 22) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("spawn");

            } else if (slot == 23) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("homes");

            } else if (slot == 24) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("rtp");

            } else if (slot == 30) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("craft");

            } else if (slot == 31) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("skills");

            } else if (slot == 32) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("ender");

            } else if (slot == 13) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                player.closeInventory();
                player.performCommand("jobs browse");
            }

        } else {
            logger.info("Inventory Clicked: " + event.getSlot());
        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        Inventory inv = player.getInventory();
        inv.setItem(17, MenuInv.getItem(new ItemStack(CHEST), "Menu", "Click to Open the Menu!"));
    }

    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getView().getBottomInventory();
        int slot = event.getSlot();
        if (slot != 17 && !(inv.equals(event.getClickedInventory()))) {
            return;
        }

        event.setCancelled(true);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
        player.closeInventory();
        player.performCommand("menu");

    }

}
