public class Node {


    private int data;
    private Node next;

    //  constructor
    Node(int d){
        this.data = d;  //  set data to parameter entered
        this.next = null;  //  default to null
    }

    public int getData() {
        return data;}

    public void addToData(int data){
        this.data += data;
    }

    public void setData(int data) {this.data = data;}


    public Node getNext() {
        return this.next;
        }

    public void setNext(Node node){
        this.next = node;
    }


}
