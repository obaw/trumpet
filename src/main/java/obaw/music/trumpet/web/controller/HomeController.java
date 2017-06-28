package obaw.music.trumpet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaowei
 * @time 17-5-4 下午2:30
 * @describe 首页控制层
 */
@Controller
public class HomeController extends BaseController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }
}
