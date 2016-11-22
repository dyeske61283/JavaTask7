/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit.controller;

import einarmigerbandit.model.OneArmedBandit;
import einarmigerbandit.view.View;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kevin
 */
public class Controller implements ActionListener
{
    private View view;
    private OneArmedBandit model;
    private CommandInvoker invoker;

  public Controller(View view, OneArmedBandit model)
  {
    this.view = view;
    this.model = model;
    this.invoker = new CommandInvoker();
  }
  
  public void registerEvents()
  {
    this.view.getBtnStart().addActionListener(this);
    this.view.getBtnStop().addActionListener(this);
  }
    
  public void registerCommands()
  {
    this.invoker.addCommand(this.view.getBtnStart(),new CommandStart(view, model));
    this.invoker.addCommand(this.view.getBtnStop(),new CommandStop(view, model));
  }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        invoker.executeCommand((Component) e.getSource());
    }
    
}
