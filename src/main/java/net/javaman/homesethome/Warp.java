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

public class Warp implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		String warp = args.<String> getOne("name").get();
		Player player = (Player) src;
		World world = player.getWorld();
		
		if (src instanceof Player) {
			boolean check = FileMethods.check("config/homesethome/warps/" + warp + "/x");
			if (check == true) {
				Integer homeX = Integer.parseInt(FileMethods.read("config/homesethome/warps/" + warp + "/x"));
				Integer homeY = Integer.parseInt(FileMethods.read("config/homesethome/warps/" + warp + "/y"));
				Integer homeZ = Integer.parseInt(FileMethods.read("config/homesethome/warps/" + warp + "/z"));
			
				player.setLocation(new Location<World>(world, homeX, homeY, homeZ));
				player.sendMessage(Text.of("Teleported you to warp: " + warp + "."));
			} else {
				player.sendMessage(Text.of("Warp: " + warp + " is not in existence."));
			}
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}