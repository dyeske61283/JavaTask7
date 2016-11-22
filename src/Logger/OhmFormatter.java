package Logger;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class OhmFormatter extends SimpleFormatter
{
  private static final DateFormat df = 
  new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
  
  public OhmFormatter(){}
  
  public String format(LogRecord record)
  {
        StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
        builder.append("[").append(record.getLevel()).append("] - ");
        builder.append("[").append(record.getSourceClassName()).append(".");
        builder.append(record.getSourceMethodName()).append("] - ");
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
  }
}