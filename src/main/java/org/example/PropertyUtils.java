package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletContext;
public class PropertyUtils {
    private Properties properties = new Properties();
    private ServletContext context;
    private static Map< String, PropertyUtils > map = new HashMap<>();

    public PropertyUtils( ServletContext context, String filename ) {
        this.context = context;
        loadProperties( filename, null );
        map.put( filename, this );
    }

    public PropertyUtils( ServletContext context, String filename, InputStream is ) throws IOException {
        this.context = context; properties.load( is );
        map.put( filename, this );
    }

    private void loadProperties( String filename, String filepath ) {
        try {
            String path = CIStringUtils.containsText( filepath ) ? filepath : context.getRealPath( "/WEB-INF" );
            File f = new File( path + File.separator + filename );
            if( f.exists() ) {
                properties.load( new FileInputStream( f ) );
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

    public String getValue( String key ) {
        return properties != null ? ( String )properties.getProperty( key ) : "";
    }

    public static PropertyUtils getInstance( String filename ) {
        return map.get( filename );
    }
}
