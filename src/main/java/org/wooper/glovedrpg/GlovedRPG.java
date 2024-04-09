package org.wooper.glovedrpg;

import dev.vankka.enhancedlegacytext.EnhancedLegacyText;
import fr.mrmicky.fastinv.FastInvManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.minimessage.tag.standard.StandardTags;
import org.bukkit.plugin.java.JavaPlugin;
import org.wooper.glovedrpg.Menus.MenuInv;
import org.wooper.glovedrpg.commands.Menu;
import org.wooper.glovedrpg.handlers.MenuHandler;
import org.wooper.glovedrpg.handlers.TorchHandler;

import java.util.logging.Logger;

public final class GlovedRPG extends JavaPlugin {

    public static Logger logger;
    public static GlovedRPG plugin;
    public static Component enhancedLegacyText;

    {
        logger = getLogger();
    }

    public static MiniMessage miniMessage = MiniMessage.builder()
            .tags(TagResolver.builder()
                    .resolver(StandardTags.color())
                    .resolver(StandardTags.decorations())
                    .build()
            )
            .build();

    public Component makeComponent(String text) {
        return EnhancedLegacyText.get().buildComponent(text).build();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        logger.info("<###>-------------< GlovedRPG has been loaded! >-------------<###>");

        new TorchHandler(this);
        new MenuHandler(this);
        new MenuInv(this);
        new Menu(this);
        FastInvManager.register(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("GlovedRPG has been disabled!");
    }
}
