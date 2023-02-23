public class linkedList {

    //  instance variable for the head of the list
    private Node head;
    private int size;
    public linkedList(){
        this.head = null;
        this.size = 0;
    }
    public int getSize(){
        return this.size;
    }


    //  adds node to front of list
    public void add(int data) {

        Node new_node = new Node(data); //  create new Node for item to be inserted
        if (this.head == null) {
            this.head = new_node;  //  if list is empty, make the head the first thing added
        } else {
            // adding to head
//            new_node.setNext(this.head);
//            this.head = new_node;
            // adding to tail
            Node curr = this.head;
            while (curr.getNext() != null) { //  traverse list
                curr = curr.getNext(); //  keep going
            }
            curr.setNext(new_node); //  once reaches end, make the last item's next the new node
        }
        this.size ++;

    }

    //  method removes last added item from list
    public void pop() {

        Node old = this.head;  //  pointer for old
        this.head = this.head.getNext();  //  set new head
        old.setNext(null);  //  set old head's next to null to disconnect
        this.size --;
    }


    //  method to retrieve val at index
    public int getVal(int index) {
        Node curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();  //  traverse linked list
        }
        return curr.getData();
    }


    //  prints list for testing
    public String printList() {
        Node curr = this.head;
        String res = "";
        while (curr != null) {  //  traverse linked list
            res = res + curr.getData();
            curr = curr.getNext();  //  move onto next node
        }
        System.out.println(res);  //  print
        return res;
    }

    public String toString() {
        Node curr = this.head;
        String res = "";
        while (curr != null) {  //  traverse linked list
            res = res + curr.getData();
            curr = curr.getNext();  //  move onto next node
        }
        return res;
    }

    public void reverse(){
        Node ptr = head;
        Node prev = null, curr = null;
        while (ptr != null){
            curr = ptr;
            ptr = ptr.getNext();

            curr.setNext(prev);
            prev = curr;
            head = curr;
        }

    }
    public linkedList clone(){
        linkedList copy = new linkedList();
        for (int i=0; i<this.getSize(); i++){
            copy.add(this.getVal(i));
        }
        return copy;
    }
}
