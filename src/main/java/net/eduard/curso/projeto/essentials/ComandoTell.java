
package net.eduard.curso.projeto.essentials;

import net.eduard.api.lib.modules.Extra;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * Comando de enviar mensagem privada para os jogadores
 * @author Eduard
 *
 */

public class ComandoTell implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length <= 1) {
				p.sendMessage("/" + label + " <player>");
			} else {
				Player target = Bukkit.getPlayer(args[0]);
				String message = Extra.getText(1, args);
				if (target == null) {
					sender.sendMessage("§cEste jogador esta offline");
				} else {
					target.sendMessage(
							"§8[§a$player§8] §2: $message".replace("$player", p.getName()).replace("$message", message));
					p.sendMessage(
							"§8[§a$player§8] §2: $message".replace("$player", p.getName()).replace("$message", message));
				}
			}

		}

		return true;
	}

}
