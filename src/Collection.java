package project1;

public class Collection {

	private Album[] albums;
	private int numAlbums;
	
	public Collection() {
		this.albums = new Album[4];
		this.numAlbums = 0;
	}
	
	private int find(Album album) {
		for (int i = 0; i < albums.length; i++) {
			if (album.equals(albums[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public int getNumAlbums() {
		return numAlbums;
	}
	
	private void grow() {
		Album[] oldAlbums = this.albums;
		int newLength = oldAlbums.length + 4;
		Album[] newAlbums = new Album[newLength];
		for (int i = 0; i < oldAlbums.length; i++) {
			newAlbums[i] = oldAlbums[i];
		}
		this.albums = newAlbums;
	}
	
	public boolean add(Album album) { 
		int index = 0;
		for (int i = 0 ; i < albums.length; i++) {
			if (albums[i] == null) {
				index = i;
			} else if(albums[i].equals(album)) {
				return false;
			}
		}
		albums[index] = album;
		numAlbums++;
		if (numAlbums == albums.length)
			grow();
		return true;
	}
	
	public boolean remove(Album album) {
		int index = find(album);
		if (index < 0) 
			return false;
		albums[index] = null;
		numAlbums--;
		return true;
	}
	
	public boolean lendingOut(Album album) {
		int index = find(album);
		if (!albums[index].getAvailability())
			return false;
		albums[index].setAvailability(false);
		return true;
	}
	
	public boolean returnAlbum(Album album) {
		int index = find(album);
		if (albums[index].getAvailability())
			return false;
		albums[index].setAvailability(true);
		return true;
	}
	
	public void print() {
		System.out.println("*List of albums in the collection.");
		for (Album album : albums) 
			if (album != null)
				System.out.println(album);
		System.out.println("*End of list.");
	}
	
	public void printByReleaseDate() {
		
	}
	
	public void printByGenre() {
		
		
	}
	
	public static void main(String[] args) {
		Collection collection = new Collection();
		System.out.println(collection.add(new Album("Change", "Anika", Genre.Pop, new Date("7/23/2021"), true)));
		System.out.println(collection.add(new Album("Change", "Anika", Genre.Pop, new Date("7/23/2021"), true)));
		System.out.println(collection.add(new Album("Change", "April March", Genre.Pop, new Date("7/23/2021"), true)));
		System.out.println(collection.add(new Album("Spiral", "Darkside", Genre.Pop, new Date("7/1/2021"), true)));
		System.out.println(collection.add(new Album("Debussy:La Mer", "Leonard Bernstein", Genre.Classical, new Date("2/28/1995"), true)));
		System.out.println(collection.add(new Album("Debussy:La Mer", "Gary Bertini", Genre.Classical, new Date("1/1/2006"), true)));
		System.out.println(collection.add(new Album("Debussy:La Mer", "Leonard Bernstein", Genre.Classical, new Date("2/28/1995"), true)));
		collection.print();
		System.out.print(collection.numAlbums);
		System.out.println(collection.remove(new Album("Change", "April March")));
		collection.print();
		System.out.println(collection.add(new Album("Change", "April March", Genre.Pop, new Date("7/23/2021"), true)));
		System.out.println(collection.lendingOut(new Album("Change", "April March")));
		System.out.println(collection.lendingOut(new Album("Change", "April March")));
		System.out.println(collection.returnAlbum(new Album("Change", "April March")));
		System.out.println(collection.returnAlbum(new Album("Change", "April March")));
		System.out.println(collection.lendingOut(new Album("Change", "April March")));
		System.out.println(collection.add(new Album("Change", "Anika", Genre.Pop, new Date("7/23/2021"), true)));
		System.out.println(collection.add(new Album("Change", "Anika", Genre.Pop, new Date("7/23/2021"), true)));
		System.out.println(collection.add(new Album("Change", "Anika", Genre.Pop, new Date("7/23/2021"), true)));
		System.out.println(collection.remove(new Album("Chang", "Anika")));
		collection.print();

	}
}

