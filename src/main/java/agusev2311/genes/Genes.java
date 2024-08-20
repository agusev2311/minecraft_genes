package agusev2311.genes;

import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

import java.nio.file.Path;

public final class Genes extends JavaPlugin implements @NotNull Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Random rand = new Random();
        double scale = (rand.nextInt(15) + 1) / 10.0;
        event.getPlayer().getAttribute(Attribute.GENERIC_SCALE).setBaseValue(scale);
//        event.getPlayer().sendMessage("Now your size is " + scale * 1.9);
        event.getPlayer().getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(rand.nextInt(3) + 1);
        event.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue((rand.nextInt(20) + 1) / 10.0);
        event.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(rand.nextInt(8) + 1);
        event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(rand.nextInt(30) + 1);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }

    @Override
    public @NotNull Path getDataPath() {
        return super.getDataPath();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
