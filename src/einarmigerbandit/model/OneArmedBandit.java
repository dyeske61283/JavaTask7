/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit.model;

import Logger.OhmLogger;

/**
 *
 * @author kevin
 */
public class OneArmedBandit
{
    private Counter[] counters;
    private OhmLogger oL;
    private boolean started;
    public OneArmedBandit() 
    {
        counters = new Counter[3];
        for(Counter i:counters)
        {
          i = new Counter();
        }      
        this.oL = OhmLogger.getInstance();
        started = false;
        oL.getLogger().info("Begin of logging");
    }

  public Counter getC1()
  {
    return counters[0];
  }

  public Counter getC2()
  {
    return counters[1];
  }

  public Counter getC3()
  {
    return counters[2];
  }

  public boolean isStarted()
  {
    return started;
  }

  public void setStarted(boolean started)
  {
    this.started = started;

    for(Counter i:counters)
    {
      i.setStarted(started);
    }
    oL.getLogger().info("Started Counters.");
  }
    
    
}
