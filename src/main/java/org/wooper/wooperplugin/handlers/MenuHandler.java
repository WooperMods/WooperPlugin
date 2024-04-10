package org.wooper.wooperplugin.handlers;

import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.wooper.wooperplugin.Menus.MenuInv;
import org.wooper.wooperplugin.WooperPlugin;

import java.util.Objects;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Material.CHEST;
import static org.wooper.wooperplugin.WooperPlugin.logInfo;
import static org.wooper.wooperplugin.commands.Menu.menuComponent;

/**
 * The MenuHandler class implements the Listener interface.
 * This class is responsible for handling various events related to the game menu.
 * It includes methods to handle events such as a player joining the game, a player clicking on an inventory, etc.
 * Each of these methods is annotated with the @EventHandler annotation to indicate that they are event handlers.
 */
public class MenuHandler implements Listener {

    /**
     * Constructor for the MenuHandler class.
     * It registers the MenuHandler as a listener for events in the Bukkit server.
     * This is done by calling the registerEvents method from the PluginManager instance retrieved from the Bukkit server.
     * The method takes two parameters: the listener (this) and the plugin instance.
     * After the event registration, it logs a message indicating that the MenuHandler has been registered.
     *
     * @param plugin The instance of the WooperPlugin.
     */
    public MenuHandler(WooperPlugin plugin) {
        getPluginManager().registerEvents(this, plugin);
        logInfo("Registered MenuHandler!");
    }

    /**
     * Event handler for inventory click events.
     * This method is triggered when a player clicks on an inventory.
     * It first checks if the clicked inventory is a MenuInv instance.
     * If it is not, the method returns immediately.
     * If it is, the method cancels the event to prevent the default behavior.
     * Then, it checks if the clicked inventory is a chest.
     * If it is, it retrieves the clicked slot and performs different actions based on the slot number.
     * For each slot, it plays a sound, closes the inventory, and performs a command.
     * If the clicked inventory is not a chest, it logs the clicked slot.
     *
     * @param event The inventory click event.
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        Component title = event.getView().title();
        int slot = event.getSlot();
        assert inventory != null;
        if (title != menuComponent) {
            return;
        }
        
        if ((Objects.requireNonNull(event.getClickedInventory()).getType().equals(InventoryType.CHEST)) && ((title == menuComponent))) {

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
            } else {
                event.setCancelled(true);
            }
            
        }
        
        
    }

    /**
     * Event handler for player join events.
     * This method is triggered when a player joins the game.
     * It first retrieves the player and their inventory.
     * Then, it adds a new item to the 18th slot of the player's inventory.
     * The new item is a chest with the name "Menu" and the lore "Click to Open the Menu!".
     * After adding the item, it logs a message indicating that the menu item has been added to the player's inventory.
     *
     * @param event The player join event.
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();
        inv.setItem(17, MenuInv.getItem(new ItemStack(CHEST), "&b&lMenu", "&aClick to Open the Menu!"));
        logInfo("Menu Item added to " + player.getName() + " inventory.");
    }

    /**
     * Event handler for inventory click events.
     * This method is triggered when a player clicks on an inventory.
     * It first retrieves the player who clicked and the bottom inventory of the clicked view.
     * Then, it checks if the clicked slot is not 17 and if the clicked inventory is not the bottom inventory.
     * If either of these conditions is true, the method returns immediately.
     * If both conditions are false, it plays a sound at the player's location, closes the player's inventory, cancels the event to prevent the default behavior, and performs the "menu" command.
     *
     * @param event The inventory click event.
     */
    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getView().getBottomInventory();
        int slot = event.getSlot();
        if ((slot == 17) && (inv == event.getClickedInventory())) {
            event.setCancelled(true);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            player.closeInventory();
            player.performCommand("menu");
        }
    }

}
