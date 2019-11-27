/**
 *
 */
package com.flight.reservation.flightreservation.dto;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author p.maurya
 *
 */
public class MailDto {

    @Value("${spring.mail.username}")
    private String fromId;

    private String toId;

    @Value("${spring.mail.subject}")
    private String subject;

    @Value("${spring.mail.title}")
    private String title;

    private String attachement;

    public String getFromId() {
        return this.fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return this.toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttachement() {
        return this.attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

}
