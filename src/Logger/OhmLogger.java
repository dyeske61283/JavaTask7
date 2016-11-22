package Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.codegen.CompilerConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class OhmLogger {
    
    private static Logger lg;
    
    private OhmLogger() {
        lg = null;
    }
    
    public static OhmLogger getInstance() {
        return OhmLoggerHolder.INSTANCE;
    }
    
    private static class OhmLoggerHolder {

        private static final OhmLogger INSTANCE = new OhmLogger();
    }
    
    public static Logger getLogger()
    {
        if(lg == null)
        {
            lg = Logger.getLogger("OhmLogger");
            initLogger();
        }
        return lg;
    }
    
    private static void initLogger()
    {
        try
        {
            Properties props = new Properties();
            
            InputStream is = OhmLogger.getInstance().getClass().
                    getResourceAsStream("logger.properties");
            props.load(is);
            
            String logFile = props.getProperty("LOG_DATEI");
            FileHandler fh = new FileHandler(logFile);
            
            lg.addHandler(fh);
            
            fh.setFormatter(new OhmFormatter());
            
            String logLevel = props.getProperty("LOG_LEVEL");
            lg.setLevel(Level.parse(logLevel));  
            
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
    }
}
