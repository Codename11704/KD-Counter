package com.sDroll.kdCounter;

import commands.deaths;
import commands.kills;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class main extends JavaPlugin implements Listener {




    @Override
   public void  onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
}

    @Override
    public void onDisable() {
}

//On Command
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       // /deaths
        if (label.equalsIgnoreCase("deaths")) {
            new deaths(sender, cmd, label, args);
            return true;
        }
        // /kills
        if (label.equalsIgnoreCase("kills")) {
            new kills(sender, cmd, label, args);
            return true;
        }

        return true;
}

//Creating Scoreboard on player death
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        createScoreboard(e.getPlayer());
    }

//Update Scoreboard On Death
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = event.getEntity();
            Score score = player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("Deaths: ");
            score.setScore(player.getStatistic(Statistic.DEATHS));
            System.out.println("working");
            System.out.println(score.toString());

        }

    }

    //Creating Scoreboard
    public void createScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("Stats", "dummy", "Deaths");
        objective.setDisplayName("Stats");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        //Death Tracker
        Score score = objective.getScore("Deaths: ");
        score.setScore(player.getStatistic(Statistic.DEATHS));

        //Kill Tracker
        Score score2 = objective.getScore("Kills: ");
        score2.setScore(player.getStatistic(Statistic.PLAYER_KILLS));



//Set Scoreboard
        player.setScoreboard(board);

    }
}
