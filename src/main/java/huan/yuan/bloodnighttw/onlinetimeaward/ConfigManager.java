package huan.yuan.bloodnighttw.onlinetimeaward;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
    private Main plugin = Main.getPlugin(Main.class);
    // add config
    public FileConfiguration save;
    static File savFile;

    public FileConfiguration language;
    static File languagefile;
    static File folder;

    // add config
    public void setup() {
        File dir = new File(plugin.getDataFolder() + "/language/"); //folder
        savFile = new File(plugin.getDataFolder(), "save.yml");//filename
        languagefile = new File(plugin.getDataFolder() + "/language/", "zh_TW.yml");//location+filename

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        if (!dir.exists()) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "creating " + ChatColor.BLUE + dir + ChatColor.RED + " folder...");
            dir.mkdir();
        }
        if (!savFile.exists()) {
            try {
                savFile.createNewFile();
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create " + savFile + " configfile.");
            }
        }
        if (!languagefile.exists()) {
            try {
                languagefile.createNewFile();
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create " + languagefile + " configfile.");
            }
        }
        save = YamlConfiguration.loadConfiguration(savFile);
        language = YamlConfiguration.loadConfiguration(languagefile);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "all configfile file has been create!");
    }

    public YamlConfiguration getlang(){
        return YamlConfiguration.loadConfiguration(languagefile);
    }

    public void saveCommandFile() {
        try {
            save.options().copyDefaults(true);
            save.save(savFile);
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "" + savFile + " has been saved!");
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save " + savFile + " file!");
        }
    }

    public void saveLang() {
        try {
            language.options().copyDefaults(true);
            language.save(languagefile);
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "" + languagefile + " has been saved!");
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save " + languagefile + " file!");
        }
    }

    public void reloadconfig() {
        save = YamlConfiguration.loadConfiguration(savFile);
        language = YamlConfiguration.loadConfiguration(languagefile);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "configfile has been reload!");
    }
}
