/**
 * Interface for a directed graph data structure
 */
public class Graph<N, W> implements IGraph<N, W> {
    //Two new lists one for edges and one for nodes
    DoubleLinkList<INode> nodes;
    DoubleLinkList<IEdge> edges;
    public Graph(){
        nodes = new DoubleLinkList<INode>();
        edges = new DoubleLinkList<IEdge>();
    }

    /**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet(){
        INode[] all_nodes = new Node[nodes.size()];
        if (nodes.size() == 0){
            return null;
        }
        for (int i = 0;i < nodes.size();i++){
            all_nodes[i] = nodes.fetch(i);
        }
        return all_nodes;
    }

    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n){
        //Counter to get the size of returned array
        int j = 0;
        for (int i = 0; i < edges.size();i++){
            if (edges.fetch(i).getSource() == n){
                j++;
            }
        }
        if(j == 0){
            return null;
        }
        //Indexes for array that will be returned
        int z = 0;
        INode[] node = new INode[j];
        for (int i = 0; i < edges.size();i++){
            if (edges.fetch(i).getSource() == n){
                node[z] = edges.fetch(i).getSource();
                z++;
            }
        }
        return node;
    }

    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v){
        INode<N> node = new Node(v);
        nodes.append(node);
        return node;
    }

    /**
     * Gets an array of all the edges in the graph
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgeSet(){
        IEdge[] all_edges = new Edge[edges.size()];
        if (edges.size() == 0){
            return null;
        }
        for (int i = 0;i < edges.size();i++){
            all_edges[i] = edges.fetch(i);
        }
        return all_edges;
    }

    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
        //Counter to get the size of returned array
        int j = 0;
        for (int i = 0; i < edges.size();i++){
            if (edges.fetch(i).getSource() == n){
                j++;
            }
        }
        if(j == 0){
            return null;
        }
        //Indexes for array that will be returned
        int z = 0;
        IEdge[] sourced = new Edge[j];
        for (int i = 0; i < edges.size();i++){
            if (edges.fetch(i).getSource() == n){
                sourced[z] = edges.fetch(i);
                z++;
            }
        }
        return sourced;

    }

    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n){
        //Counter to get the size of returned array
        int j = 0;
        for (int i = 0; i < edges.size();i++){
            if (edges.fetch(i).getDestination() == n){
                j++;
            }
        }
        if(j == 0){
            return null;
        }
        IEdge[] destinations = new Edge[j];
        //Indexes for array that will be returned
        int z = 0;
        for (int i = 0; i < edges.size();i++){
            if (edges.fetch(i).getDestination() == n){
                destinations[z] = edges.fetch(i);
                z++;
            }
        }
        return destinations;
    }


    /**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
    public void addEdge(INode<N> s, INode<N> d, W w){
        Edge<N, W> edge = new Edge<N, W>(s, d ,w);
        if(edges.size() == 0){
            edges.append(edge);
        }
        for (int i = 0; i < edges.size();i++) {
            if ((edge.equals(edges.fetch(i))) == true){
                System.out.println("here");
                break;
            }

        }
        edges.append(edge);

    }
}