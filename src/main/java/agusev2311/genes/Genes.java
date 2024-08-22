package agusev2311.genes;

import org.bukkit.*;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

import java.nio.file.Path;

public final class Genes extends JavaPlugin implements @NotNull Listener {

    @Override
    public void onEnable() {
        createNewDimension("world_paradise");
        getServer().getPluginManager().registerEvents(this, this);
    }

    private void createNewDimension(String name) {
        this.getServer().createWorld(new org.bukkit.WorldCreator("world_paradise").generator(new CustomWorldGenerator()));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Random rand = new Random();
        double scale = (rand.nextInt(15) + 1) / 10.0;
        event.getPlayer().getAttribute(Attribute.GENERIC_SCALE).setBaseValue(scale); // 1
        event.getPlayer().getAttribute(Attribute.GENERIC_JUMP_STRENGTH).setBaseValue(scale * 0.42); // 0.42
        event.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(scale * 0.1); // 0.1
        double armor = rand.nextInt(3) + 1;
        double attack_damage = (rand.nextInt(40) + 1) / 10.0;
        double attack_speed = rand.nextInt(8) + 1;
        double max_health = rand.nextInt(30) + 1;
        event.getPlayer().getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(armor); // 0
        event.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(attack_damage); // 1
        event.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(attack_speed); // 4
        event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(max_health); // 20

        int mutation_scale = rand.nextInt(5);
        int mutation_jump_strength = rand.nextInt(5);
        int mutation_movement_speed = rand.nextInt(5);
        int mutation_armor = rand.nextInt(5);
        int mutation_attack_damage = rand.nextInt(5);
        int mutation_attack_speed = rand.nextInt(5);
        int mutation_max_health = rand.nextInt(5);

        double mut_scl_pov = (rand.nextInt(11) - 5) / 10.0;
        double mut_scl_ju_st = (rand.nextInt(11) - 5) / 10.0 * 0.42;
        double mut_scl_mo_sp = (rand.nextInt(11) - 5) / 10.0 * 0.1;
        double mut_scl_arm = rand.nextInt(5) - 2;
        double mut_scl_at_da = rand.nextInt(5) - 2;
        double mut_scl_at_sp = rand.nextInt(9) - 4;
        double mut_scl_ma_he = rand.nextInt(11) - 5;
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
