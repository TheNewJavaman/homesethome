package net.javaman.homesethome;

import java.io.IOException;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.google.inject.Inject;

@Plugin(id = "HomeSetHome", name = "HomeSetHome", version = "1.1")
public class Main {
	@Listener
	public void onServerStart(GameStartedServerEvent event) throws IOException {

		CommandSpec sethomeSpec = CommandSpec.builder()
				.description(Text.of("Set a home."))
				.executor(new Sethome())
				.permission("homesethome.sethome")
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("name"))))
				.build();
		Sponge.getCommandManager().register(this, sethomeSpec, "sethome");
		
		CommandSpec homeSpec = CommandSpec.builder()
				.description(Text.of("Teleport to home."))
				.executor(new Home())
				.permission("homesethome.home")
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("name"))))
				.build();
		Sponge.getCommandManager().register(this, homeSpec, "home");
		
		CommandSpec tphereSpec = CommandSpec.builder()
				.description(Text.of("Teleport a player to you."))
				.executor(new Tphere())
				.permission("homesethome.tphere")
				.arguments(GenericArguments.onlyOne(GenericArguments.player(Text.of("player"))))
				.build();
		Sponge.getCommandManager().register(this, tphereSpec, "tphere", "teleporthere");
		
		CommandSpec delhomeSpec = CommandSpec.builder()
				.description(Text.of("Remove a home."))
				.executor(new Delhome())
				.permission("homesethome.delhome")
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("name"))))
				.build();
		Sponge.getCommandManager().register(this, delhomeSpec, "delhome", "deletehome", "remhome", "rmhome", "removehome");
		
		CommandSpec homesSpec = CommandSpec.builder()
				.description(Text.of("List your homes."))
				.executor(new Homes())
				.permission("homesethome.homes")
				.build();
		Sponge.getCommandManager().register(this, homesSpec, "homes", "listhomes");
		
		CommandSpec setspawnSpec = CommandSpec.builder()
				.description(Text.of("Set spawn to teleport to."))
				.executor(new Setspawn())
				.permission("homesethome.setspawn")
				.build();
		Sponge.getCommandManager().register(this, setspawnSpec, "setspawn");
		
		CommandSpec spawnSpec = CommandSpec.builder()
				.description(Text.of("Teleport to spawn."))
				.executor(new Spawn())
				.permission("homesethome.spawn")
				.build();
		Sponge.getCommandManager().register(this, spawnSpec, "spawn", "respawn");
		
		CommandSpec setwarpSpec = CommandSpec.builder()
				.description(Text.of("Set a public warp."))
				.executor(new Setwarp())
				.permission("homesethome.setwarp")
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("name"))))
				.build();
		Sponge.getCommandManager().register(this, setwarpSpec, "setwarp");
		
		CommandSpec warpsSpec = CommandSpec.builder()
				.description(Text.of("List your warps."))
				.executor(new Warps())
				.permission("homesethome.warps")
				.build();
		Sponge.getCommandManager().register(this, warpsSpec, "warps", "listwarps");
		
		CommandSpec delwarpSpec = CommandSpec.builder()
				.description(Text.of("Remove a public warp."))
				.executor(new Delwarp())
				.permission("homesethome.delwarp")
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("name"))))
				.build();
		Sponge.getCommandManager().register(this, delwarpSpec, "delwarp", "removewarp", "remwarp", "deletewarp");
		
		CommandSpec warpSpec = CommandSpec.builder()
				.description(Text.of("Teleport to warp."))
				.executor(new Warp())
				.permission("homesethome.warp")
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("name"))))
				.build();
		Sponge.getCommandManager().register(this, warpSpec, "warp");
		
		getLogger().info("HomeSetHome has loaded.");
	}

	private static Logger logger;

	@Inject
	private void setLogger(Logger logger) {
		Main.logger = logger;
	}

	public static Logger getLogger() {
		return logger;
	}
}
