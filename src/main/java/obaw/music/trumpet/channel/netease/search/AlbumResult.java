package obaw.music.trumpet.channel.netease.search;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.Album;
import obaw.music.trumpet.channel.netease.model.Song;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:32
 * @describe 搜索专辑结果
 */
public class AlbumResult {

  private List<Album> albums;
  private int albumCount;

  public List<Album> getAlbums() {
    return albums;
  }

  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }

  public int getAlbumCount() {
    return albumCount;
  }

  public void setAlbumCount(int albumCount) {
    this.albumCount = albumCount;
  }
}
