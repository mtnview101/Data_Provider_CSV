package core;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.*;
import java.util.*;
import org.testng.annotations.*;

public class DPCSVTest {
       String csvFile = "./src/main/resources/input.csv";
       @DataProvider(name = "dp")
       public Iterator<String[]> a2d() throws InterruptedException, IOException {
              String cvsLine = "";                       // a,b,c,d
              String[] a = null;                         // ["a","b","c","d"]
ArrayList<String[]> al = new ArrayList<>();//[["a","b","c","d"],["a","b","c","d"]]
              BufferedReader br = new BufferedReader(new FileReader(csvFile));
              while ((cvsLine = br.readLine()) != null) {
                           a = cvsLine.split(",");
                           al.add(a);}
              br.close();
              return al.iterator();}

       @Test(dataProvider = "dp")
       public void test(String a, String first_number, String second_number, String summary) {
              System.out.println(a + ", " + first_number + ", " + second_number + ", " + summary);
              assertThat(Integer.parseInt(first_number) + Integer.parseInt(second_number), is(Integer.parseInt(summary)));}
}

