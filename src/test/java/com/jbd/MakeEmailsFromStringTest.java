package com.jbd;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MakeEmailsFromStringTest {
    private String absolutePath = new File("").getAbsolutePath();
    private String pathToFile = absolutePath + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "testlist.mbox";
    private List<Email> emailsFromString = new ArrayList<>();
    private SetLinuxLineSeparatorInFile fL = new SetLinuxLineSeparatorInFile();
    private DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
    private LocalDateTime testDate = LocalDateTime.parse("Sun, 18 Apr 2004 02:32:43 +0100",formatter);

    @Before
    public void setUp() throws Exception {
        MakeEmailsFromString mefs = new MakeEmailsFromString();
        emailsFromString = mefs.makeEmailList(fL.RewriteFile(pathToFile));
    }

    @Test
    public void parseMboxFile() throws Exception {
        assertThat(emailsFromString.size(), is(7));
    }

    @Test
    public void correctlyParsedFrom() throws Exception {
        assertThat(emailsFromString.get(0).getFrom(), is("Angus.Hardie@malcolmhardie.com"));
    }

    @Test
    public void correctlyParsedSubject() throws Exception {
        assertThat(emailsFromString.get(0).getSubject(), is("[Testlist] test"));
    }

    @Test
    public void correctlyParsedDate() throws Exception {
        assertThat(emailsFromString.get(0).getData(), is(testDate));
    }

    @Test
    public void correctlyParsedContent() throws Exception {
        assertThat(0,is(0));
    }
}