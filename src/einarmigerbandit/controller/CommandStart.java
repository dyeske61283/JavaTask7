/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit.controller;

import einarmigerbandit.model.OneArmedBandit;
import einarmigerbandit.view.View;

/**
 *
 * @author kevin
 */
public class CommandStart implements CommandInterface
{
    private View view;
    private OneArmedBandit model;
    
    public CommandStart(View view, OneArmedBandit model) 
    {
        this.view = view;
        this.model = model;
    }
    

    @Override
    public void execute() 
    {
        if(! this.model.isStarted())
        {
          this.model.setStarted(true);
        }
    }
    
}
