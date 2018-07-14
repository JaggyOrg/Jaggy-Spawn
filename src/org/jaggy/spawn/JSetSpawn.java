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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JSetSpawn implements CommandExecutor {
    private final Main plugin;

    public JSetSpawn(Main main) {
        plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("jaggyspawn.admin")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location loc = player.getLocation();
                double X = loc.getX();
                double Y = loc.getY();
                double Z = loc.getZ();
                float Pitch = loc.getPitch();
                float Yaw = loc.getYaw();
                plugin.config.setPitch(Pitch);
                plugin.config.setYaw(Yaw);
                plugin.config.setX(X);
                plugin.config.setY(Y);
                plugin.config.setZ(Z);
                plugin.config.setEnforce(true);
                plugin.config.setWorld(((Player) sender).getWorld().getName());
                plugin.config.saveConfig();
            }
        }
        return true;
    }
}
