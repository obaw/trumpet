package obaw.music.trumpet.common.cons;

/**
 * @author xiaowei
 * @version 2016年9月22日下午4:51:07
 * @comments 响应状态枚举类
 */
public enum ResStatus {
  STATUS_200(200, "操作成功"),
  STATUS_400(400, "参数错误"),
  STATUS_401(401, "加密信息验证失败"),
  STATUS_402(402, "请求失败"),
  STATUS_403(403, "接口限制"),
  STATUS_404(404, "资源不存在"),
  STATUS_405(405, "手机号码错误"),
  STATUS_406(406, "推荐码错误"),
  STATUS_407(407, "手机号码或密码错误"),
  STATUS_408(408, "打样申请单不存在或状态不对"),
  STATUS_409(409, "用户不存在"),
  STATUS_410(410, "生成支付对象失败"),
  STATUS_411(411, "订单金额必须大于0"),
  STATUS_412(412, "打样订单与用户不匹配"),
  STATUS_413(413, "创建订单失败"),
  STATUS_414(414, "支付完成,订单状态稍有延迟，请稍候查看"),
  STATUS_415(415, "支付失败"),
  STATUS_416(416, "手机号已被注册"),
  STATUS_417(417, "商品不存在"),
  STATUS_418(418, "库存不足"),
  STATUS_419(419, "订单金额必须大于0"),
  STATUS_420(420, "微信公众号支付请在微信浏览器内登录支付"),
  STATUS_421(421, "短信验证码错误"),
  STATUS_422(422, "商品数据有误"),
  STATUS_423(423, "订单不存在或状态不对"),
  STATUS_424(424, "对不起商品已下架"),
  STATUS_425(425, "手机号码未注册"),
  STATUS_426(426, "微信授权失败"),
  STATUS_427(427, "微信获取用户信息失败"),
  STATUS_428(428, "用户未注册"),
  STATUS_429(429, "用户被禁用"),
  STATUS_500(500, "服务器错误");

  private Integer statusCode; // 状态码
  private String discribe; // 描述

  private ResStatus(Integer statusCode, String discribe) {
    this.statusCode = statusCode;
    this.discribe = discribe;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public String getDiscribe() {
    return discribe;
  }

  public void setDiscribe(String discribe) {
    this.discribe = discribe;
  }

  public static ResStatus getStatus(int statusCode) {
    for (ResStatus res : values()) {
      if (res.getStatusCode() == statusCode) {
        return res;
      }
    }
    return null;
  }
}
