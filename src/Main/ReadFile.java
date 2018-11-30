package Main;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import Main.Bucket;
public class ReadFile {
    private static final String pathname = "src\\Main\\X-n101-k25.vrp";
    private int dimention;
    private int capacity;
    private ArrayList<Bucket> coord;   //toa do diem den
    private ArrayList<Bucket> demand;  //nhu cau khach hang

    public int getDimention() {
        return dimention;
    }

    public void setDimention(int dimention) {
        this.dimention = dimention;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Bucket> getCoord() {
        return coord;
    }

    public void setCoord(ArrayList<Bucket> coord) {
        this.coord = coord;
    }

    public ArrayList<Bucket> getDemand() {
        return demand;
    }

    public void setDemand(ArrayList<Bucket> demand) {
        this.demand = demand;
    }

    public ReadFile(int dimention, int capacity, ArrayList<Bucket> coord, ArrayList<Bucket> demand) {
        this.dimention = dimention;
        this.capacity = capacity;
        this.coord = coord;
        this.demand = demand;
    }

    public ReadFile(){};

    public ReadFile readFile() throws Exception{
            String content = new String(Files.readAllBytes(Paths.get(pathname)), StandardCharsets.UTF_8);
            String[] str = content.split("\n");

            StringTokenizer st = new StringTokenizer(str[3]);
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            int dimention =  Integer.parseInt(c.trim());
            this.dimention = dimention;

            StringTokenizer st2 = new StringTokenizer(str[5]);
            String a2 = st2.nextToken();
            String b2 = st2.nextToken();
            String c2 = st2.nextToken();
            int capacity = Integer.parseInt(c2.trim());
            this.capacity = capacity;

        ArrayList<Bucket> listCoord = new ArrayList<Bucket>();
        for(int i=7; i<7+dimention; i++){
            String[] s2 = str[i].split("\\t");
            Bucket bucket = new Bucket(Integer.parseInt(s2[0].trim()), Integer.parseInt(s2[1].trim()), Integer.parseInt(s2[2].trim()));
            listCoord.add(bucket);
        }
        this.coord = listCoord;

        ArrayList<Bucket> listDemand = new ArrayList<Bucket>();
        for(int i = 8+dimention; i<str.length-4; i++){
            String[] s2 = str[i].split("\\t");
            Bucket bucket = new Bucket(Integer.parseInt(s2[0].trim()), Integer.parseInt(s2[1].trim()));
            listDemand.add(bucket);
        }
        this.demand = listDemand;
        return this;
    }

}
