package lab8part3;

public class Car extends RoadVehicle implements Refuelable{
    private float fuel;

    public Car(float acceleration, float maxSpeed, float currentSpeed) {
        super(acceleration, maxSpeed, currentSpeed);
    }

    @Override
    public void Refuel(float amount) {

    }

    @Override
    public void UseFuel(float amount) {

    }

    @Override
    public void SetFuel(float amount) {

    }
}
