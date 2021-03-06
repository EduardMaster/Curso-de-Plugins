package net.eduard.curso.sistemas.nao_revisados;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

/**
 * Alterar mensagem do quando executa um comando Errado
 *
 * @author Eduard
 */
public class ComandoErrado implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();
        String cmd = event.getMessage().split(" ")[0];
        HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
        if (topic != null) {
            return;
        }
        player.sendMessage("§7Ops... comando errado!");
        player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
        event.setCancelled(true);


    }
}