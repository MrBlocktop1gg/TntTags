package mrblock.tnttagkotlin.game

import mrblock.tnttagkotlin.TntTagKotlin
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class StartGame {
  private val tntTagKotlin = TntTagKotlin()
  private var time: Int = 0
  private var taskId: Int = 0
  var playersList: List<Player> = ArrayList()
  var timeState: Boolean = false

  fun startTimer(seconds: Int) {
    time = seconds
    taskId = object : BukkitRunnable() {
      override fun run() {
        for (players in playersList) {
          if (time > 0) {
            timeState = true
            time--
            players.sendMessage("До начала: $time")
          } else {
            timeState = false
            players.sendTitle("", "Игра началась!")
            stopTimer()
          }
        }
      }
    }.runTaskTimer(tntTagKotlin, 0L, 20L).taskId
  }

  private fun stopTimer() {
    Bukkit.getServer().scheduler.cancelTask(taskId)
  }
}
