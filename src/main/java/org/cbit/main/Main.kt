package org.cbit.main;

import com.cbit.GmailConnection;
import net.cbit.discord.JdaListener;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Setting up gmail-discord communication...");
        GmailConnection gmail = new GmailConnection();
        gmail.gmailConnection();

        JdaListener jda = new JdaListener();
        jda.jdaSetup();
    }
}