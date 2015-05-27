/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.m.youtube;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author mono
 */

public class Browser extends Region {
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
     
    public Browser() {
        getChildren().add(browser);
    }
    
    public void play(String videoId){
        webEngine.load("http://www.youtube.com/watch?enablejsapi=1&v=" + videoId);
    }
    
    public void setVolume(Double value){
        //
    }
        
    public Double getVolume(){
        return 0.0;
    }
}

