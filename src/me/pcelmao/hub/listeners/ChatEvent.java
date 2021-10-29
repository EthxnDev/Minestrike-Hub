package me.pcelmao.hub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import me.pcelmao.hub.Hub;
import me.pcelmao.hub.utils.Color;

public class ChatEvent implements Listener {
	
	public static Hub plugin;

	
	@SuppressWarnings("static-access")
	public ChatEvent(Hub plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, (Plugin)plugin);
	}
	@EventHandler
	public void chatevent(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPermission("hub.chat")) {
			e.setCancelled(true);
			p.sendMessage(Color.C("&cYou are not allowed to talk in the hub!"));
		}else {
			e.setCancelled(false);
		}
	}

}
