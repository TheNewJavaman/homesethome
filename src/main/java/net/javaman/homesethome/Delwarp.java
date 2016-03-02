package net.javaman.homesethome;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import net.javaman.filemethods.FileMethods;

public class Delwarp implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		String warp = args.<String> getOne("name").get();
		Player player = (Player) src;

		if (src instanceof Player) {
			boolean check = FileMethods.check("config/homesethome/warps/" + warp + "/x");
			if (check == true) {
				FileMethods.remove("config/homesethome/warps/" + warp + "/x.txt");
				FileMethods.remove("config/homesethome/warps/" + warp + "/y.txt");
				FileMethods.remove("config/homesethome/warps/" + warp + "/z.txt");
				FileMethods.remove("config/homesethome/warps/" + warp);
				player.sendMessage(Text.of("Successfully removed warp: " + warp + "."));
			} else {	
				player.sendMessage(Text.of("Warp: " + warp + " is not in existence."));
			}
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}