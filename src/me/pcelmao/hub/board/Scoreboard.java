package me.pcelmao.hub.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.bizarrealex.aether.scoreboard.Board;
import com.bizarrealex.aether.scoreboard.BoardAdapter;
import com.bizarrealex.aether.scoreboard.cooldown.BoardCooldown;

import me.pcelmao.hub.Hub;
import me.signatured.ezqueuespigot.EzQueueAPI;
import ru.tehkode.permissions.bukkit.PermissionsEx;



public class Scoreboard implements BoardAdapter, Listener {

	public Hub main;

    public Scoreboard(Hub main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents(this, main);
    }

	@Override
    public String getTitle(Player player) {
        return "&a&lMine&f&lStrike &7┃ &fHub";
	}

    @Override
    public List<String> getScoreboard(Player player, Board board, Set<BoardCooldown> cooldowns) {
    	List<String> lines = new ArrayList<>();
    	String rank = PermissionsEx.getUser(player).getPrefix().replace("[", "").replace("]", "").replace("-", " ").replace("_", " ");
    	
    	Hub.INSTANCE.getCount("ALL");
    	Hub.INSTANCE.getCount("KitPvP");
            
    	
        lines.add("&7&m------------------");
        lines.add("&aGlobal:");
        lines.add(" &f" + Hub.playerCount);
        lines.add("");
        lines.add("&aRank:"); 
        lines.add(" "+ rank);
        
        if (EzQueueAPI.getQueue(player) != null) {   
            final int spot = EzQueueAPI.getPosition(player);
            final int queuesize = EzQueueAPI.getQueueSize(Hub.getQueuedServer(player));
            final String queuedserver = Hub.getQueuedServer(player);
            lines.add("");
            lines.add("&aQueue:");  
            lines.add("&f " +  queuedserver);
            lines.add("&f " + spot + "/" + queuesize);
            
            }       	
        
        	lines.add("");
        	lines.add(" &aminestrike.cc");
        	lines.add("&7&m------------------");    	 	
        
    
        
		return lines;
    }
    public void getBoard(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        @SuppressWarnings("unused")
		Board board = Board.getByPlayer(p);
    }
}