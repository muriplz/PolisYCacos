package comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoCachear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("[PolisYCacos] You can't execute this command from console.");
            return false;
        } else {

            Player poli = (Player) sender;

            if(!poli.hasPermission("pyc.poli")){
                poli.sendMessage("No eres policia.");
                return false;
            }

            Player caco = funsiones.getCacoCercano(poli);



            if(caco==null){
                poli.sendMessage("No hay cacos cerca.");
                return false;
            }
            poli.sendMessage("Caco más cercano es: "+caco.getName());

            return true;
        }
    }
}
