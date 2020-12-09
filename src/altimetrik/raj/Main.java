package altimetrik.raj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
//    1.	create a txt file with 100 lines
        FilewriteHundredLines();

//        2.Read file by line by line
        NioClass readfileclass = new NioClass();
        readfileclass.ReadFileLineByLine();

//        3a.linecharcount()
    readfileclass.linecharcount();
//    3b. sort alphabetically
        List<String> filesorted=readfileclass.alphabetically();
        filesorted.forEach(System.out::println);

//      3c.totalcount()
        readfileclass.totalCount();
    }

    private static void FilewriteHundredLines() {
        String str = "Hello Raj! How are You?";
        StringBuilder sb = new StringBuilder();
        try {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {

                String randomstring = random.ints(97, (122 + 1))
                        .limit(10)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                sb.append(randomstring + " " + str);
                sb.append("\n");
                Path path = Paths.get("D:\\Altimetrik_NCG_Training\\test.txt");
                List<String> strlist = new ArrayList<>();
                strlist.add(sb.toString());
                Files.write(path, strlist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
