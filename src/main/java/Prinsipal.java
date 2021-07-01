import comandos.ComandoCachear;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Prinsipal extends JavaPlugin {
    PluginDescriptionFile pdffile = getDescription();
    FileConfiguration config = this.getConfig();
    public String name = ChatColor.YELLOW+"["+ChatColor.WHITE+pdffile.getName()+ChatColor.YELLOW+"]";
    public String version = pdffile.getVersion();
    public static Prinsipal plugin;


    public void onEnable(){
        plugin = this;
        registerCommands();
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
    public void registerCommands(){
        Objects.requireNonNull(this.getCommand("cachear")).setExecutor(new ComandoCachear());
    }
}
