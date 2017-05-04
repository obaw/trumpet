package obaw.music.trumpet;

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
    SongResult search = neteaseAPI.searchSong("倔强+五月天", 0, 10);
    List<Song> songs = search.getSongs();
    for (Song song : songs) {
      System.out.println(song.getName());
    }
  }

  /**
   * 歌曲详情
   */
  @Test
  public void songDetail() {
    String[] ids = {"385544"};
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

  public static void main(String[] args) {
    //http://m2.music.126.net/XYVgKjLVhUz4E3Xzx6g1NA==/7957165651774040.mp3
    String ifsId = "7957165651774040";
  }
}
