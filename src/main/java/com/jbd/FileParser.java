package com.jbd;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.Message;
import org.apache.james.mime4j.mboxiterator.CharBufferWrapper;
import org.apache.james.mime4j.mboxiterator.MboxIterator;
import org.apache.james.mime4j.message.DefaultMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
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
        SetLinuxLineSeparatorInFile fL = new SetLinuxLineSeparatorInFile();
        MakeEmailsFromString makeEmails = new MakeEmailsFromString();


        //String zawartoscpliku = wczytaj caly plik
        //zwartoscpliku.replaceALl("\\n", System.lineSeparator()
        //zwartoscpliku.replaceALl("\\r", System.lineSeparator()





        for (String file : fileList) {
            if (file.endsWith(".eml")){
                LOGGER.info(FP_MARKER, "Found eml file.");
                emailsFromFiles.add(parseEML(new File(file)));
                LOGGER.info(FP_MARKER, "Parsing of single eml file finished.");
            } else if (file.endsWith(".mbox")){

                //

                LOGGER.info(FP_MARKER, "Found mbox file.");
                //emailsFromFiles.addAll(makeEmails.makeEmailList(fL.RewriteFile(file)));
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
        SetLinuxLineSeparatorInFile s = new SetLinuxLineSeparatorInFile();
        s.RewriteFile(mboxFile);

        LOGGER.info(FP_MARKER, "Parsing mbox file.");
        List<Email> emails = new ArrayList<>();

        for(Iterator end = MboxIterator.fromFile(mboxFile).charset(ENCODER.charset()).build().iterator(); end.hasNext();) {
            CharBufferWrapper message = (CharBufferWrapper)end.next();
            DefaultMessageBuilder builder = new DefaultMessageBuilder();
            Message mess = builder.parseMessage(message.asInputStream(ENCODER.charset()));
            Email e = new Email(mess.getFrom().get(0).getAddress(),
                    mess.getSubject(),
                    mess.getDate(),
                    mess.getBody().toString());
            emails.add(e);
        }

        return emails;
    }


}
