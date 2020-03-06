/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date:    3-2-20
 *
 *  Description: My mplementation of a min heap. The zeroeth index of the heap
 *               stores the number of items in the array. I only implemented
 *               methods needed for minPQ (only removes min).
 **************************************************************************** */

public class minHeap {

    private QueueNode[] heap;

    public minHeap(int size){
        heap = new QueueNode[size + 1];
        heap[0] = new QueueNode(0, 0);
    }

    public void insert(QueueNode n){
        //resize if full
        if(heap[0].val == heap.length - 1){
            QueueNode[] temp = heap;
            heap = new QueueNode[heap.length * 2];
            for(int i = 0; i < temp.length; i++){
                heap[i] = temp[i];
            }
        }
        int index = heap[0].val + 1;
        heap[index] = n;
        int parentIndex = index/2;
        QueueNode parentNode = heap[parentIndex];
        while(parentNode.priority > n.priority){
            if(index == 1){
                heap[0].val++;
                return;
            }
            //swap with parent
            QueueNode temp = parentNode;
            heap[parentIndex] = n;
            heap[index] = temp;

            index = parentIndex;
            parentIndex = index/2;
            parentNode = heap[parentIndex];
        }
        heap[0].val++;
    }

    // removes and returns smallest item
    public QueueNode remove(){
        QueueNode removedNode = heap[1];
        //replace top with bottom right most
        int lastIndex = heap[0].val;
        heap[1] = heap[lastIndex];
        heap[lastIndex] = null;

        int leftIndex = 2;
        int rightIndex = 3;
        int currIndex = 1;
        QueueNode curr = heap[currIndex];

        while(true){
            //reached end
            if(leftIndex >= heap[0].val){
                break;
            } else if (rightIndex >= heap[0].val && curr.priority <= heap[leftIndex].priority){
                break;
            } else if (curr.priority <= heap[leftIndex].priority && curr.priority <= heap[rightIndex].priority){
                break;
            }
            if(rightIndex >= heap[0].val && heap[leftIndex].priority < curr.priority || heap[leftIndex].priority < heap[rightIndex].priority){
                //swap left
                heap[currIndex] = heap[leftIndex];
                heap[leftIndex] = curr;
                currIndex = leftIndex;
                leftIndex = currIndex * 2;
                rightIndex = (currIndex * 2) + 1;
            } else {
                //swap right
                heap[currIndex] = heap[rightIndex];
                heap[rightIndex] = curr;
                currIndex = rightIndex;
                leftIndex = currIndex * 2;
                rightIndex = (currIndex * 2) + 1;
            }
        }
        heap[0].val--;
        return removedNode;
    }

    public QueueNode[] getHeap() {
        return heap;
    }

    // For Testing
    public static void main(String[] args) {

        minHeap mh = new minHeap(30);
        mh.insert(new QueueNode (1000, 50));
        mh.insert(new QueueNode (1000, 20));
        mh.insert(new QueueNode (1000, 25));
        mh.insert(new QueueNode (1000, 3));
        mh.insert(new QueueNode (1000, 28));
        mh.insert(new QueueNode (1000, 11));
        mh.insert(new QueueNode (1000, 1));
        System.out.println("Removed:" + mh.remove());
        System.out.println("Removed:" + mh.remove());
        for(int i = 0; i<21; i++) {
            if(i ==0) {
                System.out.println(mh.heap[i].val);
            }
            else System.out.println(mh.heap[i].priority);
        }

    }
}
