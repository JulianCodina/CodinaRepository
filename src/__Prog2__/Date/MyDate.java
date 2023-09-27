package __Prog2__.Date;

public class MyDate {
    int year;
    int month;
    int day;
    String[] strMonth = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    String[] strDays = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

    //contructor
    MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //Metodos
    boolean isLeapYear(int year){
        if(year % 400 == 0) return true;
        if(year % 100 == 0) return false;
        return year % 4 == 0;
    }
    boolean isValidDate(int year,int month,int day){
        if(month < 1 || month > 12) return false;
        if(isLeapYear(year) && month == 2) return day > 0 && day <= 29;
        return day > 0 && day <= daysInMonth[month - 1];
    }
    int getDayOfWeek(int year, int month, int day){
        int diaSem = (int) (Math.floor(day + (13*(month+1))/5 + year%100 + Math.floor((year%100)/4) + Math.floor((year/100)/4) - 2*(year/100)) % 7);
        return diaSem;
    }
    @Override
    public String toString() {
        return strDays[getDayOfWeek(this.year,this.month,this.day)]+" "+this.day+" "+this.month+" "+this.year;
    }
    MyDate NextDay(){
        for(String e : strDays) {
            if(e.equals(strDays[getDayOfWeek(this.year, this.month, this.day)])){
                System.out.println(strDays[getDayOfWeek(this.year, this.month, this.day)+1]);
            }
        }
        return null;
    }
    MyDate NextMonth(){
        for(String e : strMonth) {
            if(e.equals(strMonth[this.month-1])){
                System.out.println(strMonth[this.month]);
            }
        }
        return null;
    }
    MyDate NextYear(){
        System.out.println(this.year+1);
        return null;
    }
    MyDate PreviousDay(){
        for(String e : strDays) {
            if(e.equals(strDays[getDayOfWeek(this.year, this.month, this.day)])){
                System.out.println(strDays[getDayOfWeek(this.year, this.month, this.day)-1]);
            }
        }
        return null;
    }
    MyDate PreviousMonth(){
        for(String e : strMonth) {
            if(e.equals(strMonth[this.month-1])){
                System.out.println(strMonth[this.month-2]);
            }
        }
        return null;
    }
    MyDate PreviousYear(){
        System.out.println(this.year-1);
        return null;
    }

    //getter y setter
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
