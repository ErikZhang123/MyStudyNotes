package AnonymousDemoAndLambdas.Comparator;

import java.util.*;

public class compareDemo {
    public static void main(String[] args) {
        ArrayList<Song> songs = new ArrayList<>();
        Song a = new Song("a","c",100);
        Song b = new Song("b","b",50);

        songs.add(b);
        songs.add(a);
        Comparator<Song> titlesort = new Comparator<Song>(){
            @Override
            public int compare(Song o1, Song o2) {
                int i = o1.getTile().compareTo(o2.getTile());
                return i;
            }
        };

        Comparator<Song> authorsort = (o1,o2) -> {
            int i = o1.getAuthor().compareTo(o2.getAuthor());
            return i ;
        };
        // 形式3： 
        songs.sort((o1,o2) -> (int) (o2.getDuration()-o1.getDuration()));

        for (Song s :songs) {
            System.out.println(s.getTile());
        }
    }
}
