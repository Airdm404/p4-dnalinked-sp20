public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;

        public Node(String s, Node n) {
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast, myCurrent;
    private long mySize;
    private int myAppends, myIndex, myLocalIndex;

    public LinkStrand(String s) {
        initialize(s);
    }

    public LinkStrand() {
        this("");
    }

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

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node (dna,null);
        myLast = myLast.next;
        mySize +=dna.length();
        myAppends++;
        return this;
    }

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

    @Override
    public int getAppendCount() {
    return myAppends;
    }

    @Override
    public char charAt(int index) {
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

