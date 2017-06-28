/** */
package obaw.music.trumpet.web.res;

import java.util.List;

/**
 * @author xiaowei
 * @version 2016年9月20日下午7:06:31
 * @comments 集合响应对象
 */
public class ListRes<T> extends Res {

  public ListRes(Integer statusCode) {
    super(statusCode);
  }

  private List<T> list;

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }
}
