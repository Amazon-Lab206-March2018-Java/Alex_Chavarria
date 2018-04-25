public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList (){
        this.head = null;
    }

    public SinglyLinkedList add(int number){
        Node node = new Node(number);
        Node pointer = this.head;
        if(this.head==null){
            this.head=node;
            return this;
        }
        while(pointer!=null){
            if(pointer.getNext()==null){
                pointer.setNext(node);
                return this;
            }
            pointer=pointer.getNext();
        }
        return this;
    }
    public void printValues(){
        Node pointer = this.head;
        while(pointer!=null){
            System.out.println(pointer.getValue());
            pointer=pointer.getNext();
        }
    }
    public void remove(){
        //return node that was removed 
        Node pointer = this.head;
        while(pointer.getNext().getNext()!=null){
            pointer=pointer.getNext();
        }
        pointer.setNext(null);
        
    }
}