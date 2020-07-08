import java.util.HashMap;
import java.util.Map;

public class MapDictionary implements Dictionary {
    private Map<String, String> data = new HashMap<>();

    @Override
    public void put(String key, String value) throws Exception {
        if (key == null || value == null) {
            throw new Exception("Некорректные данные!");
        }
        data.put(key, value);
    }

    @Override
    public void remove(String key) {
        data.remove(key);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public String get(String key) {
        return data.containsKey(key) ? data.get(key) : null;
    }

    @Override
    public int size() {
        return data.size();
    }
}
