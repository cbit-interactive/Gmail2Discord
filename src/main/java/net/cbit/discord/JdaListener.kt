package net.cbit.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.Scanner;

public class JdaListener implements EventListener {

    public void jdaSetup() throws InterruptedException {

        Scanner jdaSetupToken = new Scanner(System.in);
        System.out.println("Discord bot token: ");
        String token = jdaSetupToken.nextLine();

        JDA api = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        api.addEventListener(new JdaListener());
    }
    @Override
    public void onEvent(GenericEvent event) {
        if (event instanceof ReadyEvent)
            System.out.println("API is ready!");
    }
}
