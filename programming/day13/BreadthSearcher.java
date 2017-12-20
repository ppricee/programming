public class BreadthSearcher<N,W> implements ISearcher<N,W> {
    IGraph<N, W> g;
    INode<N> s;
    INode<N> e;
    Stack path_stack = new Stack();
    boolean path_exist;
    DoubleLinkList<INode> checked = new DoubleLinkList<INode>();


    public BreadthSearcher(IGraph<N, W> graph, INode<N> start, INode<N> end) {
        g = graph;
        s = start;
        e = end;
    }
//double coded by paul and tian

    /**
     * Determines if there is a path without returning the path
     *
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) {
        IList<INode<N>> path = new DoubleLinkList<INode<N>>();
        if (s == e){
            path_exist = true;
            path_stack.push(e);
            path = path_stack.getStack();
            return true;
        }
        checked.append(s);
        path_stack.push(s);
        INode[] n = g.getNeighbors(s);
        DoubleLinkList<INode> neighbors = new DoubleLinkList<>();
        for (int i = 0; i < n.length;i++){
            neighbors.append(n[i]);
        }
        if(neighbors.size() > 0) {
            for (int j = 0; j < checked.size();j++) {
                for (int i = 0; i < neighbors.size(); i++) {
                    if (checked.fetch(j).equals(neighbors.fetch(i))){
                        neighbors.remove(i);
                    }
                }
            }
            for (int i = 0; i < neighbors.size();i++){
                if (pathExists(g,neighbors.fetch(i),e) == true){
                    return true;
                }
            }
            if(path_exist == false){
                path_stack.pop();
            }

        }
        else{
            path_stack.pop();
        }
        return path_exist;

    }


    /**
     * Finds a path based on the properties of the search algorithm.
     * If there is no path in graph g from node s to node e, null should be
     * returned. If node s and node e are the same, an empty list should be returned.
     *
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return the list of nodes in the path
     */

    public IList<INode<N>> getPath(IGraph<N, W> g, INode<N> s, INode<N> e) {
        ArrayQueue<IEdge<N, W>> q = new ArrayQueue(g.getEdgeSet().length);
        DoubleLinkList<INode<N>> visited_nodes = new DoubleLinkList();
        Stack<IEdge<N, W>> stack_path = new Stack();

        if (s == e) {
            IList<INode<N>> empty_path = new DoubleLinkList();
            return empty_path;
        }
        if(pathExists(g,s,e) == false){
            return null;
        }

        IEdge<N, W>[] edge_neighbors = g.getEdgesFrom(s);
        visited_nodes.append(s);

        for (int i = 0; i < edge_neighbors.length; i++) {
                q.enqueue(edge_neighbors[i]);
        }

        boolean runner = true;
        while (runner == true) {
            if (g.getEdgeSet().length == stack_path.getSize()) {
                return null;
            }
            IEdge<N, W> edge = q.dequeue();
            boolean node_checker = true;
            for (int j = 0; j < visited_nodes.size(); j++) {
                if (visited_nodes.fetch(j) == edge.getDestination()) {
                    node_checker = false;
                }
                else if(edge.getDestination() == e){
                    stack_path.push(edge);
                    runner = false;
                }
            }

            if (node_checker == true) {
                stack_path.push(edge);
                INode<N> node = edge.getDestination();
                visited_nodes.append(node);

                IEdge<N, W>[] edge_neighbor = g.getEdgesFrom(node);
                for (int i = 0; i < edge_neighbor.length; i++) {

                    if (edge_neighbor[i].getDestination().getValue() == null) {

                    }
                    else if (edge_neighbor[i].getDestination() == e) {
                        stack_path.push(edge_neighbor[i]);
                        runner = false;
                    }
                        q.enqueue(edge_neighbor[i]);
                }
            }
        }

            IList<INode<N>> the_path = new DoubleLinkList<INode<N>>();

        IEdge<N,W> beginning_edge =  stack_path.pop();
        INode<N> beginning_node =  beginning_edge.getSource();
        the_path.insert(0,e);
        while(stack_path.isEmpty()==false){
            IEdge<N,W> new_edge = stack_path.pop();
            if(new_edge.getDestination()==beginning_node){
                the_path.insert(0,new_edge.getDestination());
                beginning_node = new_edge.getSource();
            }
        }
        the_path.insert(0,s);
        IEdge<N, W>[] edge_neighbor = g.getEdgesFrom(s);

            return the_path;
        }
    }



