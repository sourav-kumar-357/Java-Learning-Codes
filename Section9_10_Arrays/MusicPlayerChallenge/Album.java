package Section9_10_Arrays.MusicPlayerChallenge;

/*Class with operations */

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
     private String name;
     private String artist;
     private ArrayList<Song> songs;

     public Album(String name, String artist) {
          this.name = name;
          this.artist = artist;
          this.songs = new ArrayList<>();
     }

     public boolean addSong(String title, double duration) {
          if (findSong(title) == null) {
               this.songs.add(new Song(title, duration));
               return true;
          }
          return false;
     }

     private Song findSong(String title) {
          for (Song checkedSong : this.songs) {
               if (checkedSong.getTitle().equals(title)) {
                    return checkedSong;
               }
          }
          return null;
     }

     public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
          int index = trackNumber - 1;
          if ((index > 0) && (index <= this.songs.size())) {
               playList.add(this.songs.get(index));
               return true;
          }
          System.out.println("This album does not have a track " + trackNumber);
          return false;
     }

     public boolean addToPlayList(String title, LinkedList<Song> playList) {
          Song checkedSong = findSong(title);
          if (checkedSong != null) {
               playList.add(checkedSong);
               return true;
          }
          System.out.println("The song " + title + " is not in this album");
          return false;
     }
}
