package project1;
/**
 * Collects and manages Album objects in albums array.
 * Performs functions called by CollectionManager class.
 * Functions include adding and removing Album objects from the array,
 * lending out and returning Album objects - changing their availability status,
 * and printing the array collection in no specified order, by album genres, and or by album release dates
 * @author Sai Maduri, Heer Patel
 */
public class Collection {
    private Album[] albums;
    private int numAlbums;
    /**
     * Collection object array created.
     */
    public Collection() {
        this.albums = new Album[4];
        this.numAlbums = 0;
    }
    /**
     * Finds if an album already exists in array collection.
     * @param album object being searched for.
     * @return index of where the album object is in the array.
     */
    private int find(Album album) {
        for (int i = 0; i < albums.length; i++) {
            if (album.equals(albums[i])) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Returns number of albums in album array.
     * @return number of albums.
     */
    public int getNumAlbums() {
        return numAlbums;
    }
    /**
     * Grows array length if array is full.
     */
    private void grow() {
        Album[] oldAlbums = this.albums;
        int newLength = oldAlbums.length + 4;
        Album[] newAlbums = new Album[newLength];
        for (int i = 0; i < oldAlbums.length; i++) {
            newAlbums[i] = oldAlbums[i];
        }
        this.albums = newAlbums;
    }
    /**
     * Adds album object to albums array.
     * @param album object to be added.
     * @return false if album is not added, true if it is added.
     */
    public boolean add(Album album) {
        for (int i = 0; i < albums.length; i++) {
            if (albums[i] == null) {
                for (int j = i + 1; j < albums.length; j++) {
                    albums[j - 1] = albums[j];
                }
                albums[albums.length - 1] = null;
            }
        }
        int albumIndex = 0;
        for (int i = 0; i < albums.length; i++) {
            if (albums[i] == null) {
                albumIndex = i;
            } else if (albums[i].equals(album)) {
                return false;
            }
        }
        albums[albumIndex] = album;
        numAlbums++;
        if (numAlbums == albums.length)
            grow();
        return true;
    }
    /**
     * Removes album from array if it exists in the array. 
     * @param album object to be deleted.
     * @return false if album is not in array, true if it exists and is removed.
     */
    public boolean remove(Album album) {
        int albumIndex = find(album);
        if (albumIndex < 0)
            return false;
        albums[albumIndex] = null;
        numAlbums--;
        return true;
    }
    /**
     * If album exists changes album availability to false.
     * @param album object to be changed.
     * @return true if changed false if not changed.
     */
    public boolean lendingOut(Album album) {
        int albumIndex = find(album);
        if (albumIndex < 0 || !albums[albumIndex].getAvailability())
            return false;
        albums[albumIndex].setAvailability(false);
        return true;
    }
    /**
     * If album exists changes album availability to true.
     * @param album object to be changed.
     * @return true if changed, false if not changed. 
     */
    public boolean returnAlbum(Album album) {
        int albumIndex = find(album);
        if (albumIndex < 0 || albums[albumIndex].getAvailability())
            return false;
        albums[albumIndex].setAvailability(true);
        return true;
    }
    /** 
     * Prints all albums in array, if array is not empty, in no specified order.
     */
    public void print() {
        if (numAlbums != 0) {
            System.out.println("*List of albums in the collection.");
            for (Album album : albums)
                if (album != null)
                    System.out.println(album);
            System.out.println("*End of list");
        } else {
            System.out.println("The collection is empty!");
        }
    }
    /** 
     * Prints all albums in array, if array is not empty, in order of release date.
     */
    public void printByReleaseDate() {
        for (int i = 0; i < albums.length - 1; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < albums.length; j++) {
                if (albums[j] != null && albums[i] != null) {
                    if (albums[j].getReleaseDate().compareTo(albums[swapIndex].getReleaseDate()) != -1) {
                        swapIndex = j;
                    }
                }
            }
            Album tmpAlbum = albums[swapIndex];
            albums[swapIndex] = albums[i];
            albums[i] = tmpAlbum;
        }
        if (numAlbums != 0) {
            System.out.println("*Album collection by the release dates.");
            for (Album album : albums)
                if (album != null)
                    System.out.println(album);
            System.out.println("*End of list");
        } else {
            System.out.println("The collection is empty!");
        }
    }
    /** 
     * Prints all albums in array, if array is not empty, in order of genre.
     */
    public void printByGenre() {
        for (int i = 0; i < albums.length - 1; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < albums.length; j++) {
                if (albums[j] != null && albums[i] != null) {
                    if (albums[j].getGenre().compareTo(albums[swapIndex].getGenre()) == -1) {
                        swapIndex = j;
                    }
                }
            }
            Album tmpAlbum = albums[swapIndex];
            albums[swapIndex] = albums[i];
            albums[i] = tmpAlbum;
        }
        if (numAlbums != 0) {
            System.out.println("*Album collection by genre.");
            for (Album album : albums)
                if (album != null)
                    System.out.println(album);
            System.out.println("*End of list");
        } else {
            System.out.println("The collection is empty!");
        }
    }
}
