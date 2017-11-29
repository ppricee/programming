/**
 * An interface describing a representation of integer points on a 2D plane.
 */
public class IntPoint2D implements IIntPoint2D{
    int x;
    int y;
    int x1;
    int y1;
    int x2;
    int y2;


    public IntPoint2D (int _x, int _y){
        x = _x;
        y = _y;
    }
        /**
         * @returns the X coordinate
         */


    public int getX(){
        /**
         * @returns the Y coordinate
         */
        return x;
        }
public int getY(){
        return y;
        }
    /**
     * Computes the manhattan distance to another point.
     * formula: abs(x1-x2) + abs(y1-y2)
     * @param o the other point
     * @returns the manhattan distance
     */
    public int manhattanDistance(IIntPoint2D o){
         x1 = x;
         y1 = y;
         x2 = o.getX();
         y2 = o.getY();
        int manhattan = Math.abs(x1-x2) + Math.abs(y1-y2);
        return manhattan;
        }
/**
 * Computes the euclidean distance to another point.
 * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
 * @param o the other point
 * @returns the euclidean distance
 */
    public double distance(IIntPoint2D o){
         x1 = x;
         y1 = y;
         x2 = o.getX();
         y2 = o.getY();
        double euclidian = (double) Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        return euclidian;
        }
    // The following methods make JAVA objects better behaved
    /**
     * Converts a point object to a string of the form (X,Y)
     * @returns human friendly point representation
     */
    public String toString(){
        return "X: " + getX() + " Y: " + getY();
    }
    /**
     * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
     * @returns true if this point is the same as point o
     */
    public boolean equals(IIntPoint2D o){
         x1 = x;
         y1 = y;
         x2 = o.getX();
         y2 = o.getY();
        if (x1 == x2){
            return true;
        }
        else if (y1 == y2){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Hashcode to support some standard library data structures
     * formula: (x<<16)+y
     * @returns the hashcode for the point
     */
    public int hashcode(){
        int hash = (x<<16)+y;
        return hash;

    }
}