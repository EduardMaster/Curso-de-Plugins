package net.eduard.curso.projeto.warp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.eduard.api.lib.modules.Mine;


public class MenuWarps implements Listener {

    @EventHandler
    public void entrar(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        ItemStack item = new ItemStack(Material.COMPASS);


        // String == texto

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aItem usado para abrir o menu");
        ArrayList<String> lista = new ArrayList<>();
        lista.add("§aPrimeira linha");
        lista.add("§dSegunda linha");
        meta.setLore(lista);
//		  meta.setLore("linha1");
//		  meta.setLore("linha2");;
        item.setItemMeta(meta);

        player.getInventory().addItem(item);

    }


    @EventHandler
    public void event(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getItem() == null) return;
        if (e.getItem().getType() == Material.COMPASS) {
            abriMenu(p);
        }
    }


    @EventHandler
    public void event(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();
        if (!e.getInventory().getTitle().equals("§6Warps")) return;
        e.setCancelled(true);
        if (e.getRawSlot() == Mine.getPosition(1, 5)) {
            p.chat("/warp vip");
        }


    }


    public static void abriMenu(Player p) {
        Inventory menu = Bukkit.createInventory(null, 2 * 9, "§6Warps");
        ;

        ItemStack warpVip = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta warpVipMeta = warpVip.getItemMeta();
        warpVipMeta.setDisplayName("§bWarp VIP");
        warpVip.setItemMeta(warpVipMeta);

        menu.setItem(Mine.getPosition(1, 5), warpVip);


        p.openInventory(menu);
    }


}
