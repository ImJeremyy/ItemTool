package me.markiscool.itemtool.listeners;

import me.markiscool.itemtool.ItemToolPlugin;
import me.markiscool.itemtool.managers.TaskManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    private ItemToolPlugin plugin;
    private TaskManager tm;

    public LeaveListener(ItemToolPlugin plugin) {
        this.plugin = plugin;
        tm = plugin.getTaskManager();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(tm.contains(player)) {
            tm.remove(player);
        }

    }

}
