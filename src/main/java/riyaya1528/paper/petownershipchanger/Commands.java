package riyaya1528.paper.petownershipchanger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if(command.getName().equals("ownershipchange")) {
            if(sender instanceof Player) {
                if (args.length != 0) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        if (!PetOwnershipChanger.instance.getConfig().getBoolean(((Player) sender).getUniqueId() + ".allow")) {
                            if(!args[0].equals(sender.getName())) {
                                sender.sendMessage("§e§lモード: ペット指定");
                                sender.sendMessage("§a§l自分に懐いているペットをクリックして指定してください");
                                sender.sendMessage("§c§lコマンドをもう一度実行すると解除されます");
                                PetOwnershipChanger.instance.getConfig().set(((Player) sender).getUniqueId() + ".to", args[0]);
                                PetOwnershipChanger.instance.getConfig().set(((Player) sender).getUniqueId() + ".allow", true);
                                PetOwnershipChanger.instance.saveConfig();
                            }else {
                                sender.sendMessage("§c§l自分に自分のペットのオーナーを引き継ぐことはできません");
                            }
                        }else {
                            sender.sendMessage("§e§lモード: 解除");
                            PetOwnershipChanger.instance.getConfig().set(((Player) sender).getUniqueId() + ".allow",false);
                            PetOwnershipChanger.instance.saveConfig();
                        }
                    }else {
                        if(PetOwnershipChanger.instance.getConfig().getBoolean(((Player) sender).getUniqueId() + ".allow")) {
                            sender.sendMessage("§e§lモード: 解除");
                            PetOwnershipChanger.instance.getConfig().set(((Player) sender).getUniqueId() + ".allow",false);
                            PetOwnershipChanger.instance.saveConfig();
                        }else {
                            sender.sendMessage("§c§l存在するプレイヤーを入力してください");
                        }
                    }
                }else {
                    if(PetOwnershipChanger.instance.getConfig().getBoolean(((Player) sender).getUniqueId() + ".allow")) {
                        sender.sendMessage("§e§lモード: 解除");
                        PetOwnershipChanger.instance.getConfig().set(((Player) sender).getUniqueId() + ".allow",false);
                        PetOwnershipChanger.instance.saveConfig();
                    }else {
                        sender.sendMessage("§c§l引数に引き継ぐプレイヤー名を入れてください");
                        sender.sendMessage("§c§l例: /ownershipchange [プレイヤー名]");
                    }
                }
            }
        }
        return true;
    }
}
