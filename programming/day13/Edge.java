/**
 * Interface for an edge in a graph. Edges are immutable.
 */
public class Edge<N,W> implements IEdge<N,W> {
    // Implementors should implement a construct that takes in the
    // source, destination, and weight
    INode<N> source = new Node<N>(null);
    INode<N> destination = new Node<N>(null);
    W weight;

    public Edge(INode<N> s, INode<N> d, W w){
        this.source = s;
        this.destination = d;
        this.weight = w;
        }

    public void setSource(INode<N> node){
        this.source = node;
        }

    public void setDestination(INode<N> node){
        this.destination =node;
        }
/**
 * The source node of the edge
 * @return the source node
 */
    public INode<N> getSource(){
        return this.source;
        }

    /**
     * The destination node of the edge
     * @return the destination node
     */
    public INode<N> getDestination(){
        return this.destination;
        }

    /**
     * The weight of the edge
     * @return the weight
     */
    public W getWeight(){
        return this.weight;
        }

    public void setWeight(W w){
        this.weight = w;
        }

    /**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
    public boolean equals(Object o){
            Edge other = (Edge) o;
            if(this.source.equals(other.getSource()) && this.destination.equals(other.getDestination())){
                return true;
        }
        else{
                return false;
        }
        }

}