package hw;

public enum Weekday {
    SUNDAY(0),
    MONDAY(40),
    TUESDAY(32),
    WEDNESDAY(24),
    THURSDAY(16),
    FRIDAY(8),
    SATURDAY(0);

    private int workingHours;

    public int getWorkingHours() {
        return workingHours;
    }

    Weekday(int workingHours) {
        this.workingHours = workingHours;
    }

    public void getWorkingHoursOne() {
        if (workingHours == 0) {
            System.out.println("Today is a day off");
            return;
        }
        System.out.printf("There are %d hours left until the end of the working week\n", workingHours);
    }


}
