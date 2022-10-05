package pageobjects;

/*
Created By: Shilpi Gupta sgupta@bhavnacorp.com
Updated By:
Date: 8/9/2018
*/


import ui.AbstractPage;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AbcCommonAbstractPage<T extends AbcCommonAbstractPage<T>> extends AbstractPage<T> {

    public String extract_string_between_delimiters(String originalString, String LHS, String RHS) {
        logger.info("Remove dollar sign from the fetched value");
        String str = originalString;
        String result = str.substring(str.indexOf(LHS) + 1, str.indexOf(RHS));
        return result;
    }

    public String remove_decimal_from_value(String value) {
        logger.info("Remove decimal value from the data");
        double valueWithDecimal = Double.parseDouble(value);
        DecimalFormat f = new DecimalFormat("##");
        String valueWithoutDecimal = (f.format(valueWithDecimal));
        return valueWithoutDecimal;

    }


    public String generate_random_number_by_range(int minRange, int maxRange) {
        logger.info("Generate random number");
        Integer randomNumber = ThreadLocalRandom.current().nextInt(minRange, maxRange);
        String randomNumberString = randomNumber.toString();
        return randomNumberString;
    }

    public String generate_random_string() {
        logger.info("Generate random String");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String lastNameString = "";
        Random random = new Random();
        char c = alphabet.charAt(random.nextInt(26));
        Integer randomNumber = random.nextInt(9000000) + 1000000;
        String randomAlphaNumbericString = randomNumber.toString();
        lastNameString = randomAlphaNumbericString + c;
        return lastNameString;
    }
}
