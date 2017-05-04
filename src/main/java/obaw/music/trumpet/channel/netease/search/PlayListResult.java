package obaw.music.trumpet.channel.netease.search;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.PlayList;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:44
 * @describe 搜索歌单结果
 */
public class PlayListResult {

  private List<PlayList> playlists;
  private int playlistCount;

  public List<PlayList> getPlaylists() {
    return playlists;
  }

  public void setPlaylists(List<PlayList> playlists) {
    this.playlists = playlists;
  }

  public int getPlaylistCount() {
    return playlistCount;
  }

  public void setPlaylistCount(int playlistCount) {
    this.playlistCount = playlistCount;
  }
}
