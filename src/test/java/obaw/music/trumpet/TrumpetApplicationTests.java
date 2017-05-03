package obaw.music.trumpet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import obaw.music.trumpet.channel.netease.NeteaseAPI;
import obaw.music.trumpet.channel.netease.model.Songs;
import obaw.music.trumpet.common.deserializer.MapDeserializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TrumpetApplication.class)
public class TrumpetApplicationTests {

  @Autowired
  private NeteaseAPI neteaseAPI;

  /***
   * 查询
   */
  @Test
  public void search() throws IOException {
    String search = neteaseAPI.search("倔强+五月天", "1", 0, 1);
    System.out.println(search);
  }

  /***
   * 歌曲详情
   */
  @Test
  public void songDetail() {
    Gson gson = new GsonBuilder().registerTypeAdapter(Map.class, new MapDeserializer()).create();
    String[] ids = {"385544"};
    String result = neteaseAPI.songDetail(ids);
    System.out.println(result);
    Map<String, Object> map = gson.fromJson(result, new TypeToken<Map<String, Object>>() {
    }.getType());
    List<Songs> songs = new ArrayList<>();
    //成功
    if (map.get("code").toString().equals("200")) {
      JsonArray array = (JsonArray) map.get("songs");
      Iterator<JsonElement> iterator = array.iterator();
      while (iterator.hasNext()) {
        JsonElement next = iterator.next();
        Songs song = gson.fromJson(next, Songs.class);
        songs.add(song);
      }
      System.out.println(songs);
    }
  }

  /***
   * 歌词详情
   */
  @Test
  public void songLyric() {
    String songLyric = neteaseAPI.songLyric("385544");
    System.out.println(songLyric);
  }

  /***
   * 歌单详情
   */
  @Test
  public void playList() {
    String playList = neteaseAPI.playList("711845605");
    System.out.println(playList);
  }

  /***
   * 用户歌单详情
   */
  @Test
  public void userPlayList() {
    String userPlayList = neteaseAPI.userPlayList("33182671", 0, 3);
    System.out.println(userPlayList);
  }
}
