package obaw.music.trumpet.common.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author xiaowei
 * @time 17-4-26 下午1:46
 * @describe 日期序列化器
 */
public class DateSerializer implements JsonSerializer<Date> {

  @Override
  public JsonElement serialize(
      Date date, Type type, JsonSerializationContext jsonSerializationContext) {
    return date == null ? null : new JsonPrimitive(date.getTime() / 1000);
  }
}
