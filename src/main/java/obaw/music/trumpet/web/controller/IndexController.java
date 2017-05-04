package obaw.music.trumpet.web.controller;

import java.util.List;
import obaw.music.trumpet.channel.netease.model.PlayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaowei
 * @time 17-5-4 下午2:30
 * @describe
 */
@Controller
public class IndexController extends BaseController {

  @RequestMapping("/")
  public String index(Model model) {
    List<PlayList> playLists = neteaseAPI.userPlayList("33182671", 0, 10);
    model.addAttribute("playLists", playLists);
    return "index";
  }
}
