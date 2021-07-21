package muriplz.main.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickCacheo implements Listener {
    @EventHandler
    public void onPlayerOpenInventory(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int slot = e.getRawSlot();
        p.sendMessage(""+slot);
        e.setCancelled(true);
    }
}
