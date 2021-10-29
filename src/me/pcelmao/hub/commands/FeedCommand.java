package me.pcelmao.hub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.pcelmao.hub.utils.Color;



public class FeedCommand implements CommandExecutor {


	// ----------------------------------------------------
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {		
		
		Player p = (Player) sender;
		p.setSaturation(20);
		p.setFoodLevel(20);
		p.sendMessage(Color.C("&bYou have been successfully fed."));
		
	// ----------------------------------------------------

		return true;
	}

}
