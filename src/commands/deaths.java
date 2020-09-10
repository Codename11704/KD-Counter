package commands;


import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class deaths extends commandBase {


    public deaths(CommandSender sender, Command cmd, String label, String[] args) {
        super(sender, cmd, label, args);
    }


    //What command does
    public void process() {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to run this command!!!");
        }
        else {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.YELLOW + "You have died " + player.getStatistic(Statistic.DEATHS) + " times.");
        }


    }
}
