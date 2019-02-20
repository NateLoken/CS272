//CS-272
//Nate Loken
//February 8, 2019
public class IntNode{
    private int data;
    private IntNode link;

    public IntNode(){
        data = 0;
        link = null;
    }

    public IntNode(int d, IntNode n){
        data = d;
        link = n;
    }

    public int getData(){
        return data;
    }

    public IntNode getLink(){
        return link;
    }

    public void setData(int newData){
        data = newData;
    }

    public void setLink(IntNode nLink){
        link = nLink;
    }
    /**
     * listLength parses the list to count how many nodes are in the list
     * @param head is the starting node for the length
     * @return the amount of nodes in an integer value
     */
    public static int listLength(IntNode head){
        int count = 0;
        IntNode cursor = head;
        while(cursor != null){
            cursor = cursor.getLink();
            count++;
        }
        return count;
    }

    /**
     * toString parses the list to create a formatted string of output that looks like x -> x ...
     * @return returns the formatted string 
     */
    public String toString(){
        String answer = "";
        answer += data;
        IntNode cursor = link;
        while(cursor != null){
            answer += " -> " + cursor.data;
            cursor = cursor.getLink();
        }
        return answer;
    }

    public void addNodeAfterThis(int newData){
        IntNode cursor = this;
        IntNode n = new IntNode(newData, cursor.getLink());
        cursor.setLink(n);
    }
    /**
     * removeNodeAfterThis removes the node after the one specified
     * @preconditions the node itself cannot be the tail and the node after must not be the tail
     */
    public void removeNodeAfterThis(){
        IntNode cursor = this;
        if(cursor.getLink() == null)
            return;
        if(cursor.getLink().getLink() == null){
            link = null;
            return;
        }
        cursor = cursor.getLink().getLink();
    }
    /**
     * The search function parses the singly linked list to check if it has and element witht the specified data
     * @param head is what node you want to start the search from
     * @param d is the data you want the function to search for
     * @return true if it found and node with the data and false if it doesn't 
     */
    public static boolean search(IntNode head, int d){
        IntNode cursor = head;
        for(int i = 0; i < listLength(cursor); i++){
            if(cursor.getData() == d) return true;
            cursor = cursor.getLink().getLink();
        }
        return false;
    }

}