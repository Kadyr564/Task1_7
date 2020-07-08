public class ArrayDictionary implements Dictionary {

    public  String[][] data = new String[100][2];
    private int size = 0;


    public void put(String key, String value) throws Exception {
        if (key == null || value == null) {
            throw new Exception("Некорректные данные!");
        }
        if (size >= data.length) {
            throw new Exception("Нет места!");
        }
        data[size][0] = key;
        data[size][1] = value;
        size++;
    }

    private int getIndex(String key) {
        for (int i = 0; i < size; i++) {
            if (data[i][0].equals(key)) {
                return i;
            }
            if (data[i][1].equals(key)) {
                return i;
            }
        }
        return -1;
    }
    private int getIndex1(String key) {
        for (int i = 0; i < size; i++) {
            if (data[i][0].equals(key)) {
                return 0;
            }
            if (data[i][1].equals(key)) {
                return 1;
            }
        }
        return -1;
    }

    public void remove(String key) {
        int index = getIndex(key);
        if (index >= 0) {
            for (int i = index + 1; i < size; i++) {
                data[i-1][0] = data[i][0];
                data[i-1][1] = data[i][1];
            }
            size--;
            data[size][0] = null;
            data[size][1] = null;
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i][0] = data[i][1] = null;
        }
        size = 0;
    }

    public String get(String key) {
        int index = getIndex(key);
        int index1 = getIndex1(key);
        if (index < 0) {
            return "Такого слова нет";
        } else{
            if (index1==0) {
                return data[index][1];
            }else {
                return data[index][0];
            }
        }
    }

    public int size() {
        return this.size;
    }
}
