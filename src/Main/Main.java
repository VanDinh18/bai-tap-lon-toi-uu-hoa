package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static Main.Distance.distance;

public class Main {
    public static double Min(Bucket a, ArrayList<Bucket> coords){
        if (coords.size()>1) {
            double min = distance(a, coords.get(1));
            for (int i = 0; i < coords.size(); i++) {
                if (coords.get(i).getA() != a.getA()) {
                    if (distance(a, coords.get(i)) < min) {
                        min = distance(a, coords.get(i));
                    }
                }
            }
            return min;
        }
        else return 0;
    }

    public static void Sort(Bucket a, ArrayList<Bucket> coords, ArrayList<Bucket> demands){
        if(coords.size()>1){
            for (int i = 1; i < coords.size()-1; i++) {
                for (int j = 1; j<coords.size()-1; j++){
                    if(distance(a,coords.get(j))<distance(a,coords.get(j+1))){
                        Collections.swap(coords, j, j+1);
                        Collections.swap(demands, j, j+1);
                    }
                }
            }
        }
    }

    public static int DemandMin(ArrayList<Bucket> demands){
        int min = demands.get(0).getB();

        for(int i = 0 ; i < demands.size() ; i++){
            if(demands.get(i).getB() < min)
                min = demands.get(i).getB();
        }
        return min;
    }

    public static void main(String[] args) throws Exception{
        ReadFile rf = new ReadFile();
        rf = rf.readFile();
        int dimention = rf.getDimention();
        int capacity = rf.getCapacity();
        ArrayList<Bucket> coord = rf.getCoord();
        ArrayList<Bucket> demand = rf.getDemand();


        Bucket depot = new Bucket();
        depot.setA(coord.get(0).getA());
        depot.setB(coord.get(0).getB());
        depot.setC(coord.get(0).getC());
        int xe = 1;
        int tong =0;
        int d=0;

        Sort(coord.get(0), coord, demand);

        while (demand.size()>1){
            int sum = 0;
            int min = 0;
            System.out.println("XE : " + xe);
            while (sum+min <= capacity && coord.size() > 1){

                Sort(coord.get(0), coord, demand);
                int a=1;
                boolean f = false;
                while (!f){
                    if(demand.size()-a < 0){
                        f = true;
                    }
                    else {
                        if (sum + demand.get(demand.size() - a).getB() <= capacity) {
                            sum += demand.get(demand.size() - a).getB();
                            System.out.println("STT : " + coord.get(demand.size()-a).getA() + "   Demands : " + demand.get(demand.size()-a).getB());
                            tong++;
                            d+=distance(coord.get(0), coord.get(demand.size()-a));
                            Collections.swap(coord, 0, demand.size() - a);
                            Collections.swap(demand, 0, demand.size() - a);
                            coord.remove(demand.size() - a);
                            demand.remove(demand.size() - a);

                            f = true;
                        } else {
                            a++;
                        }
                    }
                }
                if(demand.size()!=0)
                    min = DemandMin(demand);
            }
            d += distance(coord.get(0),depot);
            coord.get(0).setA(depot.getA());
            coord.get(0).setB(depot.getB());
            coord.get(0).setC(depot.getC());
            demand.get(0).setB(0);
            System.out.println("Demands: " + sum);
            xe++;
            System.out.println("Tong khach hang: " + tong);
            System.out.println("Distance : "+d);
            System.out.println();
            System.out.println();
        }
    }
}
