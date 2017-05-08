package obaw.music.trumpet.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
    List<PlayList> playLists = neteaseAPI.userPlayList(uid, 0, 20);
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
    List<Song> resList = new ArrayList<>();
    SongResult songResult = neteaseAPI.searchSong(keyword, 0, 100);
    dis(songResult.getSongs(), resList);
    if (songResult.getAllPage() > 1) {
      for (int j = 1; j < songResult.getAllPage(); j++) {
        SongResult iterSong = neteaseAPI.searchSong(keyword, j, 100);
        dis(iterSong.getSongs(), resList);
      }
    }
    ListRes<Song> res = new ListRes<>(200);
    res.setList(resList);
    return gson.toJson(res);
  }

  @RequestMapping("/song")
  public String song(String id) {
    Song song = neteaseAPI.songDetail(id);
    ObjectRes<Song> res = new ObjectRes<>(200);
    res.setObject(song);
    return gson.toJson(res);
  }

  private void dis(List<Song> one, List<Song> res) {
    for (Song song : one) {
      String name = song.getName().toUpperCase();
      if (!name.contains("COVER")) {
        res.add(song);
      }
    }
  }

}
