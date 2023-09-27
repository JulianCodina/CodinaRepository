package __Prog2__.Date;

public class main {
    public static void main(String[] args) {
        MyDate date = new MyDate(2023, 9, 24);

        System.out.println("Fecha actual: " + date.toString());

        int dayOfWeek = date.getDayOfWeek(date.getYear(), date.getMonth(), date.getDay());
        System.out.println("Día de la semana: " + date.strDays[dayOfWeek]);

        boolean leapYear = date.isLeapYear(date.getYear());
        System.out.println("¿Es año bisiesto? " + leapYear);

        MyDate nextDay = date.NextDay();
        MyDate nextMonth = date.NextMonth();
        MyDate nextYear = date.NextYear();

        MyDate previousDay = date.PreviousDay();
        MyDate previousMonth = date.PreviousMonth();
        MyDate previousYear = date.PreviousYear();
    }
}
