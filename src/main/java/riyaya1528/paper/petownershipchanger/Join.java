package riyaya1528.paper.petownershipchanger;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
    public void onJoin(PlayerJoinEvent e) {
        PetOwnershipChanger.instance.getConfig().set(e.getPlayer().getUniqueId() + ".allow",false);
        PetOwnershipChanger.instance.saveConfig();
    }
}
