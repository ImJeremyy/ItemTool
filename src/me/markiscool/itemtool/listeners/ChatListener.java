package me.markiscool.itemtool.listeners;

import me.markiscool.itemtool.ItemToolPlugin;
import me.markiscool.itemtool.constants.Lang;
import me.markiscool.itemtool.constants.Task;
import me.markiscool.itemtool.constants.XEnchantment;
import me.markiscool.itemtool.managers.TaskManager;
import me.markiscool.itemtool.utility.Chat;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChatListener implements Listener {

    private ItemToolPlugin plugin;
    private TaskManager tm;
    private String prefix;

    public ChatListener(ItemToolPlugin plugin) {
        this.plugin = plugin;
        tm = plugin.getTaskManager();
        prefix = Lang.PREFIX.getMessage();
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(tm.contains(player)) {
            event.setCancelled(true);
            Task task = tm.getTask(player);
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            String message = event.getMessage();
            switch(task) {
                case DISPLAY_NAME:
                    meta.setDisplayName(message);
                    break;
                case LORE:
                    List<String> lore = meta.getLore();
                    if(lore != null) {
                        lore.add(message);
                    } else {
                        lore = new ArrayList<>();
                        lore.add(message);
                    }
                    meta.setLore(lore);
                    player.sendMessage(prefix + Chat.colourize("&aSuccessfully added &r" + message));
                    break;
                case ENCHANTMENT_ADD:
                    String[] splitMessage = message.split(" ");
                    Enchantment enchantment;
                    int level;
                    try {
                        enchantment = XEnchantment.valueOf(splitMessage[0].toUpperCase()).parseEnchantment();
                        level = Integer.parseInt(splitMessage[1]);
                    } catch (Exception ex) {
                        player.sendMessage(prefix + Chat.colourize("&cSomething went wrong. Error trying to evaluate your enchantment."));
                        return;
                    }
                    meta.addEnchant(enchantment, level, true);
                    player.sendMessage(prefix + Chat.colourize("&aSuccessfully added enchantment"));
                    break;
                case ENCHANTMENT_REMOVE:
                    Enchantment ench;
                    try {
                        ench = XEnchantment.valueOf(message.toUpperCase()).parseEnchantment();
                    } catch (Exception ex) {
                        player.sendMessage(prefix + Chat.colourize("&cError: enchantment &u" + message + " &r&ccould not be evaluated"));
                        return;
                    }
                    if(meta.getEnchants().containsKey(ench)) {
                        meta.removeEnchant(ench);
                        player.sendMessage(prefix + Chat.colourize("&aSuccessfully removed enchantment."));
                    } else {
                        player.sendMessage(prefix + Chat.colourize("&cEnchantment was not found on the item."));
                    }
                    break;
                case ITEM_FLAG:
                    //TODO
                    break;
            }
            item.setItemMeta(meta);
            tm.remove(player);
        }
    }

}
