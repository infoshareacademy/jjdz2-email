package com.jbd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeEmailsFromString {


    private String regexFrom = "From (.)*(a-zA-Z)*(\\\\.com)*";
    private String regexData = "Date: (.)**";
    private String regexSubject = "Subject: (.)*";
    private String regexContent = "";
    private String regexContent1 = "(X-List-Received-Date)(.)*";
    static String file = "From Angus.Hardie@malcolmhardie.com Sun Apr 18 02:32:47 2004\n" +
            "Received: from pol.malcolmhardie.com ([213.152.32.218] helo=malcolmhardie.com)" +
            "\tby marilac.malcolmhardie.com with asmtp \n" +
            "\t(Cipher TLSv1:DES-CBC3-SHA:168) (Exim 3.35 #1 (Debian))\n" +
            "\tid 1BF1At-0004oK-00\n" +
            "\tfor <testlist@lists.malcolmhardie.com>; Sun, 18 Apr 2004 02:32:47 +0100\n" +
            "Date: Sun, 18 Apr 2004 02:32:43 +0100\n" +
            "Mime-Version: 1.0 (Apple Message framework v553)\n" +
            "Content-Type: text/plain; charset=US-ASCII; format=flowed\n" +
            "From: Angus W Hardie <Angus.Hardie@malcolmhardie.com>\n" +
            "To: testlist@lists.malcolmhardie.com\n" +
            "Content-Transfer-Encoding: 7bit\n" +
            "Message-Id: <49C69B37-90D8-11D8-80E6-000502339DF3@malcolmhardie.com>\n" +
            "X-Mailer: Apple Mail (2.553)\n" +
            "Subject: [Testlist] test\n" +
            "Sender: testlist-admin@lists.malcolmhardie.com\n" +
            "Errors-To: testlist-admin@lists.malcolmhardie.com\n" +
            "X-BeenThere: testlist@lists.malcolmhardie.com\n" +
            "X-Mailman-Version: 2.0.11\n" +
            "Precedence: bulk\n" +
            "List-Help: <mailto:testlist-request@lists.malcolmhardie.com?subject=help>\n" +
            "List-Post: <mailto:testlist@lists.malcolmhardie.com>\n" +
            "List-Subscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=subscribe>\n" +
            "List-Id: <testlist.lists.malcolmhardie.com>\n" +
            "List-Unsubscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=unsubscribe>\n" +
            "List-Archive: <http://lists.malcolmhardie.com/pipermail/testlist/>\n" +
            "\n" +
            "test\n" +
            "\n" +
            "\n" +
            "\n" +
            "From Angus.Hardie@malcolmhardie.com Sun Apr 18 02:35:33 2004\n" +
            "Received: from pol.malcolmhardie.com ([213.152.32.218] helo=malcolmhardie.com)\n" +
            "\tby marilac.malcolmhardie.com with asmtp \n" +
            "\t(Cipher TLSv1:DES-CBC3-SHA:168) (Exim 3.35 #1 (Debian))\n" +
            "\tid 1BF1DY-0004ov-00\n" +
            "\tfor <testlist@lists.malcolmhardie.com>; Sun, 18 Apr 2004 02:35:32 +0100\n" +
            "Date: Sun, 18 Apr 2004 02:35:21 +0100\n" +
            "Mime-Version: 1.0 (Apple Message framework v553)\n" +
            "Content-Type: text/plain; charset=US-ASCII; format=flowed\n" +
            "From: Angus W Hardie <Angus.Hardie@malcolmhardie.com>\n" +
            "To: testlist@lists.malcolmhardie.com\n" +
            "Content-Transfer-Encoding: 7bit\n" +
            "Message-Id: <A84AF498-90D8-11D8-80E6-000502339DF3@malcolmhardie.com>\n" +
            "X-Mailer: Apple Mail (2.553)\n" +
            "Subject: [Testlist] test2\n" +
            "Sender: testlist-admin@lists.malcolmhardie.com\n" +
            "Errors-To: testlist-admin@lists.malcolmhardie.com\n" +
            "X-BeenThere: testlist@lists.malcolmhardie.com\n" +
            "X-Mailman-Version: 2.0.11\n" +
            "Precedence: bulk\n" +
            "List-Help: <mailto:testlist-request@lists.malcolmhardie.com?subject=help>\n" +
            "List-Post: <mailto:testlist@lists.malcolmhardie.com>\n" +
            "List-Subscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=subscribe>\n" +
            "List-Id: <testlist.lists.malcolmhardie.com>\n" +
            "List-Unsubscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=unsubscribe>\n" +
            "List-Archive: <http://lists.malcolmhardie.com/pipermail/testlist/>\n" +
            "\n" +
            "test2\n" +
            "\n" +
            "\n" +
            "\n" +
            "From awh@malcolmhardie.com Wed Jul 06 03:09:52 2005\n" +
            "Received: from awh by marilac.malcolmhardie.com with local (Exim 3.35 #1\n" +
            "\t(Debian)) id 1DpzMF-0007Cq-00\n" +
            "\tfor <testlist@lists.malcolmhardie.com>; Wed, 06 Jul 2005 03:09:51 +0100\n" +
            "To: testlist@lists.malcolmhardie.com\n" +
            "Message-Id: <E1DpzMF-0007Cq-00@marilac.malcolmhardie.com>\n" +
            "From: Angus W Hardie <awh@malcolmhardie.com>\n" +
            "Date: Wed, 06 Jul 2005 03:09:51 +0100\n" +
            "Subject: [Testlist] test\n" +
            "X-BeenThere: testlist@lists.malcolmhardie.com\n" +
            "X-Mailman-Version: 2.1.5\n" +
            "Precedence: list\n" +
            "List-Id: testlist.lists.malcolmhardie.com\n" +
            "List-Unsubscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=unsubscribe>\n" +
            "List-Archive: <http://lists.malcolmhardie.com/pipermail/testlist>\n" +
            "List-Post: <mailto:testlist@lists.malcolmhardie.com>\n" +
            "List-Help: <mailto:testlist-request@lists.malcolmhardie.com?subject=help>\n" +
            "List-Subscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=subscribe>\n" +
            "X-List-Received-Date: Wed, 06 Jul 2005 02:09:53 -0000\n" +
            "\n" +
            "test\n" +
            "\n" +
            "\n" +
            "From awh@malcolmhardie.com Wed Jul 06 03:31:01 2005\n" +
            "Received: from awh by marilac.malcolmhardie.com with local (Exim 3.35 #1\n" +
            "\t(Debian)) id 1Dpzgi-0007Gc-00\n" +
            "\tfor <testlist@lists.malcolmhardie.com>; Wed, 06 Jul 2005 03:31:00 +0100\n" +
            "To: testlist@lists.malcolmhardie.com\n" +
            "Message-Id: <E1Dpzgi-0007Gc-00@marilac.malcolmhardie.com>\n" +
            "From: Angus W Hardie <awh@malcolmhardie.com>\n" +
            "Date: Wed, 06 Jul 2005 03:31:00 +0100\n" +
            "Subject: [Testlist] test\n" +
            "X-BeenThere: testlist@lists.malcolmhardie.com\n" +
            "X-Mailman-Version: 2.1.5\n" +
            "Precedence: list\n" +
            "List-Id: testlist.lists.malcolmhardie.com\n" +
            "List-Unsubscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=unsubscribe>\n" +
            "List-Archive: <http://lists.malcolmhardie.com/pipermail/testlist>\n" +
            "List-Post: <mailto:testlist@lists.malcolmhardie.com>\n" +
            "List-Help: <mailto:testlist-request@lists.malcolmhardie.com?subject=help>\n" +
            "List-Subscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=subscribe>\n" +
            "X-List-Received-Date: Wed, 06 Jul 2005 02:31:01 -0000\n" +
            "\n" +
            "test\n" +
            "test\n" +
            "\n" +
            "\n" +
            "From awh@malcolmhardie.com Wed Jul 06 03:32:01 2005\n" +
            "Received: from awh by marilac.malcolmhardie.com with local (Exim 3.35 #1\n" +
            "\t(Debian)) id 1Dpzhh-0007Gp-00\n" +
            "\tfor <testlist@lists.malcolmhardie.com>; Wed, 06 Jul 2005 03:32:01 +0100\n" +
            "To: testlist@lists.malcolmhardie.com\n" +
            "Message-Id: <E1Dpzhh-0007Gp-00@marilac.malcolmhardie.com>\n" +
            "From: Angus W Hardie <awh@malcolmhardie.com>\n" +
            "Date: Wed, 06 Jul 2005 03:32:01 +0100\n" +
            "Subject: [Testlist] test\n" +
            "X-BeenThere: testlist@lists.malcolmhardie.com\n" +
            "X-Mailman-Version: 2.1.5\n" +
            "Precedence: list\n" +
            "List-Id: testlist.lists.malcolmhardie.com\n" +
            "List-Unsubscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=unsubscribe>\n" +
            "List-Archive: <http://lists.malcolmhardie.com/pipermail/testlist>\n" +
            "List-Post: <mailto:testlist@lists.malcolmhardie.com>\n" +
            "List-Help: <mailto:testlist-request@lists.malcolmhardie.com?subject=help>\n" +
            "List-Subscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=subscribe>\n" +
            "X-List-Received-Date: Wed, 06 Jul 2005 02:32:02 -0000\n" +
            "\n" +
            "test\n" +
            "test\n" +
            "\n" +
            "\n" +
            "From awh@malcolmhardie.com Wed Jul 06 03:36:18 2005\n" +
            "Received: from awh by marilac.malcolmhardie.com with local (Exim 3.35 #1\n" +
            "\t(Debian)) id 1Dpzlq-0007HL-00\n" +
            "\tfor <testlist@lists.malcolmhardie.com>; Wed, 06 Jul 2005 03:36:18 +0100\n" +
            "To: testlist@lists.malcolmhardie.com\n" +
            "Message-Id: <E1Dpzlq-0007HL-00@marilac.malcolmhardie.com>\n" +
            "From: Angus W Hardie <awh@malcolmhardie.com>\n" +
            "Date: Wed, 06 Jul 2005 03:36:18 +0100\n" +
            "Subject: [Testlist] test test test\n" +
            "X-BeenThere: testlist@lists.malcolmhardie.com\n" +
            "X-Mailman-Version: 2.1.5\n" +
            "Precedence: list\n" +
            "List-Id: testlist.lists.malcolmhardie.com\n" +
            "List-Unsubscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=unsubscribe>\n" +
            "List-Archive: <http://lists.malcolmhardie.com/pipermail/testlist>\n" +
            "List-Post: <mailto:testlist@lists.malcolmhardie.com>\n" +
            "List-Help: <mailto:testlist-request@lists.malcolmhardie.com?subject=help>\n" +
            "List-Subscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=subscribe>\n" +
            "X-List-Received-Date: Wed, 06 Jul 2005 02:36:18 -0000\n" +
            "\n" +
            "test\n" +
            "\n" +
            "t.\n" +
            "\n" +
            "\n" +
            "\n" +
            "From awh@malcolmhardie.com Wed Nov 05 01:49:28 2008\n" +
            "Received: from awh by marilac.malcolmhardie.com with local (Exim 4.63)\n" +
            "\t(envelope-from <awh@malcolmhardie.com>) id 1KxXWR-0001wz-U5\n" +
            "\tfor Testlist@lists.malcolmhardie.com; Wed, 05 Nov 2008 01:49:27 +0000\n" +
            "To: Testlist@lists.malcolmhardie.com\n" +
            "Message-Id: <E1KxXWR-0001wz-U5@marilac.malcolmhardie.com>\n" +
            "From: Angus W Hardie <awh@malcolmhardie.com>\n" +
            "Date: Wed, 05 Nov 2008 01:49:27 +0000\n" +
            "Subject: [Testlist] test\n" +
            "X-BeenThere: testlist@lists.malcolmhardie.com\n" +
            "X-Mailman-Version: 2.1.9\n" +
            "Precedence: list\n" +
            "List-Id: <testlist.lists.malcolmhardie.com>\n" +
            "List-Unsubscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=unsubscribe>\n" +
            "List-Archive: <http://lists.malcolmhardie.com/pipermail/testlist>\n" +
            "List-Post: <mailto:testlist@lists.malcolmhardie.com>\n" +
            "List-Help: <mailto:testlist-request@lists.malcolmhardie.com?subject=help>\n" +
            "List-Subscribe: <http://lists.malcolmhardie.com/cgi-bin/mailman/listinfo/testlist>,\n" +
            "\t<mailto:testlist-request@lists.malcolmhardie.com?subject=subscribe>\n" +
            "X-List-Received-Date: Wed, 05 Nov 2008 01:49:28 -0000\n" +
            "\n" +
            "test\n";

    private List<Email> emailsFromString = new ArrayList<>();

    private String EMAILREGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private String FROMREGEX = "(from\\s)("+EMAILREGEX+")";
    private String SUBJECTREGEX = "(subject:\\s)(.*)";
    private String DATEREGEX = "(\\ndate:\\s)(.*)";
    private String CONTENTREGEX = "(x-list.*|list.*)(\n\n)(.*)";

    public String tempName(){
        Pattern pattern = Pattern.compile(FROMREGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(file);

        Pattern pattern2 = Pattern.compile(SUBJECTREGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(file);

        Pattern pattern3 = Pattern.compile(DATEREGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(file);

        Pattern pattern4 = Pattern.compile(CONTENTREGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher4 = pattern4.matcher(file);

        //dokonczyc pat4/mat4 zeby zbieralo cala tresc maila (wyciac kawalek dac do string -> replace)
        //parametryzowac co sie da i podmienic flie na stringa (jako pararmte metody)
        //usunac co niepotrzebne
        //zrobic kolekcje arraylist emaili i zwracac w tej funkcji zamst strnga
        //yolo


        int count = 0;
        while(matcher4.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher4.start() + " - " + matcher4.end());
            System.out.println(matcher4.group(3));
        }

        return "end";
    }


    public String test() {
        Pattern pattern;
        String result = "";
        try {
            pattern = Pattern.compile(regexFrom);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(file);
        boolean found1 = matcher.find();
        if (found1) {
        }
        System.out.println();
        return null;
    }




    public String reportFrom(String file) {
        this.file = file;
        String result = "Wzorzec: \"" + regexFrom + "\"\n" +
                "Tekst: \"" + file + "\"";
        Pattern pattern;
        try {
            pattern = Pattern.compile(regexFrom);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(file);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while (matcher.find());
        System.out.println();
        return result;
    }

    public String reportContent() {
        String result = "Wzorzec: \"" + regexContent + "\"\n" +
                "Tekst: \"" + file + "\"";
        Pattern pattern;
        try {
            pattern = Pattern.compile(regexContent);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(file);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {// tutaj ma być regex ze spacjami itd
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while (matcher.find());
        System.out.println();
        return result;
    }

    public String reporData() {
        String result = "Wzorzec: \"" + regexData + "\"\n" +
                "Tekst: \"" + file + "\"";
        Pattern pattern;
        try {
            pattern = Pattern.compile(regexData);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(regexData);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while (matcher.find());
        System.out.println();
        return result;
    }

    public String reporSubject() {
        String result = "Wzorzec: \"" + regexSubject + "\"\n" +
                "Tekst: \"" + file + "\"";
        Pattern pattern;
        try {
            pattern = Pattern.compile(regexSubject);
        } catch (Exception exc) {
            return result + "\n" + exc.getMessage();
        }
        Matcher matcher = pattern.matcher(regexSubject);
        boolean found = matcher.find();
        if (!found)
            result += "\nfind(): Nie znaleziono żadnego podłańcucha " +
                    "pasującego do wzorca";
        else
            do {
                result += "\nfind(): Dopasowano podłańcuch \"" + matcher.group() +
                        "\" od pozycji " + matcher.start() +
                        " do pozycji " + matcher.end() + ".";
            } while (matcher.find());
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        MakeEmailsFromString lolo = new MakeEmailsFromString();
        //System.out.println(lolo. (file));
    }

}