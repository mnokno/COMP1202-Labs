package lab8part3;

public class JetPlane extends Transport implements Refuelable{
    private float fuel;

    public JetPlane(float acceleration, float maxSpeed, float currentSpeed) {
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
