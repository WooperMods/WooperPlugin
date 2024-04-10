package org.wooper.wooperplugin.Menus;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.wooper.wooperplugin.WooperPlugin;

import java.util.ArrayList;
import java.util.List;

import static org.wooper.wooperplugin.commands.Menu.menuComponent;

/**
 * The MenuInv class implements the InventoryHolder interface.
 * It represents a custom inventory menu for the WooperPlugin.
 * This class is responsible for creating the menu, setting up the items in the menu, and providing access to the menu.
 * It uses the Bukkit API to create an inventory and the Kyori Adventure API to create text components for item names and lore.
 */
public class MenuInv implements InventoryHolder {

    private final Inventory inventory;
    
    /**
     * Constructor for the MenuInv class.
     * It creates an inventory with 9 rows (54 slots) and sets various items in specific slots.
     * Each item represents a different functionality of the plugin and is created using the getItem method.
     * The item's name and lore are set to provide information about the functionality it represents.
     * After all items are set, it logs a message indicating that the menu has been created.
     *
     * @param plugin The instance of the WooperPlugin.
     */
    public MenuInv(WooperPlugin plugin) {
        
        this.inventory = plugin.getServer().createInventory(this, 9 * 6, menuComponent);
        this.inventory.setItem(20, getItem(new ItemStack(Material.NETHER_STAR), "&b&lWarps", "&a/warps"));
        this.inventory.setItem(21, getItem(new ItemStack(Material.GOLD_INGOT), "&6&lShop", "&a/shop"));
        this.inventory.setItem(22, getItem(new ItemStack(Material.GRASS_BLOCK), "&3&lSpawn", "&a/spawn"));
        this.inventory.setItem(23, getItem(new ItemStack(Material.RED_BED), "&4&lHomes", "&a/homes"));
        this.inventory.setItem(24, getItem(new ItemStack(Material.COMPASS), "&2&lRTP", "&a/rtp"));
        this.inventory.setItem(30, getItem(new ItemStack(Material.CRAFTING_TABLE), "&6&lCraft", "&a/craft"));
        this.inventory.setItem(31, getItem(new ItemStack(Material.WRITABLE_BOOK), "&4&lSkills", "&a/skills"));
        this.inventory.setItem(32, getItem(new ItemStack(Material.ENDER_CHEST), "&5&lEnder Chest", "&a/ender"));
        // this.inventory.setItem(13, getItem(new ItemStack(Material.EMERALD), "Jobs", "/jobs browse"));
        
    }

    /**
     * This method is used to retrieve the inventory created in the MenuInv class.
     * It logs a message indicating that the menu inventory is being returned.
     *
     * @return The inventory created in the MenuInv class.
     */
    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
    
    public void openMenu(Player player) {
        
        player.openInventory(this.inventory);
    }

    /**
     * This method is used to create a custom ItemStack with a given name and lore.
     * It first retrieves the ItemMeta from the provided ItemStack, then sets the display name and lore of the item.
     * The display name and lore are converted into Components using the makeComponent method from the plugin instance.
     * Finally, it sets the modified ItemMeta back to the ItemStack and returns it.
     *
     * @param item The original ItemStack that needs to be customized.
     * @param name The display name that needs to be set for the item.
     * @param lore The lore that needs to be set for the item. It can be multiple lines.
     * @return The customized ItemStack with the provided name and lore.
     */
    public static ItemStack getItem(ItemStack item, String name, String... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.displayName(WooperPlugin.makeComponent(name));
        List<Component> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(WooperPlugin.makeComponent(s));
        }
        meta.lore(lores);
        // logger.info("Item created: " + item.getType() + " with name: " + name + " and lore: " + lores + ".");

        item.setItemMeta(meta);
        return item;
    }
}
