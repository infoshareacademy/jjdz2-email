package com.jbd;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileParser {
    private List<Email> emailsFromFiles = new ArrayList<>();

    public List<Email> parseEmails (List<String> fileList) {
        emailsFromFiles.clear();
        for (String file : fileList) {
        }
        return emailsFromFiles;
    }

    public Email parseEML(File emlFile) throws Exception {
        Session mailSession = Session.getDefaultInstance(new Properties());
        InputStream source = new FileInputStream(emlFile);
        MimeMessage message = new MimeMessage(mailSession, source);

        //date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new Email(message.getFrom()[0].toString(), message.getSubject(), message.getSentDate(), message.getContent().toString());
    }
}
