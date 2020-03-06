/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date:    3-2-20
 *
 *  Description: Class that finds the shortest length and route between two
 *               vertices using Djikstras Algorithm.
 **************************************************************************** */


public class Dijkstras {
    minPQ pq;
    GraphNode[] graph;


    public Dijkstras(){
        GraphLoader gl = new GraphLoader("usa.txt");
        graph = gl.getGraph();
        pq = new minPQ(graph.length);
    }

    public QueueNode getNode(int loc1, int loc2){
        for(int i=0; i < graph.length; i++){
            if(i == loc1){
                //enqueue starting vertex with priority of 0.
                pq.enqueue(new QueueNode(i, 0));
            } else {
                //enqueue other vertices with artificially high priority.
                pq.enqueue(new QueueNode(i, 1000000000));
            }
            graph[i].setCurrPriority(1000000000);
        }

        QueueNode curr = pq.dequeue();
        while(curr.val != loc2) {
            //get next if visited
            if(graph[curr.val].isVisited()){
                curr = pq.dequeue();
            }
            graph[curr.val].setVisited(true);
            //get connections
            LinkedList<Integer> currConnections = graph[curr.val].getConnections();
            int currX = graph[curr.val].getX();
            int currY = graph[curr.val].getY();
            for(Integer c : currConnections){
                if(graph[c].isVisited() == false) {
                    int connX = graph[c].getX();
                    int connY = graph[c].getY();
                    int distance = (int) Math
                            .sqrt(Math.pow((currX - connX), 2) + Math.pow((currY - connY), 2));
                    int newPriority = distance + curr.priority;
                    //lower priority
                    if (newPriority < graph[c].getCurrPriority()) {
                        QueueNode adjacentNode = new QueueNode(c, newPriority);
                        adjacentNode.setPrevious(curr);
                        pq.enqueue(adjacentNode);
                        graph[c].setCurrPriority(newPriority);
                    }
                }
            }
        }

        Stack<QueueNode> s = new Stack<QueueNode>();
        QueueNode current = curr;
        while(current!=null){
            s.push(current);
            current = current.getPrevious();
        }

        System.out.println("Route:");
        for(QueueNode qn : s){
            System.out.println(qn.val);
        }
        System.out.println("Distance: ");
        System.out.println(curr.priority);
        return curr;
    }


    public static void main(String[] args) {
        Dijkstras d = new Dijkstras();
        d.getNode(100,3000);
    }
}
