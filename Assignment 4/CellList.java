import java.util.NoSuchElementException;

public class CellList {
    private CellNode head;
    private int size;

    //Default constructor -  empty list
    public CellList() {
        head = null;
        size = 0;
    }

    //Copy contructor
    public CellList(CellList cellList) {
        if (cellList.head == null) {
            head = null;
        } else {
            head = null;
            CellNode cn1, cn2, cn3; //creating 3 temporary pointers
            cn1 = cellList.head;
            cn2 = null;
            cn3 = null;
            while (cn1 != null) {
                if (head == null) {
                    cn2 = new CellNode(cn1);
                    head = cn2;
                } else {
                    cn3 = new CellNode(cn1);
                    cn2.next = cn3;
                    cn2 = cn3;
                }
                cn1 = cn1.next;
            }
            cn2 = null;
            cn3 = null;
        }
    }

    //Adding node to start
    public void addToStart(CellPhone cellPhone) {
        CellNode newHead = new CellNode(cellPhone, head);
        head = newHead;
        size++;
    }

    //Adding node at specific index
    public void insertAtIndex(CellPhone cellPhone, int index) {
        try {
            // index is invalid
            if (index >= 0 && index <= size - 1) {
                throw new NoSuchElementException();
            }
            // index is valid
            // list is empty
            if (head == null) {
                //if head is null and position is zero then exit.
                if (index != 0) {
                    return;
                } else { //node set to the head.
                    head = new CellNode(cellPhone, null);
                    size++;
                    return;
                }
            }
            if (head != null && index == 0) {
                CellNode newNode = new CellNode(cellPhone, head);
                head = newNode;
                return;
            }
            CellNode current = head; // temp pointer
            CellNode previous = null; // temp pointer
            //Finding index
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
                if (current == null) {
                    break;
                }
            }
            CellNode newNode = new CellNode(cellPhone, current);
            previous.next = newNode;
        } catch (NoSuchElementException e) {
            System.out.println("Invalid Index. Program will now terminate!");
            System.exit(-1);
        }

    }

    public void deleteFromIndex(int index) {
        try {
            // index is invalid
            if (index >= 0 && index <= size - 1) {
                throw new NoSuchElementException();
            }
            // index is valid
            // list is empty
            if (head == null) {
                //if head is null, exit.
                return;
            }
            if (head != null && index == 0) {
                head = head.next;
                return;
            }
            CellNode current = head; // temp pointer
            for (int i = 0; i < index; i++) {
                if (current == null || current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = current.next.next;
        } catch (NoSuchElementException e) {
            System.out.println("Invalid Index. Program will now terminate!");
            System.exit(-1);
        }
    }

    public void deleteFromStart() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public void replaceAtIndex(CellPhone cellPhone, int index) {
        //invalid index
        if (index >= 0 && index <= size - 1) {
            return;
        }
        //valid index
        // index is valid
        // list is empty
        if (head == null) {
            return;
        }
        if (head != null && index == 0) {
            CellNode newNode = new CellNode(cellPhone, head);
            head = newNode;
            deleteFromIndex(index + 1);
            return;
        }
        CellNode current = head; // temp pointer
        CellNode previous = null; // temp pointer
        //Finding index
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
            if (current == null) {
                break;
            }
        }
        CellNode newNode = new CellNode(cellPhone, current);
        previous.next = newNode;
        deleteFromIndex(index + 1);
    }

    public CellNode find(long serialNum) {
        if (head == null) {
            return null;
        }
        CellNode current = head;
        int i = 0;
        while (current.next != null) {
            current = current.next;
            if (current.cellPhone.getSerialNum() == serialNum) {
                System.out.printf("Found after " + i + " iterations.");
                return current;
            }
            i++;
        }
        System.out.println("Not found after " + i + " iterations.");
        return null;
    }

    public boolean contains(long serialNum) {
        if (head == null) {
            return false;
        }
        CellNode current = head;
        int i = 0;
        while (current.next != null) {
            current = current.next;
            if (current.cellPhone.getSerialNum() == serialNum) {
                return true;
            }
            i++;
        }
        return true;
    }

    public void showContents() {
        if (head == null) {
            System.out.println("There is no content to the list.");
        }
        CellNode current = head;
        CellNode previous = null;
        System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
        System.out.println("===============================================================================");
        while (current.next != null) {
            System.out.println(current.cellPhone.toString() + " ---> ");
            current = current.next;
        }
        System.out.println("X");
    }

    public boolean equals(CellList cellList) {
        if (cellList.head == null || this.head == null) {
            return false;
        }
        CellNode list1 = cellList.head;
        CellNode list2 = this.head;
        while (list1.next != null && list2.next != null) {
            list1 = list1.next;
            list2 = list2.next;
            if (!(list1.cellPhone.equals(list2.cellPhone))) {
                return false;
            }
        }
        return true;
    }

    //Inner Class
    public class CellNode {
        private CellPhone cellPhone;
        private CellNode next;

        //Default Constructor
        public CellNode() {
            cellPhone = null;
            next = null;
        }

        //Parameterized constructor
        public CellNode(CellPhone cellPhone, CellNode next) {
            this.cellPhone = cellPhone;
            this.next = next;
        }

        //Copy constructor
        public CellNode(CellNode cellNode) {
            cellPhone = cellNode.cellPhone.clone();
            next = cellNode.next;
        }

        public CellNode clone() {
            return new CellNode(this);
        }

        public CellPhone getCellPhone() {
            return cellPhone;
        }


        public CellNode getNext() {
            return next;
        }

        public void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }

        public void setNext(CellNode next) {
            this.next = next;
        }
    }

}
