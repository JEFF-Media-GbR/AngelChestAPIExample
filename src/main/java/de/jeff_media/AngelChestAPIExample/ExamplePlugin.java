package de.jeff_media.AngelChestAPIExample;

import de.jeff_media.angelchest.AngelChestPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Example plugin to show how to use the ChestSortAPI.
 */
public class ExamplePlugin extends JavaPlugin implements Listener, CommandExecutor {

	public AngelChestPlugin angelChestPlugin;
	
	public void onEnable() {

		Plugin plugin = getServer().getPluginManager().getPlugin("AngelChest");

		// ChestSort is not installed
		if(plugin==null) {
			getLogger().severe("Error: AngelChest is not installed.");
			return;
		}

		angelChestPlugin = (AngelChestPlugin) plugin;
		
		getServer().getPluginManager().registerEvents(new ExampleListener(this), this);
		getCommand("angelchesttest").setExecutor(new ExampleCommand(this));
	}

}
