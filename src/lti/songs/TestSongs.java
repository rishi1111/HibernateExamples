package lti.songs;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.util.HibernateUtil;

public class TestSongs {

	
	@Test
	public void testCase1() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Genre g1 = new Genre();
		g1.setGenreName("Hip Hop");
		
		Artist art1 = new Artist();
		art1.setArtistName("Ice Cube");
		
		
		Album alb1 = new Album();
		alb1.setAlbumName("The Predator");
		
		Song s1 = new Song();
		s1.setSongName("It was a good day");
		s1.setGenre(g1);
		s1.setArtist(art1);
		s1.setAlbum(alb1);
		
		Song s2 = new Song();
		s2.setSongName("Im Scared");
		s2.setGenre(g1);
		s2.setArtist(art1);
		s2.setAlbum(alb1);
		
		
		HashSet<Song> songs = new HashSet<>();
		HashSet<Album> albums = new HashSet<>();
		songs.add(s1);
		songs.add(s2);
		albums.add(alb1);
		alb1.setSongs(songs);
		
		art1.setSongs(songs);
		art1.setAlbums(albums);
		
		
		session.save(g1);
		session.save(art1);
		session.save(alb1);
		session.save(s1);
		session.save(s2);

		tx.commit();
		
	}
	
}
