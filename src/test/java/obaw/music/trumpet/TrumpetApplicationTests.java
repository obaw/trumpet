package obaw.music.trumpet;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import obaw.music.trumpet.channel.netease.NeteaseAPI;
import obaw.music.trumpet.channel.netease.model.PlayList;
import obaw.music.trumpet.channel.netease.model.Song;
import obaw.music.trumpet.channel.netease.search.SongResult;
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

  /**
   * 查询
   */
  @Test
  public void search() {
    SongResult search = neteaseAPI.searchSong("你就不要想起我", 1, 100);
    System.out.println(search.getAllPage());
    System.out.println(search.getPage());
    System.out.println(search.getPageSize());
    List<Song> songs = search.getSongs();
    for (Song song : songs) {
      System.out.println(song.getArtists().get(0).getName());
    }
  }

  /**
   * 歌曲详情
   */
  @Test
  public void songDetail() {
    String[] ids = {"25949862"};
    List<Song> result = neteaseAPI.songDetail(ids);
    for (Song song : result) {
      System.out.println(song.getMp3Url());
    }
  }

  /**
   * 歌词详情
   */
  @Test
  public void songLyric() {
    String songLyric = neteaseAPI.songLyric("385544");
    System.out.println(songLyric);
  }

  /**
   * 歌单详情
   */
  @Test
  public void playList() {
    PlayList playList = neteaseAPI.playList("711845605");
    System.out.println(playList.getName());
  }

  /**
   * 用户歌单详情
   */
  @Test
  public void userPlayList() {
    List<PlayList> userPlayList = neteaseAPI.userPlayList("33182671", 0, 3);
    for (PlayList playList : userPlayList) {
      System.out.println(playList.getName());
    }
  }

  @Test
  public void music() throws NoSuchAlgorithmException {
    //http://m2.music.126.net/XYVgKjLVhUz4E3Xzx6g1NA==/7957165651774040.mp3
    String input = "18705991324982209";
    String key = "3go8&$8*3*3h0k(2)2";
    byte[] keyBytes = key.getBytes();
    byte[] searchBytes = input.getBytes();

    for (int i = 0; i < searchBytes.length; ++i) {
      searchBytes[i] ^= keyBytes[i % keyBytes.length];
    }
    MessageDigest mdInst = MessageDigest.getInstance("MD5");
    mdInst.update(searchBytes);
    byte[] result = Base64.getEncoder().encode(mdInst.digest());
    String params = new String(result);
    params = params.replace("+", "-");
    params = params.replace("/", "_");
    System.out.println("http://m2.music.126.net/" + params + "/" + input + ".mp3");
  }

  public static void main(String[] args) {

  }
}
