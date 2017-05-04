package obaw.music.trumpet.channel.netease.model;

import java.util.List;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:13
 * @describe 专辑
 */
public class Album {

  private String name;
  private int id;
  private String type;
  private int size;
  private long picId;
  private String blurPicUrl;
  private int companyId;
  private long pic;
  private String picUrl;
  private long publishTime;
  private String description;
  private String tags;
  private String company;
  private String briefDesc;
  private Artist artist;
  private int status;
  private int copyrightId;
  private String commentThreadId;
  private Object subType;
  private List<Song> songs;
  private List<String> alias;
  private List<Artist> artists;

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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public long getPicId() {
    return picId;
  }

  public void setPicId(long picId) {
    this.picId = picId;
  }

  public String getBlurPicUrl() {
    return blurPicUrl;
  }

  public void setBlurPicUrl(String blurPicUrl) {
    this.blurPicUrl = blurPicUrl;
  }

  public int getCompanyId() {
    return companyId;
  }

  public void setCompanyId(int companyId) {
    this.companyId = companyId;
  }

  public long getPic() {
    return pic;
  }

  public void setPic(long pic) {
    this.pic = pic;
  }

  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  public long getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(long publishTime) {
    this.publishTime = publishTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getBriefDesc() {
    return briefDesc;
  }

  public void setBriefDesc(String briefDesc) {
    this.briefDesc = briefDesc;
  }

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getCopyrightId() {
    return copyrightId;
  }

  public void setCopyrightId(int copyrightId) {
    this.copyrightId = copyrightId;
  }

  public String getCommentThreadId() {
    return commentThreadId;
  }

  public void setCommentThreadId(String commentThreadId) {
    this.commentThreadId = commentThreadId;
  }

  public Object getSubType() {
    return subType;
  }

  public void setSubType(Object subType) {
    this.subType = subType;
  }

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }

  public List<String> getAlias() {
    return alias;
  }

  public void setAlias(List<String> alias) {
    this.alias = alias;
  }

  public List<Artist> getArtists() {
    return artists;
  }

  public void setArtists(List<Artist> artists) {
    this.artists = artists;
  }
}
