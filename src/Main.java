import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File fileReader = new File("Slovar.txt");
        Scanner scan = new Scanner(System.in);
        ArrayDictionary d = new ArrayDictionary();
        open(d, fileReader);
        System.out.println("Введите слово:");
        String slovo = scan.nextLine();
        slovo.toLowerCase();
        System.out.println("Что вы хотите сделать?");
        System.out.println("1. Найти перевод");
        System.out.println("2. Добавить слово");
        String a = scan.nextLine();
        if (a.equals("1")) {
            trans(d, slovo);
        }
        String slovo2 = null;
        if (a.equals("2")) {
            System.out.println("Введите перевод слова");
            slovo2 = scan.nextLine();
            update(slovo2,slovo,d);

        }


    }

    private static void trans(Dictionary d, String slovo1) {
        System.out.print(d.get(slovo1));
    }

    private static void open(Dictionary d, File fileReader) throws Exception {

        Scanner scanFromFile = new Scanner(fileReader);
        String elements = null;
        while (scanFromFile.hasNextLine()) {
            elements = scanFromFile.nextLine();
            String[] text = elements.split(" ");
            d.put(text[0], text[1]);
        }
    }
    private static void update (String slovo2, String slovo, ArrayDictionary d) throws Exception {
        slovo2.toLowerCase();
        d.put(slovo, slovo2);
        File myFoo = new File("Slovar.txt");
        FileWriter fooWriter = new FileWriter(myFoo, false);
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < 2; j++) {
                fooWriter.write(d.data[i][j]);
                fooWriter.write(" ");
            }
            fooWriter.write("\n");
        }
        fooWriter.close();
    }


}
