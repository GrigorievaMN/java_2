package hw;

public class Main {
    public static void main(String[] args) {
        Weekday.MONDAY.getWorkingHoursOne();
        getWorkingHoursTwo(Weekday.SATURDAY);

    }

    public static void getWorkingHoursTwo(Weekday weekday) {
        if (weekday.getWorkingHours() == 0) {
            System.out.println("Today is a day off");
            return;
        }
        System.out.printf("There are %d hours left until the end of the working week", weekday.getWorkingHours());
    }


}

