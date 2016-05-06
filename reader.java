import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class reader {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			String line;
			br = new BufferedReader(new FileReader("students.csv"));
      ArrayList<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
      HashMap<String, ArrayList<String>> studentclass = new HashMap<String, ArrayList<String>>();
      HashMap<String, ArrayList<String>> profclass = new HashMap<String, ArrayList<String>>();
      HashMap<String, ArrayList<String>> profstudent = new HashMap<String, ArrayList<String>>();
      HashMap<String, ArrayList<String>> classstudent = new HashMap<String, ArrayList<String>>();
			while ((line = br.readLine()) != null) {
        total.add(CSVtoArrayList(line));
			}
      ArrayList<String> classprof =new ArrayList<String>();
      for(int i=0;i<total.size();i++)
      {
        String str=total.get(i).get(0)+","+(total.get(i)).get(1);
        classprof.add(str);
        if(studentclass.containsKey(total.get(i).get(2)))
        {
          String strV=total.get(i).get(0);
          String strK=total.get(i).get(2);
          ArrayList<String> al = studentclass.get(strK);
          al.add(strV);
          studentclass.put(strK,al);
        }
       else
       {
          String strV=total.get(i).get(0);
          String strK=total.get(i).get(2);
          ArrayList<String> al= new ArrayList<String>();
          al.add(strV);
          studentclass.put(strK,al);
       }
        if(profclass.containsKey(total.get(i).get(1)))
        {
          String strV=total.get(i).get(0);
          String strK=total.get(i).get(1);
          ArrayList<String> al = profclass.get(strK);
          al.add(strV);
          profclass.put(strK,al);
        }
       else
       {
          String strV=total.get(i).get(0);
          String strK=total.get(i).get(1);
          ArrayList<String> al= new ArrayList<String>();
          al.add(strV);
          profclass.put(strK,al);
       }
       if(profstudent.containsKey(total.get(i).get(1)))
       {
         String strV=total.get(i).get(2);
         String strK=total.get(i).get(1);
         ArrayList<String> al = profstudent.get(strK);
         al.add(strV);
         profstudent.put(strK,al);
       }
      else
      {
         String strV=total.get(i).get(2);
         String strK=total.get(i).get(1);
         ArrayList<String> al= new ArrayList<String>();
         al.add(strV);
         profstudent.put(strK,al);
      }
      if(classstudent.containsKey(total.get(i).get(0)))
      {
        String strV=total.get(i).get(2);
        String strK=total.get(i).get(0);
        ArrayList<String> al = classstudent.get(strK);
        al.add(strV);
        classstudent.put(strK,al);
      }
     else
     {
        String strV=total.get(i).get(2);
        String strK=total.get(i).get(0);
        ArrayList<String> al= new ArrayList<String>();
        al.add(strV);
        classstudent.put(strK,al);
     }

      }
     HashSet<String> uniqueclassprof = new HashSet<String>(classprof);
     System.out.println("------------------------------------------------");
     System.out.println("Class Sections Taught");
     System.out.println("------------------------------------------------");
     for (String value : uniqueclassprof)
     {
       System.out.println(value);
     }
     System.out.println("------------------------------------------------");
     System.out.println("Classes Taken By Each Student");
     System.out.println("------------------------------------------------");
     for (String key : studentclass.keySet())
     {
       System.out.print(key+": ");
       ArrayList<String> am = studentclass.get(key);
       for (String value : am)
       {
         System.out.print(value+", ");
       }
       System.out.println("\n");
     }
     System.out.println("------------------------------------------------");
     System.out.println("How many students are registered for each class?");
     System.out.println("------------------------------------------------");
     for (String key : classstudent.keySet())
     {
       ArrayList<String> am= classstudent.get(key);
       System.out.println(key+": "+am.size());
     }
     System.out.println("------------------------------------------------");
     System.out.println("How many students take more than one class?");
     System.out.println("------------------------------------------------");
     ArrayList<String> te= new ArrayList<String>();
     for (String key : studentclass.keySet())
     {
       ArrayList<String> al= studentclass.get(key);
       if(al.size()>1)
       {
          te.add(key);
       }
     }
     System.out.print(te.size()+": ");
     for (String value : te)
     {
       System.out.print(value+", ");
     }
     System.out.println("");
     System.out.println("------------------------------------------------");
     System.out.println("How many professors teach more than one class?");
     System.out.println("------------------------------------------------");
     ArrayList<String> tf= new ArrayList<String>();
     for (String key : profclass.keySet())
     {
       ArrayList<String> al= profclass.get(key);
       if(al.size()>1)
       {
          tf.add(key);
       }
     }
     System.out.print(tf.size()+": ");
     for (String value : tf)
     {
       System.out.print(value+", ");
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
