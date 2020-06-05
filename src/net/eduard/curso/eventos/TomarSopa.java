package net.eduard.curso.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;




/**
 * Sistema de ao clicar na sopa ira tomar ela duma vez, em vez de comer como é o tradicional
 * @author Eduard
 *
 */
public class TomarSopa implements Listener {

	@EventHandler
	public void event(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getMaterial() == Material.MUSHROOM_SOUP) {

			double soma = p.getHealth() + 7;
			if (p.getHealth() == p.getMaxHealth()) {

			} else {
				if (soma > p.getMaxHealth()) {
					p.setHealth(p.getMaxHealth());
				} else {
					p.setHealth(soma);
				}
				p.playSound(p.getLocation(), Sound.BURP, 2, 1);
				// p.setItemInHand(null);
				p.getItemInHand().setType(Material.BOWL);
			}

		}
	}
}
