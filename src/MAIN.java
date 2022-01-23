import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.lang.Math;
public class MAIN {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Airports aero1 = new Airports("DSU","IOTA", "FR",265, 340);
        Airports aero2 = new Airports("DSA","NUA", "ESPN",255, 300);



        System.out.println(aero1.toString());
        System.out.println(aero2.toString());
        //System.out.println("Nombre d'aréoports : " +aero1.getNumber());
        //etu2 = null;
        World w = new World ("C:/Users/DIARIETOU/IdeaProjects/GLOBE/Resources/airport-codes_no_comma.csv");
        System.out.println("Found "+w.getAeroList().size()+" airports.");
        Airports paris = w.findNearestAirport(2.316,48.866);
        Airports cdg = w.findByCode("CDG");
        double distance = w.distance(2.316,48.866,paris.getLongitude(),paris.getLatitude());
        System.out.println(paris);
        System.out.println(distance);
        double distanceCDG = w.distance(2.316,48.866,cdg.getLongitude(),cdg.getLatitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/DIARIETOU/IdeaProjects/GLOBE/Resources/JsonOrly.txt"));
            String test = br.readLine();
            /*JsonFlightFiller jSonFlightFiller = new JsonFlightFiller(test,w);*/
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
