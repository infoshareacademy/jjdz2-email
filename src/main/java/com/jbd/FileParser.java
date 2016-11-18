package com.jbd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileParser.class);
    private static final Marker FP_MARKER = MarkerFactory.getMarker("FileParser");
    private List<Email> emailsFromFiles = new ArrayList<>();

    public List<Email> parseEmails (List<String> fileList) throws Exception {
        LOGGER.info(FP_MARKER, "Parsing Started");
        emailsFromFiles.clear();
        FileLoad fL = new FileLoad();
        MakeEmailsFromString makeEmails = new MakeEmailsFromString();

        for (String file : fileList) {
            if (file.endsWith(".eml")){
                LOGGER.info(FP_MARKER, "Found eml file.");
                emailsFromFiles.add(parseEML(new File(file)));
                LOGGER.info(FP_MARKER, "Parsing of single eml file finished.");
            } else if (file.endsWith(".mbox")){
                LOGGER.info(FP_MARKER, "Found mbox file.");
                emailsFromFiles.addAll(makeEmails.makeEmailList(fL.fileLoad(file)));
            }
        }
        LOGGER.info(FP_MARKER, "Parsing finished");
        return emailsFromFiles;
    }

    public Email parseEML(File emlFile) throws Exception {
        LOGGER.info(FP_MARKER, "Parsing eml file.");
        Session mailSession = Session.getDefaultInstance(new Properties());
        InputStream source = new FileInputStream(emlFile);
        MimeMessage message = new MimeMessage(mailSession, source);

        return new Email(message.getFrom()[0].toString(), message.getSubject(), message.getSentDate(),  message.getContent().toString());
    }
}
