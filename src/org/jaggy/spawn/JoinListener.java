/*
 * Copyright (C) 2018 Jaggy Enterprises
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.jaggy.spawn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private final Main plugin;
    private final Config config;

    public JoinListener(Main main) {
        plugin = main;
        config = plugin.config;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerJoin(PlayerJoinEvent event) {
        if (config.getEnforce()) {
            World world = plugin.getServer().getWorld(config.getWorld());
            Location location = new Location(world, config.getX(), config.getY(), config.getZ(), config.getYaw(), config.getPitch());
            event.getPlayer().teleport(location);
        }
    }
}
