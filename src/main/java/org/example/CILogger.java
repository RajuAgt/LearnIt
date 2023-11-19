package org.example;

import java.util.logging.Logger;
public class CILogger {
    public static final String LOGGER_TYPE = "Glory.ReportingWebsite";
    public static final String SEPARATOR = "|";
    public static final String FIELD_SEPARATOR = ";";
    public static final String ENTRY_STRING = "entry";
    public static final String EXIT_STRING = "exit";
    public static final String LOGGER_SEPARATOR = ".";
    private static final StringBuffer createHeader( String location, String logType ) {
        StringBuffer result = new StringBuffer();
        result.append( location );
        result.append( SEPARATOR );
        result.append( logType );
        result.append( SEPARATOR );
        return result;
    }
    public static void entry( String location ) {
        StringBuffer message = createHeader( location, ENTRY_STRING );
        Logger.getLogger( LOGGER_TYPE ).info( message.toString() );
    }

    public static void exit( String location ) {
        StringBuffer message = createHeader( location, EXIT_STRING );
        Logger.getLogger( LOGGER_TYPE ).info( message.toString() );
    }

    public static void info( String Location, Object error ) {
        Logger.getLogger( LOGGER_TYPE ).info( Location + SEPARATOR + error.toString() );
    }

    public static void debug( String Location, Object error ) {
        Logger.getLogger( LOGGER_TYPE ).finer( Location + SEPARATOR + error.toString() );
    }

    public static void error( String Location, Object error ) {
        String errmsg = error != null ? error.toString() : "Unexpected Error. Please re-login.";
        Logger.getLogger( LOGGER_TYPE ).severe( Location + SEPARATOR + errmsg );
    }
}
