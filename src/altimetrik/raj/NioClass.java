package altimetrik.raj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class NioClass {


    private String fileName;
    private List<String> sortAlphabetorder;

    public void ReadFileLineByLine() {

        fileName = "D:\\Altimetrik_NCG_Training\\test.txt";
        try {
            List<String> stream = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.toList());
            for (String s:stream) {
                System.out.println(s);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> linecharcount(){
        List<Integer> countcharinline=new ArrayList<>();
        try {

            List<String> stream = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.toList());
            for (String s:stream) {
                countcharinline.add(s.length());
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return countcharinline;
    }

    public List<String> alphabetically() {
        try {
            List<String> filestream = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.toList());

            sortAlphabetorder = filestream.stream().sorted().collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }
        return sortAlphabetorder;
    }


    public void totalCount() {
        List<Integer> countCharLine=linecharcount();
        int totcount=countCharLine.stream()
                .mapToInt(value -> value)
                .sum();
        System.out.println(totcount);
    }
}
