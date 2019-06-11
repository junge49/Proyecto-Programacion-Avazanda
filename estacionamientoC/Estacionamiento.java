package estacionamiento;

import dao.EmpleadoALDao;
import dao.EmpleadoGDao;
import dao.GerenteDao;
import static java.awt.Color.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/** 
 *
 * @author joel_
 */
public class Estacionamiento extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label mensaje =new Label();
        mensaje.setText("ELIGE TU TIPO DE USUARIO:");
        mensaje.setLayoutX(10);
        mensaje.setLayoutY(10);
        mensaje.setFont(new Font (30));
        Button gerente = new Button();
        gerente.setText("GERENTE");
        gerente.setLayoutX(10);
        gerente.setLayoutY(100);
        gerente.setFont(new Font (20));
        gerente.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage veriEmp = new Stage ();
                Label men = new Label ("Ingresa tu usuario y contraseña: ");
                men.setLayoutX(10);
                men.setLayoutY(10);
                Label user = new Label ("Usuario: ");
                user.setLayoutX(10);
                user.setLayoutY(50);
                Label pass = new Label ("Contraseña: ");
                pass.setLayoutX(10);
                pass.setLayoutY(100);
                TextField tfuser =new TextField ();
                tfuser.setLayoutX(80);
                tfuser.setLayoutY(50);
                PasswordField tfpass =new PasswordField ();
                tfpass.setLayoutX(80);
                tfpass.setLayoutY(100);
                Button ingAl = new Button("Ingresar");
                ingAl.setLayoutX(10);
                ingAl.setLayoutY(150);
                ingAl.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        GerenteDao gd = new GerenteDao();
                        if (!tfuser.getText().isEmpty() && !tfpass.getText().isEmpty()){
                            int user=Integer.parseInt(tfuser.getText());
                            String pass=tfpass.getText();
                            if (gd.buscarGerente(user,pass)){
                                VentanaGerente vg =new VentanaGerente();
                                //primaryStage.close();
                                veriEmp.close();
                            }else{
                                Alert dialogo = new Alert(Alert.AlertType.ERROR);
                                dialogo.setTitle("Error");
                                dialogo.setHeaderText("Usuario y/o contraseña erroneos");
                                dialogo.show();
                            }
                        }else{
                            Alert dialogo = new Alert(Alert.AlertType.ERROR);
                            dialogo.setTitle("Error");
                            dialogo.setHeaderText("Debe ingresar sus datos para acceder.");
                            dialogo.show();
                        }
                    }
                });
                Button canAl = new Button("Cancelar");
                canAl.setLayoutX(100);
                canAl.setLayoutY(150);
                canAl.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        veriEmp.close();
                    }
                });
                Pane root2 = new Pane();
                root2.getChildren().add(men);
                root2.getChildren().add(user);
                root2.getChildren().add(pass);
                root2.getChildren().add(tfuser);
                root2.getChildren().add(tfpass);
                root2.getChildren().add(ingAl);
                root2.getChildren().add(canAl);
                Scene scene2 = new Scene(root2, 250, 200);
                veriEmp.setTitle("Autentificacion usuario");
                veriEmp.setScene(scene2);
                veriEmp.show();
            }
        });
        Button egeneral = new Button();
        egeneral.setText("E. GENERAL");
        egeneral.setLayoutX(130);
        egeneral.setLayoutY(100);
        egeneral.setFont(new Font (20));
        egeneral.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage veriEmp = new Stage ();
                Label men = new Label ("Ingresa tu numero de personal: ");
                men.setLayoutX(10);
                men.setLayoutY(10);
                TextField tfeal =new TextField ();
                tfeal.setLayoutX(10);
                tfeal.setLayoutY(50);
                Button ingAl = new Button("Ingresar");
                ingAl.setLayoutX(10);
                ingAl.setLayoutY(100);
                ingAl.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        EmpleadoGDao egd= new EmpleadoGDao();
                        int ideg=Integer.parseInt(tfeal.getText());
                        if (egd.bBuscarEmpleadoG(ideg)){
                            Espacios es =new Espacios();
                            //primaryStage.close();
                            veriEmp.close();
                        }else{
                            Alert dialogo = new Alert(Alert.AlertType.ERROR);
                            dialogo.setTitle("Error");
                            dialogo.setHeaderText("Numero de personal erroneo");
                            dialogo.show();
                        }
                    }
                });
                Button canAl = new Button("Cancelar");
                canAl.setLayoutX(100);
                canAl.setLayoutY(100);
                canAl.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        veriEmp.close();
                    }
                });
                Pane root2 = new Pane();
                root2.getChildren().add(men);
                root2.getChildren().add(tfeal);
                root2.getChildren().add(ingAl);
                root2.getChildren().add(canAl);
                Scene scene2 = new Scene(root2, 200, 150);
                veriEmp.setTitle("Autentificacion usuario");
                veriEmp.setScene(scene2);
                veriEmp.show();
            }
        });
        Button eautolavado = new Button();
        eautolavado.setText("E. AUTOLAVADO");
        eautolavado.setLayoutX(275);
        eautolavado.setLayoutY(100);
        eautolavado.setFont(new Font (20));
        eautolavado.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage veriEmp = new Stage ();
                Label men = new Label ("Ingresa tu numero de personal: ");
                men.setLayoutX(10);
                men.setLayoutY(10);
                TextField tfeal =new TextField ();
                tfeal.setLayoutX(10);
                tfeal.setLayoutY(50);
                Button ingAl = new Button("Ingresar");
                ingAl.setLayoutX(10);
                ingAl.setLayoutY(100);
                ingAl.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        EmpleadoALDao eald= new EmpleadoALDao();
                        int ideal=Integer.parseInt(tfeal.getText());
                        if (eald.bBuscarEmpleadoAL(ideal)){
                            Autolavado al =new Autolavado();
                            //primaryStage.close();
                            veriEmp.close();
                        }else{
                            Alert dialogo = new Alert(Alert.AlertType.ERROR);
                            dialogo.setTitle("Error");
                            dialogo.setHeaderText("Numero de personal erroneo");
                            dialogo.show();
                        }
                    }
                });
                Button canAl = new Button("Cancelar");
                canAl.setLayoutX(100);
                canAl.setLayoutY(100);
                canAl.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        veriEmp.close();
                    }
                });
                Pane root2 = new Pane();
                root2.getChildren().add(men);
                root2.getChildren().add(tfeal);
                root2.getChildren().add(ingAl);
                root2.getChildren().add(canAl);
                Scene scene2 = new Scene(root2, 200, 150);
                veriEmp.setTitle("Autentificacion usuario");
                veriEmp.setScene(scene2);
                veriEmp.show();
                
            }
        });
        
        
        Pane root = new Pane();
        root.getChildren().add(gerente);
        root.getChildren().add(egeneral);
        root.getChildren().add(eautolavado);
        root.getChildren().add(mensaje);
        
        
        Scene scene = new Scene(root, 480, 200);
        
        primaryStage.setTitle("Estacionamiento");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
