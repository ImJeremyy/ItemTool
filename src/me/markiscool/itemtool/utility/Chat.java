package me.markiscool.itemtool.utility;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    public static String colourize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> colourize(List<String> messages) {
        List<String> t = new ArrayList<>();
        for(String s : messages) {
            t.add(colourize(s));
        }
        return t;
    }

}
