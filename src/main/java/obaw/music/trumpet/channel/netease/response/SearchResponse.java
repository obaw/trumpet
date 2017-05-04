package obaw.music.trumpet.channel.netease.response;

/**
 * @author xiaowei
 * @time 17-5-4 上午10:24
 * @describe 搜索响应对象
 */
public class SearchResponse<T> extends BaseResponse {

  /**
   * 结果
   */
  private T result;

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }
}
