package de.jeff_media.AngelChestAPIExample;

import de.jeff_media.angelchest.AngelChest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;
import java.util.Set;

public class ExampleCommand implements CommandExecutor {

    private final ExamplePlugin main;

    public ExampleCommand(ExamplePlugin main) {
        this.main=main;
    }

    /**
     * Sets all your AngelChest's durations to a random amount of seconds
     * @param sender CommandSender
     * @param command Command
     * @param label Command label
     * @param args Command arguments
     * @return
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("You must be player to run this command.");
            return true;
        }

        Player player = (Player) sender;

        Set<AngelChest> angelChests = main.angelChestPlugin.getAllAngelChestsFromPlayer(player);

        for(AngelChest angelChest : angelChests) {
            angelChest.setSecondsLeft(new Random().nextInt(1000) + 50);
        }

        return true;
    }
}
