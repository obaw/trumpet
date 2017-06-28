package obaw.music.trumpet.common.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * @author xiaowei
 * @time 17-4-26 下午1:55
 * @describe
 */
public class BigDecimalSerializer implements JsonSerializer<BigDecimal> {

  @Override
  public JsonElement serialize(
      BigDecimal bigDecimal, Type type, JsonSerializationContext jsonSerializationContext) {
    return bigDecimal == null
        ? null
        : new JsonPrimitive(bigDecimal.multiply(new BigDecimal(100)).intValue());
  }
}
