package muriplz.main.inventory;

import muriplz.main.comandos.funsiones;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SelectorDeCaco implements InventoryHolder {
    private Inventory inv;

    public SelectorDeCaco(){
        inv = Bukkit.createInventory(this,9, "Selecciona un caco");
    }

    private void init(Player poli){
        ItemStack item;
        List<UUID> cacos = funsiones.getCacosCercanos(poli);
        for(UUID uuid : cacos ){
            item = funsiones.crearItem(Bukkit.getPlayer(uuid).getDisplayName(),Material.LEGACY_SKULL_ITEM, Collections.singletonList("Cachea al caco"));
            inv.setItem(inv.firstEmpty(),item);
        }
    }





    @NotNull
    @Override
    public Inventory getInventory() {

        init();

        return inv;
    }
}
