/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit.adapter;

import einarmigerbandit.model.OneArmedBandit;
import einarmigerbandit.view.View;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kevin
 */
public class Adapter implements Observer
{
   private OneArmedBandit model;
  private View view;
  
  public Adapter(OneArmedBandit model, View view)
  {
      this.model= model;
      this.view = view;
  }

   public void registerEvents()
  {
    model.getC1().addObserver(this);
    model.getC2().addObserver(this);
    model.getC3().addObserver(this);
  }
  @Override
  public void update(Observable o, Object arg)
  {
    int zahlLinks = this.model.getC1().getAugen();
    int zahlMitte = this.model.getC2().getAugen();
    int zahlRechts = this.model.getC3().getAugen();
    
    this.view.getTfCounterLeft().setText(String.valueOf(zahlLinks)); 
    this.view.getTfCounterCenter().setText(String.valueOf(zahlMitte));
    this.view.getTfCounterRight().setText(String.valueOf(zahlRechts));
    
    
//    if((zahlLinks == zahlMitte && zahlLinks == zahlRechts )&& 
//       !this.model.isStarted())
//    {
//      JOptionPane.showInternalMessageDialog(this.view.getTfCounterCenter(), 
//                                            "Congratulations! You won! $$","You won!", 
//                                              JOptionPane.INFORMATION_MESSAGE);
//    }
  }
    
}
