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

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class Config {
    /**
     * pointer to parent class.
     */
    private final Main plugin;
    /**
     * container for config file
     */
    private final FileConfiguration config;
    /**
     * default X axis
     */
    private double defaultX = 0;
    /**
     * default Y axis
     */
    private double defaultY = 0;
    /**
     * default z axis
     */
    private double defaultZ = 0;
    /**
     * default pitch: up and down
     */
    private float defaultPitch = 0;
    /**
     * default yaw: left and right
     */
    private float defaultYaw = 0;
    /**
     * default to see if we enforce spawning location
     */
    private boolean defaultEnforce = false;
    private String defaultWorld = "world";


    public Config(Main main) {
        plugin = main;
        config = plugin.getConfig();
        File File = new File(plugin.getDataFolder(),"config.yml");
        if (!File.exists()) {
            plugin.saveDefaultConfig();
        }

    }

    public double getX() {
        return config.getDouble("Spawn.X", defaultX);
    }
    public double getY() {
        return config.getDouble("Spawn.Y", defaultY);
    }
    public double getZ() {
        return config.getDouble("Spawn.Z", defaultZ);
    }
    public float getPitch() {
        return config.getInt("Spawn.Pitch", (int) defaultPitch);
    }
    public float getYaw() {
        return config.getInt("Spawn.Yaw", (int) defaultYaw);
    }
    public String getWorld() {
        return config.getString("Spawn.World", defaultWorld);
    }
    public boolean getEnforce() {
        return config.getBoolean("EnforceLocation", defaultEnforce);
    }

    public void setX(double X) {
        config.set("Spawn.X", X);
    }
    public void setY(double Y) {
        config.set("Spawn.Y", Y);
    }
    public void setZ(double Z) {
        config.set("Spawn.Z", Z);
    }
    public void setPitch(float pitch) {
        config.set("Spawn.Pitch", pitch);
    }
    public void setYaw(float yaw) {
        config.set("Spawn.Yaw", yaw);
    }
    public void setEnforce(boolean enforce) {
        config.set("EnforceLocation", enforce);
    }
    public void saveConfig() {
        plugin.saveConfig();
    }

    public void setWorld(String world) {
        config.set("Spawn.World", world);
    }
}
