import java.io.*;
import java.util.ArrayList;

public class CSVController {
    public static final String SEPARATOR = ",";
    private final ArrayList<Champion> champions;


    public CSVController() {
        champions = new ArrayList<Champion>();
    }

    public ArrayList<Champion> readCSV(String path) {
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(SEPARATOR);
                Champion newChamp = new Champion(fields[0], fields[1], fields[2], Float.parseFloat(fields[3]), Integer.parseInt(fields[4]), Boolean.parseBoolean(fields[5]), fields[6]);
                champions.add(newChamp);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        return champions;
    }

    public void writeCSV(ArrayList<Champion> champions, String path) {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(path));
            for (Champion champion : champions) {
                bw.write(champion.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

}
