package MyHallBooking2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class Booking implements Comparable<Booking> {
    final LocalTime BOOKING_START_HOUR = LocalTime.of(8, 0);// OPEN SHOP
    final LocalTime BOOKING_END_HOUR = LocalTime.of(23, 30); // CLOSE SHOP
    private Customer customer;
    private Hall hall;
    private LocalTime startHour;
    private LocalTime endHour;
    private LocalDate dateBooking;// date of booking

    // default badminton hall
    public Booking() {
        customer = new Customer();
        hall = new BadmintonHall();
        dateBooking = LocalDate.now();

    }

    public Booking(String HallType) {
        if (HallType.equalsIgnoreCase("Futsal Hall"))
            hall = new FutsalCourt();
        else
            hall = new BadmintonHall();

        customer = new Customer();
        dateBooking = LocalDate.now();
    }

    public Booking(Hall newHall) {
        hall = newHall;
        customer = new Customer();
        dateBooking = LocalDate.now();
    }


    //TODO build more constructor if needed

    public LocalTime getStartHour() {
        return startHour;
    }

    //LocalTime.parse("10:15:30")
    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public void setStartHour(String str) {
        LocalTime StartHour = LocalTime.parse(str);
        this.startHour = StartHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public void setEndHour(String str) {
        LocalTime EndHour = LocalTime.parse(str);
        this.endHour = EndHour;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getHallName() {
        return hall.getHallName();
    }

    public void setHallName(String name) {
        hall.setHallName(name);
    }

    public String getHallType() {
        return hall.getHallType();
    }

    public void setHallType(String type) {
        hall.setHallType(type);
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public void setCustomerName(String name) {
        customer.setName(name);
    }

    public String getCustomerEmail() {
        return customer.getEmail();
    }

    public void setCustomerEmail(String email) {
        customer.setEmail(email);
    }

    public String getCustomerPhoneNumber() {
        return customer.getPhoneNumber();
    }

    public void setCustomerPhoneNumber(String phoneNum) {
        customer.setPhoneNumber(phoneNum);
    }

    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    public boolean isHourSettingCorrect() {
        boolean checkHour = (startHour.compareTo(endHour) == -1) && (startHour.compareTo(BOOKING_START_HOUR) == 1) && (endHour.compareTo(BOOKING_END_HOUR) == -1);
        return checkHour;
    }

    public double getTotalHour() {
        return (startHour.until(endHour, ChronoUnit.HOURS) + (((startHour.until(endHour, ChronoUnit.MINUTES)) % 60.0) / 60.0));
    }

    public double getTotalPayment() {
        if (hall instanceof BadmintonHall) {
            return getTotalHour() * BadmintonHall.HOURLY_RATE;
        } else if (hall instanceof FutsalCourt) {
            return getTotalHour() * FutsalCourt.HOURLY_RATE;
        } else {
            ConfirmBox.display("Error","This variable is not instance of any class in this package",",","Please Recheck the Code",".");
            return 0;
        }
    }

    public double getHallDeposit() {
        return hall.getDeposit();
    }

    public String getHalltoString() {
        return hall.toString();
    }


    @Override
    public int compareTo(Booking o) {
        int result;
        if (this.dateBooking.compareTo(o.getDateBooking()) == 1) {
            result = 1;
        } else if (this.dateBooking.compareTo(o.getDateBooking()) == 0) {
            if (this.startHour.compareTo(o.getStartHour()) == -1) {
                result = 1;
            } else if (this.startHour.compareTo(o.getStartHour()) == 0) {
                if (this.endHour.compareTo(o.getEndHour()) == -1) {
                    result = 1;
                } else if (this.endHour.compareTo(o.getEndHour()) == 0) {
                    if (this.getHallName().compareTo(o.getHallName()) == 1) {
                        result = 1;
                    } else if (this.getHallName().compareTo(o.getHallName()) == 0) {
                        result = 0;
                    } else {
                        result = -1;
                    }

                } else {
                    result = -1;
                }

            } else {
                result = -1;
            }
        } else {
            result = -1;
        }
        return result;
    }

}
