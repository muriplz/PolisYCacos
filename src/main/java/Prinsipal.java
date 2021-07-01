import Listeners.InventoryClickCacheo;
import comandos.ComandoCachear;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import tabs.devolverVacio;

import java.util.ArrayList;
import java.util.Objects;

public class Prinsipal extends JavaPlugin {
    private ArrayList<Inventory> inventoriosCacheados;
    PluginDescriptionFile pdffile = getDescription();
    FileConfiguration config = this.getConfig();
    public String name = ChatColor.YELLOW+"["+ChatColor.WHITE+pdffile.getName()+ChatColor.YELLOW+"]";
    public String version = pdffile.getVersion();


    public void onEnable(){
        registerCommands();
        registerEvents();
        defaultConfig();
        Bukkit.getConsoleSender().sendMessage(name+ChatColor.GRAY+" The plugin has been activated. version: "+ChatColor.GREEN+version);
    }

    public void defaultConfig(){
        // Para crear la config.yml
        config.addDefault("distancia-cachear", 7);
        config.options().copyDefaults(true);
        saveDefaultConfig();
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(name+ChatColor.WHITE+" The plugin has been deactivated.");
    }
    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new InventoryClickCacheo(), this);
    }
    public void registerCommands(){

        // Comando /cachear
        Objects.requireNonNull(this.getCommand("cachear")).setExecutor(new ComandoCachear());
        Objects.requireNonNull(getCommand("cachear")).setTabCompleter(new devolverVacio());

    }
}
