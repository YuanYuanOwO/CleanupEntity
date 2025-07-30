package org.yuanyuan.cleanupEntity;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import org.jetbrains.annotations.NotNull;

public final class cleanupEntity extends JavaPlugin implements @NotNull Listener {

  @Override
  public void onEnable() {
    Bukkit.getPluginManager().registerEvents(this, this);
    // Plugin startup logic

  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

@EventHandler
public void onEntitySpawn(EntityAddToWorldEvent event) {
  Entity entity = event.getEntity();
  if (entity instanceof Projectile) {
    Bukkit.getScheduler().runTaskLater(this, () -> {
      if (!entity.isDead()) {
        entity.remove();
        getLogger().info("已删除投掷物: " + entity.getType().name());
      }
    }, 1L);
  }
}}
