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

public class Tphere implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		Player reciever = args.<Player> getOne("player").get();
		Player player = (Player) src;
		
		if (src instanceof Player) {
			Location<World> pLoc = player.getLocation();
			World world = player.getWorld();
			int x = pLoc.getBlockX();
			int y = pLoc.getBlockY();
			int z = pLoc.getBlockZ();
			reciever.setLocation(new Location<World>(world, x, y, z));
			reciever.sendMessage(Text.of("Teleported to " + player.getName() + "."));
			player.sendMessage(Text.of(reciever.getName() + " was teleported to you."));
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}
