package com.cbit;

// For Gmail
import com.google.gson.Gson;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.net.URI;
import java.util.Scanner;

// From Main class
import org.cbit.main.Main;

public class GmailConnection {
    private static final Gson gson = new Gson();
    private static final HttpClient client = HttpClient.newHttpClient();

    public void gmailConnection() throws Exception{
        Scanner gmailWebhook = new Scanner(System.in);
        System.out.println("Gmail webhook url: ");
        String url = gmailWebhook.nextLine();

        System.out.println("Starting gmail webhook!!");

        String message = gson.toJson(Map.of("text", "Hello from Java!"));

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(url))
                .header("accept", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}