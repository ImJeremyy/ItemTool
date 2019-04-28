package me.markiscool.itemtool.constants;

import me.markiscool.itemtool.utility.Chat;

public enum Lang {

    PREFIX("&6[&bItemTool&6]&r "),
    NOT_A_PLAYER("&cYou are not a player."),
    NO_PERMISSION("&cYou do not have permission to this command"),
    INVALID_ITEM("&cInvalid item.")

    ;

    private String message;

    Lang(String message) {
        this.message = Chat.colourize(message);
    }

    public String getMessage() {
        return message;
    }

}
