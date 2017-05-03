package obaw.music.trumpet.channel.netease;

import java.util.HashMap;
import java.util.Map;
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

  final String getaway = "http://music.163.com";

  /***
   * 搜索
   * @param keyword　关键字
   * @param type 类型1=歌曲,10=专辑,100=歌手,1000=歌单,1002=用户,1004=mv,1006=歌词,1009=主播电台
   * @param page　当前页
   * @param pageSize　页大小
   * @return
   */
  public String search(String keyword, String type, Integer page, Integer pageSize) {
    Map<String, String> query = new HashMap<>();
    query.put("s", keyword);
    query.put("offset", page + "");
    query.put("limit", pageSize + "");
    query.put("type", type);
    return HttpUtil.post(getaway + "/api/search/get/", query);
  }

  /***
   *歌曲详情
   * @param ids 歌曲ID
   * @return
   */
  public String songDetail(String[] ids) {
    String id = StringUtils.join(ids, ',');
    Map<String, String> query = new HashMap<>();
    query.put("ids", "[" + id + "]");
    return HttpUtil.post(getaway + "/api/song/detail", query);
  }

  /***
   * 歌词详情
   * @param id 歌曲ID
   * @return
   */
  public String songLyric(String id) {
    Map<String, String> query = new HashMap<>();
    query.put("id", id);
    return HttpUtil.post(getaway + "/api/song/media", query);
  }

  /***
   * 歌单详情
   * @param id 歌单ID
   * @return
   */
  public String playList(String id) {
    Map<String, String> query = new HashMap<>();
    query.put("id", id);
    return HttpUtil.post(getaway + "/api/playlist/detail", query);
  }

  /***
   * 用户歌单
   * @param uid　用户ID
   * @param page 页码
   * @param pageSize 页大小
   * @return
   */
  public String userPlayList(String uid, int page, int pageSize) {
    Map<String, String> query = new HashMap<>();
    query.put("uid", uid);
    query.put("offset", page + "");
    query.put("limit", pageSize + "");
    return HttpUtil.post(getaway + "/api/user/playlist", query);
  }

  public static void main(String[] args) {
    String[] ids = {"1", "2", "3"};
    System.out.println(StringUtils.join(ids, ","));
  }
}
