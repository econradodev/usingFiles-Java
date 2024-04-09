import java.io.*;

public class Program {
    public static void main(String[] args) {

        String pathIn = ("C:\\initialFile.csv");
        String pathOut = ("C:\\summary.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn))){
            String line = br.readLine();
            while (line != null){
                String[] text = line.split(",");
                String name = text[0];
                float price = Float.parseFloat(text[1]);
                int quantity = Integer.parseInt(text[2]);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut, true))){
                    bw.write(name + "," + price * quantity);
                    bw.newLine();
                } catch (IOException e){
                    e.printStackTrace();
                    }

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}