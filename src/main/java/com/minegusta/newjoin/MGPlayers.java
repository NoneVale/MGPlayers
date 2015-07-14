package com.minegusta.newjoin;

import com.minegusta.newjoin.listener.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * NoneVale
 * 7/14/2015
 * MGNewJoin
 * com.minegusta.newjoin
 */
public class MGPlayers extends JavaPlugin
{

    private static File players;
    private static FileConfiguration playerconf;

    public void onEnable()
    {
        loadPlayers();
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    public void onDisable()
    {
        savePlayers();
    }

    public static void loadPlayers()
    {
        try {
            players = new File("plugins/MGPlayers/players.yml");
            if (!players.exists())
            {
                players.createNewFile();
                Bukkit.getLogger().info("[MGPlayers] players.yml has been created...");
            }

            playerconf = YamlConfiguration.loadConfiguration(players);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void savePlayers()
    {
        try {
            playerconf.save(players);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static FileConfiguration getPlayers()
    {
        return playerconf;
    }
}
