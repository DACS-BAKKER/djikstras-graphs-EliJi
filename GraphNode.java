/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date:    3-2-20
 *
 *  Description: Node used in the graph.
 **************************************************************************** */

public class GraphNode {

    private int x;
    private int y;
    private LinkedList<Integer> connections;

    //used in dijkstras
    private boolean visited;
    private int currPriority;

    public GraphNode(int x, int y, LinkedList<Integer> connections){
        this.x = x;
        this.y = y;
        this.connections = connections;
        visited = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCurrPriority() {
        return currPriority;
    }

    public void setCurrPriority(int currPriority) {
        this.currPriority = currPriority;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public LinkedList<Integer> getConnections() {
        return connections;
    }

    public static void main(String[] args) {
    }
}
