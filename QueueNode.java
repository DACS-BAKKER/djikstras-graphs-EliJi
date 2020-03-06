/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date:    3-2-20
 *
 *  Description: Node used in priority queue and heap.
 **************************************************************************** */

public class QueueNode {

    int val;
    int priority;
    //previous is for the getting the solution at the end
    QueueNode previous;

    public QueueNode(int val, int priority){
        this.val = val;
        this.priority = priority;
    }

    public QueueNode getPrevious() {
        return previous;
    }

    public void setPrevious(QueueNode previous) {
        this.previous = previous;
    }

    public static void main(String[] args) {

    }
}
