/** */
package obaw.music.trumpet.web.res;

import obaw.music.trumpet.common.cons.ResStatus;

/**
 * @author xiaowei
 * @version 2016年9月20日下午5:41:02
 * @comments 响应对象
 */
public class Res {

  private int statusCode; // 状态码
  private String discribe; // 状态描述

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getDiscribe() {
    return discribe;
  }

  public void setDiscribe(String discribe) {
    this.discribe = discribe;
  }

  public Res(Integer statusCode) {
    super();
    this.statusCode = ResStatus.getStatus(statusCode).getStatusCode();
    this.discribe = ResStatus.getStatus(statusCode).getDiscribe();
  }
}
