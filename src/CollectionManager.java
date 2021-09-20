package project1;

//figure out if you can S.O.P Collection Manager Runs

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager  {

	Scanner input = new Scanner(System.in);
    	public void run() {

    	while(input.hasNextLine()) { 
    		
    		String command = input.nextLine(); 
    		String [] commandsArray = command.split(","); 
    		
    		switch(commandsArray[0]) { 
    		case "A":
    			Album enterAlbum = combine(commandsArray); 
    			Collection addAlbum = new Collection();
    			addAlbum.add(enterAlbum);
    			break;
    		case "D":
    			Album removeAlbum = combine(commandsArray); 
    			Collection deleteAlbum = new Collection(); 
    			deleteAlbum.remove(removeAlbum);
    			break;
    		case "L":
    			Album lendAlbum = combine(commandsArray); 
    			Collection lendYourAlbum = new Collection(); 
    			lendYourAlbum.lendingOut(lendAlbum);		
    			break;
    		case "R":
    			Album returnedAlbum = combine(commandsArray); 
    			Collection returnMyAlbum = new Collection(); 
    			returnMyAlbum.lendingOut(returnedAlbum);	
    			break;
    		case "P":
    			printAlbum();
    			break;
    		case "PD":
    			printByReleases();
    			break;
    		case "PQ":
    			 printByGenre();
    			break;
    		case "Q":
    			//figure out if you can S.O.P for this
			System.exit(0);	
    			break;
    		default:
    			System.out.print("\nInvalid Command!");
    		}
    		
    		// a bit longer than needs to be but also redundancy
    	}	
    	} 
    	
    	private Album combine(String[] commandsArray) {
    		String title = commandsArray[1];
    		String artist = commandsArray[2];
    		Genre genre = Genre.valueOf(commandsArray[3]);       //DOES NOT WORK
    		Date releaseDate = new Date(commandsArray[4]); // idk if this will work since it already throws at the enum
    		
    		return new Album(title, artist, genre, releaseDate);
    	}
    	private void printAlbum() {
    		Collection print = new Collection();
    		print.print();
    	}
    	private void printByReleases() {
    		Collection print = new Collection();
    		print.printByReleaseDate();
    	}
    	private void printByGenre() {
    		Collection print = new Collection();
    		print.printByGenre();
    	}
    	
    	
}
