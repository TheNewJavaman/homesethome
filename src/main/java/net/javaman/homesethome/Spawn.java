package net.javaman.homesethome;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import net.javaman.filemethods.FileMethods;

public class Spawn implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		Player player = (Player) src;

		if (src instanceof Player) {
			World world = player.getWorld();
			Integer x = Integer.parseInt(FileMethods.read("config/homesethome/spawn/x"));
			Integer y = Integer.parseInt(FileMethods.read("config/homesethome/spawn/y"));
			Integer z = Integer.parseInt(FileMethods.read("config/homesethome/spawn/z"));
		
			player.setLocation(new Location<World>(world, x, y, z));
			player.sendMessage(Text.of("Teleported you to spawn."));
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}

