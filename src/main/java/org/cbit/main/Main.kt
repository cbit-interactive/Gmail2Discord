package org.cbit.main

import com.cbit.GmailConnection
import net.cbit.discord.JdaListener

object Main {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Setting up gmail-discord communication...")
        val gmail = GmailConnection()
        gmail.gmailConnection()
        val jda = JdaListener()
        jda.jdaSetup()
    }
}