package net.eduard.curso.sistemas;

import net.eduard.curso.Sistema;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class SistemaLojaBasica extends Sistema {
    @EventHandler
    public void event(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getMaterial() == Material.DIAMOND) {
            abriMenu(p);
        }
    }

    private void abriMenu(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9, "texto");
        inv.setItem(3, new ItemStack(Material.DIAMOND, 15));
        inv.setItem(5, new ItemStack(Material.DIAMOND, 16));
        p.openInventory(inv);
    }

    @EventHandler
    public void event(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Inventory inv = e.getInventory();
        if (!inv.getTitle().equals("texto")) return;
        if (e.getCurrentItem() == null)
            return;
        if (inv.containsAtLeast(new ItemStack(Material.DIAMOND), 16)) {

            if (e.getCurrentItem().getType() == Material.DIAMOND) {
//					Mine.remove(inv, new ItemStack(Material.DIAMOND,3));;
                e.setCancelled(true);
            }
        }


    }

    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable() {

    }
}
