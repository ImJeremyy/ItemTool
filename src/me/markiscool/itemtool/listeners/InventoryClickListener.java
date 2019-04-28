package me.markiscool.itemtool.listeners;

import me.markiscool.itemtool.ItemToolPlugin;
import me.markiscool.itemtool.constants.Lang;
import me.markiscool.itemtool.constants.Task;
import me.markiscool.itemtool.gui.Items;
import me.markiscool.itemtool.managers.TaskManager;
import me.markiscool.itemtool.utility.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InventoryClickListener implements Listener {

    private ItemToolPlugin plugin;
    private TaskManager tm;
    private String prefix;

    public InventoryClickListener(ItemToolPlugin plugin) {
        this.plugin = plugin;
        tm = plugin.getTaskManager();
        prefix = Lang.PREFIX.getMessage();
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            ItemStack item = player.getInventory().getItemInMainHand();
            if(player.getOpenInventory().getTitle().equals("Item Editor")) {
                event.setCancelled(true);
                ItemStack clickedItem = event.getCurrentItem();
                if(clickedItem != null) {
                    ClickType click = event.getClick();
                    if(clickedItem.equals(Items.displayName)) {
                        if(click.equals(ClickType.LEFT)) {
                            tm.add(player, Task.DISPLAY_NAME);
                            player.closeInventory();
                            player.sendMessage(prefix + Chat.colourize("&aType in chat what you would like the &6Display Name &ato be."));
                        } else if(click.equals(ClickType.RIGHT)) {
                            String name = item.getItemMeta().getDisplayName();
                            if(!name.equals("")) {
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName("");
                                item.setItemMeta(meta);
                                player.closeInventory();
                                player.sendMessage(prefix + Chat.colourize("&aChanged name from &6" + name + " &ato default"));
                            } else {
                                player.sendMessage(prefix + Chat.colourize("&cDisplay Name is already in its default state."));
                            }
                        }
                    } else if(clickedItem.equals(Items.lore)) {
                        if(click.equals(ClickType.LEFT)) {
                            tm.add(player, Task.LORE);
                            player.closeInventory();
                            player.sendMessage(prefix + Chat.colourize("&aType in chat what you would like to add to the &6Lore&a."));
                        } else if(click.equals(ClickType.RIGHT)) {
                            ItemMeta meta = item.getItemMeta();
                            List<String> lore = meta.getLore();
                            if(lore != null) {
                                lore.remove(lore.size() - 1);
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                player.sendMessage(prefix + Chat.colourize("&aSuccessfully removed last line of lore"));
                            } else {
                                player.sendMessage(prefix + Chat.colourize("&cThere is no lore."));
                            }
                        }
                    } else if(clickedItem.equals(Items.enchant)) {
                        if(click.equals(ClickType.LEFT)) {
                            tm.add(player, Task.ENCHANTMENT_ADD);
                            player.closeInventory();
                            player.sendMessage(prefix + Chat.colourize("&aType in chat the &6Enchantment &ayou would like to add. Example: 'aqua_affinity 1'"));
                        } else if(click.equals(ClickType.RIGHT)) {
                            tm.add(player, Task.ENCHANTMENT_REMOVE);
                            player.closeInventory();
                            player.sendMessage(prefix + Chat.colourize("&aType in chat the &6Enchantment &ayou would like to remove. Example: 'aqua_affinity'"));
                        }
                    } else if(clickedItem.equals(Items.itemFlags)) {
                        if(click.equals(ClickType.LEFT)) {
                            player.sendMessage(prefix + Chat.colourize("&bComing Soon!"));
                        } else if(click.equals(ClickType.RIGHT)) {
                            player.sendMessage(prefix + Chat.colourize("&bComing Soon!"));
                        }
                        player.closeInventory();
                    }
                }
            }
        }
    }

}
