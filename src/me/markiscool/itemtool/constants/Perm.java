package me.markiscool.itemtool.constants;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class Perm {

    public static Permission ITEMTOOL_COMMAND;

    static {
        ITEMTOOL_COMMAND = new Permission("itemtool.itemtool");
        ITEMTOOL_COMMAND.setDefault(PermissionDefault.OP);
    }

}
