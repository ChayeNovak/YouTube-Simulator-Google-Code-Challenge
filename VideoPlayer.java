package com.google;

import java.io.*;
import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private final List<Video> videos;
  private Video currVideo;
  private boolean isPaused = true;
  private final HashMap<String, Video> videosPerId;
  private TreeMap<String, VideoPlaylist> playlist;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    this.videosPerId = videoLibrary.getVideos();
    this.videos = new ArrayList<>(this.videosPerId.values());
    playlist = new TreeMap();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    // Used a tree map for this instead of hash so that there will be no null keys
    TreeMap<String, Video> lexoVideos = new TreeMap();
    // iterate through and add videos to playlist
    for (Video vids : videos) {
      lexoVideos.put(vids.getTitle(), vids);
    }
    // Output playlist
    System.out.println("Here's a list of all available videos:");

    for (Video vids : lexoVideos.values()) {
      System.out.println(vids.getPlaylistOutput());
    }
  }

  public void playVideo(String videoId) {
    Video vid = videosPerId.get(videoId); // Check if a video matches given ID
    if (vid == null) {
      System.out.println("Cannot play video: Video does not exist");
      return;
    }
    // Check if video has been flagged, if so prevent it from running and provide the reasoning behind it
    if (vid.isFlagged()) {
      System.out.println("Cannot play video: Video is currently flagged (reason " + vid.getFlagReason() + ")");
      return;
    }

    if (!(currVideo == null)) {
      System.out.println("Stopping video: " + currVideo.getTitle());
    }

    // Play given video and output the title
    currVideo = vid;
    System.out.println("Playing video: " + currVideo.getTitle());
    isPaused = false;
    //System.out.println("playVideo needs implementation");
  }

  public void stopVideo() {
    if (!(currVideo == null)) {
      System.out.println("Stopping video: " + currVideo.getTitle());
    } else {
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }
  // Retrieve a list of all unflagged videos
  private List<Video> getUnflaggedVids() {
    List<Video> unflaggedvids = new ArrayList<>();
    for (Video vids : videos) {
      if (!vids.isFlagged()) {
        unflaggedvids.add(vids);
      }
    }
    return unflaggedvids;
  }
    public void playRandomVideo() {
      // make sure flagged videos don't play by only retrieving unflagged videos
      List<Video> unflaggedVids = getUnflaggedVids();

      int numVids = unflaggedVids.size();
      if (numVids == 0) {
        //No videos available, we print a warning message and end the method
        System.out.println("No videos available");
        return;
      }
      // Get random video
      Random random = new Random();
      Video randomVideo = unflaggedVids.get(random.nextInt(numVids));
      playVideo(randomVideo.getVideoId());
    }

  public void pauseVideo() {
    // No video playing
    if (currVideo == null) {
      System.out.println("Cannot pause video: No video is currently playing");
    }
    // Video is already paused
    else if (isPaused) {
      System.out.println("Video already paused: " + currVideo.getTitle());
    }
    else {
      // Pause the video
      System.out.println("Pausing video: " + currVideo.getTitle());
      isPaused = true; // flag video as paused
    }
  }

  public void continueVideo() {
    // No vid playing
    if (currVideo == null) {
      System.out.println("Cannot continue video: No video is currently playing");
    }
    // video is paused, continue
    else if (isPaused) {
      System.out.println("Continuing video: " + currVideo.getTitle());
      isPaused = false; // reset pause status
    }
    // video not paused error message
    else {
      System.out.println("Cannot continue video: Video is not paused");
    }
  }

  public void showPlaying() {
    System.out.println("showPlaying needs implementation");
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}