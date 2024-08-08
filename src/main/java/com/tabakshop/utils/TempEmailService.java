package com.tabakshop.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class TempEmailService {
    private static final String API_URL = "https://www.1secmail.com/api/v1/";
    private static final int MAX_RETRIES = 10;
    private static final int WAIT_TIME_MS = 5000;

    public static String generateTempEmail() {
        String url = API_URL + "?action=genRandomMailbox&count=1";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            JSONArray emailArray = new JSONArray(json);
            return emailArray.getString(0);
        } catch (IOException | JSONException e) {
            throw new RuntimeException("Failed to generate temp email", e);
        }
    }

    public static String getVerificationLink(String email) {
        String[] parts = email.split("@");
        String login = parts[0];
        String domain = parts[1];
        String url = API_URL + "?action=getMessages&login=" + login + "&domain=" + domain;
        int retries = 0;
        while (retries < MAX_RETRIES) {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpGet request = new HttpGet(url);
                HttpResponse response = httpClient.execute(request);
                String json = EntityUtils.toString(response.getEntity());
                JSONArray messages = new JSONArray(json);
                if (messages.length() > 0) {
                    JSONObject message = messages.getJSONObject(0);
                    int messageId = message.getInt("id");
                    String messageBody = getMessageBody(login, domain, messageId);
                    System.out.println("Message Body: " + messageBody);
                    return extractVerificationLink(messageBody);
                }
                retries++;
                Thread.sleep(WAIT_TIME_MS);
            } catch (IOException | InterruptedException | JSONException e) {
                throw new RuntimeException("Failed to get messages for temp email", e);
            }
        }
        throw new RuntimeException("No messages found for temp email after " + (MAX_RETRIES * WAIT_TIME_MS / 1000) + " seconds");
    }

    private static String getMessageBody(String login, String domain, int messageId) {
        String url = API_URL + "?action=readMessage&login=" + login + "&domain=" + domain + "&id=" + messageId;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            JSONObject message = new JSONObject(json);
            return message.getString("body");
        } catch (IOException | JSONException e) {
            throw new RuntimeException("Failed to read message body", e);
        }
    }

    public static boolean isAccountActivated(String verificationLink) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            Thread.sleep(WAIT_TIME_MS);

            HttpGet request = new HttpGet(verificationLink);
            HttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());


            return responseBody.contains("Аккаунт успешно активирован");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to activate account", e);
        }
    }

    private static String extractVerificationLink(String messageBody) {
        System.out.println("Extracting from message body using Jsoup");

        Document doc = Jsoup.parse(messageBody);
        Element linkElement = doc.selectFirst("a[href*='/api/author/account-activate/']");

        if (linkElement != null) {
            String verificationLink = linkElement.attr("href");
            System.out.println("Found verification link using Jsoup: " + verificationLink);
            return verificationLink;
        }

        throw new RuntimeException("No verification link found in email body using Jsoup");
    }
}
