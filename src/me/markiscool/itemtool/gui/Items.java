package me.markiscool.itemtool.gui;

import me.markiscool.itemtool.constants.XMaterial;
import me.markiscool.itemtool.utility.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Items {

    public static ItemStack blank;
    public static ItemStack displayName;
    public static ItemStack lore;
    public static ItemStack enchant;
    public static ItemStack itemFlags;

    private static Inventory toolEditor;

    static {
        blank = generateItemStack(XMaterial.WHITE_STAINED_GLASS_PANE, 1, "&f-", null, null, null);
        displayName = generateItemStack(XMaterial.SIGN, 1, "&bChange the Display Name", Arrays.asList("&eLEFT CLICK &f- Edit", "&eRIGHT CLICK &f- Clear"), null, null);
        lore = generateItemStack(XMaterial.PAPER, 1, "&bAdd lore", Arrays.asList("&eLEFT CLICK &f- Add", "&eRIGHT CLICK &f- Remove last line"), null, null);
        enchant = generateItemStack(XMaterial.ENCHANTED_BOOK, 1, "&bAdd enchantments", Arrays.asList("&eLEFT CLICK &f- Add enchantment", "&eRIGHT CLICK &f- Remove enchantment"), null, Arrays.asList(ItemFlag.HIDE_ATTRIBUTES));
        itemFlags = generateItemStack(XMaterial.ARROW, 1, "&bAdd Item Flags", Arrays.asList("&eLEFT CLICK &f- Add Item Flag", "&eRIGHT CLICK &f- Remove last item flag"), null, null);
    }

    public static ItemStack generateItemStack(XMaterial xmaterial, int amount, String displayName, List<String> lore, Map<Enchantment, Integer> enchantments, List<ItemFlag> itemFlags) {
        ItemStack item = new ItemStack(xmaterial.parseMaterial(), amount);
        ItemMeta meta = item.getItemMeta();
        if(meta != null) {
            meta.setDisplayName(Chat.colourize(displayName));
            if (lore != null) meta.setLore(Chat.colourize(lore));
            if (enchantments != null) {
                for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                    meta.addEnchant(entry.getKey(), entry.getValue(), true);
                }
            }
            if (itemFlags != null) {
                for (ItemFlag iF : itemFlags) {
                    meta.addItemFlags(iF);
                }
            }
            item.setItemMeta(meta);
        }
        return item;
    }

    public static Inventory generateToolEditor(ItemStack headItem) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Item Editor");
        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, blank);
        }
        inventory.setItem(4, headItem);
        inventory.setItem(11, displayName);
        inventory.setItem(12, lore);
        inventory.setItem(14, enchant);
        inventory.setItem(15, itemFlags);
        return inventory;
    }

}
