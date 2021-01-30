package net.eduard.curso.projeto.warp;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Location;

import net.eduard.api.lib.config.BukkitConfig;
import net.eduard.curso.Curso;

public class WarpAPI {

	private static BukkitConfig config = Curso.getConfigs();

	public static void setWarp(String name, Location local) {
		config.set("Warps." + name.toLowerCase(), local);
	}

	public static boolean hasWarps() {
		return config.contains("Warps") && getWarps().size() > 0;
	}

	public static Location getWarp(String name) {
		return config.getLocation("Warps." + name.toLowerCase());
	}

	public static boolean hasWarp(String name) {
		return config.contains("Warps." + name.toLowerCase());
	}

	public static void removeWarp(String name) {
		config.remove("Warps." + name.toLowerCase());
	}

	public static BukkitConfig getConfig() {
		return config;
	}

	public static List<String> getWarps() {
		return config.getSection("Warps").getKeys(false).stream().collect(Collectors.toList());
	}

	public static void setConfig(BukkitConfig config) {
		WarpAPI.config = config;
	}

}
