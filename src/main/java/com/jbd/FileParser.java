package com.jbd;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.dom.*;
import org.apache.james.mime4j.mboxiterator.CharBufferWrapper;
import org.apache.james.mime4j.mboxiterator.MboxIterator;
import org.apache.james.mime4j.message.BodyPart;
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
import java.util.*;

public class FileParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileParser.class);
    private static final Marker FP_MARKER = MarkerFactory.getMarker("FileParser");
    private List<Email> emailsFromFiles = new ArrayList<>();

    private final static CharsetEncoder ENCODER = Charset.forName("UTF-8").newEncoder();

    public List<Email> parseEmails (List<String> fileList) throws Exception {
        LOGGER.info(FP_MARKER, "Parsing Started");
        emailsFromFiles.clear();

        for (String file : fileList) {
            if (file.endsWith(".eml")){
                LOGGER.info(FP_MARKER, "Found eml file.");
                emailsFromFiles.add(parseEML(new File(file)));
                LOGGER.info(FP_MARKER, "Parsing of single eml file finished.");
            } else if (file.endsWith(".mbox")){
                LOGGER.info(FP_MARKER, "Found mbox file.");
                emailsFromFiles.addAll(parseMbox(new File(file)));
                LOGGER.info(FP_MARKER, "Parsing of single mbox file finished.");
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
        SetLinuxLFInFile s = new SetLinuxLFInFile();
        mboxFile = s.RewriteFile(mboxFile);

        LOGGER.info(FP_MARKER, "Parsing mbox file.");
        List<Email> emails = new ArrayList<>();

        for(Iterator end = MboxIterator.fromFile(mboxFile).charset(ENCODER.charset()).build().iterator(); end.hasNext();) {
            CharBufferWrapper message = (CharBufferWrapper)end.next();
            DefaultMessageBuilder builder = new DefaultMessageBuilder();
            Message mess = builder.parseMessage(message.asInputStream(ENCODER.charset()));
            String messageBody = "";


            // this -> http://www.mozgoweb.com/posts/how-to-parse-mime-message-using-mime4j-library/
            if (mess.isMultipart()) {
                Multipart multipart = (Multipart) mess.getBody();
                messageBody = parseBodyParts(multipart);

            } else {
                //If it's single part message, just get text body
                //String text = getTxtPart(mimeMsg);
                //txtBody.append(text);
                //TextBody body = (TextBody) mess.getBody();
                //String messageBody = new Scanner(body.getReader()).useDelimiter("\\A").next();
                messageBody = getTxtPart(mess);
            }


            //TextBody body = (TextBody) mess.getBody();
            //String messageBody = new Scanner(body.getReader()).useDelimiter("\\A").next();

            Email e = new Email(mess.getFrom().get(0).getAddress(),
                    mess.getSubject(),
                    mess.getDate(),
                    messageBody);
            emails.add(e);
        }

        return emails;
    }

    private String getTxtPart(Entity part) throws IOException {
        //Get content from body
        //TextBody tb = (TextBody) part.getBody();
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //tb.writeTo(baos);
        //return new String(baos.toByteArray());
        TextBody body = (TextBody) part.getBody();
        //String messageBody =
                //return new Scanner(body.getReader()).useDelimiter("\\A").next();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        body.writeTo(baos);
        return new String(baos.toByteArray());
    }

    private String parseBodyParts(Multipart multipart) throws IOException {

        StringBuffer txtBody = new StringBuffer();
        StringBuffer htmlBody = new StringBuffer();
        ArrayList<BodyPart> attachments = new ArrayList<>();

        for (Entity part : multipart.getBodyParts() /*Entity part : multipart.getBodyParts()*/) {
            if (part.getMimeType().equals("text/plain") /*part.isMimeType("text/plain")*/) {
                String txt = getTxtPart(part);
                txtBody.append(txt);
            } else if (part.getMimeType().equals("text/html") /*part.isMimeType("text/html")*/) {
                String html = getTxtPart(part);
                htmlBody.append(html);
            } else if (part.getDispositionType() != null && !part.getDispositionType().equals("")) {
                //If DispositionType is null or empty, it means that it's multipart, not attached file
                attachments.add((BodyPart) part);
            }

            //If current part contains other, parse it again by recursion
            if (part.isMultipart()) {
                parseBodyParts((Multipart) part.getBody());
            }
        }

        return txtBody.toString();
    }


}
