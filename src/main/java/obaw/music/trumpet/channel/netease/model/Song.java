package obaw.music.trumpet.channel.netease.model;

import java.util.List;

/**
 * @author xiaowei
 * @time 17-5-3 下午4:19
 * @describe 歌曲对象
 */
public class Song {

  /**
   * ID
   */
  private String id;
  /**
   * 歌曲名称
   */
  private String name;
  /**
   * 艺术家
   */
  private List<Artist> artists;
  /**
   * 专辑
   */
  private Album album;
  /**
   * 时长
   */
  private String duration;
  /**
   * 版权标识
   */
  private String copyrightId;
  /**
   * 状态
   */
  private String status;

  private SongFile hMusic;
  private SongFile mMusic;
  private SongFile lMusic;
  private SongFile bMusic;
  /**
   * mvId
   */
  private String mvid;
  /**
   * Mp3Url
   */
  private String mp3Url;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Artist> getArtists() {
    return artists;
  }

  public void setArtists(List<Artist> artists) {
    this.artists = artists;
  }

  public Album getAlbum() {
    return album;
  }

  public void setAlbum(Album album) {
    this.album = album;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getCopyrightId() {
    return copyrightId;
  }

  public void setCopyrightId(String copyrightId) {
    this.copyrightId = copyrightId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SongFile gethMusic() {
    return hMusic;
  }

  public void sethMusic(SongFile hMusic) {
    this.hMusic = hMusic;
  }

  public SongFile getmMusic() {
    return mMusic;
  }

  public void setmMusic(SongFile mMusic) {
    this.mMusic = mMusic;
  }

  public SongFile getlMusic() {
    return lMusic;
  }

  public void setlMusic(SongFile lMusic) {
    this.lMusic = lMusic;
  }

  public SongFile getbMusic() {
    return bMusic;
  }

  public void setbMusic(SongFile bMusic) {
    this.bMusic = bMusic;
  }

  public String getMvid() {
    return mvid;
  }

  public void setMvid(String mvid) {
    this.mvid = mvid;
  }

  public String getMp3Url() {
    return mp3Url;
  }

  public void setMp3Url(String mp3Url) {
    this.mp3Url = mp3Url;
  }
}
