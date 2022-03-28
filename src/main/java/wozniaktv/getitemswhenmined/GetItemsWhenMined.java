package wozniaktv.getitemswhenmined;

import events.MineEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GetItemsWhenMined extends JavaPlugin {

    @Override
    public void onEnable() {
        /* Using a boolean variable to understand if i need to send the success message at the end. */
        boolean thrown_exception = false;

        getLogger().info("Plugin started loading...");

        try{

            /* onEnable code */

            /* == LISTENERS == */

            getServer().getPluginManager().registerEvents(new MineEvent(),this);


        } catch (Exception e) {


            /* Error message logic (i hope it is not needed) */
            getLogger().severe("Something went wrong during the loading of this plugin, please contact the Developer.");
            getLogger().severe("Error Message: ");
            getLogger().severe(e.toString());
            thrown_exception=true;

        }
        /* If all goes right it sends this message. */

        if(!thrown_exception)
            getLogger().info("Plugin loaded successfully!");
    }

    @Override
    public void onDisable() {

        /* onDisable code */

    }
}
