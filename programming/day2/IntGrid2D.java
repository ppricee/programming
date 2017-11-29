/**
 * An interface for 2D grids that store char values
 */
public class IntGrid2D implements IIntGrid2D{
    int up_x;
    int up_y;
    int low_x;
    int low_y;
    int c_x;
    int c_y;
    char[][] Grid;
    public IntGrid2D(int upper_x, int upper_y, int lower_x, int lower_y, char _fill){
        up_x = upper_x;
        up_y = upper_y;
        low_x = lower_x;
        low_y = lower_y;
        char fill = _fill;
        int g_x = Math.abs(up_x)+1+low_x;
        int g_y = up_y+1+ Math.abs(low_y);
        setGrid(g_x, g_y);
        for (int i = g_x; i > 0;i--){
            for (int j = g_y; j >0 ;j--) {
                Grid[i-1][j-1] = ' ';
            }

        }
    }
    public void setGrid(int g_x, int g_y){
        //Creates the right size Grid for the program
        Grid = new char[g_x][g_y];
    }
    /**
     * Sets the value at a point on the grid, replacing the previous value if any.
     * @param p The coordinate to set the value of
     * @param v The value to set at the coordinate
     */
    public void setPoint(IIntPoint2D p, char v){
        c_x = Math.abs(up_x);
        c_y = low_y;
        Grid[(p.getX() + c_x)][(Math.abs(p.getY()-c_y))] = v;
    }

    /**
     * Gets the value at a point on the grid
     * @param p The coordinate to get the value of
     * @returns the stored value
     */
    public char getPoint(IIntPoint2D p){
        int _x = p.getX() + Math.abs(up_x);
        int _y = Math.abs(p.getY() -low_y);
        return Grid[_x][_y];
    }

    /**
     * Gets the coordinate for the upper left most location
     * @returns an IIntPoint that is the coordinate of the upper left corner
     */
    public IIntPoint2D getUpperLeftCorner(){
        IIntPoint2D a = new IntPoint2D(up_x,up_y);
        return a;
    }

    /**
     * Gets the coordinate for the lower right most location
     * @returns an IIntPoint that is the lower right corner
     */
    public IIntPoint2D getLowerRightCorner(){
        IIntPoint2D b = new IntPoint2D(low_x,low_y);
        return b;
    }

}