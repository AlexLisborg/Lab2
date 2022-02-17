import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:


    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.


    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

    public CarController(String name){
        this.drawPanel = new DrawPanel(800, 800 -240);
        frame = new CarView(name);
    }


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController("CarSim 1.0");

        Car saab95 = new Saab95();
        saab95.setY(100);
        Car scania = new Scania();
        scania.setY(200);
        cc.frame.drawPanel.getCarGroup().add(new Volvo240());
        cc.frame.drawPanel.getCarGroup().add(saab95);
        cc.frame.drawPanel.getCarGroup().add(scania);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

}
