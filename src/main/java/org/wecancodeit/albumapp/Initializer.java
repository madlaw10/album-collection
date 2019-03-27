package org.wecancodeit.albumapp;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.albumapp.models.Album;
import org.wecancodeit.albumapp.models.AlbumComment;
import org.wecancodeit.albumapp.models.Artist;
import org.wecancodeit.albumapp.models.ArtistComment;
import org.wecancodeit.albumapp.models.Song;
import org.wecancodeit.albumapp.models.SongComment;
import org.wecancodeit.albumapp.repositories.AlbumRepository;
import org.wecancodeit.albumapp.repositories.ArtistRepository;
import org.wecancodeit.albumapp.repositories.CommentRepository;
import org.wecancodeit.albumapp.repositories.SongRepository;

@Service
public class Initializer implements CommandLineRunner {
	@Resource
	AlbumRepository albumRepo;
	@Resource
	ArtistRepository artistRepo;
	@Resource
	SongRepository songRepo;
	@Resource
	CommentRepository commentRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Artist artistZero= artistRepo.save(
				new Artist(
						"Elton John", 
						"../images/initializer/Elton John-11.jpg", 
						5));
		Album albumZero= albumRepo.save(
				new Album(
						"Goodbye Yellow Brick Road", 
						"https://images-na.ssl-images-amazon.com/images/I/61h9curIxYL._SY400_.jpg", 
						10,
						artistZero));
		Song songZero = songRepo.save(
				new Song(
						"Goodbye Yellow Brick Road", 
						"3:13", 
						10, 
						albumZero));
		songRepo.save(new Song(
						"Funeral for a Friend", 
						"11:09", 
						10, 
						albumZero));
		songRepo.save(new Song(
						"Candle in the Wind", 
						"3:50", 
						10, 
						albumZero));
		songRepo.save(new Song(
						"Bennie and the Jets", 
						"5:23", 
						10, 
						albumZero));
		songRepo.save(new Song(
						"Saturday Night's Alright for Fighting", 
						"4:57", 
						10, 
						albumZero));
		albumRepo.save(new Album(
						"Don't Shoot Me I'm Only The Piano Player",
						"https://d3c0x8onoccsn3.cloudfront.net/400/400/1505502930discog_dontshootme.jpg",
						8,
						artistZero));
		albumRepo.save(new Album(
						"Elton John's Greatest Hits Volume II", 
						"https://d3c0x8onoccsn3.cloudfront.net/400/400/1505502024discog_ghvolume2.jpg",
						5,
						artistZero));
		albumRepo.save(new Album(
						"Blue Moves", 
						"https://d3c0x8onoccsn3.cloudfront.net/400/800/DB1505502117discog_bluemoves.jpg",
						7,
						artistZero));
		albumRepo.save(new Album(
						"Greatest Hits 1970�2002", 
						"https://i.ebayimg.com/images/g/jaIAAOSwgrZcJoqb/s-l400.jpg",
						2,
						artistZero));
		
		commentRepo.save(new ArtistComment("I love Elton!!!", artistZero));	
		commentRepo.save(new AlbumComment("This album is the greatest, again!", albumZero));	
		commentRepo.save(new SongComment("I cried my eyes out", songZero));
		
		Artist artistOne = artistRepo.save(
				new Artist(
						"John Cena", 
						"../images/initializer/cena.jpg", 
						5));
		Album albumOne= albumRepo.save(
				new Album(
						"Can't See Me", 
						"https://upload.wikimedia.org/wikipedia/en/thumb/f/f9/Cant_See_Me.jpg/220px-Cant_See_Me.jpg", 
						10,
						artistOne));
		Song songOne= songRepo.save(
				new Song(
						"Basic Thuganomics", 
						"4:01", 
						10, 
						albumOne));
		
		
		commentRepo.save(new ArtistComment("Who is he?", artistOne));	
		commentRepo.save(new AlbumComment("I can't see anything!", albumOne));	
		commentRepo.save(new SongComment("What is happening?!?!", songOne));
		
		
		Artist mgmt = artistRepo.save(
				new Artist("MGMT",
						"../images/initializer/mgmt.jpg",
						7));
		Album oa = albumRepo.save(
				new Album(
						"Oracular Spectacular",
						"../images/initializer/oa.jpg",
						8,
						mgmt));
		songRepo.save(
				new Song(
						"Time to Pretend",
						"4:21",
						8,
						oa));
		
		artistRepo.save(new Artist("The Beatles", "../images/initializer/beatles.jpg", 5));
		artistRepo.save(new Artist("George Michael", "../images/initializer/georgemichael.jpg", 5));
		artistRepo.save(new Artist("George Michael", "../images/initializer/michael_cera.jpg", 5));
		artistRepo.save(new Artist("Bob Ross", "../images/initializer/bobross.jpg", 5));
		artistRepo.save(new Artist("Van Gogh", "https://www.thoughtco.com/thmb/P9Mhc4RYHi8dgK5sqDTCW5HhpK0=/400x400/filters:no_upscale():max_bytes(150000):strip_icc()/SueBond-13VanGoghSelfP-Stra-56a6e35b5f9b58b7d0e54bca.jpg", 1));
		artistRepo.save(new Artist("GWAR", "https://pbs.twimg.com/profile_images/636793344513974272/FspNM2JA_400x400.jpg", 666));
		artistRepo.save(new Artist("Jonas Brothers", "https://pbs.twimg.com/profile_images/1105726641895100416/ZIa6THm7_400x400.png", 3));
		artistRepo.save(new Artist("BTS", "https://pbs.twimg.com/profile_images/1012002776954621955/7tnbbhbH_400x400.jpg", 10));
		artistRepo.save(new Artist("LMFAO","https://www.hotnewhiphop.com/image/500x500/cover/1342213215_2d367a6dde08e07b7350ef4af2016661.jpg/8a9ca32b863478032c0decb6a76c2dca/1342213215_lmfao.jpg", 8));
		artistRepo.save(new Artist("Prison Mike", "../images/initializer/prisonmike.jpg", 6));
		artistRepo.save(new Artist("Nas", "../images/initializer/nas.jpg", 10));
		artistRepo.save(new Artist("DJ Tanner", "../images/initializer/djt.jpg", 6));
		artistRepo.save(new Artist("Led Zeppelin", "../images/initializer/led.jpg", 10));
		artistRepo.save(new Artist("Pink Floyd", "../images/initializer/pf.jpg", 10));
		artistRepo.save(new Artist("Queen", "../images/initializer/queen.jpg", 10));
		artistRepo.save(new Artist("Fleetwood Mac", "../images/initializer/fleet.jpg", 10));
		artistRepo.save(new Artist("Cream", "../images/initializer/cream.jpg", 10));
		artistRepo.save(new Artist("Velvet Underground", "../images/initializer/velvet.jpg", 10));
		artistRepo.save(new Artist("Rush", "../images/initializer/rush.jpg", 10));
		artistRepo.save(new Artist("Wu-Tang Clan", "../images/initializer/wu.png", 10));
		artistRepo.save(new Artist("Jon Lajoie", "../images/initializer/jon.jpg", 10));
		artistRepo.save(new Artist("Flight of the Conchords", "../images/initializer/flight.jpg", 10));
		artistRepo.save(new Artist("Prestige Worldwide", "../images/initializer/pw.jpg", 10));
		artistRepo.save(new Artist("Faith + 1", "../images/initializer/f1.jpg", 10));
		artistRepo.save(new Artist("2gether", "../images/initializer/2gether.jpg", 10));
	}

}
