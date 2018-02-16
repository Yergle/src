package me.fudged.sbpic.listener;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import me.fudged.sbpic.SkyblockPickaxes;

public class BlockBreak implements Listener {

	public BlockBreak(SkyblockPickaxes main){
		Bukkit.getServer().getPluginManager().registerEvents(this, main);
	}

	@SuppressWarnings("deprecation")
	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event){
		ItemStack item = event.getPlayer().getItemInHand();
		
		WorldGuardPlugin wgp = WorldGuardPlugin.inst();
		
		if(!wgp.canBuild(event.getPlayer(), event.getBlock())){
			return;
		}
		
		if(event.isCancelled()){
			return;
		}
		
		if(event.getPlayer().getLocation().getWorld().toString().equalsIgnoreCase("Spawn")){
			event.setCancelled(true);
			return;
		}
		
		if(!item.hasItemMeta() || !item.getItemMeta().hasLore() || !item.getType().toString().contains("AXE")){
			return;
		}

		if(ChatColor.stripColor(item.getItemMeta().getLore().get(1)).equals("Skyblock Zone") && item.getType().toString().contains("PICKAXE")){
			int lvl = Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(3)).replace("Level: ", ""));
			int blocksMined = Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(4)).replace("Blocks Mined: ", ""));

			int newLvl = lvl++;
			int newBlocks = blocksMined++;
			
			if(item.getDurability() > item.getType().getMaxDurability() / 2){
				item.setDurability((short) 0);
			}

			if(event.getBlock().getType() == Material.LONG_GRASS){
				return;
			}

			if(blocksMined % 200 == 0 && lvl <= 6){ // WOOD pickaxe
				switch(lvl){
				case 1:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_PICKAXE, newLvl, newBlocks, Enchantment.DIG_SPEED, 1, 200));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 2:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 200));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 3:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 200));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 4:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 200));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 5:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 200));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 6:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_PICKAXE, lvl++, blocksMined++, 500));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}
			if(blocksMined % 500 == 0 && lvl <= 12 && lvl > 6){ // STONE pickaxe
				switch(lvl){
				case 7:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 8:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 9:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 10:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 11:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 12:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_PICKAXE, lvl++, blocksMined++, 1000));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}

			if(blocksMined % 1000 == 0  && lvl <= 18 && lvl > 12){ // GOLD pickaxe
				switch(lvl){
				case 13:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 14:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 15:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 16:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 17:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 18:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_PICKAXE, lvl++, blocksMined++, 1500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}

			if(blocksMined % 1500 == 0  && lvl <= 24 && lvl > 18){ // IRON pickaxe
				switch(lvl){
				case 19:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 1500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 20:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 1500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 21:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 1500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 22:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 1500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 23:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 1500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 24:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, 2000));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}

			if(blocksMined % 2000 == 0 && lvl <= 32 && lvl > 24){ // DIAMOND pickaxe
				switch(lvl){
				case 25:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 2000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 26:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 2000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 27:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 2000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 28:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 2000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 29:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 2000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 30:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 6, 2000));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 31:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 7, 2000));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 32:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_PICKAXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 8, 0));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your pickaxe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;

			}

			ItemMeta meta = item.getItemMeta();
			if(lvl++ == 32){
				meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(3)).replace("Level: ", "")),
						ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined++, ChatColor.GOLD + 
						"Blocks Remaining: " + ChatColor.GRAY + "Max Level"));
				item.setItemMeta(meta);
			} else {
				meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(3)).replace("Level: ", "")),
						ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined++,  ChatColor.GOLD + 
						"Blocks Remaining: " + ChatColor.GRAY + (Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(5)).replace("Blocks Remaining: ", "")) - 1)));
				item.setItemMeta(meta);
			}
			
			return;

		}
		if(ChatColor.stripColor(item.getItemMeta().getLore().get(1)).equals("Skyblock Zone") && item.getType().toString().contains("AXE")){
			int lvl = Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(3)).replace("Level: ", ""));
			int blocksMined = Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(4)).replace("Blocks Mined: ", ""));
			
			int newLvl = lvl++;
			int newBlocks = blocksMined++;
			
			if(item.getDurability() > item.getType().getMaxDurability() / 2){
				item.setDurability((short) 0);
			}
			
			if(event.getBlock().getType() == Material.LONG_GRASS){
				return;
			}
			
			if(blocksMined % 100 == 0 && lvl <= 6){ // WOOD axe
				switch(lvl){
				case 1:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_AXE, newLvl, newBlocks, Enchantment.DIG_SPEED, 1, 100));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 2:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 100));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 3:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 100));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 4:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 100));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 5:
					event.getPlayer().setItemInHand(createPickaxe(Material.WOOD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 100));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 6:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_AXE, lvl++, blocksMined++, 250));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}
			if(blocksMined % 250 == 0 && lvl <= 12 && lvl > 6){ // STONE AXE
				switch(lvl){
				case 7:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 250));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 8:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 250));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 9:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 250));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 10:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 250));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 11:
					event.getPlayer().setItemInHand(createPickaxe(Material.STONE_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 250));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 12:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_AXE, lvl++, blocksMined++, 500));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}
			
			if(blocksMined % 500 == 0  && lvl <= 18 && lvl > 12){ // GOLD AXE
				switch(lvl){
				case 13:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 14:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 15:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 16:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 17:
					event.getPlayer().setItemInHand(createPickaxe(Material.GOLD_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 500));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 18:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_AXE, lvl++, blocksMined++, 750));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}
			
			if(blocksMined % 750 == 0  && lvl <= 24 && lvl > 18){ // IRON AXE
				switch(lvl){
				case 19:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 750));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 20:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 750));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 21:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 750));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 22:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 750));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 23:
					event.getPlayer().setItemInHand(createPickaxe(Material.IRON_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 750));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 24:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, 1000));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
			}
			
			if(blocksMined % 1000 == 0 && lvl <= 32 && lvl > 24){ // DIAMOND AXE
				switch(lvl){
				case 25:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 1, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 26:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 2, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 27:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 3, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 28:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 4, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 29:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 5, 1000));
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 30:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 6, 1000));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 31:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 7, 1000));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				case 32:
					event.getPlayer().setItemInHand(createPickaxe(Material.DIAMOND_AXE, lvl++, blocksMined++, Enchantment.DIG_SPEED, 8, 0));	
					event.getPlayer().sendMessage("");
					event.getPlayer().sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "SkyBlock " + ChatColor.GRAY + "Your axe has leveled up!");
					event.getPlayer().sendMessage("");
					break;
				}
				return;
				
			}

			ItemMeta meta = item.getItemMeta();
			if(lvl++ == 32){
				meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(3)).replace("Level: ", "")),
						ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined++, ChatColor.GOLD + 
						"Blocks Remaining: " + ChatColor.GRAY + "Max Level"));
				item.setItemMeta(meta);
			} else {
				meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(3)).replace("Level: ", "")),
						ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined++,  ChatColor.GOLD + 
						"Blocks Remaining: " + ChatColor.GRAY + (Integer.parseInt(ChatColor.stripColor(item.getItemMeta().getLore().get(5)).replace("Blocks Remaining: ", "")) - 1)));
				item.setItemMeta(meta);
			}
			
		}
	}

	public ItemStack createPickaxe(Material material, Integer lvl, Integer blocksMined, Enchantment ench, int enchLvl, int blocksRem){
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();

		meta.setLore(Arrays.asList("", ChatColor.GREEN + "Skyblock Zone", "", ChatColor.GOLD + "Level: " + ChatColor.GRAY + lvl,
				ChatColor.GOLD + "Blocks Mined: " + ChatColor.GRAY + blocksMined, ChatColor.GOLD + "Blocks Remaining: " + ChatColor.GRAY + blocksRem));
		if(material.toString().contains("PICKAXE")){
			meta.setDisplayName(ChatColor.GOLD + "Leveling Pickaxe");
		} else {
			meta.setDisplayName(ChatColor.GOLD + "Leveling Axe");
		}

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
		
		if(material.toString().contains("PICKAXE")){
			meta.setDisplayName(ChatColor.GOLD + "Leveling Pickaxe");
		} else {
			meta.setDisplayName(ChatColor.GOLD + "Leveling Axe");
		}

		item.setItemMeta(meta);

		return item;
	}

}
