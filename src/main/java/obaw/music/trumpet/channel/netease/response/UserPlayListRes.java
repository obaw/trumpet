package obaw.music.trumpet.channel.netease.response;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.PlayList;

/**
 * @author xiaowei
 * @time 17-5-4 下午2:09
 * @describe
 */
public class UserPlayListRes extends BaseRes {

  private boolean more;
  private List<PlayList> playlist;

  public boolean isMore() {
    return more;
  }

  public void setMore(boolean more) {
    this.more = more;
  }

  public List<PlayList> getPlaylist() {
    return playlist;
  }

  public void setPlaylist(List<PlayList> playlist) {
    this.playlist = playlist;
  }
}
