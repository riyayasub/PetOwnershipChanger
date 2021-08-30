package riyaya1528.paper.petownershipchanger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Cat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SelectPet implements Listener {
    @EventHandler
    public void onClickEntity(EntityDamageByEntityEvent e) {
        if(e.getDamager().getType().equals(EntityType.PLAYER)) {
            if(e.getEntity().getType().equals(EntityType.WOLF) || e.getEntity().getType().equals(EntityType.CAT)) {
                Player Player = (Player)e.getDamager();
                if(PetOwnershipChanger.instance.getConfig().getBoolean(Player.getUniqueId() + ".allow")) {
                    e.setCancelled(true);
                    if(e.getEntity().getType().equals(EntityType.WOLF)) {
                        Wolf Wolf = (Wolf)e.getEntity();
                        if(Wolf.getOwner() != null && Wolf.getOwner().getName().equals(Player.getName())) {
                            Wolf.setOwner(Bukkit.getPlayer(PetOwnershipChanger.instance.getConfig().getString(Player.getUniqueId() + ".to")));
                            Player.sendMessage("§a§lペットのオーナーを引き継ぎました");
                            Player.sendMessage("§e§lモード: 解除");
                            PetOwnershipChanger.instance.getConfig().set(Player.getUniqueId() + ".allow", false);
                        }else {
                            Player.sendMessage("§c§lあなたに懐いていないペットは他の人に引き継げません");
                        }
                    }else if(e.getEntity().getType().equals(EntityType.CAT)) {
                        Cat Cat = (Cat) e.getEntity();
                        if(Cat.getOwner() != null && Cat.getOwner().getName().equals(Player.getName())) {
                        Cat.setOwner(Bukkit.getPlayer(PetOwnershipChanger.instance.getConfig().getString(Player.getUniqueId() + ".to")));
                        Player.sendMessage("§a§lペットのオーナーを引き継ぎました");
                        Player.sendMessage("§e§lモード: 解除");
                        PetOwnershipChanger.instance.getConfig().set(Player.getUniqueId() + ".allow",false);
                    }else {
                        Player.sendMessage("§c§lあなたに懐いていないペットは他の人に引き継げません");
                        }
                    }
                }
            }
        }
    }
}
