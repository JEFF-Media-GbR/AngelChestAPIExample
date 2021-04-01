package de.jeff_media.AngelChestAPIExample;

import de.jeff_media.angelchest.AngelChest;
import de.jeff_media.angelchest.events.AngelChestSpawnEvent;
import de.jeff_media.angelchest.events.AngelChestSpawnPrepareEvent;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ExampleListener implements Listener {

    private final ExamplePlugin main;

    ExampleListener(ExamplePlugin main) {
        this.main=main;
    }

    /**
     * Always move the AngelChest one block down
     * @param event AngelChestSpawnPrepareEvent
     */
    @EventHandler
    public void onAngelChestSpawnPrepareEvent(AngelChestSpawnPrepareEvent event) {
        event.setBlock(event.getBlock().getRelative(BlockFace.DOWN));
    }

    /**
     * Fill up the empty slots in the AngelChest with Diamonds ands sets random XP
     * @param event AngelChestSpawnEvent
     */
    @EventHandler
    public void onAngelChestSpawnEvent(AngelChestSpawnEvent event) {
        AngelChest angelChest = event.getAngelChest();
        ItemStack[] oldItems = angelChest.getStorageInv();
        ItemStack[] newItems = angelChest.getStorageInv().clone();
        for(int i = 0; i < oldItems.length; i++)
            if(oldItems[i] == null) {
                newItems[i] = new ItemStack(Material.DIAMOND,new Random().nextInt(64)+1);
        }
        angelChest.setStorageInv(newItems);
        angelChest.setExperience(new Random().nextInt(Integer.MAX_VALUE));
    }
}
