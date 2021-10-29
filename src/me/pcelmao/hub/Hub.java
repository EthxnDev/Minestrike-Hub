package me.pcelmao.hub;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import com.bizarrealex.aether.Aether;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.pcelmao.hub.board.Scoreboard;
import me.pcelmao.hub.commands.FeedCommand;
import me.pcelmao.hub.inventory.Inventories;
import me.pcelmao.hub.listeners.ChatEvent;
//import me.pcelmao.hub.listeners.DoubleJump;
import me.pcelmao.hub.listeners.PlayerListeners;
import me.signatured.ezqueuespigot.EzQueueAPI;

public class Hub extends JavaPlugin implements PluginMessageListener {

    public static int playerCount;
    public static int kitpvp;

	public Aether aether;
	public static Hub INSTANCE;

    static {
        Hub.playerCount = 0;
        Hub.kitpvp = 0;

    }

    @Override
    public void onEnable() {
    	
    	
		INSTANCE = this;
		aether = new Aether(this, new Scoreboard(this));
		
		
		new Scoreboard(this);
		new PlayerListeners(this);
		//new DoubleJump(this);
		new ChatEvent(this);		
		new Inventories(this);
		
		this.getCommand("feed").setExecutor((CommandExecutor)new FeedCommand());
		this.getServer().getMessenger().registerIncomingPluginChannel((Plugin)this, "BungeeCord", (PluginMessageListener)this);
        this.getServer().getMessenger().registerOutgoingPluginChannel((Plugin)this, "BungeeCord"); 
    	
        
    }
    
    
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;									
        }
        
        
        try {
        	
        	
        	final DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        	final String subchannel = in.readUTF();
            if (subchannel.equals("PlayerCount")) {
                String server = in.readUTF();
                int playerCount2 = in.readInt();
                if (server.equals("ALL")) {
                	Hub.playerCount = playerCount2;
                }
                if (server.equalsIgnoreCase("KitPvP")) {
                    Hub.kitpvp = playerCount2;
                }
            }
        }
        catch (Exception e) {
        }
    }
    public void getCount(String server) {
        try {
            final ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("PlayerCount");
            out.writeUTF(server);
            Bukkit.getServer().sendPluginMessage((Plugin)this, "BungeeCord", out.toByteArray());
        }
        catch (Exception e) {
        }
    }
    public static String getQueuedServer(final Player p) {
        final String server = EzQueueAPI.getQueue(p);
        if (server.equalsIgnoreCase("kitpvp")) {
            return "KitPvP";
        }
   
    
        return null;
    }

}