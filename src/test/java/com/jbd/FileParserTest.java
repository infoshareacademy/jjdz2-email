package com.jbd;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileParserTest {
    private FileParser fP = new FileParser();
    private String absolutePath = new File("").getAbsolutePath();
    private String pathToFile = absolutePath + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "sample.eml";

    @Test
    public void parseEmlFile() throws Exception {
        Email e1 = fP.parseEML(new File(pathToFile));
        assertThat(e1.getFrom(), is ("yolo@exampleeml.com"));
    }
}