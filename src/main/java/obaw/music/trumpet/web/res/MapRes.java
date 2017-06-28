package obaw.music.trumpet.web.res;

import java.util.Map;

/**
 * @author xiaowei
 * @version 2016年9月21日下午12:24:26
 * @comments map响应对象
 */
public class MapRes<K, V> extends Res {

  private Map<K, V> map;

  public Map<K, V> getMap() {
    return map;
  }

  public void setMap(Map<K, V> map) {
    this.map = map;
  }

  /** @param statusCode */
  public MapRes(Integer statusCode) {
    super(statusCode);
  }
}
