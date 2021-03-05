package org.example.mirai.plugin.Utils

import java.net.HttpURLConnection
import java.net.URL

/**
@author charlottexiao
 */
class HttpUtils {
    fun doGet(urlString: String): String {
        var conn: HttpURLConnection? = null
        conn = URL(urlString).openConnection() as HttpURLConnection
        conn.setRequestProperty("Referer","https://zuanbot.com/")
        conn.connect()
        conn.inputStream.use { input ->
            val data = input.bufferedReader().readText()
            return data
        }
    }
}
