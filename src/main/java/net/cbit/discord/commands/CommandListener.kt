package net.cbit.discord.commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.InteractionHook
import version.Version

class CommandListener : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {

        val vers = Version()
        // Ping embed
        val time = System.currentTimeMillis()
        val ping = EmbedBuilder()
        ping.setTitle("/ping")
        ping.setColor(0x4287f5)
        ping.setAuthor("Gmail2Discord")
        ping.setDescription("Pong: $time ms")

        // help embed
        val help = EmbedBuilder()
        help.setAuthor("Gmail2Discord")
        help.setColor(0x2fff00)
        help.setTitle("Help Menu")
        help.setDescription("Help Menu\nversion ${vers.version}\n\n")

        when(event.name){
            "ping" -> event.replyEmbeds(ping.build()).setEphemeral(true).queue()
            "help" -> event.replyEmbeds(help.build()).setEphemeral(false).queue()
            "echo" -> event.reply(event.getOption("message")!!.asString).queue()
        }
    }
}
