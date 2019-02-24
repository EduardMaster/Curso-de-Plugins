package net.eduard.curso.homes;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.eduard.api.lib.BukkitConfig;

public class HomesAPI {

	public static BukkitConfig homeConfig = new BukkitConfig("homes.yml");

	public static void setHome(Player player, String home) {
		homeConfig.set("homes." + player.getName() + "." + home, player.getLocation());
	}

	public static boolean hasHomes(Player player) {
		return getHomes(player).size() > 0;
	}

	public static List<String> getHomes(Player player) {
		return homeConfig.getSection("homes."+player.getName()).getKeys(false).stream().collect(Collectors.toList());
	}

	public static Location getHome(Player player, String home) {
		return homeConfig.getLocation("homes." + player.getName() + "." + home);
	}

	public static boolean existsHome(Player player, String home) {
		return homeConfig.contains("homes." + player.getName() + "." + home);
	}

	public static void deleteHome(Player player, String home) {
		homeConfig.remove("homes." + player.getName() + "." + home);
	
	}
}
