package riyaya1528.paper.petownershipchanger;

import org.bukkit.plugin.java.JavaPlugin;

public final class PetOwnershipChanger extends JavaPlugin {
    public static PetOwnershipChanger instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("ownershipchange").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Join(),this);
        getServer().getPluginManager().registerEvents(new SelectPet(),this);
        getLogger().info("プラグインが有効になりました");
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("プラグインが無効になりました");
    }
}
