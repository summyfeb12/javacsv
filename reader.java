import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class reader {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			String line;
			br = new BufferedReader(new FileReader("/Users/spandu3/Documents/samples/students.csv"));
      ArrayList<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
			// How to read file in java line by line?
			while ((line = br.readLine()) != null) {
        total.add(CSVtoArrayList(line));
			}
      ArrayList<String> classprof =new ArrayList<String>();
      ArrayList<String> stuclass =new ArrayList<String>();
      for(int i=0;i<total.size();i++)
      {
        String str=total.get(i).get(0)+","+(total.get(i)).get(1);
        classprof.add(str);
        str = total.get(i).get(0)+","+(total.get(i)).get(2);

      }
      HashSet<String> uniqueclassprof = new HashSet<String>(classprof);
     for (String value : uniqueclassprof) {
       System.out.println(value);
     }









}
    catch (IOException e) {
			e.printStackTrace();
		}
    finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> CSVtoArrayList(String CSV) {
		ArrayList<String> result = new ArrayList<String>();

		if (CSV != null) {
			String[] splitData = CSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					result.add(splitData[i].trim());
				}
			}
		}

		return result;
	}

}
