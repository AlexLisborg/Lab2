import java.awt.*;

/***
 * Subclass to car, has a unique value trimfactor that is used in speedFactor function.
 * @author Eli Uhlin, Alexander Lisborg
 * @version 1.6 21 january 2022
 */
public class Volvo240 extends Car{

    /***
     * Used to calculate the speedFactor for the Volvo240 car.
     */
    public final static double trimFactor = 1.25;

    /***
     * Constructor for  car Volvo240.
     */
    public Volvo240(){
        super(4,100,Color.black,"Volvo240",2,"pics/Volvo240.jpg");
        //stopEngine();
    }

    /***
     * Calculates the speedFactor for the Volvo240 car.
     * @return speedFactor a unique value used to determine the
     * acceleration of the car in increment and decrement speed
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}







