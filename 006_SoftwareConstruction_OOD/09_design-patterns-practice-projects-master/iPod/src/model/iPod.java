package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;
import model.media.Song;

import java.util.*;

public class iPod implements Iterable<AbstractMedia>{

    private String name;

    // TODO: add fields here which represent this iPod's Movies, Photos, and Songs, they should be of the Collection type
    private Set<AbstractMedia> movies = new HashSet<>();
    private Set<AbstractMedia> songs = new HashSet<>();
    private Set<AbstractMedia> photos = new HashSet<>();

    public iPod(String name) {
        this.name = name;
    }

    // getters
    public String getName() { return name; }
    public Set<AbstractMedia> getMovies() {
        return movies;
    }
    public Set<AbstractMedia> getPhotos() {
        return photos;
    }
    public Set<AbstractMedia> getSongs() {
        return songs;
    }

    public void addMedia(AbstractMedia m) {
        if (m instanceof Movie) {
           movies.add(m);
        }
        else if (m instanceof Song) {
            songs.add(m);
        }
        else if (m instanceof Photo) {
            photos.add(m);
        }
    }
    @Override
    public Iterator<AbstractMedia> iterator() {
        return new AbstractMediaIterator();
    }

    private class AbstractMediaIterator implements Iterator<AbstractMedia> {
        Iterator movieIterator = movies.iterator();
        Iterator songIterator = songs.iterator();
        Iterator photoIterator = photos.iterator();

        @Override
        public boolean hasNext() {
            return movieIterator.hasNext() || songIterator.hasNext() || photoIterator.hasNext();
        }

        @Override
        public AbstractMedia next() {
            if (movieIterator.hasNext()) {
                return (AbstractMedia) movieIterator.next();
            } else if (songIterator.hasNext()) {
                return (AbstractMedia) songIterator.next();
            } else {
                return (AbstractMedia) photoIterator.next();
            }
        }
    }
}