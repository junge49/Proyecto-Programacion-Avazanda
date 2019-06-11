package estacionamiento;

import Entity.Autos;
import dao.AutosDao;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author joel_
 */
public class Espacios extends Stage {

    private Pane root;
    private List<Shape> espacios;
    private Shape forma;
    private List<Autos> autos;
    private AutosDao ad;

    public Espacios() {
        ad = new AutosDao();
        Label numeracion;
        root = new Pane();
        autos=new ArrayList<Autos>();
        espacios = new ArrayList<Shape>();
        int x = 0, y = 0, cont = 1, xl = 0, yl = 0;
        for (int i = 0; i < 20; i++) {
            forma = new Rectangle(10 + x, 10 + y, 120, 150);
            numeracion = new Label((i + 1) + "");
            numeracion.setLayoutX(30 + xl);
            numeracion.setLayoutY(35 + yl);
            numeracion.setFont(new Font(80));
            forma.setFill(Color.GREEN);
            espacios.add(forma);
            root.getChildren().add(forma);
            root.getChildren().add(numeracion);
            if (cont >= 5) {
                x = 0;
                xl = 0;
                y += 160;
                yl += 160;
                cont = 1;
            } else {
                x += 130;
                xl += 130;
                cont++;
            }
        }
        Rectangle r1 = new Rectangle(50, 650, 20, 20);
        r1.setFill(Color.GREEN);
        Rectangle r2 = new Rectangle(200, 650, 20, 20);
        r2.setFill(Color.RED);
        Label dis = new Label("Disponible");
        dis.setLayoutX(80);
        dis.setLayoutY(650);
        Label ocp = new Label("Ocupado");
        ocp.setLayoutX(230);
        ocp.setLayoutY(650);
        autos=ad.regresaAllAutosActivos();
        for (int n=0;n<autos.size();n++){
            int esp=autos.get(n).getIdEspacio();
            espacios.get(esp-1).setFill(Color.RED);
        }
        root.setOnMousePressed((MouseEvent evt) -> {
            double x1 = evt.getX();
            double y1 = evt.getY();
            int cont2 =0;
            for (int i = 0; i < espacios.size(); i++) {
                Shape xforma = espacios.get(i);
               
                if (xforma.contains(x1 - xforma.getTranslateX(), y1 - xforma.getTranslateY())) {
                    if (xforma.getFill().equals(Color.GREEN)){
                        agregarAuto(i);
                        
                    }else if (xforma.getFill().equals(Color.RED)){
                        actualizarAuto(i);
                    }
                }
                cont2 ++;
            }
        });

        root.getChildren().add(r1);
        root.getChildren().add(r2);
        root.getChildren().add(dis);
        root.getChildren().add(ocp);
        Scene scene = new Scene(root, 660, 680);
        this.setTitle("Espacios de estacionamiento");
        this.setScene(scene);
        this.show();
    }

    public void agregarAuto(int pos) {
        Stage stage2 = new Stage();
        Pane root = new Pane();
        Label men, mod, mar, pla, col, ent, lav, ide, sal, pag;
        men = new Label("Registrar Auto: ");
        men.setLayoutX(10);
        men.setLayoutY(0);
        men.setFont(new Font(30));
        mod = new Label("Modelo: ");
        mod.setLayoutX(10);
        mod.setLayoutY(50);
        mar = new Label("Marca: ");
        mar.setLayoutX(10);
        mar.setLayoutY(80);
        pla = new Label("Placa: ");
        pla.setLayoutX(10);
        pla.setLayoutY(110);
        col = new Label("Color: ");
        col.setLayoutX(10);
        col.setLayoutY(140);
        ent = new Label("Entrada: ");
        ent.setLayoutX(10);
        ent.setLayoutY(230);
        lav = new Label("Lavado: ");
        lav.setLayoutX(10);
        lav.setLayoutY(200);
        ide = new Label("idEmpleado: ");
        ide.setLayoutX(10);
        ide.setLayoutY(170);
        TextField[] campos = new TextField[5];
        int c = 0;
        for (int i = 0; i < 5; i++) {
            campos[i] = new TextField();
            campos[i].setLayoutX(100);
            campos[i].setLayoutY(50 + c);
            root.getChildren().add(campos[i]);
            c += 30;
        }
        CheckBox lava= new CheckBox();
        lava.setLayoutX(100);
        lava.setLayoutY(200);
        DatePicker dpe = new DatePicker();
        dpe.setLayoutX(100);
        dpe.setLayoutY(230);
        Button ag, can;
        ag = new Button("Agregar");
        ag.setLayoutX(50);
        ag.setLayoutY(350);
        root.getChildren().addAll(men, mod, mar, pla, col, ent, lav, ide, ag, dpe, lava);
        ag.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String mode=campos[0].getText();
                String morc=campos[1].getText();
                String placa=campos[2].getText();
                String color=campos[3].getText();
                Date de =null;
                if (dpe.getValue() != null) {
                        de = new java.sql.Date(dpe.getValue().getYear()-1900,
                        dpe.getValue().getMonthValue()-1,
                        dpe.getValue().getDayOfMonth());
                }
                int lavado= 0;
                if (lava.isSelected()){
                    lavado=1;
                }
                int idee=Integer.parseInt(campos[4].getText());
                if (ad.insertarAuto(pos+1,mode,morc,placa,color,de,lavado, idee)){
                    espacios.get(pos).setFill(Color.RED);
                    Integer idAutos=Integer.BYTES;
                    Autos a= new Autos(idAutos, pos+1, mode, morc, placa,color, de,lavado,idee);
                    autos.add(a);
                    stage2.close();
                }else{
                    Alert dialogo = new Alert(Alert.AlertType.ERROR);
                    dialogo.setTitle("Error");
                    dialogo.setHeaderText("No se puedo agregar, verifica tus datos.");
                    dialogo.show();
                }
                
            }
        });
        can = new Button("Cancelar");
        can.setLayoutX(150);
        can.setLayoutY(350);
        can.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage2.close();
            }
        });
        root.getChildren().add(can);

        Scene scene = new Scene(root, 300, 410);
        stage2.setTitle("Espacios de estacionamiento");
        stage2.setScene(scene);
        stage2.show();
    }
    
    public void actualizarAuto(int pos) {
        Stage stage2 = new Stage();
        Pane root = new Pane();
        Label men, mod, mar, pla, col, ent, lav, ide, sal, pag;
        men = new Label("Actualizar Auto: ");
        men.setLayoutX(10);
        men.setLayoutY(0);
        men.setFont(new Font(30));
        mod = new Label("Modelo: ");
        mod.setLayoutX(10);
        mod.setLayoutY(50);
        mar = new Label("Marca: ");
        mar.setLayoutX(10);
        mar.setLayoutY(80);
        pla = new Label("Placa: ");
        pla.setLayoutX(10);
        pla.setLayoutY(110);
        col = new Label("Color: ");
        col.setLayoutX(10);
        col.setLayoutY(140);
        ent = new Label("Entrada: ");
        ent.setLayoutX(10);
        ent.setLayoutY(260);
        lav = new Label("Lavado: ");
        lav.setLayoutX(10);
        lav.setLayoutY(230);
        ide = new Label("idEmpleado: ");
        ide.setLayoutX(10);
        ide.setLayoutY(170);
        sal = new Label("Salida: ");
        sal.setLayoutX(10);
        sal.setLayoutY(290);
        pag = new Label("Pago: ");
        pag.setLayoutX(10);
        pag.setLayoutY(200);
        TextField[] campos = new TextField[6];
        int c = 0;
        for (int i = 0; i < 6; i++) {
            campos[i] = new TextField();
            campos[i].setLayoutX(100);
            campos[i].setLayoutY(50 + c);
            root.getChildren().add(campos[i]);
            c += 30;
        }
        CheckBox lava= new CheckBox();
        lava.setLayoutX(100);
        lava.setLayoutY(230);
        DatePicker dpe = new DatePicker();
        dpe.setLayoutX(100);
        dpe.setLayoutY(260);
        DatePicker dps = new DatePicker();
        dps.setLayoutX(100);
        dps.setLayoutY(290);
        for (int j = 0; j < autos.size(); j++){
            if(autos.get(j).getIdEspacio()==pos+1){
                if (autos.get(j).getLavado()==1){
                    lava.setSelected(true);
                }
                campos[0].setText(autos.get(j).getModelo());
                campos[1].setText(autos.get(j).getMarca());
                campos[2].setText(autos.get(j).getPlaca());
                campos[3].setText(autos.get(j).getColor());
                campos[4].setText(autos.get(j).getIdEmpleadoG()+"");
            }
        }
        Button ag, can;
        ag = new Button("Actualizar");
        ag.setLayoutX(50);
        ag.setLayoutY(350);
        root.getChildren().addAll(men, mod, mar, pla, col, ent, lav, ide, ag, dpe, lava, dps, sal, pag);
        ag.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //AutosDao ad = new AutosDao();
                String mode=campos[0].getText();
                String morc=campos[1].getText();
                String placa=campos[2].getText();
                String color=campos[3].getText();
                Date de =null;
                if (dpe.getValue() != null) {
                        de = new java.sql.Date(dpe.getValue().getYear()-1900,
                        dpe.getValue().getMonthValue()-1,
                        dpe.getValue().getDayOfMonth());
                }
                Date ds =null;
                if (dps.getValue() != null) {
                        ds = new java.sql.Date(dps.getValue().getYear()-1900,
                        dps.getValue().getMonthValue()-1,
                        dps.getValue().getDayOfMonth());
                }
                
                int idee=Integer.parseInt(campos[4].getText());
                double pago= Double.parseDouble(campos[5].getText());
                int idA=0,lavado=0;
                for (int k = 0; k < autos.size(); k++){
                    if(autos.get(k).getIdEspacio()==pos+1){
                        idA = autos.get(k).getIdAutos();
                        lavado=autos.get(k).getLavado();
                        autos.get(k).setModelo(mode);
                        autos.get(k).setMarca(morc);
                        autos.get(k).setPlaca(placa);
                        autos.get(k).setColor(color);
                        autos.get(k).setEntrada(de);
                        autos.get(k).setIdEmpleadoG(idee);
                        autos.get(k).setSalida(ds);
                        autos.get(k).setPago(pago);
                    }
                }
                if (ad.actualizarAuto(idA, pos+1,mode,morc,placa,color,de,lavado, idee, ds, pago)){
                    if(autos.get(pos).getPago()!=null){
                        espacios.get(pos).setFill(Color.GREEN);
                    }
                    stage2.close();
                }else{
                    Alert dialogo = new Alert(Alert.AlertType.ERROR);
                    dialogo.setTitle("Error");
                    dialogo.setHeaderText("No se puedo actualizar, verifica tus datos.");
                    dialogo.show();
                }
                
            }
        });
        can = new Button("Cancelar");
        can.setLayoutX(150);
        can.setLayoutY(350);
        can.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage2.close();
            }
        });
        root.getChildren().add(can);

        Scene scene = new Scene(root, 300, 410);
        stage2.setTitle("Espacios de estacionamiento");
        stage2.setScene(scene);
        stage2.show();
    }

}
