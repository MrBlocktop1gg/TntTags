package mrblock.tnttagkotlin.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

class CancelledListener : Listener {
  @EventHandler
  fun dropItem(event: PlayerDropItemEvent) {
    event.isCancelled = true
  }
}