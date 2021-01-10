package MyHallBooking2;

public abstract class Hall {
    final static double MAX_DEPOSIT = 100;
    private String hallName;
    private String hallType;


    protected Hall() {
    }

    protected Hall(String HallName) {
        this();
        hallName = HallName;
    }

    protected Hall(String HallName, String HallType) {
        hallName = HallName;

        hallType = HallType;
    }

    // getter

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    // setter

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    // useful abstract methods
    public abstract double getDeposit();

    public abstract String toString();
}
