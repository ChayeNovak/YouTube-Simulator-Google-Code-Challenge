package com.google;

import java.util.Collections;
import java.util.List;

/** A class used to represent a video. */
class Video {

  private final String title;
  private final String videoId;
  private final List<String> tags;
  private boolean flagged = false;
  private String flagReason = "";

  Video(String title, String videoId, List<String> tags) {
    this.title = title;
    this.videoId = videoId;
    this.tags = Collections.unmodifiableList(tags);
  }

  /** Returns the title of the video. */
  public String getTitle() {
    return title;
  }

  /** Returns the video id of the video. */
  public String getVideoId() {
    return videoId;
  }

  /** Returns a readonly collection of the tags of the video. */
  public List<String> getTags() {
    return tags;
  }

  public void flagVideo(String reason) {
    flagged = true;
    flagReason = flagReason;
  }

  public String getPlaylistOutput() {
    String outputString = title + " (" + videoId + ") [";
    for (String tag: tags) {
      outputString = outputString + tag + " ";
    }
    outputString = outputString.trim() + "]";
    if (flagged) {
      outputString = outputString + " - FLAGGED (reason: " + flagReason + ")";
    }
    return outputString;
  }


  public boolean isFlagged() {
    return flagged;
  }

  public String getFlagReason() {
    return flagReason;
  }

  public void allowVideo () {
    flagged = false;
    flagReason = "";
  }
}
