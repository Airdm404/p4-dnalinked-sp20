public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;
        /**
         Constructor that creates a LinkStrand based on
         * @param s is a String
         * @param n is the node it points toward
         */
        public Node(String s, Node n) {
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast, myCurrent;
    private long mySize;
    private int myAppends, myIndex, myLocalIndex;
    /**
     Constructor that creates a LinkStrand based on
     * @param s is a String
     */
    public LinkStrand(String s) {
        initialize(s);
    }
    /**
     Constructor that creates a LinkStrand with no parameters
     */
    public LinkStrand() {
        this("");
    }

    /**
     Initializes instance variables
     * @param source is a String that gives information for the LinkStrand
     */
    @Override
    public void initialize(String source) {
        myFirst = new Node(source, null);
        myLast = myFirst;
        mySize = source.length();
        myAppends = 0;
        myCurrent = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
    }
    /**
     Copies the given String to a new LinkStrand
     * @param source is a String that gives information for the LinkStrand
     * @return a LinkStrand object
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }
    /**
     Getter for mySize
     * @return the mySize int
     */
    @Override
    public long size() {
        return mySize;
    }
    /**
     Appends a new String to the pre-existing one
     @param String dna to be added
     @return the same node
     */
    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node (dna,null);
        myLast = myLast.next;
        mySize +=dna.length();
        myAppends++;
        return this;
    }
    /**
     *Reverses order of characters
     */
    @Override
    public IDnaStrand reverse() {
    Node iterator = myFirst;
    Node f = iterator;
    while(iterator != null){
        StringBuilder c = new StringBuilder(iterator.info);
        c.reverse();
        String s1 = c.toString();
        iterator.info = s1;
        iterator = iterator.next;
    }
    LinkStrand n1 = new LinkStrand(f.info);
    f=f.next;
    while(f != null){
        n1.myFirst = new Node(f.info, n1.myFirst);
        f=f.next;
    }
        return n1;
    }
    /**
     *Getter for myAppends
     * @return int myAppends
     */
    @Override
    public int getAppendCount() {
    return myAppends;
    }
    /**
    *Gives the character at a given index
     *@param int index is the index to be searched
     * @return a LinkStrand object
     */
    @Override
    public char charAt(int index) {
        if(index <= 0 || index>mySize-1){
            throw new IndexOutOfBoundsException("out of bounds");
        }
        if(index < myIndex){
        myCurrent = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
        }
        while(myIndex != index){
            myLocalIndex++;
            myIndex++;
            if(myLocalIndex >= myCurrent.info.length()){
                myLocalIndex = 0;
                myCurrent = myCurrent.next;
            }
        }
        return myCurrent.info.charAt(myLocalIndex);
        }
    /**
    *Turns node to a String
     * @return String given from node
     */
    @Override
    public String toString() {
        Node temp = myFirst;
        StringBuilder hold = new StringBuilder();
        while (temp != null) {
            hold.append(temp.info);
            temp = temp.next;
        }
        return hold.toString();
    }


}

