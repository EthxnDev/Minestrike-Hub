package me.pcelmao.hub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.pcelmao.hub.utils.Color;

public class DayCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// --------------------------
		
		Player p = (Player) sender;
		p.sendMessage(Color.C("&aThe time has been set to &aday."));
		p.setPlayerTime(5000, true);
		return true;
		
		// -------------------------- 
	}
	

}
