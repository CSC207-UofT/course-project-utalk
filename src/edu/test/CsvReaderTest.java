import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReaderTest {

    public static int a = 0;

    public static void go(){
        a = 10;
    }




    public static void main(String[] args) {

        ArrayList<String> abc1 = new ArrayList<>();
        abc1.add("a");
        abc1.add("b");
        abc1.add("c");
        abc1.add("d");
        ArrayList<String> abc2 = new ArrayList<>();
        abc2.add("aa");
        abc2.add("bb");
        abc2.add("cc");
        abc2.add("dd");
        ArrayList<ArrayList<String>> need_to_convert = new ArrayList<>();
        need_to_convert.add(abc1);
        need_to_convert.add(abc2);
        System.out.println(need_to_convert);
        List_to_string(need_to_convert);
        write_to_file(need_to_convert, "a.csv");

    }


    public static String List_to_string(ArrayList<ArrayList<String>> need_to_convert){
        String result = "";
        for (ArrayList<String>row : need_to_convert){
            for(String item : row){
                result = result.concat(item);
                result = result.concat(",");
            }
            int length = Math.max(result.length() - 1, 0);
            result = result.substring(0, length);
            result = result.concat("\n");
        }
        System.out.println(result);
        return result;
    }

    public static void write_to_file(ArrayList<ArrayList<String>> list, String file_path){
        String need = List_to_string(list);
        try {
            FileWriter myWriter = new FileWriter(file_path);
            myWriter.write(need);
            myWriter.close();
            System.out.println("Write successfully");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
