package obaw.music.trumpet.channel.netease.response;

import obaw.music.trumpet.channel.netease.model.PlayList;

/**
 * @author xiaowei
 * @time 17-5-4 下午2:06
 * @describe
 */
public class PlayListDetailRes extends BaseRes {

  private PlayList result;

  public PlayList getResult() {
    return result;
  }

  public void setResult(PlayList result) {
    this.result = result;
  }
}
