package mrblock.tnttagkotlin

import mrblock.tnttagkotlin.listener.CancelledListener
import mrblock.tnttagkotlin.listener.PlayerListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class TntTagKotlin : JavaPlugin() {
  override fun onEnable() {
    val pluginManager = Bukkit.getServer().pluginManager
    pluginManager.registerEvents(CancelledListener(), this)
    pluginManager.registerEvents(PlayerListener(), this)
  }
}
