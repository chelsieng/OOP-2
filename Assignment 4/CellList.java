import java.util.NoSuchElementException;

public class CellList {
    private CellNode head;
    private int size;

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

    public void insertAtIndex(CellPhone cellPhone, int index) {
        try {
            // index is invalid
            if (index >= 0 && index <= size - 1) {
                throw new NoSuchElementException();
            }
            // index is valid
            CellNode current = new CellNode(cellPhone, head);
            while (current.next != null) {

            }
        } catch (NoSuchElementException e) {
            System.out.println("Invalid Index. Program will now terminate!");
            System.exit(-1););
        }

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
