package mrblock.tnttagkotlin.listener

import mrblock.tnttagkotlin.game.StartGame
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.inventory.ItemStack

class PlayerListener : Listener {
  private val startGame = StartGame()

  @EventHandler
  fun playerConnect(event: PlayerJoinEvent) {
    val player = event.player
    startGame.playersList.plus(player)
    player.sendMessage("Добро пожаловать на TntTag ${player.name}!")
    player.inventory.setItem(4, ItemStack(Material.PAPER))
    if (startGame.playersList.size >= 2) {
      startGame.startTimer(20)
    }
  }

  @EventHandler
  fun playerLeave(event: PlayerQuitEvent) {
    val player = event.player
    startGame.playersList.minus(player)
    if (startGame.timeState && startGame.playersList.size < 2) {
      startGame.timeState = false;
      player.sendTitle("Таймер остановлен!", "Не достаточно игроков!")
      return
    }
  }
}