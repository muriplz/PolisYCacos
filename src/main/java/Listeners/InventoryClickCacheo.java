package Listeners;

import comandos.ComandoCachear;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClickCacheo implements Listener {
    private Prinsipal prinsipal;
    prinsipal = new Prinsipal(this);
    @EventHandler
    public void onPlayerOpenInventory(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        int slot = e.getRawSlot();
        e.setCancelled(true);
    }
}
