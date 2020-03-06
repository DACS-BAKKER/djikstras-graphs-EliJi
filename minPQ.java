/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date:    3-2-20
 *
 *  Description: minPQ implementation using minHeap.
 **************************************************************************** */

public class minPQ {

    minHeap mh;

    public minPQ(int size){
        mh = new minHeap(size);
    }

    public void enqueue(QueueNode n){
        mh.insert(n);
    }

    public QueueNode dequeue(){
        return mh.remove();
    }

    public minHeap getMh() {
        return mh;
    }

    public static void main(String[] args) {

    }
}
