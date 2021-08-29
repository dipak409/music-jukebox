package com.niit;

import com.niit.DAO.*;
import com.niit.DAO.Impl.*;
import com.niit.model.*;

import java.nio.file.NoSuchFileException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        int choice =0,choice1=0;
        Scanner scanner = new Scanner(System.in);

        GenresDAO genresDAO= new GenresDAOImpl();
        ArtistDAO artistDAO = new ArtistDAOImpl();
        SongDAO songDAO = new SongDAOImpl();
        PlaylistDAO playlistDAO = new PlaylistDAOImpl();
        PodcastDAO podcastDAO=new PodcastDAOImpl();
        CatalogDAO catalogDAO= new CatalogDAOImpl();
        AlbumDAO albumDAO=new AlbumDAOImpl();

        System.out.println("-------------------- Welcome to JukeBox ---------------------");
        try {
            do {

                System.out.println(" 1. Song \n 2. Podcast \n " +
                        "3. Genre \n 4. Artist\n 5. Playlist\n " +
                        "6. Catalog\n 7. Album \n 8. Exit");
                System.out.println("===========================================================");
                choice1 = scanner.nextInt();

                switch (choice1) {
                    case 1:
                        do {
                            System.out.println(" \n 1. Add song\n 2. Delete Song name \n 3. Search song details from song name" +
                                    "\n 4. Search Artist name from song name\n 5. Play Song \n 6. Display All Songs \n 7. Back");
                            choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    System.out.println("-------------------------- Song ----------------------------------");
                                    System.out.println("******************** Add New Song *****************************");
                                    System.out.println("Enter song ID ::");
                                    int songId = scanner.nextInt();
                                    System.out.println("Enter song Name ::");
                                    String songName = scanner.next();
                                    System.out.println("Enter Duration ::");
                                    String songDuration = scanner.next();
                                    System.out.println("Enter Location of song ::");
                                    String songPath = scanner.next();
                                    System.out.println("Enter Artist ID ::");
                                    int songArtistId = scanner.nextInt();

                                    Song song = new Song(songId, songName, songDuration, songPath, songArtistId);
                                    boolean resultSong = songDAO.addSong(song);
                                    if (resultSong) {
                                        System.out.println("song Name = " + song.getsName() + " inserted successfully.");
                                    } else {
                                        System.out.println("song Name = " + song.getsName() + " is not inserted successfully.");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("******************** Delete Song Name *********************");
                                    System.out.println("Enter song id :: ");
                                    songId = scanner.nextInt();
                                    Song song2 = songDAO.getSongById(songId);
                                    boolean resultSong2 = songDAO.deleteSongById(songId);
                                    if (resultSong2) {
                                        System.out.println(song2.getsId() + " is successfully Deleted");
                                    } else {
                                        System.out.println("Song Id is not Deleted.");
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("******************** Search Song Details By Song Name *********************");
                                    System.out.println("Enter Song name :: ");
                                    songName = scanner.next();
                                    Song song1 = songDAO.searchBySongName(songName);
                                    System.out.println("\n" + song1.toString());

                                    break;


                                case 4:
                                    System.out.println("*********************** Search Artist By Song Name ***********************");
                                    System.out.println("Enter Song Name :: ");
                                    String songName1 = scanner.next();

                                    Artist findArtistName = songDAO.searchByArtistName(songName1);
                                    System.out.println(" Artist Name = " + findArtistName.getaName());
                                    break;
                                case 5:
                                    System.out.println("Enter Song Name ::");
                                    String songName2 = scanner.next();
                                    Song songPath1 = songDAO.getSongPathByName(songName2);
                                    try {

                                        String filePath = songPath1.getSongPath();
                                        AudioPlayerDAO audioPlayer = new AudioPlayerDAOImpl(filePath);
                                        audioPlayer.play();
                                        scanner = new Scanner(System.in);

                                        while (true) {

                                            System.out.println("1. pause");
                                            System.out.println("2. resume");
                                            System.out.println("3. restart");
                                            System.out.println("4. stop");
                                            int c = scanner.nextInt();
                                            audioPlayer.gotoChoice(c);

                                            if (c == 4)
                                                break;
                                        }

                                    }
                                    catch (NoSuchFileException ex) {
                                        ex.printStackTrace();
                                    } catch (Exception ex) {
                                        System.out.println("Error with playing sound.");
                                        ex.printStackTrace();
                                    }
                                    break;
                                case 6:
                                    System.out.println("*************** Display All Song *******************");
                                    List<Song> displaySong = songDAO.getAllSong();
                                    songDAO.displaySong(displaySong);
                                    System.out.println();
                                    break;
                            }

                        } while (choice < 7);
                        System.out.println("--------------------------------------------------------------------------------------");
                    case 2:
                        do {
                            System.out.println("------------------------------------- Podcast ----------------------------------------");
                            System.out.println(" 1. Add Podcast\n 2. Search by Podcast Name\n 3. Search by Podcast Celebrity Name \n 4. Delete By PodcastName\n 5. Display All Podcast \n 6. Back");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("******************** Add New Podcast ******************");

                                    System.out.println("Enter Podcast ID :: ");
                                    int podcastId = scanner.nextInt();
                                    System.out.println("Enter Podcast Name:");
                                    String podcastName = scanner.next();
                                    System.out.println("Enter Celebrity Name:");
                                    String podcastCelebrityName = scanner.next();
                                    System.out.println("Enter Podcast Duration:");
                                    String podcastDuration = scanner.next();
                                    System.out.println("Enter Podcast Date :");
                                    String podcastDate = scanner.next();
                                    System.out.println("Enter Podcast Path:");
                                    String podcastPath = scanner.next();
                                    System.out.println("Enter Artist Id for Podcast:");
                                    int podcastArtistId = scanner.nextInt();

                                    Podcast podcast = new Podcast(podcastId, podcastName, podcastCelebrityName, podcastDuration, podcastDate, podcastPath, podcastArtistId);
                                    boolean resultPodcast = podcastDAO.addPodcast(podcast);
                                    if (resultPodcast) {
                                        System.out.println(podcast.getpName() + " is added successfully");
                                    } else {
                                        System.out.println(podcast.getpName() + " is not added successfully");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("******************** Search By Podcast Name **********************************************");
                                    System.out.println("Enter Podcast Name to search ::");
                                    podcastName = scanner.next();

                                    Podcast podcast1 = podcastDAO.searchPodcastByName(podcastName);
                                    System.out.println("\n" + podcast1.toString());
                                    break;

                                case 3:
                                    System.out.println("******************** Search by Podcast Celebrity Name *********************");
                                    System.out.println("Enter Podcast Celebrity Name ::");
                                    podcastCelebrityName = scanner.next();
                                    Podcast podcast2 = podcastDAO.searchPodcastByCelebrityName(podcastCelebrityName);
                                    System.out.println(podcast2.toString());
                                    System.out.println();
                                    break;

                                case 4:
                                    System.out.println("******************** Delete By PodcastName **********************************************");
                                    System.out.println("Enter PodcastName to be delete :: ");
                                    String podcastName1 = scanner.next();
                                    Podcast deletePodcast = podcastDAO.getPodcastByName(podcastName1);
                                    boolean resultDeletePodcast = podcastDAO.deletePodcastByName(podcastName1);
                                    if (resultDeletePodcast) {
                                        System.out.println(" Podcast " + deletePodcast.getpName() + " is deleted Successfully.");
                                    } else {
                                        System.out.println(" Podcast " + deletePodcast.getpName() + " is not deleted.");
                                    }
                                    System.out.println();
                                    break;
                                case 5:
                                    System.out.println("*************** Display All Podcast *******************");
                                    List<Podcast> displayPodcast = podcastDAO.getAllPodcast();
                                    podcastDAO.displayPodcast(displayPodcast);
                                    System.out.println();
                                    break;

                            }

                        } while (choice < 6);
                        System.out.println("--------------------------------------------------------------------------------------");

                    case 3:
                        do {
                            System.out.println("----------------------------- Genre -------------------------------------------");
                            System.out.println(" 1. Add Genre \n 2. Delete Genre By Id \n 3.Display all genres \n 4. Back");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("******************** Add Genre *********************");
                                    System.out.println("Enter genre ID:");
                                    int genreId = scanner.nextInt();
                                    System.out.println("enter genre Name:");
                                    String genreName = scanner.next();

                                    Genres genres = new Genres(genreId, genreName);
                                    boolean result = genresDAO.addGenres(genres);
                                    if (result) {
                                        System.out.println("Genre id = " + genres.getGenreId() + " added successfully to database");
                                    } else {
                                        System.out.println("Genre id = " + genres.getGenreId() + " is not added successfully to database");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("******************** Delete Genre By Id  *********************");
                                    System.out.println("Enter genre ID :");
                                    genreId = scanner.nextInt();

                                    Genres deleteGenres = genresDAO.getGenresById(genreId);
                                    boolean resultDeleteGenres = genresDAO.deleteGenres(genreId);
                                    System.out.println();
                                    if (resultDeleteGenres) {
                                        System.out.println(" Genre Id " + deleteGenres.getGenreId() + " is deleted Successfully.");
                                    } else {
                                        System.out.println(" Genre Id " + deleteGenres.getGenreId() + " is not deleted.");
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("****************** Display All Genres *****************");
                                    List<Genres> displayGenres = genresDAO.getAllGenres();
                                    genresDAO.displayGenres(displayGenres);
                                    System.out.println();
                                    break;
                            }
                        } while (choice < 4);
                        System.out.println("--------------------------------------------------------------------------------------");

                    case 4:
                        do {
                            System.out.println(" 1. Add Artist \n 2. Delete Artist By Id \n 3. Display Artist \n 4. Back");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("******************** Add New Song *****************************");
                                    System.out.println("Enter Artist ID:");
                                    int artistId = scanner.nextInt();
                                    System.out.println("Enter Artist Name:");
                                    String artistName = scanner.next();
                                    System.out.println("Enter Artist Genre ID:");
                                    int artistGenreId = scanner.nextInt();

                                    Artist artist = new Artist(artistId, artistName, artistGenreId);
                                    boolean resultArtist = artistDAO.addArtist(artist);
                                    if (resultArtist) {
                                        System.out.println();
                                        System.out.println("Artist id = " + artist.getaId() + " inserted successfully.");
                                    } else {
                                        System.out.println("Artist id = " + artist.getaId() + " is not inserted.");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("******************** Delete Artist by Id **********************************************");
                                    System.out.println("Enter ArtistName to be delete");
                                    artistId = scanner.nextInt();
                                    Artist deleteArtist = artistDAO.getArtistById(artistId);
                                    boolean resultDeleteArtist = artistDAO.deleteArtist(artistId);
                                    if (resultDeleteArtist) {
                                        System.out.println();
                                        System.out.println(" Artist Id " + deleteArtist.getaId() + " is deleted Successfully.");
                                    } else {
                                        System.out.println(" Artist Id " + deleteArtist.getaId() + " is not deleted Successfully.");
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("******************* Display All Artist *****************");
                                    List<Artist> allArtist = artistDAO.getAllArtist();
                                    artistDAO.displayArtist(allArtist);
                                    System.out.println();
                                    break;
                            }

                        } while (choice < 4);
                        System.out.println("--------------------------------------------------------------------------------------");
                    case 5:
                        do {
                            System.out.println("------------------------------------------- Playlist --------------------------------");
                            System.out.println(" 1. Display All Playlist\n 2. Add Playlist \n 3. Delete Playlist By Name \n 4. Search Playlist By Name\n " +
                                    "5. Back");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("******************** Display All Playlist ****************************");
                                    List<PlayList> allPlaylist = playlistDAO.getAllPlaylist();
                                    playlistDAO.displayPlayList(allPlaylist);
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("Enter Playlist Id ::");
                                    int playlistId = scanner.nextInt();
                                    System.out.println("Enter Playlist Name ::");
                                    String playlistName = scanner.next();
                                    System.out.println("Enter Playlist Date (DD-MM-YYYY) ::");
                                    String playlistDate = scanner.next();

                                    PlayList playList = new PlayList(playlistId, playlistName, playlistDate);
                                    boolean resultPlaylist = playlistDAO.addPlaylist(playList);
                                    if (resultPlaylist) {
                                        System.out.println();
                                        System.out.println("playList id = " + playList.getPlaylistId() + " inserted successfully.");
                                    } else {
                                        System.out.println("playList id = " + playList.getPlaylistId() + " is not inserted successfully.");
                                    }

                                    System.out.println();
                                    break;

                                case 3:
                                    System.out.println("******************** Delete Playlist By Name ***********************");
                                    System.out.println("Enter Playlist Name");
                                    playlistName = scanner.next();

                                    PlayList playList2 = playlistDAO.getPlaylistByName(playlistName);
                                    boolean resultPlaylist1 = playlistDAO.deletePlaylistByName(playlistName);

                                    if (resultPlaylist1) {
                                        System.out.println();
                                        System.out.println(playList2.getPlaylistName() + " is deleted.");
                                    } else {
                                        System.out.println(playList2.getPlaylistName() + " is not deleted.");
                                    }
                                    System.out.println();
                                    break;

                                case 4:
                                    System.out.println("******************** Search Playlist By Name ***********************");
                                    System.out.println("Enter Playlist Name");
                                    playlistName = scanner.next();

                                    PlayList playList1 = playlistDAO.searchPlaylistByName(playlistName);
                                    System.out.println("\n" + playList1.toString());
                                    System.out.println();
                                    break;
                            }

                        } while (choice < 5);
                        System.out.println("--------------------------------------------------------------------------------------");
                    case 6:
                        do {
                            System.out.println("------------------------------------- Catalog ------------------------------------------------");
                            System.out.println(" 1. Display All Catalog\n 2. Add Catalog\n 3. Delete Catalog\n 4. Search Catalog By Name \n 5. Display Song From Catalog \n" +
                                    " 6. Display Podcast From Catalog \n 7. Play song from playlist \n 8. Back ");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("******************** Display All Catalog ***********************");
                                    List<Catalog> displayCatalog = catalogDAO.getAllCatalog();
                                    catalogDAO.displayCatalog(displayCatalog);
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("******************** Add Catalog **********************");
                                    System.out.println("Enter Catalog Id :: ");
                                    int catalogId = scanner.nextInt();
                                    System.out.println("Enter Catalog Name :: ");
                                    String catalogName = scanner.next();
                                    System.out.println("Enter Catalog Item Id  :: ");
                                    int catalogItem = scanner.nextInt();
                                    System.out.println("Enter Catalog Item Type  :: ");
                                    String catalogType = scanner.next();


                                    Catalog catalog = new Catalog(catalogId, catalogName, catalogItem, catalogType);
                                    boolean addCatalog = catalogDAO.addCatalog(catalog);
                                    if (addCatalog) {
                                        System.out.println(" Catalog " + catalog.getcName() + " is added successfully");
                                    } else {
                                        System.out.println("Catalog is not added sucessfully or have duplicate values");
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("******************** Delete Catalog ***********************");
                                    System.out.println("Enter Catalog ID ");
                                    catalogId = scanner.nextInt();
                                    boolean result = catalogDAO.deleteCatalog(catalogId);
                                    if (result) {
                                        System.out.println(" Catalog is deleted successfully");
                                    } else {
                                        System.out.println("Catalog is Not Deleted");
                                    }
                                    System.out.println();
                                    break;
                                case 4:
                                    System.out.println("****************** Search Catalog By Name *******************");
                                    System.out.println("Enter Catalog Name :: ");
                                    catalogName = scanner.next();
                                    Catalog catalog1 = catalogDAO.searchCatalogByName(catalogName);
                                    System.out.println("\n" + catalog1.toString());
                                    System.out.println();
                                    break;
                                case 5:
                                    System.out.println("*************** Display Song From Catalog *******************");
                                    List<Song> displaySong = catalogDAO.getSongFromCatalog();
                                    catalogDAO.displaySongFromCatalog(displaySong);
                                    System.out.println();
                                    break;
                                case 6:
                                    System.out.println("*************** Display Podcast From Catalog *******************");
                                    List<Podcast> displayPodcast = catalogDAO.getPodcastFromCatalog();
                                    catalogDAO.displayPodcastFromCatalog(displayPodcast);
                                    System.out.println();
                                    break;
                                case 7:
                                    System.out.println("**************** Play song from playlist ********************");
                                    System.out.println("Enter Catalog Name :: ");
                                    catalogName = scanner.next();
                                    Song catalogPlay = catalogDAO.getSongCatalogByName(catalogName);

                                    try {
                                        String filePath = catalogPlay.getSongPath();

                                        AudioPlayerDAO audioPlayer = new AudioPlayerDAOImpl(filePath);
                                        audioPlayer.play();
                                        scanner = new Scanner(System.in);

                                        while (true) {

                                            System.out.println("1. pause");
                                            System.out.println("2. resume");
                                            System.out.println("3. restart");
                                            System.out.println("4. stop");
                                            int c = scanner.nextInt();
                                            audioPlayer.gotoChoice(c);

                                            if (c == 4)
                                                break;
                                        }
                                    }
                                    catch (NoSuchFileException ex) {
                                        ex.printStackTrace();
                                    } catch (Exception ex) {
                                        System.out.println("Error with playing sound.");
                                        ex.printStackTrace();
                                    }
                                    break;
                            }

                        } while (choice < 7);
                        System.out.println("--------------------------------------------------------------------------------------");
                    case 7:
                        do {
                            System.out.println("------------------------------------ Album ----------------------------------------");
                            System.out.println(" 1. Add Album\n 2. Search By Album Date\n 3. Delete By Album Id\n 4. Display Album \n 5. Back");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("****************** Add Album ********************");
                                    System.out.println("Enter Album Id :: ");
                                    int albumId = scanner.nextInt();
                                    System.out.println("Enter Album Name :: ");
                                    String albumName = scanner.next();
                                    System.out.println("Enter Album Date (DD-MM-YYYY) ::");
                                    String albumDate = scanner.next();
                                    System.out.println("Enter Song Id :: ");
                                    int songId = scanner.nextInt();

                                    Album album = new Album(albumId, albumName, albumDate, songId);

                                    boolean resultAlbum = albumDAO.addAlbum(album);
                                    if (resultAlbum) {
                                        System.out.println(album.getAlbumName() + " is added Successfully");
                                    } else {
                                        System.out.println(album.getAlbumName() + " is not added Successfully or have duplicate values");
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("******************** Search By Album Date ********************");
                                    System.out.println("Enter Album date (DD-MM-YYYY) ::");
                                    albumDate = scanner.next();
                                    Album album1 = albumDAO.searchByAlbumDate(albumDate);
                                    System.out.println("\n" + album1.toString());
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("******************** Delete Album By Id **********************");
                                    System.out.println("Enter Album id :: ");
                                    albumId = scanner.nextInt();

                                    Album album2 = albumDAO.getByAlbumId(albumId);
                                    boolean result = albumDAO.deleteByAlbumId(albumId);
                                    if (result) {
                                        System.out.println(album2.getAlbumName() + " is deleted.");
                                    } else {
                                        System.out.println("Album is Not Deleted");
                                    }
                                    System.out.println();
                                    break;
                                case 4:
                                    System.out.println("****************** Display Album *****************");
                                    List<Album> displayAlbum = albumDAO.getAllAlbum();
                                    albumDAO.displayAlbum(displayAlbum);
                                    System.out.println();
                                    break;
                            }

                        } while (choice < 5);
                }
                System.out.println("--------------------------------------------------------------------------------------");
            } while (choice1 < 8);
        }

        catch (InputMismatchException exception)
        {
            System.out.println(exception.toString());
        }
        catch (Exception exception)
        {
            System.out.println(exception.toString());
        }
    }

}