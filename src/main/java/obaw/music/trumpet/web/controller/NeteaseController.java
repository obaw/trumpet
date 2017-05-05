package obaw.music.trumpet.web.controller;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.PlayList;
import obaw.music.trumpet.channel.netease.model.Song;
import obaw.music.trumpet.channel.netease.search.SongResult;
import obaw.music.trumpet.web.res.ListRes;
import obaw.music.trumpet.web.res.ObjectRes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaowei
 * @time 17-5-5 上午10:09
 * @describe 网易云控制层
 */
@RestController
@RequestMapping("/netease")
public class NeteaseController extends BaseController {

  @RequestMapping("/userPlaylist")
  public String userPlaylist(String uid) {
    List<PlayList> playLists = neteaseAPI.userPlayList(uid, 0, 10);
    ListRes<PlayList> res = new ListRes<>(200);
    res.setList(playLists);
    return gson.toJson(res);
  }

  @RequestMapping("/playlist")
  public String playlist(String id) {
    PlayList playList = neteaseAPI.playList(id);
    ObjectRes<PlayList> res = new ObjectRes<>(200);
    res.setObject(playList);
    return gson.toJson(res);
  }

  @RequestMapping("/search")
  public String search(String keyword) {
    SongResult songResult = neteaseAPI.searchSong(keyword, 0, 10);
    ListRes<Song> res = new ListRes<>(200);
    res.setList(songResult.getSongs());
    return gson.toJson(res);
  }
}
