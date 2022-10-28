package lab8part3;

public abstract class Transport {

    private float currentSpeed;
    private float acceleration;
    private float maxSpeed;

    public Transport(float acceleration, float maxSpeed, float currentSpeed){
        this.currentSpeed = currentSpeed;
        this.acceleration = acceleration;
        this.maxSpeed = maxSpeed;
    }

    public float getCurrentSpeed(){
        return currentSpeed;
    }

    public void accelerate(float amount){

    }

    public void deAccelerate(float amount){

    }
}
