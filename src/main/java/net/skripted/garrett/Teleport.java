package net.skripted.garrett;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

import java.util.ArrayList;

/**
 * Created by GarrettV on 4/29/2014.
 * Github: www.github.com/garrettvorce
 * Contact: garrett.vorce@mail.com
 * Facebook: facebook.com/garrett.vorce
 * Twitter: twitter.com/garrettvorce
 * Website: www.garrettvorce.com
 * Server: www.skripted.net
 */
public final class Teleport extends JavaPlugin
{
	@Override
	// On server startup
	public void onEnable()
	{
		// this refers to this class
		// pdfFile.getName() is getting the defined name from plugin.yml
		// in this case it's Practice
		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().info(pdfFile.getName() + " has been enabled!");
	}

	// On server stop/reload
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().info(pdfFile.getName() + " has been disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
	{
		if(commandLabel.equalsIgnoreCase("random"))
		{
			Player player = (Player) sender;

			int X = (int) (Math.random() * 1000);
			int Z = (int) (Math.random() * 1000);
			int Y = player.getWorld().getHighestBlockYAt(X, Z);

			Location newLocation = new Location(player.getWorld(), X, Y, Z);
			player.teleport(newLocation);
			player.sendMessage(ChatColor.GREEN + "You were teleported to X: " + X + "Y: " + Y + "Z: " + Z);
		}
		return true;
	}
}
