package obaw.music.trumpet.channel.netease.model;

/**
 * @author xiaowei
 * @time 17-5-3 下午4:28
 * @describe 歌曲文件
 */
public class SongFile {

  /**
   * 歌曲ID
   */
  private String id;
  /**
   * 大小
   */
  private String size;
  /**
   * 格式
   */
  private String extension;
  /**
   *
   */
  private String sr;
  /**
   * 文件ID
   */
  private String dfsId;
  /**
   * 码率
   */
  private String bitrate;
  /**
   * 播放时间
   */
  private String playTime;
  /**
   *
   */
  private String volumeDelta;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getSr() {
    return sr;
  }

  public void setSr(String sr) {
    this.sr = sr;
  }

  public String getDfsId() {
    return dfsId;
  }

  public void setDfsId(String dfsId) {
    this.dfsId = dfsId;
  }

  public String getBitrate() {
    return bitrate;
  }

  public void setBitrate(String bitrate) {
    this.bitrate = bitrate;
  }

  public String getPlayTime() {
    return playTime;
  }

  public void setPlayTime(String playTime) {
    this.playTime = playTime;
  }

  public String getVolumeDelta() {
    return volumeDelta;
  }

  public void setVolumeDelta(String volumeDelta) {
    this.volumeDelta = volumeDelta;
  }
}
