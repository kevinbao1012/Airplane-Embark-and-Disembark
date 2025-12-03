package LA5Q;

import java.util.*;

public class AirplaneLogic {

    //use queue for boarding because we want first come first serve basis, and also this way, passengers who sit at the back enter first, and move up to the front of the plane
    private Queue<String> boardingLine = new LinkedList<>();

    //Arraylist for the seated passengers list so we can access and/or print by index
    private List<String> seatedPassengers = new ArrayList<>();

    //stack for disembark because we want the people at the front of the plane to get off first, then move towards the back (LIFO)
    private Stack<String> disembarkLine = new Stack<>();

    //letters for each seat in a row
    private final char[] seatLetters = {'A', 'B', 'C', 'D', 'E', 'F'};

    //method to add passenger onto the boarding line
    public void addPassenger(Scanner scanner) {
        //get the passnger info
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        //add to the boarding line
        boardingLine.add(name);
        System.out.println(name + " added to boarding line.");
    }

    //method to board passenger onto the plane
    public void boardPassenger() {
        //base case
        if (boardingLine.isEmpty()) {
            System.out.println("No passengers waiting to board.");
            return;
        }

        //gets the name of passenger that will get on the plane
        String passenger = boardingLine.poll();

        // Assign seat
        int index = seatedPassengers.size();
        int row = (index / 6) + 1;
        char letter = seatLetters[index % 6];
        String seat = row + "" + letter;

        //inform where the passenger is sitting
        String seatedInfo = passenger + " (" + seat + ")";
        seatedPassengers.add(seatedInfo);

        System.out.println(passenger + " has boarded and is assigned seat " + seat + ".");
    }

    //method to view the current state of the boarding line
    public void viewBoardingLine() {
        //base case
        if (boardingLine.isEmpty())
            System.out.println("The boarding line is empty.");
        else
            System.out.println("Passengers in boarding line: " + boardingLine);
    }

    //method to view everyone currently sitting on the plane
    public void viewSeatedPassengers() {
        if (seatedPassengers.isEmpty())
            System.out.println("No passengers have boarded yet.");
        else
            System.out.println("Seated passengers: " + seatedPassengers);
    }

    //method for when we start to disembark
    public void prepareDisembark() {
        if (seatedPassengers.isEmpty()) {
            System.out.println("No passengers to disembark.");
            return;
        }

        //reset, make sure the line is clear to begin with
        disembarkLine.clear();

        //add in all the currently seated passengers front to back
        for (int i = seatedPassengers.size() - 1; i >= 0; i--) {
            disembarkLine.push(seatedPassengers.get(i));
        }

        System.out.println("Disembarking process has begun.");
    }

    //method to disembark passenger off the plane
    public void disembarkPassenger() {
        if (disembarkLine.isEmpty()) {
            System.out.println("No more passengers to disembark.");
            return;
        }

        String passenger = disembarkLine.pop();
        System.out.println(passenger + " has disembarked.");
    }
}
