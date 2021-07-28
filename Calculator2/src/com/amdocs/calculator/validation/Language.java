package com.amdocs.calculator.validation;

import java.util.*;
import java.io.*;

public class Language {

	public static ResourceBundle getResourceBundle(String language) throws IOException {

        String message = "";
        ResourceBundle rb = null;

        if (language.equals("de") || language.equals("en")) {

            InputStream input = null;
            input = Language.class.getResourceAsStream("/" + language.toLowerCase() + ".properties");

            Properties prop = new Properties();
            prop.load(input);

            Locale currentLocale = new Locale(language.toLowerCase(), language.toUpperCase()); 
            return ResourceBundle.getBundle(language.toLowerCase(), currentLocale);

        } else {
            message = "Default language (english) is set";

            Locale currentLocale = new Locale("en", "US");
            return ResourceBundle.getBundle("en", currentLocale);
        }
    }
	
}
