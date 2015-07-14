package com.minegusta.newjoin.listener;

import com.minegusta.newjoin.MGPlayers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

/**
 * NoneVale
 * 7/14/2015
 * MGNewJoin
 * com.minegusta.newjoin.listener
 */
public class PlayerJoin implements Listener
{


    @EventHandler
    public void onNPJE(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        FileConfiguration playerc = MGPlayers.getPlayers();

        if (!playerc.isSet(player.getUniqueId().toString()))
        {
            for (Player players : Bukkit.getOnlinePlayers())
            {
                players.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.LIGHT_PURPLE + "MG" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + "Welcome " + ChatColor.GREEN + player.getName() + ChatColor.GRAY + " to  Minegusta!");
            }
            Player nate = Bukkit.getPlayer(UUID.fromString("1310f910-9480-49bb-9955-c122154cfe1d"));
            if (Bukkit.getOnlinePlayers().contains(nate))
            {
                nate.chat(ChatColor.BLUE + "Welcome to Minegusta " + ChatColor.GREEN + player.getName());
            }
            playerc.set(player.getUniqueId().toString() + ".name", player.getName());
            MGPlayers.savePlayers();
        }
    }
}
