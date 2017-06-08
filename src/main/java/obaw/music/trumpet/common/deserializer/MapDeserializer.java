package obaw.music.trumpet.common.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xiaowei
 * @time 17-5-3 下午6:00
 * @describe
 */
public class MapDeserializer implements JsonDeserializer<Map<String, Object>> {

  @Override
  public Map<String, Object> deserialize(
      JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
      throws JsonParseException {
    TreeMap<String, Object> treeMap = new TreeMap<>();
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
    for (Map.Entry<String, JsonElement> entry : entrySet) {
      treeMap.put(entry.getKey(), entry.getValue());
    }
    return treeMap;
  }
}
