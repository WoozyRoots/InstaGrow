import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;

public class TagsBase {
    private final static String fileName = "src\\main\\resources\\tags.base";
    private String tag;
    private HashMap<Integer, String> tagBase = new HashMap <Integer,String>();
    int i=0;

    TagsBase() throws IOException {

        try {
            FileInputStream fstream = new FileInputStream(fileName);
            //System.out.println("checkpoint");
            if (fstream != null) {

                FileReader fr = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fr);


                while ((tag = reader.readLine()) != null) {
                    tagBase.put(i++,tag);

                }


            } else {
                throw new FileNotFoundException(String.format("Не удалось загрузить файл %s", fileName));
            }

        }

        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

//		finally {
//			if (fstream != null) {
//				fstream.close();
//			}
//		}
    }

    public HashMap<Integer, String> getTagBase() {
        return tagBase;
    }
}
