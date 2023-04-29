package de.grafjojo.shareposition.position;

import de.grafjojo.shareposition.SharePosition;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Position {

    public Location location;
    public Player sender;

    public Position(Location location, Player sender) {
        this.location = location;
        this.sender = sender;
    }

    public void sendInPublicChat() {
        Bukkit.getOnlinePlayers().forEach(players -> {
            players.sendMessage(" ");
            players.sendMessage(SharePosition.getInstance().getPrefix() + "§a§lPublic");
            players.sendMessage(SharePosition.getInstance().getPrefix() + "§9" + sender.getName()  + "'s §7coordinates are: §5§l" +
                    location.getBlockX() + " " +
                    location.getBlockY() + " " +
                    location.getBlockZ());

            players.sendMessage(SharePosition.getInstance().getPrefix() + "§7Biome: §5§l" + location.getBlock().getBiome().name().replaceAll("_", " "));

            switch (location.getWorld().getName()) {
                case "world":
                    players.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lWorld");
                    break;
                case "world_nether":
                    players.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lNether");
                    break;
                case "world_the_end":
                    players.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lThe End");
                    break;
                default:
                    players.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§l" + location.getWorld().getName().replaceAll("_", " "));
                    break;
            }
            players.sendMessage(" ");

            players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10 , 3);
        });
    }

    public void sendInPrivateChat() {
        sender.sendMessage(" ");
        sender.sendMessage(SharePosition.getInstance().getPrefix() + "§c§lPrivate");
        sender.sendMessage(SharePosition.getInstance().getPrefix() + "§9Your §7coordinates are: §5§l" +
                location.getBlockX() + " " +
                location.getBlockY() + " " +
                location.getBlockZ());

        sender.sendMessage(SharePosition.getInstance().getPrefix() + "§7Biome: §5§l" + location.getBlock().getBiome().name().replaceAll("_", " "));
        switch (location.getWorld().getName()) {
            case "world":
                sender.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lWorld");
                break;
            case "world_nether":
                sender.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lNether");
                break;
            case "world_the_end":
                sender.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lThe End");
                break;
            default:
                sender.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§l" + location.getWorld().getName().replaceAll("_", " "));
                break;
        }
        sender.sendMessage(" ");
        sender.playSound(sender.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10 , 3);

    }

    public void sendInProtectedChat(Player target) {
        target.sendMessage(" ");
        target.sendMessage(SharePosition.getInstance().getPrefix() + "§3§lProtected");
        target.sendMessage(SharePosition.getInstance().getPrefix() + "§9" + sender.getName()  + "'s §7coordinates are: §5§l" +
                location.getBlockX() + " " +
                location.getBlockY() + " " +
                location.getBlockZ());

        target.sendMessage(SharePosition.getInstance().getPrefix() + "§7Biome: §5§l" + location.getBlock().getBiome().name().replaceAll("_", " "));
        switch (location.getWorld().getName()) {
            case "world":
                target.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lWorld");
                break;
            case "world_nether":
                target.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lNether");
                break;
            case "world_the_end":
                target.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§lThe End");
                break;
            default:
                target.sendMessage(SharePosition.getInstance().getPrefix() + "§7World: §5§l" + location.getWorld().getName().replaceAll("_", " "));
                break;
        }
        target.sendMessage(" ");
        target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10 , 3);

        sender.sendMessage(SharePosition.getInstance().getPrefix() + "§7You have shared your location with §9" + target.getName() + "§7.");

    }
}