package me.hungaz.getpos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.floodgate.api.FloodgateApi;

public class GetPos extends JavaPlugin {

    @Override
    public void onEnable() {
        // Lệnh /toado sẽ được dùng
        getCommand("toado").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("\u00A7cThis command can only be executed by Bedrock players.");
            return true;
        }

        Player player = (Player) sender;

        if (isBedrockPlayer(player)) {
            double x = player.getLocation().getX();
            double y = player.getLocation().getY();
            double z = player.getLocation().getZ();

            player.sendMessage("\u00A7aTọa độ của bạn là \u00A7bX: \u00A7e" + x + " \u00A7bY: \u00A7e" + y + " \u00A7bZ: \u00A7e" + z);
        } else {
            player.sendMessage("\u00A7cLệnh này chỉ có thể được dùng bởi người chơi Bedrock.");
        }

        return true;
    }

    private boolean isBedrockPlayer(Player player) {
        return FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId());
    }
}
