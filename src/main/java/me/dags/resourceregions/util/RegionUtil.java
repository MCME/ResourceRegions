/*
 * ResourceRegions, a regions based texture-switcher
 * Copyright (c) 2014 dags <http://dags.me>
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by the
 *   Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful, but WITHOUT
 *   ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *   FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package me.dags.resourceregions.util;

import me.dags.resourceregions.ResourceRegions;
import me.dags.resourceregions.region.Region;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

/**
 * @author dags_ <dags@dags.me>
 */

public class RegionUtil
{

    public static boolean hasRegionBuilder(Player p)
    {
        return p.hasMetadata(Constants.REGION_BUILDER);
    }

    public static Region getRegionBuilder(Player p)
    {
        if (hasRegionBuilder(p))
        {
            return (Region) p.getMetadata(Constants.REGION_BUILDER).get(0).value();
        }
        return null;
    }

    public static void removeRegionBuilder(Player p)
    {
        if (hasRegionBuilder(p))
        {
            p.removeMetadata(Constants.REGION_BUILDER, ResourceRegions.getPlugin());
        }
    }

    public static void attachRegionBuilder(Player p, Region r)
    {
        MetadataValue mv = new FixedMetadataValue(ResourceRegions.getPlugin(), r);
        p.setMetadata(Constants.REGION_BUILDER, mv);
    }

    public static boolean validPackUrl(String url)
    {
        return (url.startsWith("http://") || url.startsWith("https://")) && url.endsWith(".zip");
    }

}
