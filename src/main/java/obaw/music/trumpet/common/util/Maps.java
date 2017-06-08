package obaw.music.trumpet.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xiaowei
 * @time 17-3-29 上午10:19
 * @describe Map, XML转化类
 */
public class Maps {

  /**
   * 支付请求前签名
   *
   * @param params 参数(已经升序, 排出非空值和sign)
   * @return MD5的签名字符串(大写)
   */
  public static String toString(final Map<String, Object> params) {
    if (MapUtils.isEmpty(params)) {
      return null;
    }
    Map<String, Object> validParams = new TreeMap<>();
    validParams.putAll(params);
    StringBuilder signing = new StringBuilder();

    for (Map.Entry<String, Object> entry : validParams.entrySet()) {
      if (!StringUtils.isEmpty(entry.getValue().toString())) {
        signing.append(entry.getKey()).append('=').append(entry.getValue()).append("&");
      }
    }

    return signing.toString().substring(0, signing.length() - 1);
  }
}
