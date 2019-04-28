package me.markiscool.itemtool.commands;

import me.markiscool.itemtool.ItemToolPlugin;
import me.markiscool.itemtool.constants.Lang;
import me.markiscool.itemtool.constants.Perm;
import me.markiscool.itemtool.constants.XMaterial;
import me.markiscool.itemtool.gui.Items;
import me.markiscool.itemtool.managers.TaskManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemToolCommand implements CommandExecutor {

    private ItemToolPlugin plugin;
    private TaskManager tm;
    private String prefix;

    public ItemToolCommand(ItemToolPlugin plugin) {
        this.plugin = plugin;
        tm = plugin.getTaskManager();
        prefix = Lang.PREFIX.getMessage();
    }

    /**
     * Player holds an item and runs ths command
     * Opens a GUI which
     * @return
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission(Perm.ITEMTOOL_COMMAND)) {
                ItemStack item = player.getInventory().getItemInMainHand();
                if(item != null && !item.getType().equals(XMaterial.AIR)) {
                    player.openInventory(Items.generateToolEditor(item));
                } else {
                    player.sendMessage(prefix + Lang.INVALID_ITEM.getMessage());
                }
            } else {
                player.sendMessage(prefix + Lang.NO_PERMISSION.getMessage());
            }
        } else {
            sender.sendMessage(prefix + Lang.NOT_A_PLAYER.getMessage());
        }
        return true;
    }

}
