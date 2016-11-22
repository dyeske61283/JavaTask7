/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit;

import einarmigerbandit.adapter.Adapter;
import einarmigerbandit.controller.Controller;
import einarmigerbandit.model.OneArmedBandit;
import einarmigerbandit.view.View;

/**
 *
 * @author kevin
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new Start();
    }

  public Start()
  {
          
      View view = new View();
      
      OneArmedBandit model = new OneArmedBandit();
      
      Adapter adapter = new Adapter(model, view);
      
      adapter.registerEvents();
      
      Controller controller = new Controller(view, model);
      
      controller.registerCommands();
      controller.registerEvents();
      
      view.setVisible(true);
  }
    
}
