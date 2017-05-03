package obaw.music.trumpet.channel.netease.response;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.Song;

/** Created by xiaowei on 17-5-3. */
public class SongDetailResponse {
  private int code;
  private List<Song> songs;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }
}
