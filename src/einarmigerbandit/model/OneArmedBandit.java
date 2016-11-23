/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit.model;

import Logger.OhmLogger;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kevin
 */
public class OneArmedBandit extends Observable implements Observer
{
    private Counter[] counters;
    private OhmLogger oL;
    private boolean started;
    private int credit;
    
    
    public OneArmedBandit() 
    {
        counters = new Counter[3];
        for(int i=0;i<counters.length;i++)
        {
          counters[i] = new Counter();
          counters[i].addObserver(this);
        }      
        this.oL = OhmLogger.getInstance();
        started = false;
        credit = 100;
        
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

  public int getCredit()
  {
    return credit;
  }

  public void setStarted(boolean started)
  {
    this.started = started;

    for(Counter i:counters)
    {
      i.setStarted(started);
    }
    oL.getLogger().info("Started Counters.");
    
    if(started)
    {
      this.credit -= 1;
    }
    else
    {
      if(counters[0].getAugen() == counters[1].getAugen() || 
       counters[1].getAugen() == counters[2].getAugen())
    {
      int getCredits = 1;
      if(counters[2] == counters[0])
      {
        getCredits = 10;
      }
      this.credit += getCredits;
    }
    }
    this.setChanged();
    this.notifyObservers();
  }

  @Override
  public void update(java.util.Observable o, Object arg)
  {
    this.setChanged();
    this.notifyObservers();
  }
}
