package obaw.music.trumpet.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.zip.GZIPInputStream;
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

  public static String post(String url, Map<String, Object> body) {
    try {
      MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
      Request.Builder requestBuilder = new Request.Builder();
      requestBuilder.url(url);
      requestBuilder.post(RequestBody.create(mediaType, body == null ? "" : Maps.toString(body)));
      requestBuilder.addHeader("cache-control", "no-cache");
      requestBuilder.addHeader("accept-encoding", "gzip, deflate, sdch");
      requestBuilder.addHeader("content-type", "application/x-www-form-urlencoded");
      Request request = requestBuilder.build();
      Response execute = httpClient.newCall(request).execute();
      if (execute.isSuccessful()) {
        return getResponseBodyAsString(execute);
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  protected static String getResponseBodyAsString(Response response) throws IOException {
    // Reference the input stream.
    InputStream inputStream;

    String contentEncodingHeader = response.header("Content-Encoding");
    if (contentEncodingHeader != null && contentEncodingHeader.equals("gzip")) {
      // Read the zipped contents.
      inputStream = new GZIPInputStream(response.body().byteStream());
    } else {
      // Read the normal contents.
      inputStream = response.body().byteStream();
    }

    // Create and return buffered reader.
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

    // Read stream.
    StringBuilder sb = new StringBuilder("");
    String line;
    while ((line = br.readLine()) != null) {
      sb.append(line.trim());
    }

    // Close everything.
    response.body().close();
    inputStream.close();
    br.close();

    // Return the string.
    return sb.toString();
  }
}
