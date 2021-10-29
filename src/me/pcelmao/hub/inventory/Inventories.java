package me.pcelmao.hub.inventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.pcelmao.hub.Hub;
import me.pcelmao.hub.utils.Color;
import me.signatured.ezqueuespigot.EzQueueAPI;
import net.md_5.bungee.api.ChatColor;

public class Inventories implements Listener {
		
	public static Hub plugin;
	
	public Inventories(Hub plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, (Plugin)plugin);
	}
	@EventHandler
	public static void SelectorInv(Player p) {

		Inventory inv = Bukkit.createInventory((InventoryHolder) p, 9, Color.C("&8Server Selector"));
		
		// ------------------------------------------------------------------------------------
		ItemStack kitpvp = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta kitpvpMeta1 = kitpvp.getItemMeta(); 
		
		kitpvpMeta1.setDisplayName("§a§lKit§f§lPvP");
		
		List<String> kitpvp1 = new ArrayList<>();	
		kitpvp1.add(ChatColor.translateAlternateColorCodes('&', "&7Claim your kits and start pvping with others"));
		kitpvp1.add(ChatColor.translateAlternateColorCodes('&', "&7and aim for a spot on the leaderboards!"));
		kitpvp1.add(ChatColor.translateAlternateColorCodes('&', ""));
		kitpvp1.add(ChatColor.translateAlternateColorCodes('&', "&a&lPlayers: &f " + Hub.kitpvp + " / 500"));
		kitpvp1.add(ChatColor.translateAlternateColorCodes('&', "&7"));
		kitpvp1.add(ChatColor.translateAlternateColorCodes('&', "&7Click to queue..."));
		
		kitpvpMeta1.setLore(kitpvp1);
		kitpvp.setItemMeta(kitpvpMeta1);
		
		// ------------------------------------------------------------------------------------
		
		// ------------------------------------------------------------------------------------
		ItemStack comingsoon = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta comingsoonMeta1 = comingsoon.getItemMeta(); 
		
		comingsoonMeta1.setDisplayName("§c§lComing Soon");
		
		List<String> coming1 = new ArrayList<>();	
		coming1.add(ChatColor.translateAlternateColorCodes('&', "&7What could be coming next?"));
		
		comingsoonMeta1.setLore(coming1);
		comingsoon.setItemMeta(comingsoonMeta1);
		
		// ------------------------------------------------------------------------------------
		
		inv.setItem(4, kitpvp);
		inv.setItem(6, comingsoon);
		inv.setItem(2, comingsoon);
		p.openInventory(inv);
	}
	
	   @EventHandler
	    public void clickEvent3(InventoryClickEvent e){

	       if(e.getClickedInventory().getTitle().equalsIgnoreCase(Color.C("&8Server Selector"))){
	            Player player = (Player) e.getWhoClicked();
	            switch(e.getCurrentItem().getType()){
	                case DIAMOND_SWORD:
	        			player.closeInventory();
	        			EzQueueAPI.addToQueue(player, "kitpvp");
                    break;
	    		default:
	    			player.closeInventory();
	    			break;
	            }


    			player.closeInventory();
	            e.setCancelled(true); 
	        }
	    }


	}

