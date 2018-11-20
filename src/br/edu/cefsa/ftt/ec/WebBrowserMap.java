package br.edu.cefsa.ftt.ec;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

//Referencia: https://docs.oracle.com/javafx/2/webview/jfxpub-webview.htm
//            https://www.openstreetmap.org/
 
public class WebBrowserMap extends Application {
    private Scene scene;
    @Override public void start(Stage stage) {
        // create the scene
        stage.setTitle("Web View");
        scene = new Scene(new BrowserMap(),750,500, Color.web("#666970"));
        stage.setScene(scene);
        scene.getStylesheets().add("webviewsample/BrowserToolbar.css");        
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
}

class BrowserMap extends Region {
 
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
     
    public BrowserMap() {
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
        webEngine.load("https://www.openstreetmap.org/search?query=funda%C3%A7ao%20salvador%20arena#map=17/-23.73790/-46.58542");
        //add the web view to the scene
        getChildren().add(browser);
 
    }
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
 
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}