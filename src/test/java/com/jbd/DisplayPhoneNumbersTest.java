package com.jbd;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Admin on 07.11.2016.
 */
public class DisplayPhoneNumbersTest {
    List<Email> eMailKeeper =  Arrays.asList(new Email("marcin@wp.pl","subject","2015-01-01","test 515-417-846"),
            new Email("marcin@wp.pl","subject","2015-01-01","test 515417844"),
            new Email("marcin@wp.pl","subject","2015-01-01","test 515 417 846"),
            new Email("wojtek@wp.pl","subject","2015-01-01","test 616478366"),
            new Email("wojtek@wp.pl","subject","2015-01-01","test 616478366"));
    @Test
    public void shouldReturnListSize2() throws Exception {
        Map<String,List<String>> resultMap;
        List<String> resultList;
        DisplayPhoneNumbers displayPhoneNumbers = new DisplayPhoneNumbers();
        resultMap = displayPhoneNumbers.searchPhoneNumbers(eMailKeeper);
        resultList = resultMap.get("marcin@wp.pl");
        assertThat("Size of the list number is not equal 2! ", resultList.size(), is(2));
    }

}