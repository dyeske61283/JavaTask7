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
    private Counter c1;
    private Counter c2;
    private Counter c3;
    private OhmLogger oL;
    private boolean started;
    public OneArmedBandit() 
    {
        this.c1 = new Counter();
        this.c2 = new Counter();
        this.c3 = new Counter();
        this.oL = OhmLogger.getInstance();
        started = false;
    }

  public Counter getC1()
  {
    return c1;
  }

  public Counter getC2()
  {
    return c2;
  }

  public Counter getC3()
  {
    return c3;
  }

  public boolean isStarted()
  {
    return started;
  }

  public void setStarted(boolean started)
  {
    this.started = started;

    c1.setStarted(started);
    c2.setStarted(started);
    c3.setStarted(started);
  }
    
    
}
