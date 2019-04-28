package me.markiscool.itemtool.managers;

import me.markiscool.itemtool.ItemToolPlugin;
import me.markiscool.itemtool.constants.Task;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private ItemToolPlugin plugin;
    private Map<Player, Task> tasks;

    public TaskManager(ItemToolPlugin plugin) {
        this.plugin = plugin;
        this.tasks = new HashMap<>();
    }

    public void add(Player player, Task task) {
        tasks.put(player, task);
    }

    public boolean contains(Player player) {
        return tasks.containsKey(player);
    }

    public void remove(Player player) {
        tasks.remove(player);
    }

    public Task getTask(Player player) {
        return tasks.get(player);
    }

}
