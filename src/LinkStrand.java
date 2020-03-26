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
     @param dna to be added
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
    StringBuilder r = new StringBuilder();
    Node r1 = this.myFirst;
    while(r1 != null){
        StringBuilder copy = new StringBuilder(r1.info);
        copy.reverse();
        r.insert(0,copy.toString());
        r1 = r1.next;
    }
    LinkStrand L = new LinkStrand(r.toString());
    return L;
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
     *@param index is the index to be searched
     * @return a LinkStrand object
     */
    @Override
    public char charAt(int index) {
        if(index < 0 | index >= mySize){
            throw new IndexOutOfBoundsException("Out of Bounds");
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

