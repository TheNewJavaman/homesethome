package net.javaman.homesethome;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class Homes implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		Player player = (Player) src;
		String uuid = player.getUniqueId().toString();

		if (src instanceof Player) {
			File file = new File("config/homesethome/homes/" + uuid);
			String[] directories = file.list(new FilenameFilter() {
				@Override
				public boolean accept(File current, String name) {
					return new File(current, name).isDirectory();
				}
			});
			player.sendMessage(Text.of("Homes:"));
			player.sendMessage(Text.of((Arrays.toString(directories))));
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}
