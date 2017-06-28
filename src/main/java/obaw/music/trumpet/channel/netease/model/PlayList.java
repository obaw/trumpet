package obaw.music.trumpet.channel.netease.model;

import java.util.List;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:38
 * @describe
 */
public class PlayList {

  private boolean subscribed;
  private User creator;
  private Object artists;
  private List<Song> tracks;
  private int status;
  private boolean ordered;
  private int adType;
  private long trackNumberUpdateTime;
  private long createTime;
  private int playCount;
  private int trackCount;
  private long coverImgId;
  private int userId;
  private int privacy;
  private String coverImgUrl;
  private int specialType;
  private boolean anonimous;
  private boolean newImported;
  private boolean highQuality;
  private long updateTime;
  private String commentThreadId;
  private long trackUpdateTime;
  private int totalDuration;
  private String name;
  private int id;
  private String description;
  private int cloudTrackCount;
  private int subscribedCount;
  private List<?> subscribers;
  private List<String> tags;

  public boolean isSubscribed() {
    return subscribed;
  }

  public void setSubscribed(boolean subscribed) {
    this.subscribed = subscribed;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  public Object getArtists() {
    return artists;
  }

  public void setArtists(Object artists) {
    this.artists = artists;
  }

  public List<Song> getTracks() {
    return tracks;
  }

  public void setTracks(List<Song> tracks) {
    this.tracks = tracks;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public boolean isOrdered() {
    return ordered;
  }

  public void setOrdered(boolean ordered) {
    this.ordered = ordered;
  }

  public int getAdType() {
    return adType;
  }

  public void setAdType(int adType) {
    this.adType = adType;
  }

  public long getTrackNumberUpdateTime() {
    return trackNumberUpdateTime;
  }

  public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
    this.trackNumberUpdateTime = trackNumberUpdateTime;
  }

  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }

  public int getPlayCount() {
    return playCount;
  }

  public void setPlayCount(int playCount) {
    this.playCount = playCount;
  }

  public int getTrackCount() {
    return trackCount;
  }

  public void setTrackCount(int trackCount) {
    this.trackCount = trackCount;
  }

  public long getCoverImgId() {
    return coverImgId;
  }

  public void setCoverImgId(long coverImgId) {
    this.coverImgId = coverImgId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getPrivacy() {
    return privacy;
  }

  public void setPrivacy(int privacy) {
    this.privacy = privacy;
  }

  public String getCoverImgUrl() {
    return coverImgUrl;
  }

  public void setCoverImgUrl(String coverImgUrl) {
    this.coverImgUrl = coverImgUrl;
  }

  public int getSpecialType() {
    return specialType;
  }

  public void setSpecialType(int specialType) {
    this.specialType = specialType;
  }

  public boolean isAnonimous() {
    return anonimous;
  }

  public void setAnonimous(boolean anonimous) {
    this.anonimous = anonimous;
  }

  public boolean isNewImported() {
    return newImported;
  }

  public void setNewImported(boolean newImported) {
    this.newImported = newImported;
  }

  public boolean isHighQuality() {
    return highQuality;
  }

  public void setHighQuality(boolean highQuality) {
    this.highQuality = highQuality;
  }

  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }

  public String getCommentThreadId() {
    return commentThreadId;
  }

  public void setCommentThreadId(String commentThreadId) {
    this.commentThreadId = commentThreadId;
  }

  public long getTrackUpdateTime() {
    return trackUpdateTime;
  }

  public void setTrackUpdateTime(long trackUpdateTime) {
    this.trackUpdateTime = trackUpdateTime;
  }

  public int getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(int totalDuration) {
    this.totalDuration = totalDuration;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCloudTrackCount() {
    return cloudTrackCount;
  }

  public void setCloudTrackCount(int cloudTrackCount) {
    this.cloudTrackCount = cloudTrackCount;
  }

  public int getSubscribedCount() {
    return subscribedCount;
  }

  public void setSubscribedCount(int subscribedCount) {
    this.subscribedCount = subscribedCount;
  }

  public List<?> getSubscribers() {
    return subscribers;
  }

  public void setSubscribers(List<?> subscribers) {
    this.subscribers = subscribers;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }
}
