public interface Equippable {
    boolean equip(Player player, EquipmentSlot slot);
    void unequip(Player player);
}
