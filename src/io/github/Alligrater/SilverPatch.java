package io.github.Alligrater;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SilverPatch extends JavaPlugin {
	
	public static HashMap<UUID, Boolean> notvisible = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> ccmode = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> cmode = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, String> target = new HashMap<UUID, String>();
	public static boolean hasess = false;
	
	@Override
	public void onEnable() {
		//this.getCommand("applypatch").setExecutor(new PatchFix());
		getServer().getPluginManager().registerEvents(new PatchFix(), this);
		
		for(Plugin p : Bukkit.getPluginManager().getPlugins()) {
			if(p.getName().equalsIgnoreCase("Essentials")) {

				hasess = true;
			}
		}
		
		if(Bukkit.getPlayer("SilverKela") != null) {
			Bukkit.getPlayer("SilverKela").sendMessage("¡ìa¡ìlGood News, SilverPatch Has Been Enabled!");
		}

		
	}
	
	@Override
	public void onDisable() {
		if(Bukkit.getPlayer("SilverKela") != null) {
			Bukkit.getPlayer("SilverKela").sendMessage("¡ìc¡ìlBad News, SilverPatch Has Been Disabled!");
		}
	}
}
