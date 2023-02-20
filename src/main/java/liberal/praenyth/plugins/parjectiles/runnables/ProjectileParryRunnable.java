package liberal.praenyth.plugins.parjectiles.runnables;

import liberal.praenyth.plugins.parjectiles.Parjectiles;
import liberal.praenyth.plugins.parjectiles.ParjectilesUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class ProjectileParryRunnable extends BukkitRunnable {

    private float damage;
    private UUID victimUUID;
    private UUID shooterUUID;

    public void startParryTime(float damage, UUID victimUUID, UUID shooterUUID) {
        this.damage = damage;
        this.victimUUID = victimUUID;
        this.shooterUUID = shooterUUID;
        runTaskLater(ParjectilesUtils.plugin, 10);
    }

    @Override
    public void run() {

        Player victim = Bukkit.getPlayer(victimUUID);
        Entity shooter = Bukkit.getEntity(shooterUUID);

        if (Parjectiles.playersInParryMode.contains(victimUUID)) {
            assert victim != null;
            victim.damage(damage, shooter);
            Parjectiles.playersInParryMode.remove(victimUUID);
        }
    }
}
