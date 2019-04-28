package me.markiscool.itemtool.constants;

import org.bukkit.permissions.Permission;

public class Perm {

    public static Permission ITEMTOOL_COMMAND;

    static {
        ITEMTOOL_COMMAND = new Permission("itemtool.itemtool");
    }

}
