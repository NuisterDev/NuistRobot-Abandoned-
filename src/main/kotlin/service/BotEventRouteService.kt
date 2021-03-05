package org.example.mirai.plugin.service

import kotlinx.coroutines.*
import net.mamoe.mirai.contact.Friend
import org.example.mirai.plugin.PluginMain
import org.example.mirai.plugin.Utils.HttpUtils
import kotlin.coroutines.CoroutineContext

/**
@author charlottexiao
 */
object BotEventRouteService : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() =  SupervisorJob(PluginMain.coroutineContext.job)

    fun start() = launch(context = this.coroutineContext){

        var str: String ?= null
        var bot =PluginMain.targetBotInstance
        while(true) {
//            str=HttpUtils().doGet("https://zuanbot.com/api.php?level=min&lang=zh_cn")
            str=HttpUtils().doGet("https://chp.shadiao.app/api.php")
//            str = HttpUtils().doGet("https://zuanbot.com/api.php?lang=zh_cn")
//            str= (0..1000000).random().toString()
//            print(str)
//            for (friend in bot.friends) {
//                friend?.sendMessage(str)
//            }
            bot.getFriend(1073741019)?.sendMessage(str)
        }
    }

}