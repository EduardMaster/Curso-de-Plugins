package net.eduard.curso.projeto.login;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoLogin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (!ProjetoLogin.getManager().isRegistred(player)) {
            player.sendMessage("§cVoce nao esta registrado ainda por "
                    + "favor digite /register senha confirmar");
            return true;
        }
        // login senha

        if (args.length == 0) {
            // login
            sender.sendMessage("§c/login SENHA");
            return true;
        }
        String digitou = args[0];
        String senha = ProjetoLogin.getManager().getSenha(player);
        if (!digitou.equals(senha)) {
            player.kickPlayer(
                    "§cVoce deve acertar a senha de primeira por motivos de seguran§a!");

            return true;
        }
        ProjetoLogin.getManager().login(player);
        player.sendMessage("§aAutentica§§o feita com sucesso!");


        return true;
    }

}
