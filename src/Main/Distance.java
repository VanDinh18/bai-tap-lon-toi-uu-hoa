package Main;

public class Distance {
    public static double distance(Bucket a, Bucket b){
        double xy1 = Math.pow(a.getB() - b.getB(), 2);
        double xy2 = Math.pow(a.getC() - b.getC(), 2);
        double distance = Math.sqrt(Math.abs(xy1+xy2));
        return distance;
    }

}
