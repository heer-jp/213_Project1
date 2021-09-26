package project1;
/**
 * Creates Album objects utilizing user input.
 * If input is valid, album information from CollectionManager is utilized 
 * to create an Album object. 
 * @author Sai Maduri, Heer Patel
 */
public class Album {
    private String title;
    private String artist;
    private Genre genre;
    private Date releaseDate;
    private boolean isAvailable;
    /**
     * Creates album object with title, artist, genre, and release date elements.
     * @param title given by the user 
     * @param artist given by the user 
     * @param genre given by the user 
     * @param releaseDate given by the user 
     */
    public Album(String title, String artist, Genre genre, Date releaseDate) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = true;
    }
    /**
     * Creates album object with title and artist elements.
     * @param title given by the user
     * @param artist given by the user
     */
    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.genre = null;
        this.releaseDate = null;
        this.isAvailable = false;
    }
    /**
     * Returns album object's song title.
     * @return song title string.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Returns album object's artist name.
     * @return artist name string.
     */
    public String getArtist() {
        return artist;
    }
    /**
     * Returns album object's genre type.
     * @return genre type string.
     */
    public Genre getGenre() {
        return genre;
    }
    /**
     * Returns album object's release date.
     * @return release date string.
     */
    public Date getReleaseDate() {
        return releaseDate;
    }
    /**
     * Returns availability of album object.
     * @return boolean value of album's availability.
     */
    public boolean getAvailability() {
        return isAvailable;
    }
    /**
     * Sets current album object's boolean value isAvailable to isAvailable.
     * @param isAvailable boolean value.
     */
    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    /**
     * Compares album objects.
     * Returns true if albums objects are equal, returns false if they are different.
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (!(obj instanceof Album))
            return false;
        Album album = (Album) obj;
        return album.getTitle().equals(getTitle()) && album.getArtist().equals(getArtist());
    }
    /**
     * Converts album information into a single string printout.
     */
    @Override
    public String toString() {
        if (genre != null && releaseDate != null) {
            String availability = isAvailable ? "is available" : "is not available";
            return title + "::" + artist + "::" + genre + "::" + releaseDate.toString() + "::" + availability;
        } else {
            return title + "::" + artist;
        }
    }
}
