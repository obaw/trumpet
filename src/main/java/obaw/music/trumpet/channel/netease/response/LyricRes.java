package obaw.music.trumpet.channel.netease.response;

/**
 * @author xiaowei
 * @time 17-5-4 下午2:00
 * @describe 歌词响应对象
 */
public class LyricRes extends BaseRes {

  private String lyric;

  public String getLyric() {
    return lyric;
  }

  public void setLyric(String lyric) {
    this.lyric = lyric;
  }
}
