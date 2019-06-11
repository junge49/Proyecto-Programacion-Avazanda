package estacionamiento;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author joel_
 */
public class Autolavado extends Stage{
    
    public Autolavado() {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 400);
        
        this.setTitle("Autolavado");
        this.setScene(scene);
        this.show();
    }

    
}
