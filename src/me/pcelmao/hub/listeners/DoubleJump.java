//package me.pcelmao.hub.listeners;
// 
//import org.bukkit.Bukkit;
//import org.bukkit.GameMode;
//import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.player.PlayerJoinEvent;
//import org.bukkit.event.player.PlayerToggleFlightEvent;
//import org.bukkit.plugin.Plugin;
//import org.bukkit.util.Vector;
//
//import me.pcelmao.hub.Hub;
// 
//public class DoubleJump implements Listener {
//	
//	public static Hub plugin;
//	
//	@SuppressWarnings("static-access")
//	public DoubleJump(Hub plugin) {
//		this.plugin = plugin;
//		Bukkit.getPluginManager().registerEvents(this, (Plugin)plugin);
//	}
// 
//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent e){
//        e.getPlayer().setAllowFlight(true);
//    }
//    
//    @EventHandler
//    public void onPlayerDoubleJump(PlayerToggleFlightEvent e){
//        Player p = e.getPlayer();
//        if(p.getGameMode() != GameMode.CREATIVE){
//            e.setCancelled(true);
//            Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0,2,0));
//            if(!b.getType().equals(Material.AIR)){
//                Vector v = p.getLocation().getDirection().multiply(1).setY(1);
//                p.setVelocity(v);
//            }
//        }
//    }
//}