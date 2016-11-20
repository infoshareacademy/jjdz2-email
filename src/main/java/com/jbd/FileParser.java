package com.jbd;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.mboxiterator.CharBufferWrapper;
import org.apache.james.mime4j.mboxiterator.MboxIterator;
import org.apache.james.mime4j.message.DefaultMessageBuilder;
import org.apache.james.mime4j.message.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FileParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileParser.class);
    private static final Marker FP_MARKER = MarkerFactory.getMarker("FileParser");
    private List<Email> emailsFromFiles = new ArrayList<>();

    private final static CharsetEncoder ENCODER = Charset.forName("UTF-8").newEncoder();

    public List<Email> parseEmails (List<String> fileList) throws Exception {
        LOGGER.info(FP_MARKER, "Parsing Started");
        emailsFromFiles.clear();
        FileLoad fL = new FileLoad();
        MakeEmailsFromString makeEmails = new MakeEmailsFromString();


        String zawartoscpliku = wczytaj caly plik
        zwartoscpliku.replaceALl("\\n", System.lineSeparator()
        zwartoscpliku.replaceALl("\\r", System.lineSeparator()



        for (String file : fileList) {
            if (file.endsWith(".eml")){
                LOGGER.info(FP_MARKER, "Found eml file.");
                emailsFromFiles.add(parseEML(new File(file)));
                LOGGER.info(FP_MARKER, "Parsing of single eml file finished.");
            } else if (file.endsWith(".mbox")){
                LOGGER.info(FP_MARKER, "Found mbox file.");
                //emailsFromFiles.addAll(makeEmails.makeEmailList(fL.fileLoad(file)));
                emailsFromFiles.addAll(parseMbox(new File(file)));
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

    public List<Email> parseMbox(File mboxFile) throws IOException, MimeException {
        LOGGER.info(FP_MARKER, "Parsing mbox file.");
        //int count = 0;
        List<Email> emails = new ArrayList<>();

        MboxIterator.Builder charset = MboxIterator.fromFile(mboxFile).charset(ENCODER.charset());
        for (CharBufferWrapper message : charset.build()) {
            //System.out.println(messageSummary(message.asInputStream(ENCODER.charset())));
            MessageBuilder builder = new MessageBuilder();
            Message mess = builder.parse(message.asInputStream(ENCODER.charset())).build();
            //count++;
            Email e = new Email(mess.getFrom().toString(),mess.getSubject(),mess.getDate(),mess.getBody().toString());
            emails.add(e);
        }
        //System.out.println("Found " + count + " messages");

        return emails;
    }

    private static String messageSummary(InputStream messageBytes) throws IOException, MimeException {
        MessageBuilder builder = new MessageBuilder();
        Message message = builder.parse(messageBytes).build();
        return String.format("\nMessage %s \n" +
                        "Sent by:\t%s\n" +
                        "To:\t%s\n",
                message.getSubject(),
                message.getSender(),
                message.getTo());
    }

}
