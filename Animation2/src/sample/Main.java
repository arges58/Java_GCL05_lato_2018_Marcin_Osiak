package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.layout.HBox;

import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.geometry.Insets;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Drawing Operations Test");

        Group root = new Group();
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        /*for(int i=0; i<60; i++)
        {
            gc[i] = canvas[i].getGraphicsContext2D();
        }*/

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        final double[] x={0,0,0};
        final double[] y = { 0 ,0,0};
        double z = 120;
        final double[] alfa = {0,0,0};

        int i =0;
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                Calendar time = new GregorianCalendar();
                int seconds = time.get(Calendar.SECOND);
                int hour = time.get(Calendar.HOUR);
                int minute = time.get(Calendar.MINUTE);

                alfa[0] = seconds *(Math.PI / 30.0);
                alfa[1] = minute *(Math.PI / 30.0);
                alfa[2] = hour *(Math.PI / 6);

                x[0] = 210 - z * Math.cos(alfa[0]+Math.PI/2);
                y[0] = 210 - z * Math.sin(alfa[0]+Math.PI/2);
                x[1] = 210 - (z-10) * Math.cos(alfa[1]+Math.PI/2);
                y[1] = 210 - (z-10) * Math.sin(alfa[1]+Math.PI/2);
                x[2] = 210 - (z-30) * Math.cos(alfa[2]+Math.PI/2);
                y[2] = 210 - (z-30) * Math.sin(alfa[2]+Math.PI/2);

                gc.setFill(Color.WHITE);
                gc.setStroke(Color.BLUE);

                gc.fillOval(60,60,300,300);

                gc.setFill(Color.BLACK);
                gc.strokeOval(60, 60, 300, 300);

                double [] xnumbers = new double[13];
                double [] ynumbers = new double[13];
                xnumbers[12] =210 - 130* Math.cos(0*(Math.PI/6) + Math.PI/2);
                ynumbers[12] =210 - 130* Math.sin(0*(Math.PI/6) + Math.PI/2);

                for(int i=1; i<12;i++)
                {
                    xnumbers[i] = 210 - 130* Math.cos(i*(Math.PI/6) + Math.PI/2);
                    ynumbers[i] =210 - 130* Math.sin(i*(Math.PI/6) + Math.PI/2);
                }

                double xhour = 200 + Math.cos(Math.PI/14 + Math.PI/2);
                double yhour = 75 + Math.sin(Math.PI/14 + Math.PI/2);
                gc.fillText("12", xnumbers[12], ynumbers[12]);
                gc.fillText("1", xnumbers[1], ynumbers[1]);
                gc.fillText("2", xnumbers[2], ynumbers[2]);
                gc.fillText("3", xnumbers[3], ynumbers[3]);
                gc.fillText("4", xnumbers[4], ynumbers[4]);
                gc.fillText("5", xnumbers[5], ynumbers[5]);
                gc.fillText("6", xnumbers[6], ynumbers[6]);
                gc.fillText("7", xnumbers[7], ynumbers[7]);
                gc.fillText("8", xnumbers[8], ynumbers[8]);
                gc.fillText("9", xnumbers[9], ynumbers[9]);
                gc.fillText("10", xnumbers[10], ynumbers[10]);
                gc.fillText("11", xnumbers[11], ynumbers[11]);


                gc.strokeLine(210, 210, x[0], y[0]);
                gc.strokeLine(210, 210, x[1], y[1]);
                gc.strokeLine(210, 210, x[2], y[2]);
            }
        };
        timer.start();
               // root.getChildren().add(canvas);
                //primaryStage.setScene(new Scene(root));
               // primaryStage.show();
                //root.getChildren().add(canvas);


    }
    private void drawShapes(GraphicsContext gc, double x, double y){
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLUE);


        gc.strokeOval(60, 60, 300, 300);

        gc.strokeLine(210, 210, x, y);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
