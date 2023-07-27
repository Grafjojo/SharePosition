package de.grafjojo.shareposition.command;

import de.grafjojo.shareposition.SharePosition;
import de.grafjojo.shareposition.position.Position;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PositionCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return true;

        Position position = new Position(player.getLocation(), player);

        if (args.length == 1) {

            if (args[0].equalsIgnoreCase("help")) {
                if (!player.hasPermission("shareposition.position.help.command"))
                    player.sendMessage(SharePosition.getInstance().getNoPerm());
                // Send a list of commands

                player.sendMessage(SharePosition.getInstance().getPrefix() + " ");
                player.sendMessage(SharePosition.getInstance().getPrefix() + "§9§l§nSharePosition§f §8§l§n|§f §6§l§nCommands: ");
                player.sendMessage(SharePosition.getInstance().getPrefix() + "§6/position help §8| §7Sends a list of commands.");
                player.sendMessage(SharePosition.getInstance().getPrefix() + "§6/position get §8| §7Sends your location.");
                player.sendMessage(SharePosition.getInstance().getPrefix() + "§6/position share §8| §7Sends your location to the public chat.");
                player.sendMessage(SharePosition.getInstance().getPrefix() + "§6/position share <PLAYER> §8| §7Sends your location to a specific player.");
                player.sendMessage(SharePosition.getInstance().getPrefix() + " ");


            } else if (args[0].equalsIgnoreCase("get")) {
                if (!player.hasPermission("shareposition.position.get.command"))
                    player.sendMessage(SharePosition.getInstance().getNoPerm());

                position.sendInPrivateChat();


            } else if (args[0].equalsIgnoreCase("share")) {
                if (!player.hasPermission("shareposition.position.share.command"))
                    player.sendMessage(SharePosition.getInstance().getNoPerm());

                position.sendInPublicChat();
            }

        } else if (args.length == 2) {

            if (args[0].equalsIgnoreCase("share")) {
                if (!player.hasPermission("shareposition.position.share.other.command"))
                    player.sendMessage(SharePosition.getInstance().getNoPerm());
                Player target = Bukkit.getPlayer(args[1]);

                if (target != null) {
                    position.sendInProtectedChat(target);

                } else {
                    player.sendMessage(SharePosition.getInstance().getPlayerNotFound());
                }

            } else {
                player.sendMessage(SharePosition.getInstance().getPrefix() + "§cCommand was not found! Try §9/position help");
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            return List.of("help", "get", "share");
        }
        return null;
    }
}