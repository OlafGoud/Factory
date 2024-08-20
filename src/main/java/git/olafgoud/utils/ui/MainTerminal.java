package git.olafgoud.utils.ui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import git.olafgoud.utils.CreateItem;

public class MainTerminal {

	
	public static void getTerminal(Player p) {
		CreateItem image = new CreateItem(Material.CLAY_BALL);
		image.setName(" ");
		image.setNBT("factory", "mainterminal");
		Inventory inv = Bukkit.createInventory(p, 6*9);
		inv.setItem(0, image.getItem());
		
		p.openInventory(inv);
	}
}
