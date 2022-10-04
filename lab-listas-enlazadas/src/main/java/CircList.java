////////////////////////////////////////////////////////////////
class Link {
    public long iData;
    public Link next;

    // -------------------------------------------------------------
    public Link(long id) {
        iData = id;
    }

    // -------------------------------------------------------------
    public void displayLink() {
        System.out.print(iData + " ");
    }
}

////////////////////////////////////////////////////////////////
class CircList {
    private Link current;
    private int count;

    // -------------------------------------------------------------
    public CircList() {
        count = 0;
        current = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty() {
        return count == 0;
    }

    // -------------------------------------------------------------
    public void insertLink(int data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            current = newLink;
            current.next = current;
        } else {
            newLink.next = current.next;
            current.next = newLink;
        }
        count++;
    }

    // -------------------------------------------------------------
    public void displayList() {
        while (!isEmpty()) {
            current.displayLink();
            current = current.next;
            count--;
        }
        System.out.println();
    }
}

////////////////////////////////////////////////////////////////
class CircListApp {
    public static void main(String[] args) {
        CircList circList = new CircList();
        circList.insertLink(100);
        circList.insertLink(30);
        circList.insertLink(15);
        circList.insertLink(10);
        circList.insertLink(20);
        circList.insertLink(80);
        circList.insertLink(120);
        circList.insertLink(43);
        circList.displayList();
    }
}