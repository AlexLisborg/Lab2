import java.awt.*;

/***
 * Abstract superclass defining the attributes of a basic car.
 * @author Eli Uhlin, Alexander Lisborg
 * @version 1.6 21 january 2022
 *
 */
public abstract class Car implements Movable, Positionable{

    /***
     * X coordinate of the car.
     */
    private double x;

    /***
     * Y coordinate of the car.
     */
    private double y;

    /***
     * The direction of the car
     */
    private double angle;

    /***
     * The turn speed of the car.
     */
    private double turnSpeed = Math.PI / 8;

    /***
     * Number of doors on the car
     */
    private final int nrDoors;

    /***
     * Engine power of the car
     */
    private final double enginePower;

    /***
     * The current speed of the car
     */
    private double currentSpeed;

    /***
     * Color of the car
     */
    private Color color;

    /***
     * The car model name
     */
    private String modelName;

    /***
     * the start value of the cars engine.
     */
    private double engineStartValue = 0.1;

    private double size;

    private String texture;

    /**
     * Super constructor for Car object.
     * @param nrDoors the number of doors the car will have.
     * @param enginePower the power of the engine.
     * @param color the color of the car.
     * @param modelName the name of the car model.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName,double size, String texture) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.angle = 0;
        this.size = size;
        this.x = 0;
        this.y = 0;
        this.texture = texture;
        stopEngine();
    }

    /***
     * the speed of acceleration and deacceleration
     * (see functions incrementSpeed and decrementSpeed)
     *
     */
    protected abstract double speedFactor();

    /***
     * Increases currentSpeed with speedFactor times the defined amount.
     * @param amount the amount with which we multiply the speedFactor.
     */
    public void incrementSpeed(double amount){
        if (currentSpeed != 0) {
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
        }
    }

    /***
     * Decreases currentSpeed with speedFactor times the defined amount.
     * @param amount the amount with which we multiply the speedFactor.
     */
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /***
     * Sets currentSpeed to the engineStartValue,
     * allowing for acceleration and deceleration.
     * (see functions incrementSpeed and decrementSpeed)
     */
    public void startEngine(){
        if(currentSpeed == 0) {
            currentSpeed = engineStartValue;
        }
    }

    /***
     * Sets currentSpeed value to zero.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /***
     * Returns the number of doors on the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /***
     * Returns the enginePower of the car.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /***
     * Returns the currentSpeed of the car.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /***
     * Returns the color of the car.
     */
    public Color getColor(){
        return color;
    }

    /***
     *
     * Returns the engine start value.
     */
    public double getEngineStartValue() {return engineStartValue;}

    /***
     * Sets the color of the car.
     * @param clr the color which will be set.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /***
     * Sets the currentSpeed of the car.
     * @param currentSpeed the speed with which the currentSpeed will be set.
     */
    public void setCurrentSpeed(double currentSpeed) {this.currentSpeed = currentSpeed;}

    /***
     * Sets the angle of the car.
     * @param angle the angle which will be set.
     */
    public void setAngle(double angle) {this.angle = Math.toRadians(angle);}

    /***
     *
     * Returns the angle of the car.
     */
    public double getAngle(){ return angle;}

    /***
     *
     * Gets the x value of the car.
     */
    public double getX() {return x;}

    /***
     *
     * Gets the y value of the car.
     */
    public double getY() {return y;}

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void turnLeft(){
        this.angle = this.angle - this.turnSpeed;
    }

    public void turnRight(){
        this.angle = this.angle + this.turnSpeed;
    }


    public void move() {
        this.x = this.x + getCurrentSpeed() * Math.cos(angle);
        this.y = this.y + getCurrentSpeed() * Math.sin(angle);
    }

    /***
     * Increases currentSpeed.
     * @param n the input which decides the amount of incrementSpeed. Input needs to be in interval[0, 1].
     */
    public void gas(double n) {
        if (n > 1 || n < 0) throw new RuntimeException("input needs to be in interval [0, 1]");
        else {
            incrementSpeed(n);
        }

    }

    /***
     *
     * @param n the input which decides the amount of decrementSpeed. Input needs to be in interval[0, 1].
     */
    public void brake(double n){
        if(n > 1 || n < 0)
        {throw new RuntimeException("input needs to be in interval [0, 1]");}

        else decrementSpeed(n);
    }

    public String getTexture() {
        return texture;
    }
}
