package org.wooper.glovedrpg.handlers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.wooper.glovedrpg.GlovedRPG;
import static org.wooper.glovedrpg.GlovedRPG.logger;

public class TorchHandler implements Listener {

    public TorchHandler(GlovedRPG plugin) {
        // Register the event
        Bukkit.getPluginManager().registerEvents(this, plugin);
        logger.info("<###>-------------< Registered TorchHandler! >-------------<###>");
    }

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event) {
        // Check if the block placed is a torch
        Block block = event.getBlock();
        if (block.getType() != Material.TORCH) return;

        logger.info("Torch placed at " + block.getLocation());

    }
}
