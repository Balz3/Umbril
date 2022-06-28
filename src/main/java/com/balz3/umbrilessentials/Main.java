package com.balz3.umbrilessentials;

import com.balz3.umbrilessentials.Commands.RollCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        new RollCommand();
        System.out.println("TicTacToe is loading up!");
    }

    @Override
    public void onDisable() {
        System.out.println("TicTacToe is shutting down!");
    }

    public static Main getInstance(){
        return instance;
    }
}
