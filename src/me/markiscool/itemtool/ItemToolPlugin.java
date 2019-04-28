package me.markiscool.itemtool;

import me.markiscool.itemtool.commands.ItemToolCommand;
import me.markiscool.itemtool.listeners.ChatListener;
import me.markiscool.itemtool.listeners.InventoryClickListener;
import me.markiscool.itemtool.listeners.LeaveListener;
import me.markiscool.itemtool.managers.TaskManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemToolPlugin extends JavaPlugin {

    private TaskManager taskManager;

    /**
     * Runs when server is enabled
     */
    @Override
    public void onEnable() {
        registerManagers();
        registerListeners();
        registerCommands();
    }

    /**
     * Get instance of Task Manager
     * @return Task Manager instance
     */
    public TaskManager getTaskManager() {
        return taskManager;
    }

    /**
     * Registers all manager classes, should only be one instance of each
     */
    private void registerManagers() {
        taskManager = new TaskManager(this);
        new MetricsLite(this);
    }

    /**
     * Registers all listeners
     */
    private void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        Object[] listeners = {new ChatListener(this), new InventoryClickListener(this), new LeaveListener(this)};
        for(Object o : listeners) {
            pm.registerEvents((Listener) o, this);
        }
    }

    /**
     * Registers all commands
     */
    private void registerCommands() {
        getCommand("itemtool").setExecutor(new ItemToolCommand(this));
    }
}
