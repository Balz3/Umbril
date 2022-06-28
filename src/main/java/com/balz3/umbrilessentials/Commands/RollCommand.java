package com.balz3.umbrilessentials.Commands;

import com.balz3.umbrilessentials.Utils.CommandBase;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class RollCommand {

    public RollCommand() {

        new CommandBase("roll", 0,1, true) {
            @Override
            public boolean onCommand(CommandSender sender, String[] args) {
                //Initialization
                Player player = (Player) sender;
                List<Entity> nearbyEntities;
                Random random;
                int diceSize = 20, numRolls = 1;
                String[] arguments;

                //Input
                if(args.length != 0){

                    if(args[0].matches("[1-9]d[1-9][0-9]{0,8}")){
                        arguments = args[0].split("d");
                        numRolls = Integer.parseInt(arguments[0]);
                        diceSize = Integer.parseInt(arguments[1]);
                    } else if(args[0].matches("0d\\d{1,9}")){
                        sender.sendMessage("The number of rolls must be higher than 0!");
                        return true;
                    } else if(args[0].matches("[1-9]d0")){
                        sender.sendMessage("The dice size must be higher than 0!");
                        return true;
                    } else if(args[0].matches("[1-9]+d\\d{1,9}")){
                        sender.sendMessage("The number of rolls must be lower than 9!");
                        return true;
                    } else if(args[0].matches("[1-9]d\\d+")){
                        sender.sendMessage("The dice size must be lower than 100,000,000!");
                        return true;
                    }  else {
                        sender.sendMessage("Improper syntax!");
                        return false;
                    }
                }

                //Process && Output
                nearbyEntities = player.getNearbyEntities(20, 20, 20);
                nearbyEntities.add(player);
                random = new Random(System.currentTimeMillis());

                for(int i = 0; i < numRolls; i++){
                    for(Entity e: nearbyEntities){
                        if(e instanceof Player){
                            e.sendMessage(player.getName() + " has rolled " + random.nextInt(diceSize + 1) + " out of " + diceSize + "!");
                        }
                    }
                }

                return true;
            }

            @Override
            public String getUsage() {
                return "/roll \nOR\n/roll 1d20";
            }
        }.enableDelay(2);
    }
}
