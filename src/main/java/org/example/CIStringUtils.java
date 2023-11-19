package org.example;

public class CIStringUtils {
    public static boolean containsText( String text ) {
        return text != null && text.trim().length() > 0;
    }

    public static String getText( String text, String defaultText ) {
        return text != null && text.trim().length() > 0 ? text : defaultText;
    }

    public static boolean equalsText( String text1, String text2, boolean ignoreCase ) {
        return ( text1 != null && text2 != null ) && ( ignoreCase ? text1.equalsIgnoreCase( text2 ) : text1.equals( text2 ) );
    }
}
