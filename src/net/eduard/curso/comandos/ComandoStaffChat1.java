package net.eduard.curso.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.Assunto;

/**
 * Comando de chat staff que envia a mensagem pra quem tem permissão para ver a mensagem
 * @author Eduard
 *
 */
@Assunto(subnivel=7)
public class ComandoStaffChat1 implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			StringBuilder builder = new StringBuilder();
			for (String arg : args) {
				builder.append(" ");
				builder.append(arg);
				
			}
			String message = ChatColor.translateAlternateColorCodes('&', builder.toString());
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.hasPermission("command.staffchat")) {
					player.sendMessage("§8[§bSTAFF§8] §r" + p.getDisplayName() + "§f:§r" + message);
				}
			}

		}
		return true;
	}
}
