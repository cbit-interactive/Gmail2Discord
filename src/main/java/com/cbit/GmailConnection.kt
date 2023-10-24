package com.cbit

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*
import java.util.Map

// For Gmail
// From Main class
class GmailConnection {
    @Throws(Exception::class)
    fun gmailConnection() {
        val gmailWebhook = Scanner(System.`in`)
        println("Gmail webhook url: ")
        val url = gmailWebhook.nextLine()
        println("Starting gmail webhook!!")
        val message = gson.toJson(Map.of("text", "Hello from Java!"))
        val request = HttpRequest.newBuilder(
                URI.create(url))
                .header("accept", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.body())
    }

    companion object {
        private val gson = Gson()
        private val client = HttpClient.newHttpClient()
    }
}