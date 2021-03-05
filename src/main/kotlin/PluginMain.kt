package org.example.mirai.plugin

import net.mamoe.mirai.Bot
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.BotOnlineEvent
import net.mamoe.mirai.utils.info
import org.example.mirai.plugin.service.BotEventRouteService

object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "org.example.mirai-plugin",
        name = "ExamplePlugin",
        version = "0.1.0"
    ) {
        author("")
    }
) {
    lateinit var targetBotInstance: Bot;
    override fun onEnable() {
        logger.info { "Plugin loaded" }
        GlobalEventChannel.filter{
            it is BotOnlineEvent
        }.subscribeOnce<BotOnlineEvent> {
            targetBotInstance = it.bot
            BotEventRouteService.start();
        }
    }
}