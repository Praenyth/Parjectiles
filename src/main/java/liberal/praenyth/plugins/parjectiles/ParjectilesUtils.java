package liberal.praenyth.plugins.parjectiles;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class ParjectilesUtils {



    public static Plugin plugin;

    /**
     * Returns a list of entities that are within the player's line of sight.
     *
     * @param player The player to check.
     * @param directEyesightRange The range of the player's line of sight.
     * @return
     */
    public static List<Entity> getEntitiesInEyesight(Player player, double directEyesightRange) {
        List<Entity> entities = new ArrayList<>();
        for(Entity e : player.getNearbyEntities(10, 10, 10)){
            if(getIfLookingAt(player, e, directEyesightRange)){
                entities.add(e);
            }
        }

        return entities;
    }

    /**
     * Returns true if the entity is within the player's line of sight.
     *
     * @param player
     * @param entity
     * @param directEyesightRange
     * @return
     */
    private static boolean getIfLookingAt(Player player, Entity entity, double directEyesightRange) {
        Location eye = player.getEyeLocation();
        Vector toEntity = entity.getLocation().toVector().subtract(eye.toVector());
        double dot = toEntity.normalize().dot(eye.getDirection());

        return dot > directEyesightRange;
    }

}
