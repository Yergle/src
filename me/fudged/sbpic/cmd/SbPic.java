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

public class SbPic implements CommandExecutor {

	public SbPic(SkyblockPickaxes main) {
		main.getCommand("sbpic").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sbpic")){
			
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
				
				sender.sendMessage("Pickaxe given to " + target.getDisplayName());
				
				switch (lvl){
				case 0: target.getInventory().addItem(createPickaxe(Material.WOOD_PICKAXE, lvl, blocksMined, 200));break;
				case 1: target.getInventory().addItem(createPickaxe(Material.WOOD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 200)); break;
				case 2: target.getInventory().addItem(createPickaxe(Material.WOOD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 200));break;
				case 3: target.getInventory().addItem(createPickaxe(Material.WOOD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 200));break;
				case 4: target.getInventory().addItem(createPickaxe(Material.WOOD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 200));break;
				case 5: target.getInventory().addItem(createPickaxe(Material.WOOD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 200));break;
				case 6: target.getInventory().addItem(createPickaxe(Material.STONE_PICKAXE, lvl, blocksMined, 200));break;
				
				case 7: target.getInventory().addItem(createPickaxe(Material.STONE_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 500));break;
				case 8: target.getInventory().addItem(createPickaxe(Material.STONE_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 500));break;
				case 9: target.getInventory().addItem(createPickaxe(Material.STONE_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 500));break;
				case 10: target.getInventory().addItem(createPickaxe(Material.STONE_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 500));break;
				case 11: target.getInventory().addItem(createPickaxe(Material.STONE_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 500));break;
				case 12: target.getInventory().addItem(createPickaxe(Material.GOLD_PICKAXE, lvl, blocksMined, 500));break;
				
				case 13: target.getInventory().addItem(createPickaxe(Material.GOLD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 1000));break;
				case 14: target.getInventory().addItem(createPickaxe(Material.GOLD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 1000));break;
				case 15: target.getInventory().addItem(createPickaxe(Material.GOLD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 1000));break;
				case 16: target.getInventory().addItem(createPickaxe(Material.GOLD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 1000));break;
				case 17: target.getInventory().addItem(createPickaxe(Material.GOLD_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 1000));break;
				case 18: target.getInventory().addItem(createPickaxe(Material.IRON_PICKAXE, lvl, blocksMined, 1000));break;
				
				case 19: target.getInventory().addItem(createPickaxe(Material.IRON_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 1500));break;
				case 20: target.getInventory().addItem(createPickaxe(Material.IRON_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 1500));break;
				case 21: target.getInventory().addItem(createPickaxe(Material.IRON_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 1500));break;
				case 22: target.getInventory().addItem(createPickaxe(Material.IRON_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 1500));break;
				case 23: target.getInventory().addItem(createPickaxe(Material.IRON_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 1500));break;
				case 24: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, 1500));break;
				
				case 25: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 1, 2000));break;
				case 26: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 2, 2000));break;
				case 27: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 3, 2000));break;
				case 28: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 4, 2000));break;
				case 29: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 5, 2000));break;
				case 30: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 6, 2000));break;
				case 31: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 7, 2000));break;
				case 32: target.getInventory().addItem(createPickaxe(Material.DIAMOND_PICKAXE, lvl, blocksMined, Enchantment.DIG_SPEED, 8, 2000));break;
				
				}
				
			} else {
				sender.sendMessage("/sbpic <name> <level> <blocksMined>");
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
		meta.setDisplayName(ChatColor.GOLD + "Leveling Pickaxe");

		meta.addEnchant(ench, enchLvl, true);

		item.setItemMeta(meta);

		return item;
	}

	public ItemStack createPickaxe(Material material, Integer lvl, Integer blocksMined, int blocksRem){
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();

		meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + lvl,
				ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined, ChatColor.GOLD + "Blocks Remaining: " + ChatColor.GRAY + blocksRem));
		meta.setDisplayName(ChatColor.GOLD + "Leveling Pickaxe");

		item.setItemMeta(meta);

		return item;
	}

}
