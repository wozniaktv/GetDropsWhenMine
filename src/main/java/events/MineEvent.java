package events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class MineEvent implements Listener {

    @EventHandler
    public void BlockBreak(BlockBreakEvent event){
        if(event.isDropItems()){
            /* Gets the Player so he can do some stuff to the player. */
            Player p = event.getPlayer();

            /* Cancels the drops. */
            event.setDropItems(false);

            /* Getting drops and giving them into the Player's inventory */
            Collection<ItemStack> drops = event.getBlock().getDrops(p.getItemInUse());
            if(p.getInventory().firstEmpty()==-1) { /* If Player's inventory is full we just use the legacy drops method */

                World w = p.getWorld();
                for(ItemStack IS : drops){
                    w.dropItem(event.getBlock().getLocation(), IS);
                }

            }
            else
                for(ItemStack IS : drops){ /* If Player's Inventory is not full it will work. */

                p.getInventory().addItem(IS);

                }




            /* Gives the player The Experience it would have had from the Block-Breaking */
            p.setTotalExperience(p.getTotalExperience()+event.getExpToDrop());
            /* And of course i now disable the natural dropping of the experience for not letting players have 2x experience from blocks. */
            event.setExpToDrop(0);

        }

    }

}
