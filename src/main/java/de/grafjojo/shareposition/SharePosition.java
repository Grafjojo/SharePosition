package de.grafjojo.shareposition;

import de.grafjojo.shareposition.command.PositionCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.Console;

public final class SharePosition extends JavaPlugin {

    public static SharePosition instance;
    private String prefix;
    private String noPerm;
    private String playerNotFound;

    @Override
    public void onEnable() {
        instance = this;
        prefix = "§8» §7";
        noPerm = prefix + "§cYou don't have permissions!";
        playerNotFound = prefix + "§cPlayer was not found!";

        getCommand("position").setExecutor(new PositionCommand());

        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§aPlugin has been loaded.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§cPlugin has been unloaded.");
    }

    public static SharePosition getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPerm() {
        return noPerm;
    }

    public String getPlayerNotFound() {
        return playerNotFound;
    }
}
