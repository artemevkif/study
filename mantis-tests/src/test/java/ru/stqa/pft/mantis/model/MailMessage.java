package ru.stqa.pft.mantis.model;

/**
 * Created by xxartema on 26.02.2017.
 */

public class MailMessage {

    public String to;
    public String text;

    public MailMessage(String to, String text) {
        this.to = to;
        this.text = text;
    }
}