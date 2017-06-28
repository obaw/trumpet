/** */
package obaw.music.trumpet.web.res;

/**
 * @author xiaowei
 * @version 2016年9月20日下午7:04:49
 * @comments 实体响应对象
 */
public class ObjectRes<T> extends Res {

  /** @param statusCode */
  public ObjectRes(Integer statusCode) {
    super(statusCode);
  }

  private T object;

  public T getObject() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }
}
