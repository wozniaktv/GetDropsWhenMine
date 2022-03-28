package events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MineEvent implements Listener {

    @EventHandler
    public void BlockBreak(BlockBreakEvent event){
        if(event.isDropItems()){
            /* Gets the Player so he can do some stuff to the player. */
            Player p = event.getPlayer();

            /* Cancels the drops. ~ Now it doesn't actually do it because i didn't figure out how to extract the DropItems and give them directly to the player. */
            // event.setDropItems(true);


            /* Gives the player The Experience it would have had from the Block-Breaking */
            p.setTotalExperience(p.getTotalExperience()+event.getExpToDrop());
            /* And of course i now disable the natural dropping of the experience for not letting players have 2x experience from blocks. */
            event.setExpToDrop(0);

        }

    }

}
