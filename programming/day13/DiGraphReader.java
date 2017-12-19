import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    Graph<String,Double> r = new Graph();
    INode<String> one;
    INode<String> two;
//    IList<INode> path = new DoubleLinkList<INode>();
    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        // Open the file
        BufferedReader br=new BufferedReader(new FileReader(filename));
        String h = br.readLine();
        IDict<String,INode<String>> tree = new BSTree();

        while(h != null){
            String u[] = h.split(":");
            //Get the source if it already exists or else make a new one
            if(tree.fetch(u[0]) == null){
                one = r.addNode(u[0]);
                tree.add(u[0],one);
            }
            one = tree.fetch(u[0]);
            //Get the dest. node if is already exists or make new once
            if(tree.fetch(u[1]) == null){
                two = r.addNode(u[1]);
                tree.add(u[1],two);
            }
            two = tree.fetch(u[1]);
            //add the edge to the graphs
            Double b = Double.parseDouble(u[2]);
            r.addEdge(one,two,b);
            h = br.readLine();
        }
        return r;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
        INode<String> start = edges[0].getSource();
        INode<String> end = edges[5].getDestination();
        Searcher s = new Searcher();
//        boolean test;
//        test = s.pathExists(g, start, end);
        IList<INode> path = s.getPath(g, start, end);
        for (int i = 0; i < path.size();i++){
            System.out.println(path.fetch(i).getValue());
        }
    }
}