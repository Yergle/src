package me.fudged.sbpic.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

import me.fudged.sbpic.SkyblockPickaxes;

public class AntiEnchant implements Listener {

	public AntiEnchant(SkyblockPickaxes main){
		Bukkit.getServer().getPluginManager().registerEvents(this, main);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEnchantCmd(PlayerCommandPreprocessEvent event){
		String[] message = event.getMessage().split(" ");
		Player p = event.getPlayer();
		ItemStack item = p.getItemInHand();
		if (message[0].equalsIgnoreCase("/enchant")){
			if(!item.hasItemMeta() || !item.getItemMeta().hasLore() || !item.getType().toString().contains("PICKAXE")){
				return;
			}

			if(ChatColor.stripColor(item.getItemMeta().getLore().get(1)).equals("Skyblock Zone")){
				event.setCancelled(true);
				p.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "You are not able to enchant this item");
			}
		}
	}

	@EventHandler
	public void onAnvilPrep(PrepareAnvilEvent event){
		ItemStack firstItem = event.getInventory().getItem(0);
		ItemStack secondItem = event.getInventory().getItem(1);
		if(!firstItem.hasItemMeta() || !firstItem.getItemMeta().hasLore() || !firstItem.getType().toString().contains("PICKAXE")){
			return;
		}

		if(ChatColor.stripColor(firstItem.getItemMeta().getLore().get(1)).equals("Skyblock Zone")){
			event.setResult(null);
			event.getViewers().get(0).sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "You are not able to enchant this item");
		}
		if(!secondItem.hasItemMeta() || !secondItem.getItemMeta().hasLore() || !secondItem.getType().toString().contains("PICKAXE")){
			return;
		}

		if(ChatColor.stripColor(secondItem.getItemMeta().getLore().get(1)).equals("Skyblock Zone")){
			event.setResult(null);
			event.getViewers().get(0).sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "You are not able to enchant this item");
		}
	}

}
