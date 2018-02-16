package me.fudged.sbpic.cmd;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.fudged.sbpic.SkyblockPickaxes;

public class SbAxe implements CommandExecutor {

	public SbAxe(SkyblockPickaxes main) {
		main.getCommand("sbaxe").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sbaxe")){
			
			if(!sender.isOp()){
				return true;
			}
			//sbpic <name> <level> <blocksMined>
			if(args.length == 3){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				
				if(target == null){
					sender.sendMessage("Player not found");
					return true;
				}
				
				if(!target.isOnline()){
					sender.sendMessage("Player is not online");
					return true;
				}
				
				int lvl;
				
				try {
					lvl = Integer.parseInt(args[1]);
				} catch (Exception e){
					sender.sendMessage(args[1] + " is not a number");
					return true;
				}
				
				int blocksMined;
				
				try {
					blocksMined = Integer.parseInt(args[2]);
				} catch (Exception e){
					sender.sendMessage(args[2] + " is not a number");
					return true;
				}
				
				if(lvl > 32 || lvl < 0){
					sender.sendMessage("Please pick a number 0-32");
					return true;
				}
				
				sender.sendMessage("Axe given to " + target.getDisplayName());
				
				switch (lvl){
				case 0: target.getInventory().addItem(createPickaxe(Material.WOOD_AXE, lvl, blocksMined, 100));break;
				case 1: target.getInventory().addItem(createPickaxe(Material.WOOD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 100)); break;
				case 2: target.getInventory().addItem(createPickaxe(Material.WOOD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 100));break;
				case 3: target.getInventory().addItem(createPickaxe(Material.WOOD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 100));break;
				case 4: target.getInventory().addItem(createPickaxe(Material.WOOD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 100));break;
				case 5: target.getInventory().addItem(createPickaxe(Material.WOOD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 100));break;
				case 6: target.getInventory().addItem(createPickaxe(Material.STONE_AXE, lvl, blocksMined, 250));break;
				
				case 7: target.getInventory().addItem(createPickaxe(Material.STONE_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 250));break;
				case 8: target.getInventory().addItem(createPickaxe(Material.STONE_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 250));break;
				case 9: target.getInventory().addItem(createPickaxe(Material.STONE_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 250));break;
				case 10: target.getInventory().addItem(createPickaxe(Material.STONE_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 250));break;
				case 11: target.getInventory().addItem(createPickaxe(Material.STONE_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 250));break;
				case 12: target.getInventory().addItem(createPickaxe(Material.GOLD_AXE, lvl, blocksMined, 500));break;
				
				case 13: target.getInventory().addItem(createPickaxe(Material.GOLD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 500));break;
				case 14: target.getInventory().addItem(createPickaxe(Material.GOLD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 500));break;
				case 15: target.getInventory().addItem(createPickaxe(Material.GOLD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 500));break;
				case 16: target.getInventory().addItem(createPickaxe(Material.GOLD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 500));break;
				case 17: target.getInventory().addItem(createPickaxe(Material.GOLD_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 500));break;
				case 18: target.getInventory().addItem(createPickaxe(Material.IRON_AXE, lvl, blocksMined, 750));break;
				
				case 19: target.getInventory().addItem(createPickaxe(Material.IRON_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 750));break;
				case 20: target.getInventory().addItem(createPickaxe(Material.IRON_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 750));break;
				case 21: target.getInventory().addItem(createPickaxe(Material.IRON_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 750));break;
				case 22: target.getInventory().addItem(createPickaxe(Material.IRON_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 750));break;
				case 23: target.getInventory().addItem(createPickaxe(Material.IRON_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 750));break;
				case 24: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, 1000));break;
				
				case 25: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 1000));break;
				case 26: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 1000));break;
				case 27: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 1000));break;
				case 28: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 1000));break;
				case 29: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 1000));break;
				case 30: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 6, 1000));break;
				case 31: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 7, 1000));break;
				case 32: target.getInventory().addItem(createPickaxe(Material.DIAMOND_AXE, lvl, blocksMined, Enchantment.DIG_SPEED, 8, 1000));break;
				
				}
				
			} else {
				sender.sendMessage("/sbaxe <name> <level> <blocksMined>");
				return true;
			}
			
		}
		return false;
	}
	
	public ItemStack createPickaxe(Material material, Integer lvl, Integer blocksMined, Enchantment ench, int enchLvl, int blocksRem){
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();

		meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + lvl,
				ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined, ChatColor.GOLD + "Blocks Remaining: " + ChatColor.GRAY + blocksRem));
		meta.setDisplayName(ChatColor.GOLD + "Leveling Axe");

		meta.addEnchant(ench, enchLvl, true);

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack createPickaxe(Material material, Integer lvl, Integer blocksMined, int blocksRem){
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();

		meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + lvl,
				ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined, ChatColor.GOLD + "Blocks Remaining: " + ChatColor.GRAY + blocksRem));
		meta.setDisplayName(ChatColor.GOLD + "Leveling Axe");

		item.setItemMeta(meta);

		return item;
	}

}
