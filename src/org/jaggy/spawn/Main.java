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

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Config config;

    public void onLoad() {
        config = new Config(this);
    }

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        this.getCommand("jsetspawn").setExecutor(new JSetSpawn(this));

    }
}
