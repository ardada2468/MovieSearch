import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Theatre {
    private ArrayList<String> Movies_Showing = new ArrayList<>();
    private ArrayList<Double> Movies_Price = new ArrayList<>();
    private ArrayList<String> Movies_Time = new ArrayList<>();
    private ArrayList<Integer> Movies_Available_Tickets =new ArrayList<>();
    private ArrayList<Double> Movies_Rating = new ArrayList<>();
    private ArrayList<String> Movies_Language = new ArrayList<>();
    private String TheatreName;
    private int i = 0;

// constructor
    public Theatre(String theatreName) {
        TheatreName = theatreName;
    }

    // Sorts by Language
    public void LanguageSort(){
        System.out.println("Enter the Language that you would like to sort by; ");
        Scanner LanguageInput = new Scanner(System.in);
        String UserimputLang = LanguageInput.nextLine(); // takes user input
      for(i = 0; i < Movies_Showing.size(); i++){
            if(Movies_Language.get(i).contains(UserimputLang)){ // Sorts by testing which languages array containes Userimpued Lang
                PrintSingleMovie(i); // Prints the movies accourding to lang.
            }
        }
    }

    // Swaps all Positions of ArrayList
    public void ChangeMoviePositions(int OldIndex, int NewIndex){
           String TempValue_STR_Name = Movies_Showing.get(OldIndex); // Saving the Value in Temp Variable
           Movies_Showing.remove(OldIndex);                         // Delting the old value from Array List
           Movies_Showing.add(NewIndex,TempValue_STR_Name);         // Adding the Value at new Position
                                                                    // Repeat for rest of this class.
        double TempValue_Double_Rating = Movies_Rating.get(OldIndex);
        Movies_Rating.remove(OldIndex);
        Movies_Rating.add(NewIndex,TempValue_Double_Rating);

        String TempValue_STR_lang = Movies_Language.get(OldIndex);
        Movies_Language.remove(OldIndex);
        Movies_Language.add(NewIndex,TempValue_STR_lang);

        String TempValue_STR_Time = Movies_Time.get(OldIndex);
        Movies_Time.remove(OldIndex);
        Movies_Time.add(NewIndex,TempValue_STR_Time);

        int TempValue_Int_Avaliable_Tickets = Movies_Available_Tickets.get(OldIndex);
        Movies_Available_Tickets.remove(OldIndex);
        Movies_Available_Tickets.add(NewIndex,TempValue_Int_Avaliable_Tickets);

        double TempValue_Double_Price = Movies_Price.get(OldIndex);
        Movies_Price.remove(OldIndex);
        Movies_Price.add(NewIndex,TempValue_Double_Price);
    }
    //Sorts By Rating.
    public void RatingSort(){
        System.out.println("Sorting By Ratings");
        for(int i = 0; i < Movies_Rating.size(); i++){          //Runs the code the same number of times as arraylist lenght.
            for(int j = i+1; j < Movies_Rating.size(); j++ ){   // Runs that code inside for the same number of times, to fully sort Array list.
                if(Movies_Rating.get(i) < Movies_Rating.get(j)){ // Tests if the previos value is greater than the first value
                    ChangeMoviePositions(j,i); // if the condtion above is true then it swiches it using the  ChangeMoviePositions method
                }
            }


        }
                PrintAvailableMovies();

    }
// Sorts by Price
    public void PriceSort(){
        System.out.println("Sorting By Price");
        for(int i = 0; i < Movies_Price.size(); i++){
            for(int j = i+1; j < Movies_Price.size(); j++ ){
                if(Movies_Price.get(i) > Movies_Price.get(j)){  // Test to see if the the first value is greater than the seccond value
                    ChangeMoviePositions(j,i);
                }
            }


        }

        PrintAvailableMovies();

    }

public void SortInstructions(){
        System.out.println("Enter 'Lang' -- to filter for languages");
        System.out.println("Enter 'Price' -- to sort (low to high)");
        System.out.println("Enter 'Rating' -- to sort (high to low) ");
}

    public void Sort_Movies(){   // Takes User Imput and Decied what function to activate.
        SortInstructions();
        Scanner UserInput = new Scanner(System.in);
        String UserSort = UserInput.nextLine();
        if(UserSort.equals("Lang") || UserSort.equals("lang")){LanguageSort();}
        if(UserSort.equals("Price") || UserSort.equals("price")){PriceSort();}
        if(UserSort.equals("Rating") || UserSort.equals("rating")){RatingSort();}
        else{System.out.println("Error");}


    }

// Purchasing Method.
    public void buyTickets(){
        int Position;
        System.out.println("Enter the Title of the Movie; ");
        Scanner MovieTitleInput = new Scanner(System.in);
        String UserTitle = MovieTitleInput.nextLine();          // Asks the User What movie he would like to buy tickets too.
        if(Movies_Showing.contains(UserTitle)){                 // Checks if the ArrayList Containing the names inclues the UserInput
            Position =  Movies_Showing.indexOf(UserTitle);     // If it contians it then It gets the index
        }else{Position = -1; }                                 //If it cannot find it it gives it a value of -1; and the next line returns, to prevent a crash.
        if(Position == -1){System.out.println("Title not found!");
        return; }
        if(Movies_Showing.contains(UserTitle) & Movies_Available_Tickets.get(Position) > 0){
            System.out.println("Enter the Amount of Tickets that you would like to Purchase");
            Scanner TicketAmountInput = new Scanner(System.in);
            int ticketAmount  = TicketAmountInput.nextInt();
            if(ticketAmount > Movies_Available_Tickets.get(Position)){
                System.out.println("The Max Amount of Tickets Available Are -- " + Movies_Available_Tickets.get(Position));
                System.out.println("Please Enter A value less then or equal to -- " + Movies_Available_Tickets.get(Position));
                return;
            }
            Double Purchase_Total = Movies_Price.get(Position)* ticketAmount;
            Scanner Confirm = new Scanner(System.in);
            System.out.println("You are Purchasing "+ ticketAmount + " for the movie " + Movies_Showing.get(Position));
            System.out.println("The Total Cost For this Transaction is  -- " + Purchase_Total );
            System.out.println("To continue enter y;\nto cancel enter n");
            String Confirming = Confirm.nextLine();
            if(Confirming.equals("y")){
                int Updated_Availability = Movies_Available_Tickets.get(Position) - ticketAmount;
                Movies_Available_Tickets.remove(Position);
                Movies_Available_Tickets.add(Position, Updated_Availability);
                System.out.println("Transaction Completed");
            }else if(Confirming.equals("n")){
                System.out.println("Transaction Aborted");
            }else{
                System.out.println("Error");
            }
        }else if(Movies_Showing.contains(UserTitle)){
            System.out.println("Sorry, "+ Movies_Showing.get(Position) + " is Sold Out!");
        }else{
            System.out.println("Error");
        } }

// Prints only one movie
    public void PrintSingleMovie(int index){
           index = i;
            System.out.println( "Movie Title -- " + Movies_Showing.get(i));
            System.out.println( "Price -- " + Movies_Price.get(i));
            System.out.println( "Show Time -- " + Movies_Time.get(i));
            System.out.println( "Available Tickets -- " + Movies_Available_Tickets.get(i));
            System.out.println("Rating -- " + Movies_Rating.get(i));
        System.out.println("Language -- " + Movies_Language.get(i));
        System.out.println("-----------------------------------");

    }
//prints all movies.
    public void PrintAvailableMovies(){

        for(i =0; i < Movies_Showing.size(); i++){
            int plusone = i +1;
            System.out.println( plusone + ") Movie Title -- " + Movies_Showing.get(i));
            System.out.println( "Price -- " + Movies_Price.get(i));
            System.out.println( "Show Time -- " + Movies_Time.get(i));
            System.out.println( "Available Tickets -- " + Movies_Available_Tickets.get(i));
            System.out.println("Rating -- " + Movies_Rating.get(i));
            System.out.println("Language -- " + Movies_Language.get(i));
            System.out.println("-----------------------------------");
        }

    }
// User Interface
    public void UI_InterFace(){
        boolean Quit = false;
        System.out.println("Welcome to the " + TheatreName + " Terminal! ");
        PrintCommands();
        while (!Quit){
            System.out.println("Enter A Command; ");
            Scanner UserCommand = new Scanner(System.in);
            String UserInput = UserCommand.nextLine();
            UserInput.toLowerCase();
            if(UserInput.contains("help") || UserInput.contains("help")){PrintCommands();}
            if(UserInput.equals("Buy")||UserInput.equals("buy")){ buyTickets();}
            if(UserInput.equals("Movies") || UserInput.equals("movies") ){PrintAvailableMovies();}
            if(UserInput.equals("Find") || UserInput.equals("find")){Search();}
            if(UserInput.equals("Sort") || UserInput.equals("sort")){Sort_Movies();}
            if(UserInput.equals("Quit!")){Quit = true;}


        }
    }
//search Method
    public void Search(){
        System.out.println("Enter the Title of the Movie that you are searching for");
        Scanner SearchParameter = new Scanner(System.in);
        String Search = SearchParameter.nextLine();
        if(Movies_Showing.contains(Search)){
            System.out.println("Movie Found!");
            int position = Movies_Showing.indexOf(Search);
            PrintSingleMovie(position);
        }else{
            System.out.println("Unable to Find Title, but here are some other movies");
            PrintAvailableMovies();
        }
    }

    public void PrintCommands(){
        System.out.println("Enter 'Help' -- for list of Commands");
        System.out.println("Enter 'Buy' -- To Purchase Tickets");
        System.out.println("Enter 'Movies' -- for list of Movies");
        System.out.println("Enter 'Find' -- to Search for a Movie");
        System.out.println("Enter 'Sort' -- to Sort Movies ");
        System.out.println("Enter 'Quit!' -- To Quit");

    }
// innerclass movie.
    public class Movie{
        String Name;
        Double Price;
        String Time;
        int AmountTickets;
        Double Rating;
        String Language;

            public Movie(String name, Double price, String time, int AmountTickets, double rating, String language ) {
                Name = name;
                Price = price;
                Time = time;
                this.AmountTickets = AmountTickets;
                Language = language;
                Rating = rating;
                Movies_Showing.add(i,Name);
                Movies_Price.add(i,Price);
                Movies_Time.add(i,Time);
                Movies_Available_Tickets.add(i, this.AmountTickets);
                Movies_Rating.add(i, Rating);
                Movies_Language.add(i, Language);
            }



    }


    public ArrayList<String> getMovies_Showing() {
        return Movies_Showing;
    }


    public ArrayList<Double> getMovies_Price() {
        return Movies_Price;
    }

    public ArrayList<String> getMovies_Time() {
        return Movies_Time;
    }

    public String getTheatreName() {
        return TheatreName;
    }

    public int getI() {
        return i;
    }
}

