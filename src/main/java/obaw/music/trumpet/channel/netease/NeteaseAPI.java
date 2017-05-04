package obaw.music.trumpet.channel.netease;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import obaw.music.trumpet.channel.netease.enums.Service;
import obaw.music.trumpet.channel.netease.model.PlayList;
import obaw.music.trumpet.channel.netease.model.Song;
import obaw.music.trumpet.channel.netease.response.BaseRes;
import obaw.music.trumpet.channel.netease.response.LyricRes;
import obaw.music.trumpet.channel.netease.response.PlayListDetailRes;
import obaw.music.trumpet.channel.netease.response.SearchRes;
import obaw.music.trumpet.channel.netease.response.SongDetailRes;
import obaw.music.trumpet.channel.netease.response.UserPlayListRes;
import obaw.music.trumpet.channel.netease.search.AlbumResult;
import obaw.music.trumpet.channel.netease.search.ArtistResult;
import obaw.music.trumpet.channel.netease.search.PlayListResult;
import obaw.music.trumpet.channel.netease.search.SongResult;
import obaw.music.trumpet.common.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author xiaowei
 * @time 17-5-3 上午10:54
 * @describe 网易云音乐API
 */
@Component
public class NeteaseAPI {

  public static String getaway = "http://music.163.com";


  /***
   *歌曲详情
   * @param ids 歌曲ID
   * @return
   */
  public List<Song> songDetail(String[] ids) {
    String id = StringUtils.join(ids, ',');
    Map<String, String> query = new HashMap<>();
    query.put("ids", "[" + id + "]");
    SongDetailRes response = doPost(Service.SONG, query, SongDetailRes.class);
    return response != null ? response.getSongs() : null;
  }

  /***
   * 歌词详情
   * @param id 歌曲ID
   * @return
   */
  public String songLyric(String id) {
    Map<String, String> query = new HashMap<>();
    query.put("id", id);
    LyricRes response = doPost(Service.LYRIC, query, LyricRes.class);
    return response != null ? response.getLyric() : null;
  }

  /***
   * 歌单详情
   * @param id 歌单ID
   * @return
   */
  public PlayList playList(String id) {
    Map<String, String> query = new HashMap<>();
    query.put("id", id);
    PlayListDetailRes response = doPost(Service.PLAYLIST, query, PlayListDetailRes.class);
    return response != null ? response.getResult() : null;
  }

  /***
   * 用户歌单
   * @param uid　用户ID
   * @param page 页码
   * @param pageSize 页大小
   * @return
   */
  public List<PlayList> userPlayList(String uid, int page, int pageSize) {
    Map<String, String> query = new HashMap<>();
    query.put("uid", uid);
    query.put("offset", page + "");
    query.put("limit", pageSize + "");
    UserPlayListRes response = doPost(Service.USER_PLAYLIST, query, UserPlayListRes.class);
    return response != null ? response.getPlaylist() : null;
  }

  /***
   * 搜索歌曲
   * @param keyword
   * @param page
   * @param pageSize
   * @return
   */
  public SongResult searchSong(String keyword, Integer page, Integer pageSize) {
    SearchRes<SongResult> search = search(keyword, 1, page, pageSize, new TypeToken<SearchRes<SongResult>>() {
    }.getType());
    return search != null ? search.getResult() : null;
  }

  /***
   * 搜索专辑
   * @param keyword
   * @param page
   * @param pageSize
   * @return
   */
  public AlbumResult searchAlbum(String keyword, Integer page, Integer pageSize) {
    SearchRes<AlbumResult> search = search(keyword, 10, page, pageSize,
        new TypeToken<SearchRes<AlbumResult>>() {
        }.getType());
    return search != null ? search.getResult() : null;
  }

  /***
   * 搜索歌手
   * @param keyword
   * @param page
   * @param pageSize
   * @return
   */
  public ArtistResult searchArtist(String keyword, Integer page, Integer pageSize) {
    SearchRes<ArtistResult> search = search(keyword, 100, page, pageSize,
        new TypeToken<SearchRes<ArtistResult>>() {
        }.getType());
    return search != null ? search.getResult() : null;
  }

  /***
   * 搜索歌单
   * @param keyword
   * @param page
   * @param pageSize
   * @return
   */
  public PlayListResult searchPlayList(String keyword, Integer page, Integer pageSize) {
    SearchRes<PlayListResult> search = search(keyword, 1000, page, pageSize,
        new TypeToken<SearchRes<PlayListResult>>() {
        }.getType());
    return search != null ? search.getResult() : null;
  }

  ////////////////////////////////////////////////
  //私有方法
  ///////////////////////////////////////////////

  /***
   * 搜索
   * @param keyword　关键字
   * @param type 类型1=歌曲,10=专辑,100=歌手,1000=歌单,1002=用户,1004=mv,1006=歌词,1009=主播电台
   * @param page　当前页
   * @param pageSize　页大小
   * @return
   */
  private <T> T search(String keyword, Integer type, Integer page, Integer pageSize, Type classzType) {
    Map<String, String> query = new HashMap<>();
    query.put("s", keyword);
    query.put("offset", page + "");
    query.put("limit", pageSize + "");
    query.put("type", type + "");
    String post = HttpUtil.post(NeteaseAPI.getaway + Service.SEARCH.getApi(), query);
    BaseRes response = new Gson().fromJson(post, BaseRes.class);
    if (response.getCode() != 200) {
      return null;
    }
    return new Gson().fromJson(post, classzType);
  }

  private <T> T doPost(Service service, Map<String, String> param, Class<T> classz) {
    String post = HttpUtil.post(NeteaseAPI.getaway + service.getApi(), param);
    SearchRes<SongResult> songResut = new Gson().fromJson(post, new TypeToken<SearchRes<SongResult>>() {
    }.getType());
    BaseRes response = new Gson().fromJson(post, BaseRes.class);
    if (response.getCode() != 200) {
      return null;
    }
    return new Gson().fromJson(post, classz);
  }
}
