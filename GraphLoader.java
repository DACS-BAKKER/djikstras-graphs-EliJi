/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date:    3-2-20
 *
 *  Description: This class loads all the info in usa.txt into an array. The
 *               getGraph method is used to get this array.
 **************************************************************************** */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GraphLoader {

    GraphNode[] graph;
    String fileName;

    public GraphLoader(String fileName){
        this.fileName = fileName;
    }

    public GraphNode[] getGraph(){
        loadData();
        return graph;
    }

    public void loadData(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int currentLine = 1;
            while(true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                StringTokenizer st = new StringTokenizer(line);
                // set size of graph to number of vertices on the first line
                if(currentLine == 1){
                    graph = new GraphNode[Integer.parseInt(st.nextToken())];
                // create graph nodes and put into graph
                } else if (st.countTokens() == 3) {
                    int index = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    graph[index] = new GraphNode(x, y, new LinkedList<Integer>());
                // add connections to linked lists
                } else if (st.countTokens() == 2){
                    int firstRoad = Integer.parseInt(st.nextToken());
                    int secondRoad = Integer.parseInt(st.nextToken());
                    //add connection to both roads
                    graph[firstRoad].getConnections().add(secondRoad);
                    graph[secondRoad].getConnections().add(firstRoad);
                }
                currentLine++;
            }
            br.close();
        }catch(IOException ex){
            System.out.println("Error in reading file.");
        }
    }

    // For Testing
    public static void main(String[] args) {
        GraphLoader gl = new GraphLoader("usa.txt");
        GraphNode[] graph = gl.getGraph();
        for(int i =0; i<1000; i++){
            System.out.print(i + "  ");
            System.out.print("x:" + " " + graph[i].getX() + "  y:" + graph[i].getY());
            System.out.print("  Connections:");
            for(Integer s: graph[i].getConnections()) {
                System.out.print("  " + s);
            }
            System.out.println("");
        }
    }

}
