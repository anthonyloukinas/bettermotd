package net.anthonyloukinas.bettermotd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{

	
	public String colorize(String msg){
		String coloredMsg = "";
		for(int i = 0; i < msg.length(); i++){
			if(msg.charAt(i) == '&')
				coloredMsg += '§';
			else
				coloredMsg += msg.charAt(i);
		}
		return coloredMsg;
	}
	
	
	@Override
	public void onEnable(){
		new Motd(this);
		
		this.saveDefaultConfig();
		
		// Register a new listener
        getServer().getPluginManager().registerEvents(new Listener() {
 
            @EventHandler
            public void playerJoin(PlayerJoinEvent event) {
                // On player join send them the message from config.yml
                // Old message send with no color support.
            	//event.getPlayer().sendMessage(Main.this.getConfig().getString("message"));
            	//String customstring = getConfig().getString("message").replaceAll("(&([a-f0-9]))", "\u00A7$2" + "");
                //event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("message")));
            	String customstring = getConfig().getString("message");
                event.getPlayer().sendMessage(colorize(customstring));
            }
        }, this);
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		Player p = (Player) sender;
		if(command.getName().equalsIgnoreCase("bmreload")){
			this.reloadConfig();
			p.sendMessage("[BetterMOTD] Reloaded config!");
		}else if(command.getName().equalsIgnoreCase("bmmotd")){
			p.sendMessage(colorize(getConfig().getString("message")));
		}
		return true;
}
}
