package org.wooper.wooperplugin;

import dev.vankka.enhancedlegacytext.EnhancedLegacyText;
import fr.mrmicky.fastinv.FastInvManager;
import net.kyori.adventure.text.Component;
import org.bukkit.plugin.java.JavaPlugin;
import org.wooper.wooperplugin.Menus.MenuInv;
import org.wooper.wooperplugin.commands.Menu;
import org.wooper.wooperplugin.handlers.MenuHandler;
import org.wooper.wooperplugin.handlers.TorchHandler;

import java.util.logging.Logger;

/**
 * The MenuInv class implements the InventoryHolder interface.
 * It represents a custom inventory menu for the WooperPlugin.
 * This class is responsible for creating the menu, setting up the items in the menu, and providing access to the menu.
 * It uses the Bukkit API to create an inventory and the Kyori Adventure API to create text components for item names and lore.
 */
public final class WooperPlugin extends JavaPlugin {

    private static Logger logger;

    {
        logger = getLogger();
    }

    /**
     * This method is used to log information messages in a specific format.
     * The format is: <###>-------------< {message} >-------------<###>
     *
     * @param message The message that needs to be logged.
     */
    public static void logInfo(String message) {
        logger.info("<###>-------------< " + message + " >-------------<###>");
    }

    /**
     * This method is used to log warning messages in a specific format.
     * The format is: <###>-------------< {message} >-------------<###>
     *
     * @param message The warning message that needs to be logged.
     */
    public static void logWarning(String message) {
        logger.warning("<###>-------------< " + message + " >-------------<###>");
    }

    /**
     * This method is used to create a Component from a given text string.
     * It uses the EnhancedLegacyText library to build the Component.
     *
     * @param input The text string that needs to be converted into a Component.
     * @return The created Component.
     */
    public static Component makeComponent(String input) {
        
        return EnhancedLegacyText.get().buildComponent(input).build();
    }

    /**
     * This method is called when the plugin is enabled.
     * It logs a message indicating that the WooperPlugin has been loaded.
     * It also initializes various handlers and menus, and registers the plugin with FastInvManager.
     */
    @Override
    public void onEnable() {
        // Plugin startup logic

        // Initialize TorchHandler
        new TorchHandler(this);
        // Initialize MenuHandler
        new MenuHandler(this);
        // Initialize Menu
        new Menu(this);
        // Initialize MenuInv
        new MenuInv(this);
        // Register FastInv with the plugin
        FastInvManager.register(this);
        
        logInfo("WooperPlugin has been loaded!");

    }

    /**
     * This method is called when the plugin is disabled.
     * It logs a message indicating that the WooperPlugin has been disabled.
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logInfo("WooperPlugin has been disabled!");
    }


}
