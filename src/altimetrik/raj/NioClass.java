package altimetrik.raj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NioClass {


    private String fileName;
    private List<String> sortAlphabetorder;
    private List<String> stream=new ArrayList<>();

    //    public void ReadFileLineByLine() {
public List<String> ReadFileLineByLine(){
        fileName = "D:\\Altimetrik_NCG_Training\\test.txt";
        try {
            stream = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.toList());
            for (String s:stream) {
                System.out.println(s);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public List<Integer> linecharcount(List<String> listoffiles){
        List<Integer> countcharinline=new ArrayList<>();


//            List<String> stream = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.toList());
            List<String> streamcp=new ArrayList<>();
            streamcp.addAll(listoffiles);
            for (String s:stream) {
                countcharinline.add(s.length());
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

        List<Integer> countCharLine=linecharcount(sortAlphabetorder);
        int totcount=countCharLine.stream()
                .mapToInt(value -> value)
                .sum();
        System.out.println(totcount);
    }
}
