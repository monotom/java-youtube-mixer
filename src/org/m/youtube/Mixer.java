/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.m.youtube;

import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author mono
 */
public class Mixer extends Region {
    final Browser player1;
    final Browser player2;
    
    final public WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
     
    final File mixerIndexFile;
            
    public Mixer(){
        player1 = new Browser();
        player2 = new Browser();
        mixerIndexFile = new File("./lib/html-youtube-mixer/index.html");
        try{
            webEngine.load(mixerIndexFile.toURI().toURL().toString()+"?_runjplayer=1");
        }
        catch(MalformedURLException e){    
        }
        
        getChildren().add(browser);
    }
 
    @Override public void setHeight(double height) {
        super.setHeight(height);
        browser.setPrefHeight(height);
    }
 
    @Override public void setWidth(double width) {
        super.setWidth(width);
        browser.setPrefWidth(width);
    }
}
