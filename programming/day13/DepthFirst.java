public class DepthFirst<N,W>{
    Stack path_stack = new Stack();
    IGraph<N,W> g;
    INode<N> s;
    INode<N> e;
    DoubleLinkList<INode> checked = new DoubleLinkList<INode>();
    IList<INode<N>> path = new DoubleLinkList<INode<N>>();
    boolean nodes_exist;
    boolean path_exist;

    public DepthFirst(IGraph<N,W> graph, INode<N> start, INode<N> end){
        g = graph;
        s = start;
        e = end;
    }

    public boolean node(INode<N> s, INode<N> e){
        INode[] nodes = g.getNodeSet();
        int counter = 0;
        for (int i = 0;i < nodes.length;i++){
            if (nodes[i] == s || nodes[i] == e){
                counter++;
            }
        }
        if (counter == 2){
            nodes_exist = true;
            return true;
        }
        else {
            nodes_exist = false;
            return false;
        }
    }
    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean Exists(INode<N> s){
        if (nodes_exist == false){
            return false;
        }
        if (s == e){
            path_exist = true;
            path_stack.push(e);
            path = path_stack.getStack();
            System.out.println("HERHERHEHRE");
            System.out.println(path.size());
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
            for (int j = 0; j < checked.size()-1;j++) {
                for (int i = 0; i < neighbors.size(); i++) {
                  if (checked.fetch(j).equals(neighbors.fetch(i))){
                      neighbors.remove(i);
                  }
                }
            }
            for (int i = 0; i < neighbors.size();i++){
                    if (Exists(neighbors.fetch(i)) == true){
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
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return the list of nodes in the path
     */
    public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
        if (path.size() == 0){
            IList<INode<N>> empty_path = new DoubleLinkList<INode<N>>();
            return empty_path;
        }
        else if (path_exist == false){
            return null;
        }
        return path;
    }


}