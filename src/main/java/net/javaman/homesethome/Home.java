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

public class Home implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		String home = args.<String> getOne("name").get();
		Player player = (Player) src;
		String uuid = player.getUniqueId().toString();
		World world = player.getWorld();
		
		if (src instanceof Player) {
			boolean check = FileMethods.check("config/homesethome/homes/" + uuid + "/" + home + "/x");
			if (check == true) {
				Integer homeX = Integer.parseInt(FileMethods.read("config/homesethome/homes/" + uuid + "/" + home + "/x"));
				Integer homeY = Integer.parseInt(FileMethods.read("config/homesethome/homes/" + uuid + "/" + home + "/y"));
				Integer homeZ = Integer.parseInt(FileMethods.read("config/homesethome/homes/" + uuid + "/" + home + "/z"));
			
				player.setLocation(new Location<World>(world, homeX, homeY, homeZ));
				player.sendMessage(Text.of("Teleported you to home: " + home + "."));
			} else {
				player.sendMessage(Text.of("Home: " + home + " is not in existence."));
			}
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}