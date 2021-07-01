package comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ComandoCachear implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("[PolisYCacos] You can't execute this command from console.");
            return false;
        } else {

            Player poli = (Player) sender;

            if(args.length!=0){
                return false;
            }

            if(!poli.hasPermission("pyc.poli")){
                poli.sendMessage("No eres policia.");
                return false;
            }

            Player caco = funsiones.getCacoCercano(poli);

            if(caco==null){
                poli.sendMessage("No hay cacos cerca.");
                return false;
            }
            poli.openInventory(caco.getInventory());

            return true;
        }
    }
}
