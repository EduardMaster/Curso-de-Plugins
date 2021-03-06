package net.eduard.curso.projeto.report;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.HashMap;

public class MenuReports implements Listener {


    private static final String nome = "Reportes";
    // private static HashMap<Integer, Report> reportes = new HashMap<>();


    private static final HashMap<Player, HashMap<Integer, Report>> playersReportes
            = new HashMap<>();

    private static final HashMap<Player, Integer> paginaAberta = new HashMap<>();

    private static final int slotVoltar = 0;
    private static final int slotAvancar = 8;
    @EventHandler
    public void clearCache(PlayerQuitEvent event){
        paginaAberta.remove(event.getPlayer());
        playersReportes.remove(event.getPlayer());
    }
    @EventHandler
    public void controle(InventoryClickEvent evento) {
        Player player = (Player) evento.getWhoClicked();
        if (!evento.getInventory().getName().equals(nome)) return;
        evento.setCancelled(true);
        if (evento.getCurrentItem() == null) return;
        int slotClicado = evento.getRawSlot();
        int paginaAtual = paginaAberta.get(player);

        if (paginaAtual > 1 && slotClicado == slotVoltar) {
            abrirMenu(player, paginaAtual - 1);
            return;
        }
        if (slotClicado == slotAvancar) {
            abrirMenu(player, paginaAtual + 1);
            return;
        }
        HashMap<Integer, Report> reportes = playersReportes.get(player);
        if (reportes == null) return;
        Report reporte = reportes.get(slotClicado);
        if (reporte == null) return;
        // player.sendMessage("§aVocê clicou no report do " + reporte.getReportedPlayer());
        if (evento.getClick() == ClickType.RIGHT) {
            ProjetoReport.getManager().getReports().remove(reporte);
            reportes.remove(slotClicado);
            player.sendMessage("§AEste report foi removido.");
            abrirMenu(player);
        } else if (evento.getClick() == ClickType.LEFT) {
            Player alvo = Bukkit.getPlayer(reporte.getReportedPlayer());
            if (alvo == null) {
                return;
            }
            player.teleport(alvo);
            player.sendMessage("§aVocê esta agora verificando o reporte.");
            reporte.setVerified(true);
            reporte.setVerifierPlayer(player.getName());

        } else if (evento.getClick() == ClickType.SHIFT_RIGHT) {

        } else if (evento.getClick() == ClickType.SHIFT_LEFT) {

        } else if (evento.getClick() == ClickType.MIDDLE) {

        }
    }

    public static void abrirMenu(Player player) {
        abrirMenu(player, 1);
    }

    public static void abrirMenu(Player player, int pagina) {
        Inventory menu = Bukkit.createInventory(null, 6 * 9, nome);
        // argumentos [0]
        paginaAberta.put(player, pagina);
        int slotUsado = 10;
        int porPagina = 2;
        int fim = (pagina * porPagina);
        HashMap<Integer, Report> reports = new HashMap<>();
        int size = ProjetoReport.getManager().getReports().size();
        if (pagina > 1) {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aVoltar para pagina " + (pagina - 1));
            item.setItemMeta(meta);
            menu.setItem(slotVoltar, item);
        }
        {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§aAvançar para pagina " + (pagina + 1));
            item.setItemMeta(meta);
            menu.setItem(slotAvancar, item);
        }

        for (int atual = (pagina - 1) * porPagina; atual < fim; atual++) {
            if (atual >= size) break;
            Report reporte = ProjetoReport.getManager().getReports().get(atual);
            if (reporte.isVerified()) {
                continue;
            }
            menu.setItem(slotUsado, reporte.getIcon());
            reports.put(slotUsado, reporte);
            slotUsado++;
        }

        playersReportes.put(player, reports);
        player.openInventory(menu);
    }

}
