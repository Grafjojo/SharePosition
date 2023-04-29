package de.grafjojo.shareposition.position;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PositionNavigator {

    private Player player;
    private Location location;
    private World world;

    public PositionNavigator(Player player, Location location, World world) {
        this.player = player;
        this.location = location;
        this.world = world;
    }
}
