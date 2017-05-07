package obaw.music.trumpet.channel.netease.search;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.Page;
import obaw.music.trumpet.channel.netease.model.Song;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:32
 * @describe 搜索歌曲结果
 */
public class SongResult extends Page {

  private List<Song> songs;
  private int songCount;

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }

  public int getSongCount() {
    return songCount;
  }

  public void setSongCount(int songCount) {
    this.songCount = songCount;
  }
}
