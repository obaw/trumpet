package obaw.music.trumpet.channel.netease.response;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.Song;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:14
 * @describe 歌曲详情响应对象
 */
public class SongDetailRes extends BaseRes {

  private List<Song> songs;

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }
}
