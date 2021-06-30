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

            // La llamo caco, pero aquí mismo es un poli
            Player caco = (Player) sender;

            // Ahora creo el (Player) poli
            Player poli = caco;

            // Ahora cambio caco a que sea el caco más cercano
            funsiones.getCacoCercano(caco);

            poli.sendMessage("caco más cercano es: "+caco.getName());

            return false;
        }
    }
}
