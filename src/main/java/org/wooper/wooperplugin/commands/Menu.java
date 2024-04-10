package org.wooper.wooperplugin.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.wooper.wooperplugin.Menus.MenuInv;
import org.wooper.wooperplugin.WooperPlugin;

import java.util.Objects;

import static org.wooper.wooperplugin.WooperPlugin.logInfo;

/**
 * The Menu class implements the CommandExecutor interface.
 * This class is responsible for handling the "menu" command in the game.
 * It includes a constructor that registers the Menu command with the WooperPlugin and logs a message indicating that the Menu command has been registered.
 * It also includes an overridden onCommand method that is triggered when a player uses the "menu" command.
 * The onCommand method checks if the command sender is a player, sends a message to non-player command senders, logs a message indicating that a player has opened the menu, and opens the menu inventory for the player.
 */
public class Menu implements CommandExecutor {
    
    
    MenuInv menuInv = new MenuInv(JavaPlugin.getPlugin(WooperPlugin.class));
    public static Component menuComponent = WooperPlugin.makeComponent("WooperMenu");
    /**
     * Constructor for the Menu class.
     * This constructor is responsible for registering the "menu" command with the WooperPlugin.
     * It first retrieves the "menu" command from the plugin and sets this instance of Menu as its executor.
     * After registering the command, it logs a message indicating that the Menu command has been registered.
     *
     * @param plugin The instance of the WooperPlugin that this Menu is associated with.
     */
    public Menu(WooperPlugin plugin) {
        
        Objects.requireNonNull(plugin.getCommand("menu")).setExecutor(this);
        logInfo("Registered Menu Command!");
        
    }

    /**
     * This method is an override of the onCommand method in the CommandExecutor interface.
     * It is triggered when a player uses the "menu" command.
     * The method first checks if the command sender is a player.
     * If the command sender is not a player, it sends a message to the command sender and returns true.
     * If the command sender is a player, it logs a message indicating that the player has opened the menu.
     * It then creates a new instance of the MenuInv class and opens the menu inventory for the player.
     * The method returns true after executing the command.
     *
     * @param sender  The sender of the command.
     * @param command The command that was executed.
     * @param label   The alias of the command that was used.
     * @param args    The arguments that were passed with the command.
     * @return A boolean indicating whether the command was executed successfully.
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can open menu.");
            return true;
        }
        // logInfo(player.getName() + " opened the menu.");
        
        menuInv.openMenu(player);

        return true;
    }


}
