package net.anthonyloukinas.bettermotd;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Motd implements Listener{
	public Motd(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		
		Player player = e.getPlayer();
		
		//player.sendMessage("Testing");
	}

}
