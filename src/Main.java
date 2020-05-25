public class Main {

    public static void main(String[] args) {

        Theatre AMC = new Theatre("AMC Trumbull");

        Theatre.Movie Jaws =  AMC.new Movie( "Jaws", 12.99, "6:00 PM", 50, 8.4, "English");
        Theatre.Movie HappyNewYear =  AMC.new Movie( "Happy New Year", 8.50, "6:00 PM", 50, 5.3, "Hindi");
        Theatre.Movie FastAndFurious =  AMC.new Movie( "Fast And Furious", 9.45, "6:00 PM", 50,7.2, "English");
        Theatre.Movie Frozen =  AMC.new Movie( "Frozen", 17.23, "8:00 PM", 50, 6.5, "English");
        Theatre.Movie JamesBond =  AMC.new Movie( "James Bond", 20.23, "9:00 PM", 50, 6.7, "English");
        Theatre.Movie Badla =  AMC.new Movie( "Badla", 8.23, "4:00 PM", 50, 8.4, "Hindi");
        System.out.println("Movies -- ");
        AMC.PrintAvailableMovies();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        AMC.UI_InterFace();

    }





}
