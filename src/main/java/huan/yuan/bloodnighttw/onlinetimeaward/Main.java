package huan.yuan.bloodnighttw.onlinetimeaward;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    ConfigManager cfgm = new ConfigManager();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new eventListener(), this);
        System.out.println(ChatColor.DARK_RED +"ssss");

    }
    public void configsetup(){
        cfgm.setup();
        cfgm.language.addDefault("test","");
        //githubtest
        cfgm.saveLang();
        cfgm.reloadconfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
