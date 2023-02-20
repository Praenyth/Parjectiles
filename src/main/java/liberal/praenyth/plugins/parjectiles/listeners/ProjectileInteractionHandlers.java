package liberal.praenyth.plugins.parjectiles.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.minecart.RideableMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static liberal.praenyth.plugins.parjectiles.ParjectilesUtils.getEntitiesInEyesight;

public class ProjectileInteractionHandlers implements Listener {

    @EventHandler
    public void onInteractWithProjectile(PlayerInteractEvent event) {

        switch (event.getAction()) {

            case LEFT_CLICK_AIR:
            case LEFT_CLICK_BLOCK:
                Player player = event.getPlayer();
                Location playerLocation = player.getLocation();

                for (Entity entity : getEntitiesInEyesight(player, 0.8)) {

                    if (entity instanceof Projectile) {

                        if (entity.getLocation().distance(playerLocation) < 4) {

                            entity.setVelocity(playerLocation.getDirection().multiply(3.5));

                        }


                    }


                }
        }

    }

}
