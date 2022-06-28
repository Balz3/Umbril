package com.balz3.umbrilessentials.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageManager {

    public static void send(CommandSender sender, String message) {
        send(sender, message, "&a");
    }

    public static void send(CommandSender sender, String message, String prefix) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
    }
}
