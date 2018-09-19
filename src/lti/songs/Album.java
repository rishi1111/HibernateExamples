package lti.songs;

import java.util.HashSet;
import java.util.Set;

public class Album {

	private int albumId;
	private String albumName;
	private Set<Song> songs;
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	
	
	public Set<Song> getSongs() {
		return songs == null ? new HashSet<Song>() : songs;
	}
	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	
	
}
