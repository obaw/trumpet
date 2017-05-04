package obaw.music.trumpet.channel.netease.search;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.Album;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:32
 * @describe 搜索歌手结果
 */
public class ArtistResult {

  private List<Album> artists;
  private int artistCount;

  public List<Album> getArtists() {
    return artists;
  }

  public void setArtists(List<Album> artists) {
    this.artists = artists;
  }

  public int getArtistCount() {
    return artistCount;
  }

  public void setArtistCount(int artistCount) {
    this.artistCount = artistCount;
  }
}
