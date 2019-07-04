package huan.yuan.bloodnighttw.onlinetimeaward;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class eventListener implements Listener {
    @EventHandler
    public void PJE(PlayerJoinEvent event){

        Player p=event.getPlayer();
        if(!p.hasPlayedBefore()){
            String playerName=p.toString();
            System.out.println("find a new player"+"("+playerName+")"+"join");


        }

        String playerName= p.getName();
        String playerUUID=p.getUniqueId().toString();
        System.out.println("OTM debug:"+playerName+" "+playerUUID+"join!");
        p.sendMessage("OTM debugMod");



    }


}
