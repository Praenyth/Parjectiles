package liberal.praenyth.plugins.parjectiles;

//import liberal.praenyth.plugins.parjectiles.listeners.InteractWithProjectiles;
//import liberal.praenyth.plugins.parjectiles.listeners.ProjectileDamageListener;
import liberal.praenyth.plugins.parjectiles.listeners.ProjectileInteractionHandlers;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Parjectiles extends JavaPlugin {

    public static List<UUID> playersInParryMode = new ArrayList<>();
    public static Map<UUID, Float> parriedProjectiles = new HashMap();

    @Override
    public void onEnable() {
        // Plugin startup logic
        ParjectilesUtils.plugin = this;

        // getServer().getPluginManager().registerEvents(new InteractWithProjectiles(), this);
        // getServer().getPluginManager().registerEvents(new ProjectileDamageListener(), this);
        getServer().getPluginManager().registerEvents(new ProjectileInteractionHandlers(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
