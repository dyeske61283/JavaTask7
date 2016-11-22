/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit.model;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author kevin
 */
public class Counter extends Observable implements Runnable
{
    private final static int Bound = 10;
  
  private Thread thd;
  private int Augen;
  private Boolean started;
  
  public Counter()
  {
    Augen = 0;
    started = false;
    
    thd = new Thread(this);
    thd.start();
    }

  public synchronized void setStarted(Boolean started)
  {
    this.started = started;
    notifyAll();
  }
  
  public int getAugen()
  {
    return this.Augen;
  }
  public Boolean getStarted()
  {
    return this.started;
  }
  
  @Override
  public void run()
  {
      while(true)
      {
       try
       {
         this.berechneAugen();
       }
       catch(InterruptedException ex)
       {
         ex.printStackTrace();
       }
      }
  }
 
  
  private synchronized void berechneAugen() throws InterruptedException
  {
    while(!started)
    {
      wait();
    }
    Augen = 1 + new Random().nextInt(Bound);
    this.setChanged();
    this.notifyObservers();
    notifyAll();
  }


}
