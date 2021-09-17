package riyaya1528.paper.petownershipchanger;

import org.bukkit.plugin.java.JavaPlugin;

public final class DeleteWorlds {
    public boolean deleteWorld(File path) {
      if(path.exists()) {
          File files[] = path.listFiles();
          for(int i=0; i<files.length; i++) {
              if(files[i].isDirectory()) {
                  deleteWorld(files[i]);
              } else {
                  files[i].delete();
              }
          }
      }
      return(path.delete());
}

public void unloadWorld(World world) {
    this.world = Bukkit.getWorld("");
    if(!world.equals(null)) {
        Bukkit.getServer().unloadWorld(world, true);
    }
}
public void deletePlugin()

}