package AnonymousDemoAndLambdas.Comparator;

public class Song {
    private String tile;
    private String author;
    private double duration;

    public Song(String tile, String author, double duration) {
        this.tile = tile;
        this.author = author;
        this.duration = duration;
    }

    public String getTile() {
        return tile;
    }

    public String getAuthor() {
        return author;
    }

    public double getDuration() {
        return duration;
    }
}
