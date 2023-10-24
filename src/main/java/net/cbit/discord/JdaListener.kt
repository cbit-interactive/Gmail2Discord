package net.cbit.discord

import net.cbit.discord.commands.CommandListener
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.EventListener
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent
import java.util.*

class JdaListener : EventListener {
    @Throws(InterruptedException::class)
    fun jdaSetup() {
        val jdaSetupToken = Scanner(System.`in`)
        println("Discord bot token: ")
        val token = jdaSetupToken.nextLine()
        val api = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build()
        api.addEventListener(JdaListener())
        api.addEventListener(CommandListener())
        api.updateCommands().addCommands(
                Commands.slash("echo", "Echo a message")
                        .addOption(OptionType.STRING, "message", "A message"),
                Commands.slash("help", "Help menu"),
                Commands.slash("ping", "Ping time")
        ).queue()
    }

    override fun onEvent(event: GenericEvent) {
        if (event is ReadyEvent) println("API is ready!")
    }
}
