public interface Dictionary {
    void put(String key, String value) throws Exception;
    void remove(String key);
    void clear();
    String get(String key);
    int size();
}
