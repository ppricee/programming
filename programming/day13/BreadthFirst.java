public class BreadthFirst<N,W> implements ISearcher<N,W>
{
    IGraph<N,W> g;
    INode<N> s;
    INode<N> e;
//double coded by paul and tian
    public BreadthFirst(IGraph<N,W> graph, INode<N> start, INode<N> end){
        g = graph;
        s = start;
        e = end;
    }
    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
        return false;
    }


    /**
     * Finds a path based on the properties of the search algorithm.
     * If there is no path in graph g from node s to node e, null should be
     * returned. If node s and node e are the same, an empty list should be returned.
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return the list of nodes in the path
     */
    public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
        Queue<IEdge<N,W>> q = new Queue(g.getNodeSet().length);
        DoubleLinkList<INode<N>> visited_nodes = new DoubleLinkList();
        Stack<IEdge<N,W>> dq_edges = new Stack();

        if (s == e){
            IList<INode<N>> empty_path = new DoubleLinkList();
            return empty_path;
        }

        IEdge<N,W>[] edge_neighbors = g.getEdgesFrom(s);
        for (int i = 0;i<edge_neighbors.length;i++){
            q.enqueue(edge_neighbors[i]);
        }
        visited_nodes.append(s);

        boolean runner = true;
        while(runner == true)
        {
            if(g.getEdgeSet().length == dq_edges.getSize()){
                return null;
            }
            IEdge<N,W> edge = q.dequeue();
            System.out.println(edge);
            boolean node_checker = true;
            for (int j = 0;j<visited_nodes.size(); j++ ) {
                if(visited_nodes.fetch(j) == edge.getDestination()){
                    node_checker = false;
                }
            }
            if(node_checker == true)
            {
                dq_edges.push(edge);
                INode<N> node = edge.getDestination();
                visited_nodes.append(node);
                if(node == e){
                    runner = false;
                }

                IEdge<N,W>[] edge_neighbor = g.getEdgesFrom(node);

                for (int i = 0;i<edge_neighbor.length;i++){
                    q.enqueue(edge_neighbor[i]);
                }
            }
        }


        IList<INode<N>> path = new DoubleLinkList();
        while(dq_edges.isEmpty()==false){
            path.insert(0,dq_edges.pop().getSource());
        }

        return path;
    }




}