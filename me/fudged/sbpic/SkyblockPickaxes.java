package me.fudged.sbpic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.fudged.sbpic.cmd.SbAxe;
import me.fudged.sbpic.cmd.SbPic;
import me.fudged.sbpic.listener.AntiEnchant;
import me.fudged.sbpic.listener.BlockBreak;

public class SkyblockPickaxes extends JavaPlugin {
	
	@Override
	public void onEnable(){
		Bukkit.getServer().getLogger().info("SkyblockPickaxes has been enabled");
		
		new BlockBreak(this);
		new SbPic(this);
		new SbAxe(this);
		new AntiEnchant(this);
	}

}
