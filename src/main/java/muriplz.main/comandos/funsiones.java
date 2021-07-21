package muriplz.main.comandos;

import muriplz.main.Prinsipal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Buenos días, he aquí un ejemplo de como abusar de static :)
public class funsiones {

    private static Prinsipal plugin;

    public funsiones(Prinsipal plugin) {
        funsiones.plugin = plugin;
    }

    public static List<UUID> getCacosCercanos(Player poli){
        List<UUID> cacos = new ArrayList<>();
        for(Player p : Bukkit.getOnlinePlayers() ){
            if(!p.hasPermission("pyc.poli")){
                if(poli.getLocation().distance(p.getLocation())<plugin.getConfig().getInt("distancia-cachear")){
                    cacos.add(p.getUniqueId());
                }
            }
        }
        return cacos;
    }

    public static ItemStack crearItem(String name, Material mat, List<String> lore){
        ItemStack item = new ItemStack(mat,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    // Para mandar mensajes con base hexadecimal (&1,&2,&3,...)
    public static void sendMessage(Player player,String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
