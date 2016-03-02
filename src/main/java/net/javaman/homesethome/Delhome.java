package net.javaman.homesethome;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import net.javaman.filemethods.FileMethods;

public class Delhome implements CommandExecutor {
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		String home = args.<String> getOne("name").get();
		Player player = (Player) src;
		String uuid = player.getUniqueId().toString();

		if (src instanceof Player) {
			boolean check = FileMethods.check("config/homesethome/homes/" + uuid + "/" + home + "/x");
			if (check == true) {
				FileMethods.remove("config/homesethome/homes/" + uuid + "/" + home + "/x.txt");
				FileMethods.remove("config/homesethome/homes/" + uuid + "/" + home + "/y.txt");
				FileMethods.remove("config/homesethome/homes/" + uuid + "/" + home + "/z.txt");

				FileMethods.remove("config/homesethome/homes/" + uuid + "/" + home);
				player.sendMessage(Text.of("Successfully removed home: " + home + "."));
			} else {
				player.sendMessage(Text.of("Home: " + home + " is not in existence."));
			}
		} else {
			src.sendMessage(Text.of("You cannot send this command!"));
		}
		return CommandResult.success();
	}
}