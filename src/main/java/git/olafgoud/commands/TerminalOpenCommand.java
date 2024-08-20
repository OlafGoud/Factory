package git.olafgoud.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import git.olafgoud.utils.ui.MainTerminal;


public class TerminalOpenCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		try {
			if(args == null) {
				sender.sendMessage(ChatColor.RED + "You must fill in a target player");
				return true;
			}
		} catch(Exception e) {
			sender.sendMessage(ChatColor.RED + "format: <terminal>");
			return true;
		}
		
		if(args.length > 1) {
			try {
				Player player = Bukkit.getPlayer(args[1]);
				checkForTerminal(player, args[0]);
			} catch (Exception e) {
				sender.sendMessage(ChatColor.RED + "The player must be online");
				return true;
			}
		} else {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				checkForTerminal(p, args[0]);
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to perform this command as it is. A other format is: <terminal> <player>");
			}
		}
		
		
		
		
		
		
		return true;
	}
	
	private void checkForTerminal(Player p, String terminal) {
		
		switch(terminal) {
		case "main": MainTerminal.getTerminal(p); break;
		case "power": p.sendMessage(ChatColor.RED + "This does nothing yet"); break;
		}
		
	}
	
}
