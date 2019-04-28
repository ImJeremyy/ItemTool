package me.markiscool.itemtool.constants;

import org.bukkit.enchantments.Enchantment;

public enum XEnchantment {
    PROTECTION(Enchantment.PROTECTION_ENVIRONMENTAL),
    FIRE_PROTECTION(Enchantment.PROTECTION_FIRE),
    FEATHER_FALLIGN(Enchantment.PROTECTION_FALL),
    BLAST_PROTECTION(Enchantment.PROTECTION_EXPLOSIONS),
    PROJECTILE_PROTECTION(Enchantment.PROTECTION_PROJECTILE),
    RESPIRATION(Enchantment.OXYGEN),
    AQUA_AFFINITY(Enchantment.WATER_WORKER),
    THORNS(Enchantment.THORNS),
    DEPTH_STRIDER(Enchantment.DEPTH_STRIDER),
    FROST_WALKER(Enchantment.FROST_WALKER),
    CURSE_OF_BINDING(Enchantment.BINDING_CURSE),
    SHARPNESS(Enchantment.DAMAGE_ALL),
    SMITE(Enchantment.ARROW_DAMAGE),
    BANE_OF_ARTHROPODS(Enchantment.DAMAGE_ARTHROPODS),
    KNOCKBACK(Enchantment.KNOCKBACK),
    FIRE_ASPECT(Enchantment.FIRE_ASPECT),
    LOOTING(Enchantment.LOOT_BONUS_MOBS),
    SWEEPING_EDGE(Enchantment.SWEEPING_EDGE),
    UNBREAKING(Enchantment.DURABILITY),
    POWER(Enchantment.ARROW_DAMAGE),
    PUNCH(Enchantment.ARROW_KNOCKBACK),
    FLAME(Enchantment.ARROW_FIRE),
    INFINITY(Enchantment.ARROW_INFINITE),
    LOYALTY(Enchantment.LOYALTY),
    IMPALING(Enchantment.IMPALING),
    RIPTIDE(Enchantment.RIPTIDE),
    CHANNELING(Enchantment.CHANNELING),
    MENDING(Enchantment.MENDING),
    CURSE_OF_VANISHING(Enchantment.VANISHING_CURSE),
    EFFICIENCY(Enchantment.DIG_SPEED),
    SILK_TOUCH(Enchantment.SILK_TOUCH),
    FORTUNE(Enchantment.LOOT_BONUS_BLOCKS),
    LUCK_OF_THE_SEA(Enchantment.LUCK),
    LURE(Enchantment.LURE),
    ;

    private Enchantment enchantment;

    XEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    public Enchantment parseEnchantment() {
        return enchantment;
    }
}
