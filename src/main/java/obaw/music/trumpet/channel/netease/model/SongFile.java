package obaw.music.trumpet.channel.netease.model;

/**
 * @author xiaowei
 * @time 17-5-3 下午4:28
 * @describe 歌曲文件
 */
public class SongFile {
  private Object name;
  private int id;
  private int size;
  private String extension;
  private int sr;
  private long dfsId;
  private int bitrate;
  private int playTime;
  private double volumeDelta;

  public Object getName() {
    return name;
  }

  public void setName(Object name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public int getSr() {
    return sr;
  }

  public void setSr(int sr) {
    this.sr = sr;
  }

  public long getDfsId() {
    return dfsId;
  }

  public void setDfsId(long dfsId) {
    this.dfsId = dfsId;
  }

  public int getBitrate() {
    return bitrate;
  }

  public void setBitrate(int bitrate) {
    this.bitrate = bitrate;
  }

  public int getPlayTime() {
    return playTime;
  }

  public void setPlayTime(int playTime) {
    this.playTime = playTime;
  }

  public double getVolumeDelta() {
    return volumeDelta;
  }

  public void setVolumeDelta(double volumeDelta) {
    this.volumeDelta = volumeDelta;
  }
}
