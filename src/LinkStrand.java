public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;

        public Node(String s, Node n) {
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;

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
        StringBuilder reversed = new StringBuilder(myLast.info);
        LinkStrand copy = new LinkStrand(reversed.reverse().toString());




        copy.reverse()

        return null;
    }

    @Override
    public int getAppendCount() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
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
