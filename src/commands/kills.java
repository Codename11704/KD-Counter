package commands;


import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kills extends commandBase {


    public kills(CommandSender sender, Command cmd, String label, String[] args) {
        super(sender, cmd, label, args);

    }


    //What command does
    public void process() {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to run this command!!!");
        }
        else {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.YELLOW + "You have killed " + player.getStatistic(Statistic.PLAYER_KILLS) + " players.");
        }


    }
}
