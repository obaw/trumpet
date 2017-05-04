package obaw.music.trumpet.common.util;

import java.io.IOException;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author xiaowei
 * @time 17-5-3 上午11:02
 * @describe 基于OkHttp的Http工具类
 */
public class HttpUtil {

  static OkHttpClient httpClient;

  static {
    httpClient = new OkHttpClient();
  }

  public static String post(String url, Map<String, String> rawParams) {
    try {
      Builder builder = HttpUrl.parse(url).newBuilder();
      for (String key : rawParams.keySet()) {
        builder.addQueryParameter(key, rawParams.get(key));
      }
      Request.Builder requestBuilder = new Request.Builder();
      requestBuilder.url(builder.build());
      requestBuilder.post(
          RequestBody.create(MediaType.parse("multipart/form-data; charset=utf-8"), ""));
      requestBuilder.addHeader("cache-control", "no-cache");
      Request request = requestBuilder.build();
      Response execute = httpClient.newCall(request).execute();
      if (execute.isSuccessful()) {
        return execute.body().string();
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
