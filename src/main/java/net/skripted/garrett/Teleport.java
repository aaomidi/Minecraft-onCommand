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
		//Command, doesn't matter if random, RANDOM, RaNdOm, etc
		if(commandLabel.equalsIgnoreCase("random"))
		{
			//Casting player to sender, final because Zenexer taught me the ways :p
			final Player player = (Player) sender;

			//Math.random() is getting a random number between 0 and 1000
			//casting (Math.random() * 1000) to an integer instead of a float
			int X = (int) (Math.random() * 1000);
			int Z = (int) (Math.random() * 1000);

			//Have to initialize Y AFTER Z to get the highestpoint of the world's location
			int Y = player.getWorld().getHighestBlockYAt(X, Z);

			//Location method from int X, Z, Y
			Location newLocation = new Location(player.getWorld(), X, Y, Z);

			//Calling ^ method to teleport the player to a random location
			player.teleport(newLocation);

			//Player message on the final random teleport location
			player.sendMessage(ChatColor.GREEN + "You were teleported to X: " + X + "Y: " + Y + "Z: " + Z);
		}
		//Boolean returned true onCommand
		return true;
	}
}
