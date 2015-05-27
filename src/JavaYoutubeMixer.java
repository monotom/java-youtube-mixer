import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEvent;
import javafx.stage.Stage;

import org.m.youtube.Mixer;

/**
 *
 * @author mono
 */
public class JavaYoutubeMixer extends Application {
    private Scene scene;
    private Mixer mixer;
    @Override public void start(Stage stage) {
        stage.setTitle("java-youtube-mixer");
        
        mixer = new Mixer();
        scene = new Scene(mixer ,750,500);
        
        stage.setScene(scene);    
        stage.show();
        
        scene.widthProperty().addListener( new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) { 
                Double width = (Double)newValue;     
                mixer.setWidth(width);
            }
        });
        
        scene.heightProperty().addListener( new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) { 
                Double height = (Double)newValue; 
                mixer.setHeight(height);
            }
        });
        
        mixer.browser.getEngine().setOnAlert(new EventHandler<WebEvent<String>>() {
          @Override 
          public void handle(WebEvent<String> event) {
            System.out.println(event.getData());
          }
        }); 
    }

    public static void main(String[] args) {
        launch(args);
    }  
}
