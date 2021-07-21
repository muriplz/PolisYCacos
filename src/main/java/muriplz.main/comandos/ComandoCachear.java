package muriplz.main.comandos;

import muriplz.main.Prinsipal;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ComandoCachear implements CommandExecutor {

    private final Prinsipal plugin;

    public ComandoCachear(Prinsipal plugin) {
        this.plugin = plugin;
    }


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

            List<UUID> cacos = funsiones.getCacosCercanos(poli);

            if(cacos.size()==0){
                poli.sendMessage("No hay cacos cerca.");
                return false;
            }
            Inventory inv = null;
            poli.openInventory(inv);

            return true;
        }
    }
}
