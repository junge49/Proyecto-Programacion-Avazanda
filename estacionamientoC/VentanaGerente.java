package estacionamiento;

import Entity.EmpleadoAL;
import dao.EmpleadoALDao;
import dao.EmpleadoGDao;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author joel_
 */
public class VentanaGerente extends Stage{ 
    public VentanaGerente() {
        Label men,eg, au,ig;
        Button aeg,beg, aau, bau, ing;
        Pane root = new Pane();
        men=new Label("Menú Gerente:");
        men.setLayoutX(10);
        men.setLayoutY(2);
        men.setFont(new Font (40));
        eg=new Label("Empleado General:");
        eg.setLayoutX(50);
        eg.setLayoutY(50);
        eg.setFont(new Font (30));
        au=new Label("Empleado Autolavado:");
        au.setLayoutX(50);
        au.setLayoutY(130);
        au.setFont(new Font(30));
        ig=new Label("Ingresos:");
        ig.setLayoutX(50);
        ig.setLayoutY(200);
        ig.setFont(new Font (30));
        aeg=new Button("Agregar");
        aeg.setLayoutX(250);
        aeg.setLayoutY(100);
        aeg.setFont(new Font (15));
        aeg.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage aEG = new Stage();
                Label men, n, ap, am,tel,dir,fn,gen,s;
                men= new Label("Registrar empleado general: ");
                men.setLayoutX(10);
                men.setLayoutY(0);
                men.setFont(new Font(30));
                n= new Label("Nombre: ");
                n.setLayoutX(10);
                n.setLayoutY(50);
                ap= new Label("A. Paterno: ");
                ap.setLayoutX(10);
                ap.setLayoutY(80);
                am= new Label("A. Materno: ");
                am.setLayoutX(10);
                am.setLayoutY(110);
                tel= new Label("Teléfono: ");
                tel.setLayoutX(10);
                tel.setLayoutY(140);
                dir= new Label("Dirección: ");
                dir.setLayoutX(10);
                dir.setLayoutY(170);
                fn= new Label("F. nacimiento: ");
                fn.setLayoutX(10);
                fn.setLayoutY(260);
                gen= new Label("Género: ");
                gen.setLayoutX(10);
                gen.setLayoutY(200);
                s= new Label("Sueldo: ");
                s.setLayoutX(10);
                s.setLayoutY(230);
                TextField [] campos = new TextField[7];
                int c =0;
                Pane root = new Pane();
                for (int i=0; i<7;i++){
                    campos [i] = new TextField();
                    campos[i].setLayoutX(100);
                    campos[i].setLayoutY(50+c);
                    root.getChildren().add(campos[i]);
                    c+=30;
                }
                DatePicker fnac=new DatePicker();
                fnac.setLayoutX(100);
                fnac.setLayoutY(260);
                Button ag, can;
                ag= new Button("Agregar");
                ag.setLayoutX(50);
                ag.setLayoutY(310);
                ag.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        EmpleadoGDao eg = new EmpleadoGDao();
                        String nom =campos[0].getText();
                        String ap =campos[1].getText();
                        String am =campos[2].getText();
                        int tel = Integer.parseInt(campos[3].getText());
                        String dir=campos[4].getText();
                        Date fn =null;
                        if (fnac.getValue() != null) {
                            fn = new java.sql.Date(fnac.getValue().getYear()-1900,
                            fnac.getValue().getMonthValue()-1,
                            fnac.getValue().getDayOfMonth());
                        }
                        String gen= campos[5].getText();
                        double sueldo=Double.parseDouble(campos[6].getText());
                        eg.insertarEmpleadoG(nom, ap, am, tel, dir, fn, gen, sueldo);
                        aEG.close();
                    }
                });
                can= new Button("Cancelar");
                can.setLayoutX(150);
                can.setLayoutY(310);
                can.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        aEG.close();
                    }
                });
                root.getChildren().addAll(men, n, ap, am, tel,dir,fn,gen,s, ag, can, fnac);
                Scene scene = new Scene(root, 450, 350);
                aEG.setTitle("Agregar usuario");
                aEG.setScene(scene);
                aEG.show();
            }
        });
        beg=new Button("Buscar");
        beg.setLayoutX(350);
        beg.setLayoutY(100);
        beg.setFont(new Font (15));
        beg.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage bus = new Stage();
                Pane root=new Pane();
                Label men, men2;
                men = new Label("Buscar empleado general");
                men.setLayoutX(10);
                men.setLayoutY(0);
                men.setFont(new Font(30));
                men2 = new Label("Ingrese id:");
                men2.setLayoutX(10);
                men2.setLayoutY(40);
                men2.setFont(new Font(20));
                Button buscar=new Button("Buscar");
                buscar.setLayoutX(170);
                buscar.setLayoutY(70);
                TextField b=new TextField();
                b.setLayoutX(10);
                b.setLayoutY(70);
                root.getChildren().addAll(men, men2, buscar, b);
                Scene scene =new Scene (root, 350, 110);
                bus.setTitle("Agregar usuario");
                bus.setScene(scene);
                bus.show();
            }
        });
        aau=new Button("Agregar");
        aau.setLayoutX(250);
        aau.setLayoutY(180);
        aau.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage aEG = new Stage();
                Label men, n, ap, am,tel,dir,fn,gen,s;
                men= new Label("Registrar empleado autolavado: ");
                men.setLayoutX(10);
                men.setLayoutY(0);
                men.setFont(new Font(30));
                n= new Label("Nombre: ");
                n.setLayoutX(10);
                n.setLayoutY(50);
                //n.setFont(new Font(30));
                ap= new Label("A. Paterno: ");
                ap.setLayoutX(10);
                ap.setLayoutY(80);
                am= new Label("A. Materno: ");
                am.setLayoutX(10);
                am.setLayoutY(110);
                tel= new Label("Teléfono: ");
                tel.setLayoutX(10);
                tel.setLayoutY(140);
                dir= new Label("Dirección: ");
                dir.setLayoutX(10);
                dir.setLayoutY(170);
                fn= new Label("F. nacimiento: ");
                fn.setLayoutX(10);
                fn.setLayoutY(260);
                gen= new Label("Género: ");
                gen.setLayoutX(10);
                gen.setLayoutY(200);
                s= new Label("Sueldo: ");
                s.setLayoutX(10);
                s.setLayoutY(230);
                TextField [] campos = new TextField[7];
                int c =0;
                Pane root = new Pane();
                for (int i=0; i<7;i++){
                    campos [i] = new TextField();
                    campos[i].setLayoutX(100);
                    campos[i].setLayoutY(50+c);
                    root.getChildren().add(campos[i]);
                    c+=30;
                }
                DatePicker fnac = new DatePicker();
                fnac.setLayoutX(100);
                fnac.setLayoutY(260);
                Button ag, can;
                ag= new Button("Agregar");
                ag.setLayoutX(50);
                ag.setLayoutY(310);
                ag.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        EmpleadoALDao eg = new EmpleadoALDao();
                        String nom =campos[0].getText();
                        String ap =campos[1].getText();
                        String am =campos[2].getText();
                        int tel = Integer.parseInt(campos[3].getText());
                        String dir=campos[4].getText();
                        Date fn =null;
                        if (fnac.getValue() != null) {
                            fn = new java.sql.Date(fnac.getValue().getYear()-1900,
                            fnac.getValue().getMonthValue()-1,
                            fnac.getValue().getDayOfMonth());
                        }
                        String gen= campos[5].getText();
                        double sueldo=Double.parseDouble(campos[6].getText());
                        eg.insertarEmpleadoAL(nom, ap, am, tel, dir, fn, gen, sueldo);
                        aEG.close();
                    }
                });
                can= new Button("Cancelar");
                can.setLayoutX(150);
                can.setLayoutY(310);
                can.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        aEG.close();
                    }
                });
                root.getChildren().addAll(men, n, ap, am, tel,dir,fn,gen,s, ag, can, fnac);
                Scene scene = new Scene(root, 450, 350);
                aEG.setTitle("Agregar usuario");
                aEG.setScene(scene);
                aEG.show();
            }
        });
        aau.setFont(new Font (15));
        bau=new Button("Buscar");
        bau.setLayoutX(350);
        bau.setLayoutY(180);
        bau.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Stage bus = new Stage();
                Pane root=new Pane();
                Label men, men2;
                men = new Label("Buscar empleado autolavado");
                men.setLayoutX(10);
                men.setLayoutY(0);
                men.setFont(new Font(30));
                men2 = new Label("Ingrese id:");
                men2.setLayoutX(10);
                men2.setLayoutY(40);
                men2.setFont(new Font(20));
                TextField b=new TextField();
                b.setLayoutX(10);
                b.setLayoutY(70);
                Button buscar=new Button("Buscar");
                buscar.setLayoutX(170);
                buscar.setLayoutY(70);
                buscar.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        EmpleadoALDao eald= new EmpleadoALDao();
                        int num=Integer.parseInt(b.getText());
                        if(eald.bBuscarEmpleadoAL(num)){
                            EmpleadoAL al=eald.buscarEmpleadoAL(num);
                            Stage stage= new Stage();
                            Pane root=new Pane();
                            Label ue, id, nom, ap;
                            ue =new Label ("Usuario encontrado:");
                            ue.setLayoutX(10);
                            ue.setLayoutY(0);
                            ue.setFont(new Font (30));
                            id = new Label ("id");
                            id.setLayoutX(10);
                            id.setLayoutY(50);
                            nom = new Label ("nombre");
                            nom.setLayoutX(40);
                            nom.setLayoutY(50);
                            ap = new Label ("A. Paterno");
                            ap.setLayoutX(200);
                            ap.setLayoutY(50);
                            TextField tfn,tfid, tfap;
                            tfid=new TextField();
                            tfid.setText(al.getIdEmpleadoAL()+"");
                            tfid.setLayoutX(10);
                            tfid.setLayoutY(70);
                            tfid.minWidth(20);
                            tfid.minHeight(20);
                            tfn=new TextField();
                            tfn.setText(al.getNombre());
                            tfn.setLayoutX(40);
                            tfn.setLayoutY(70);
                            tfap=new TextField();
                            tfap.setText(al.getAPaterno());
                            tfap.setLayoutX(200);
                            tfap.setLayoutY(70);
                            Button edt, eli, can;
                            edt = new Button ("Editar");
                            edt.setLayoutX(50);
                            edt.setLayoutY(120);
                            edt.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    Stage stage2 = new Stage();
                                    Pane root = new Pane();
                                    Label men, n, ap, am,tel,dir,fn,gen,s;
                                    men= new Label("Actualizar empleado general: ");
                                    men.setLayoutX(10);
                                    men.setLayoutY(0);
                                    men.setFont(new Font(30));
                                    n= new Label("Nombre: ");
                                    n.setLayoutX(10);
                                    n.setLayoutY(50);
                                    ap= new Label("A. Paterno: ");
                                    ap.setLayoutX(10);
                                    ap.setLayoutY(80);
                                    am= new Label("A. Materno: ");
                                    am.setLayoutX(10);
                                    am.setLayoutY(110);
                                    tel= new Label("Teléfono: ");
                                    tel.setLayoutX(10);
                                    tel.setLayoutY(140);
                                    dir= new Label("Dirección: ");
                                    dir.setLayoutX(10);
                                    dir.setLayoutY(170);
                                    fn= new Label("F. nacimiento: ");
                                    fn.setLayoutX(10);
                                    fn.setLayoutY(260);
                                    gen= new Label("Género: ");
                                    gen.setLayoutX(10);
                                    gen.setLayoutY(200);
                                    s= new Label("Sueldo: ");
                                    s.setLayoutX(10);
                                    s.setLayoutY(230);
                                    TextField [] campos = new TextField[7];
                                    int c =0;
                                    for (int i=0; i<7;i++){
                                        campos [i] = new TextField();
                                        campos[i].setLayoutX(100);
                                        campos[i].setLayoutY(50+c);
                                        root.getChildren().add(campos[i]);
                                        c+=30;
                                    }
                                    campos[0].setText(al.getNombre());
                                    campos[1].setText(al.getAPaterno());
                                    campos[2].setText(al.getAMaterno());
                                    campos[3].setText(al.getTelefono()+"");
                                    campos[4].setText(al.getDireccion());
                                    campos[5].setText(al.getGenero());
                                    campos[6].setText(al.getSueldo()+"");
                                    DatePicker fnac=new DatePicker();
                                    fnac.setLayoutX(100);
                                    fnac.setLayoutY(260);
                                    
                                    Button ag, can;
                                    ag= new Button("Actualizar");
                                    ag.setLayoutX(50);
                                    ag.setLayoutY(310);
                                    can= new Button("Cancelar");
                                    can.setLayoutX(150);
                                    can.setLayoutY(310);
                                    can.setOnAction(new EventHandler<ActionEvent>() {

                                    @Override
                                    public void handle(ActionEvent event) {
                                            EmpleadoALDao eg = new EmpleadoALDao();
                                            String nom =campos[0].getText();
                                            String ap =campos[1].getText();
                                            String am =campos[2].getText();
                                            int tel = Integer.parseInt(campos[3].getText());
                                            String dir=campos[4].getText();
                                            Date fn =null;
                                            if (fnac.getValue() != null) {
                                                fn = new java.sql.Date(fnac.getValue().getYear()-1900,
                                                fnac.getValue().getMonthValue()-1,
                                                fnac.getValue().getDayOfMonth());
                                            }
                                            String gen= campos[5].getText();
                                            double sueldo=Double.parseDouble(campos[6].getText());
                                            eg.actualizarEmpleadoAL(al.getIdEmpleadoAL(),nom, ap, am, tel, dir, fn, gen, sueldo);
                                            stage2.close();
                                        }
                                    });
                                    root.getChildren().addAll(men, n, ap, am, tel,dir,fn,gen,s, ag, can, fnac);
                                    Scene scene = new Scene(root, 450, 350);
                                    stage2.setTitle("Editar usuario");
                                    stage2.setScene(scene);
                                    stage2.show();
                                    stage.close();
                                }
                            });
                            eli = new Button ("Eliminar");
                            eli.setLayoutX(120);
                            eli.setLayoutY(120);
                            eli.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
                                    EmpleadoALDao eal=new EmpleadoALDao();
                                    eal.eliminarEmpleadoAL(al.getIdEmpleadoAL());
                                    stage.close();
                                }
                            });
                            can = new Button ("Cancelar");
                            can.setLayoutX(200);
                            can.setLayoutY(120);
                            can.setOnAction(new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {

                                    stage.close();
                                }
                            });
                            root.getChildren().addAll(ue,id,nom,ap, tfid, tfn, tfap, edt,eli, can);
                            Scene scene = new Scene (root,400, 150);
                            stage.setTitle("Gerente");
                            stage.setScene(scene);
                            stage.show();
                            bus.close();
                        }else{
                            Alert dialogo = new Alert(Alert.AlertType.ERROR);
                            dialogo.setTitle("Error");
                            dialogo.setHeaderText("Empleado no encontrado");
                            dialogo.show();
                        }
                    
                    }    
                });
                
                root.getChildren().addAll(men, men2, buscar, b);
                Scene scene =new Scene (root, 400, 110);
                bus.setTitle("Agregar usuario");
                bus.setScene(scene);
                bus.show();
            }
        });
        bau.setFont(new Font (15));
        ing=new Button("Ingresos");
        ing.setLayoutX(150);
        ing.setLayoutY(250);
        ing.setFont(new Font (15));
        root.getChildren().addAll(men,eg,au,ig, aeg, beg, aau, bau, ing);
        Scene scene = new Scene(root, 500, 400);
        
        this.setTitle("Gerente");
        this.setScene(scene);
        this.show();
    }
    
}
