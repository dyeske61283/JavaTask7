/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package einarmigerbandit.controller;

import java.awt.Component;
import java.util.HashMap;

/**
 *
 * @author kevin
 */
public class CommandInvoker 
{
    private HashMap<Component,CommandInterface> commands;

    public CommandInvoker() 
    {
        commands = new HashMap<>();
    }
    
    public void addCommand(Component key, CommandInterface value)
    {
      commands.put(key, value);
    }
  
    public void executeCommand(Component key)
    {
      commands.get(key).execute();
    }
}
