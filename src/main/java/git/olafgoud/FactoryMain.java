package git.olafgoud;

import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;

public class FactoryMain extends JavaPlugin {
	
	public static StateFlag factory;
	
	public void onLoad() {
		FlagRegistry registry = WorldGuardPlugin.inst().getFlagRegistry();
		try {
	        StateFlag flag = new StateFlag("factory-building", false);
	        registry.register(flag);
	        factory = flag; // only set our field if there was no error
	        System.out.println("flag registerd");
	    } catch (FlagConflictException e) {
	        Flag<?> existing = registry.get("mineflag");
	        if (existing instanceof StateFlag) {
	        	factory = (StateFlag) existing;
	        } else {
	        	System.out.println("je hebt al een andere plugin met deze flag");
	        }
	    }
	}
	
	public void onEnable() {
		
	}

	public void onDisable() {
		
	}
	
}
