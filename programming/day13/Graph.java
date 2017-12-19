public class Graph<N,W> implements IGraph<N,W> {

    //Fields
    DoubleLinkList<INode> nodes;
    DoubleLinkList<IEdge> edges;


    public Graph(){
        nodes = new DoubleLinkList<INode>();
        edges = new DoubleLinkList<IEdge>();
    }

    public INode<N>[] getNodeSet(){
        INode[] a = new INode[nodes.size()];
        for(int k = 0; k < a.length;k++ ){
            a[k] = nodes.fetch(k);
        }
        return a;
    }

    public INode<N>[] getNeighbors(INode<N> n){
        DoubleLinkList<INode> neighbors = new DoubleLinkList();
        for(int i = 0; i < edges.size();i++){
            IEdge<N,W> thisOne = edges.fetch(i);
            if(thisOne.getSource().equals(n) ){
                neighbors.append(thisOne.getDestination());
            }
        }

        INode<N>[] a = (Node<N>[])new Node[neighbors.size()];
        for(int u = 0; u < neighbors.size(); u++){
            a[u] = neighbors.fetch(u);
        }
        return a;
    }

    public INode<N> addNode(N v){
        INode<N> addition = new Node(v);
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.fetch(i).equals(addition)){ return addition; }//returned even though it didnt add it to the list
        }
        nodes.append(addition);
        return addition;
    }

    public IEdge<N,W>[] getEdgeSet(){
        IEdge[] a = new IEdge[edges.size()];
        for(int k = 0; k < edges.size(); k++ ){
            a[k] = edges.fetch(k);
        }
        return a;
    }

    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
        DoubleLinkList<IEdge> temp = new DoubleLinkList();
        for(int i = 0; i < edges.size(); i++){
            IEdge<N,W> thisOne = edges.fetch(i);
            if(thisOne.getSource().equals(n)){
                temp.append(thisOne);
            }
        }
        IEdge<N,W>[] a = (Edge<N,W>[])new Object[edges.size()];
        for(int k = 0; k < temp.size(); k++ ){
            a[k] = temp.fetch(k);
        }
        return a;
    }

    public IEdge<N,W>[] getEdgesTo(INode<N> n){
        DoubleLinkList<IEdge> temp = new DoubleLinkList();
        for(int i = 0; i < edges.size(); i++){
            IEdge<N,W> thisOne = edges.fetch(i);
            if(thisOne.getDestination().equals(n)){
                temp.append(thisOne);
            }
        }
        IEdge<N,W>[] a = (Edge<N,W>[]) new Object[edges.size()];
        for(int k = 0; k < temp.size(); k++ ){
            a[k] = temp.fetch(k);
        }
        return a;
    }

    public void addEdge(INode<N> s, INode<N> d, W w){
        Edge<N,W> edge = new Edge<N,W>(s,d,w);
        if(edges.size() == 0){
            edges.append(edge);
        }
        for(int i = 0; i < edges.size(); i++){
            if(edges.fetch(i).equals(edge)){ return; }
        }
        edges.append(edge);
    }

}