package obaw.music.trumpet.channel.netease;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import obaw.music.trumpet.common.util.HttpUtil;
import obaw.music.trumpet.common.util.Maps;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sun.misc.BASE64Encoder;

/**
 * Created by xiaowei on 17-5-7.
 */
public class NeteaseWeapi {

  private String MODULUS = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
  private String NONCE = "0CoJUm6Qyw8W8jud";
  private String PUBKEY = "010001";
  private String VI = "0102030405060708";
  private String USERAGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.157 Safari/537.36";
  private String COOKIE = "os=pc; osver=Microsoft-Windows-10-Professional-build-10586-64bit; appver=2.0.3.131777; channel=netease; __remember_me=true";
  private String REFERER = "http://music.163.com/";
  private String secretKey = "TA3YiYCfY2dDJQgg";
  private String encSecKey = "84ca47bca10bad09a6b04c5c927ef077d9b9f1e37098aa3eac6ea70eb59df0aa28b691b7e75e4f1f9831754919ea784c8f74fbfadf2898b0be17849fd656060162857830e241aba44991601f137624094c114ea8d17bce815b0cd4e5b8e2fbaba978c6d1d14dc3d1faf852bdd28818031ccdaaa13a6018e1024e2aae98844210";
  Gson gson = new Gson();

  public String connection(String url, Map<String, Object> data)
      throws Exception {
    String response = "";
    OutputStreamWriter out = null;
    BufferedReader reader = null;
    StringBuffer parameterBuffer = new StringBuffer();
    URL curl = new URL(url);
    HttpURLConnection conn = (HttpURLConnection) curl.openConnection();
    if (data != null && data.size() > 0) {
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Referer", this.REFERER);
      conn.setRequestProperty("Cookie", this.COOKIE);
      conn.setRequestProperty("User-Agent", this.USERAGENT);
      Iterator iterator = data.keySet().iterator();
      String key = null;
      String value = null;
      while (iterator.hasNext()) {
        key = (String) iterator.next();
        if (data.get(key) != null) {
          value = (String) data.get(key);
        } else {
          value = "";
        }
        parameterBuffer.append(key).append("=")
            .append(URLEncoder.encode(value, "utf-8"));
        if (iterator.hasNext()) {
          parameterBuffer.append("&");
        }
      }
      try {
        out = new OutputStreamWriter(conn.getOutputStream());
        out.write(parameterBuffer.toString());
        out.flush();
        reader = new BufferedReader(new InputStreamReader(
            conn.getInputStream()));
        String lines;
        while ((lines = reader.readLine()) != null) {
          lines = new String(lines.getBytes(), "utf-8");
          response += lines;
        }
      } catch (Exception e) {

      } finally {
        reader.close();
        out.close();
      }
    }
    return response;
  }

  public Map<String, Object> prepare(Map<String, Object> raw) {
    Map<String, Object> data = new HashMap<String, Object>();
    data.put("params", encrypt(jsonEncode(raw), this.NONCE));
    data.put("params", encrypt((String) data.get("params"), this.secretKey));
    data.put("encSecKey", this.encSecKey);
    return data;
  }

  private String jsonEncode(Object object) {
    return new Gson().toJson(object);
  }

  private String encrypt(String content, String password) {
    try {
      SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// 创建密码器
      IvParameterSpec iv = new IvParameterSpec(VI.getBytes());// 创建iv
      byte[] byteContent = content.getBytes("utf-8");
      cipher.init(Cipher.ENCRYPT_MODE, key, iv);// 初始化
      byte[] result = cipher.doFinal(byteContent);
      BASE64Encoder encoder = new BASE64Encoder();
      return encoder.encode(result); // 加密
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (InvalidAlgorithmParameterException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String url(String id) {
    String url = "http://music.163.com/weapi/song/enhance/player/url?csrf_token=";
    String[] urls = {id};
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("ids", urls);
    map.put("br", 999000);
    map.put("csrf_token", "");
    try {
      return connection(url, prepare(map));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String detail(String id) {
    String url = "http://music.163.com/weapi/v3/song/detail?csrf_token=";
    Map<String, Object> map = new HashMap<String, Object>();
    Map<String, String> ids = new HashMap<String, String>();
    ids.put("id", id);
    map.put("c", "[" + jsonEncode(ids) + "]");
    map.put("csrf_token", "");
    try {
      return connection(url, prepare(map));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String search(String s) {
    int limit = 100;//限制结果数量
    int offset = 0;
    int type = 1;
    String url = "http://music.163.com/weapi/cloudsearch/get/web?csrf_token=";
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("s", s);
    map.put("type", type);
    map.put("limit", limit);
    map.put("total", "true");
    map.put("offset", offset);
    map.put("csrf_token", "");
    try {
      return connection(url, prepare(map));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void test(Map<String, Object> dataMap) throws Exception {
    OkHttpClient client = new OkHttpClient();
    Map<String, Object> data = prepare(dataMap);
    Iterator iterator = data.keySet().iterator();
    StringBuffer parameterBuffer = new StringBuffer();
    String key = null;
    String value = null;
    while (iterator.hasNext()) {
      key = (String) iterator.next();
      if (data.get(key) != null) {
        value = (String) data.get(key);
      } else {
        value = "";
      }
      parameterBuffer.append(key).append("=")
          .append(URLEncoder.encode(value, "utf-8"));
      if (iterator.hasNext()) {
        parameterBuffer.append("&");
      }
    }
    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    System.out.println(parameterBuffer.toString());
    RequestBody requestBody = RequestBody.create(mediaType, parameterBuffer.toString());
    Request.Builder builder = new Request.Builder();
    builder.url("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=");
    builder.post(requestBody);
    builder.addHeader("content-type", "application/x-www-form-urlencoded");
    builder.addHeader("accept-encoding", "gzip");
    builder.addHeader("cache-control", "no-cache");
    builder.addHeader("Referer", this.REFERER);
    builder.addHeader("Cookie", this.COOKIE);
    builder.build();
    Response response = client.newCall(builder.build()).execute();
//    System.out.println(getResponseBodyAsString(response));
  }

  public static void main(String[] args) throws Exception {
//    System.out.println(new NeteaseWeapi().url("28481683"));
//    System.out.println(new NeteaseWeapi().detail("28481683"));
//    System.out.println(new NeteaseWeapi().search("你就不要想起我 田馥甄"));//搜索方法可接受歌名
//    new NeteaseWeapi().test();
    String url = "https://music.163.com/weapi/login/cellphone";
    Map<String, Object> map = new HashMap<>();
    map.put("phone", "13918731742");
    map.put("password", "helloxiaowei");
    map.put("rememberLogin", true);
    System.out.println(Maps.toString(new NeteaseWeapi().prepare(map)));
    System.out.println(HttpUtil.post(url, new NeteaseWeapi().prepare(map)));
  }

}
