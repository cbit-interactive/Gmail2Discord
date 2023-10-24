package net.cbit.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class JdaListener implements EventListener {

    String token = "MTE1NDk2Mzk4NzA0NjMzODY1Mg.GWcEoh.0Ms3NwXrYbjF9NvYAISQfFExQjkrq2vBKCI5tQ";

    public void jdaSetup() throws InterruptedException {
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
