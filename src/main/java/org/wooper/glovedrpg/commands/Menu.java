package org.wooper.glovedrpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.wooper.glovedrpg.GlovedRPG;
import org.wooper.glovedrpg.Menus.MenuInv;
import static org.wooper.glovedrpg.GlovedRPG.logger;

public class Menu implements CommandExecutor {

    public Menu(GlovedRPG plugin) {
        plugin.getCommand("menu").setExecutor(this);
        logger.info("<###>-------------< Registered Menu Command! >-------------<###>");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can open menu.");
            return true;
        }
        logger.info(player.getName() + " opened the menu.");
        MenuInv menuInv = new MenuInv(JavaPlugin.getPlugin(GlovedRPG.class));
        player.openInventory(menuInv.getInventory());

        return true;
    }


}
