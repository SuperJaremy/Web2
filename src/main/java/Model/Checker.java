package Model;


public class Checker implements Check {
    private boolean checkAreaOne(Double x, Double y, Double r){
        if(x.compareTo(0.0)<0||y.compareTo(0.0)<0)
            return false;
        return Double.compare(Math.pow(x, 2.0) + Math.pow(y, 2.0), Math.pow(r / 2.0, 2.0))<=0;
    }

    private boolean checkAreaTwo(Double x, Double y, Double r){
        if(x.compareTo(0.0)>0||y.compareTo(0.0)<0){
            return false;
        }
        return x.compareTo(-r)>=0 && y.compareTo(r/2.0)<=0;
    }

    private boolean checkAreaThree(Double x, Double y, Double r){
        if(x.compareTo(0.0)>0 || y.compareTo(0.0)>0)
            return false;
        return false;
    }

    private boolean checkAreaFour(Double x, Double y, Double r){
        if(x.compareTo(0.0)<0||y.compareTo(0.0)>0)
            return false;
        return y.compareTo(x-r)>=0;
    }

    @Override
    public boolean checkDot(double x, double y, double r) {
        Double _x = x;
        Double _y = y;
        Double _r = r;
        return checkAreaOne(_x,_y,_r) || checkAreaTwo(_x,_y,_r) ||
                checkAreaThree(_x,_y,_r) || checkAreaFour(_x,_y,_r);
    }
}
