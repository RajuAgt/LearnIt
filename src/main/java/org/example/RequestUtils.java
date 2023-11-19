package org.example;

import javax.servlet.http.HttpServletRequest;
public class RequestUtils {
    public static int getParamAsInteger( HttpServletRequest request, String parameterName ) {
        System.out.println("Inside getParamAsInteger");
        return getParamAsInteger( request, parameterName, -1 );
    }
    public static int getParamAsInteger( HttpServletRequest request, String parameterName, int defaultValue ) {
        System.out.println("Parameter valu: "+ parameterName);
        String reqValue = request.getParameter( parameterName );
        System.out.println("Request value: "+ reqValue);
        String value = CIStringUtils.containsText( reqValue ) ? reqValue : String.valueOf( defaultValue );
        if( value.matches( "" ) ) {
            throw new IllegalArgumentException( parameterName + " cannot be parsed as Integer. " );
        }
        return Integer.parseInt( value );
    }

    public static boolean getParamAsBoolean( HttpServletRequest request, String parameterName ) {
        return getParamAsBoolean( request, parameterName, false );
    }

    public static boolean getParamAsBoolean( HttpServletRequest request, String parameterName, boolean defaultValue ) {
        String value = request.getParameter( parameterName ) != null ? request.getParameter( parameterName ) : String.valueOf( defaultValue );
        if( value.matches( "" ) ) {
            throw new IllegalArgumentException( parameterName + " cannot be parsed as Boolean. " );
        }
        return Boolean.valueOf( value );
    }

    public static String getParamAsString( HttpServletRequest request, String parameterName, String defaultValue ) {
        String value = request.getParameter( parameterName ) != null ? request.getParameter( parameterName ) : defaultValue; return value;
    }

    /**
     * public static String getLabel( String key, * HttpServletRequest request ) * { *
     * HttpSession session = request.getSession( false );
     * * Locale locale = ( Locale )session.getAttribute( "locale" );
     * * * String file = locale.getCountry() * + locale.getLanguage();
     * * * PropertyUtils instance = PropertyUtils.getInstance( file );
     * * return instance.getValue( key );
     * * }
     * */
}
