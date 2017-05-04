package obaw.music.trumpet.channel.netease.enums;

/**
 * @author xiaowei
 * @time 17-5-4 上午11:12
 * @describe
 */
public enum Service {
  SEARCH("/api/search/get/"), SONG("/api/song/detail"), LYRIC("/api/song/media"), PLAYLIST(
      "/api/playlist/detail"), USER_PLAYLIST("/api/user/playlist");

  Service(String api) {
    this.api = api;
  }

  private String api;

  public String getApi() {
    return api;
  }

  public void setApi(String api) {
    this.api = api;
  }
}
