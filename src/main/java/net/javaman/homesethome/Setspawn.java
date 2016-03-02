package net.javaman.homesethome;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

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

public class Setspawn implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		Player player = (Player) src;

		if (src instanceof Player) {
			Location<World> pLoc = player.getLocation();
			Integer x = pLoc.getBlockX();
			Integer y = pLoc.getBlockY();
			Integer z = pLoc.getBlockZ();

			try {
				FileMethods.create("config/homesethome/spawn/", "x", x.toString());
				FileMethods.create("config/homesethome/spawn/", "y", y.toString());
				FileMethods.create("config/homesethome/spawn/", "z", z.toString());

				player.sendMessage(Text.of("Spawn set successfully."));
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				player.sendMessage(Text.of("Contact server admin for support."));
			}
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}
