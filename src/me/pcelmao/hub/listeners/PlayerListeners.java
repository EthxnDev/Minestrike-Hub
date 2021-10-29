package me.pcelmao.hub.listeners;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.pcelmao.hub.Hub;

import me.pcelmao.hub.inventory.Inventories;
import me.pcelmao.hub.utils.Color;
import me.pcelmao.hub.utils.ItemBuilder;
import me.pcelmao.hub.utils.ItemStackBuilder;
import me.signatured.ezqueuespigot.util.C;


public class PlayerListeners implements Listener {
	
	public static Hub plugin;

	@SuppressWarnings("static-access")
	public PlayerListeners(Hub plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, (Plugin)plugin);
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
// --------------------------------------------------
		
		Player p = e.getPlayer();
		
// --------------------------------------------------
		e.setJoinMessage(null);
		p.updateInventory();
		p.getInventory().clear();
		p.setHealth(20D);
		p.setFoodLevel(20);
    	p.getInventory().setBoots(new ItemStack(Material.AIR));
    	p.getInventory().setLeggings(new ItemStack(Material.AIR));
    	p.getInventory().setChestplate(new ItemStack(Material.AIR));
    	p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setHeldItemSlot(4);
		p.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).amount(1).name("&aServer Selector").build());
		p.getInventory().setItem(8, new ItemBuilder(Material.WATCH).amount(1).name("&dCosmetics &7(Coming Soon)").build());
		p.getInventory().setItem(0, new ItemBuilder(Material.BOOK).amount(1).name("&eServer Information").build());
	}
	
	@EventHandler
	public void QuitEvent(PlayerQuitEvent e) {
		e.setQuitMessage(null);
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		p.sendMessage(Color.C("&cYou cannot drop items in the Hub"));
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("hub.place")) {
			e.setCancelled(false);
		}else {
			p.sendMessage(Color.C("&cYou cannot place blocks in the Hub"));
			e.setCancelled(true);
					
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("hub.break")) {
			e.setCancelled(false);
		}else {
		p.sendMessage(Color.C("&cYou cannot break blocks in the Hub"));
		e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void InteractEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action action = e.getAction();
		ItemStack is = e.getItem();
		
		if (action == Action.PHYSICAL || is == null || is.getType() == Material.AIR) {
			return;
		}
		if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if (p.getItemInHand().getType() == Material.COMPASS) {
				Inventories.SelectorInv(p);
				}
			if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
				if (p.getItemInHand().getType() == Material.BOOK) {
					p.sendMessage(Color.C("&aDiscord: &fhttps://discord.gg/P3F6MyJ4B7"));
					p.sendMessage(Color.C("&aWebsite: &fhttps://minestrike.cc"));
					p.sendMessage(Color.C("&aStore: &fhttps://store.minestrike.cc"));
				}
			}

			}
			
			}
		
		

	
	// --------------------------------------------------
	
	@EventHandler
	
    public void onFoodLevelChange(FoodLevelChangeEvent event)
    {
        event.setCancelled(true);
    }
	
	@EventHandler
	public void onPlayerDropItem1(PlayerDropItemEvent e)
	{
		e.setCancelled(true);
	}
		
		
	// --------------------------------------------------
				
				
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e)
	{
		e.setCancelled(true);
	
	// --------------------------------------------------
	}
			
					
}
