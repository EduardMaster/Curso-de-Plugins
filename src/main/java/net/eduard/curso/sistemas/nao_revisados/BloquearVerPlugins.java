package net.eduard.curso.sistemas.nao_revisados;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


/**
 * Bloquear comandos expecificos do servidor (/plugins)
 * @author Eduard
 *
 */
public class BloquearVerPlugins implements Listener {
	private static List<String> comandosBloqueados = Arrays.asList("/pl",
			"/plugins", "/bukkit:?"

			, "/bukkit:plugins", "/bukkit:help", "/bukkit:pl", "/ver", "/help",
			"/bukkit:ver", "/logout", "/?");
	@EventHandler
	public void NaoProcurarOsPluginsDoServer(PlayerCommandPreprocessEvent e) {

		Player player = e.getPlayer();
		if (comandosBloqueados.contains(e.getMessage().toLowerCase())) {
			player.sendMessage("§6Nao tente procurar nossos Plugins");
			e.setCancelled(true);
		}

	}
}
