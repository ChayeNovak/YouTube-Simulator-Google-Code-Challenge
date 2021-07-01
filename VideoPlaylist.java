package com.google;

import java.util.ArrayList;
/** A class used to represent a Playlist */
class VideoPlaylist extends ArrayList<Video>{

    private final String playlistName;

    public VideoPlaylist(String name) {
        super();
        this.playlistName = name;
    }

    public String getPlaylistName() {
        return playlistName;
    }
}
