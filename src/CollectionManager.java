package project1;

import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * Reads all user input and runs valid commands until terminated.
 * Valid commands, besides termination command, are performed by Collection class.
 * aaaaaaaCommands include Add, Remove, Lend out, Return, and Print albums in a collection as well as Termination. 
 * @author Sai Maduri, Heer Patel
 */
public class CollectionManager {

    public static final int ADD_ALBUM_ARGUMENTS_COUNT = 4;
    public static final int MODIFY_ALBUM_ARGUMENTS_COUNT = 2;
    /**
     * Reads through user input and performs valid commands until terminated.
     * If command is valid StringTokenizer separates the user input line into tokens for readability.
     * The appropriate method is called to perform the command.
     * While loop terminated by Q command.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in); //if we take this and line 14 out it becomes 35 lines with the closing brackets
        Collection collection = new Collection();
        System.out.println("Collection Manager starts running."); //not sure if putting them outside is proper coding
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            StringTokenizer input = new StringTokenizer(command, ",");
            switch (input.nextToken()) {
            case "A":
                addAlbumToCollection(collection, input);
                break;
            case "D":
                removeAlbumFromCollection(collection, input);
                break;
            case "L":
                lendAlbum(collection, input);
                break;
            case "R":
                returnAlbum(collection, input);
                break;
            case "P":
                collection.print();
                break;
            case "PD":
                collection.printByReleaseDate();
                break;
            case "PG":
                collection.printByGenre();
                break;
            case "Q":
            	terminateCollectionManager();
                break;
            default:
                System.out.println("Invalid command!");
            }
        }
    }
    /**
     * Creates an album object to be added to the Collection class albums array.
     * Method sends album input to buildAlbum method.
     * If input is invalid the output is the appropriate statement.
     * If album is valid and not already in the album it gets added to the array in the Collection class and the appropriate statement is output. 
     * If album is already in the collection - album does not get added to the array and the appropriate statement is output. 
     * @param collection object that correlates to the array 
     * @param input user album input
     */
    private void addAlbumToCollection(Collection collection, StringTokenizer input) {
        Album albumToBeAdded = buildAlbum(input);
        if (albumToBeAdded == null) {
            System.out.println("Invalid Date!");
        } else if (collection.add(albumToBeAdded)) {
            System.out.println(albumToBeAdded.toString() + " >> added.");
        } else {
            System.out.println(albumToBeAdded.toString() + " >> is already in the collection.");
        }
    }
    /**
     * Removes album from the Collection class array.
     * If album exist in the array it is deleted and the appropriate statement is printed.
     * If album is not in the array the appropriate statement in printed.
     * @param collection object that correlates to the array 
     * @param input user album input
     */
    private void removeAlbumFromCollection(Collection collection, StringTokenizer input) {
        Album albumToBeDeleted = buildAlbum(input);
        if (collection.remove(albumToBeDeleted)) {
            System.out.println(albumToBeDeleted.toString() + " >> deleted.");
        } else {
            System.out.println(albumToBeDeleted.toString() + " >> is not in the collection.");
        }
    }
    /**
     * Changes album availability to false. 
     * If album exist in the array it's availability status is changed with proper print statement.
     * If album is not in the array the appropriate statement in printed.
     * @param collection object that correlates to the array. 
     * @param input user album input.
     */
    private void lendAlbum(Collection collection, StringTokenizer input) {
        Album albumToBeLended = buildAlbum(input);
        if (collection.lendingOut(albumToBeLended)) {
            System.out.println(albumToBeLended.toString() + " >> lending out and set to not available.");
        } else {
            System.out.println(albumToBeLended.toString() + " >> is not available.");
        }
    }
    /**
     * Changes album availability to true. 
     * If album exist in the array it's availability status is changed with proper print statement.
     * If album is not in the array the appropriate statement in printed.
     * @param collection object that correlates to the array. 
     * @param input user album input.
     */
    private void returnAlbum(Collection collection, StringTokenizer input) {
        Album albumToBeReturned = buildAlbum(input);
        if (collection.returnAlbum(albumToBeReturned)) {
            System.out.println(albumToBeReturned.toString() + " >> returning and set to available.");
        } else {
            System.out.println(albumToBeReturned.toString() + " >> return cannot be completed.");
        }
    }
    /**
     * Creates album object using user input.
     * @param input user album input. 
     * @return the album object if it is valid and created otherwise returns null.
     */
    private Album buildAlbum(StringTokenizer input) {
        if (input.countTokens() == ADD_ALBUM_ARGUMENTS_COUNT) {
            String title = input.nextToken();
            String artist = input.nextToken();
            Genre genre = getGenre(input.nextToken());
            Date releaseDate = new Date(input.nextToken());
            if (!releaseDate.isValid()) {
                return null;
            }
            return new Album(title, artist, genre, releaseDate);
        } else if (input.countTokens() == MODIFY_ALBUM_ARGUMENTS_COUNT) {
            String title = input.nextToken();
            String artist = input.nextToken();
            return new Album(title, artist);
        } else {
            return null;
        }
    }
    /**
     * Allows user to enter genres in lower-case and return the correlating Genre type.
     * @param genre string input.
     * @return the genre data type.
     */
    private Genre getGenre(String genre) {
        switch (genre.toLowerCase()) {
        case "pop":
            return Genre.Pop;
        case "country":
            return Genre.Country;
        case "classical":
            return Genre.Classical;
        case "jazz":
            return Genre.Jazz;
        default:
            return Genre.Unknown;
        }
    }
    /**
     * Terminates program and prints termination statement.
     */
    private static void terminateCollectionManager() {
    	 System.out.println("Collection Manager terminated.");
         System.exit(0);
    }

}
