import java.io.*;

public class Program {
    public static void main(String[] args) {

        // recebe um arquivo .csv separado por virgula
        // criar string nome, float preço e int quantidade
        // le as linhas enquanto as linhas sao diferentes de null
        // usa o split com ',' para separar os dados num array
        // coleta a string na posicao do array, float e int tambem
        // imprime nome e preço * quantidade
        // continua o programa até as linhas serem difrentes de null



        String pathIn = ("C:\\initialFile.csv");
        String pathOut = ("C:\\summary.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn))){
            String line = br.readLine();
            while (line != null){
                String[] text = line.split(",");
                float price = Float.parseFloat(text[1]);
                int quantity = Integer.parseInt(text[2]);
                
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut, true))){
                    bw.write(text[0] + "," + price * quantity);
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