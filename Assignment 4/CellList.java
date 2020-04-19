// -----------------------------------------------------
// Assignment 4
// Question: part 2 - III
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------

import java.util.NoSuchElementException;

/**
 * @author Chelsie Ng - 40071692
 * CellList Class to store head and size
 */
public class CellList {
    private CellNode head;
    private int size;

    /**
     * This is a default constructor
     */
    public CellList() {
        head = null;
        size = 0;
    }

    /**
     * This is a copy constructor
     *
     * @param cellList stores the other list being copied
     */
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
                    cn2 = new CellNode(cn1); //using copy constructor of CellNode
                    head = cn2;
                } else {
                    cn3 = cn1.clone(); //using clone method of CellNode
                    cn2.next = cn3;
                    cn2 = cn3;
                }
                size++;
                cn1 = cn1.next;
            }
            cn2 = null;
            cn3 = null;
        }
    }

    /**
     * addToStart Method
     *
     * @param cellPhone stores the cellphone being added to the beginning of the list
     */
    public void addToStart(CellPhone cellPhone) {
        CellNode newHead = new CellNode(); //using default constructor
        newHead.cellPhone = cellPhone;
        newHead.next = head;
        head = newHead;
        size++;
    }

    /**
     * insertAtIndex Method
     *
     * @param cellPhone stores the cellphone to be inserted
     * @param index     represents the position where to be inserted
     */
    public void insertAtIndex(CellPhone cellPhone, int index) {
        try {
            // list is empty
            if (head == null) {
                //if head is null and position is zero then exit.
                if (index == 0) { //node set to the head.
                    head = new CellNode(cellPhone, null);
                    size++;
                }
                return;
            }
            // index is invalid
            if (index >= size) {
                throw new NoSuchElementException();
            }
            // index is valid
            if (head != null && index == 0) {
                CellNode newNode = new CellNode(cellPhone, head);
                head = newNode;
                size++;
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
            size++;
        } catch (NoSuchElementException e) {
            System.out.println("Invalid Index. Program will now terminate!");
            System.exit(-1);
        }

    }

    /**
     * deleteFromIndex Method
     *
     * @param index represents the position where to be deleted
     */
    public void deleteFromIndex(int index) {
        try {
            // list is empty
            if (head == null) {
                //if head is null, exit.
                return;
            }
            // index is invalid
            if (index >= size) {
                throw new NoSuchElementException();
            }
            // index is valid
            if (head != null && index == 0) {
                head = head.next;
                size--;
                return;
            }
            CellNode current = head; // temp pointer
            for (int i = 0; i < index - 1; i++) {
                if (current == null || current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        } catch (NoSuchElementException e) {
            System.out.println("Invalid Index. Program will now terminate!");
            System.exit(-1);
        }
    }

    /**
     * deleteFromStart Method
     * deletes at the beginning of the list
     */
    public void deleteFromStart() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    /**
     * replaceAtIndex Method
     *
     * @param cellPhone stores cellphone to be replaced with
     * @param index     represents position where to be replaced
     */
    public void replaceAtIndex(CellPhone cellPhone, int index) {
        // list is empty
        if (head == null) {
            return;
        }
        //invalid index
        if (index >= size) {
            return;
        }
        // index is valid
        if (head != null && index == 0) {
            CellNode newNode = new CellNode(cellPhone, head);
            head = newNode;
            size++;
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
        size++;
        deleteFromIndex(index + 1);
    }

    /**
     * find Method
     *
     * @param serialNum stores serial number to find
     * @return a reference of object found with that serial number
     */
    public CellNode find(long serialNum) {
        if (head == null) {
            return null;
        }
        CellNode current = head;
        int i = 1;
        while (current.next != null) {
            if (current.cellPhone.getSerialNum() == serialNum) {
                if (i == 1) {
                    System.out.println("Found after " + i + " iteration.");
                } else {
                    System.out.println("Found after " + i + " iterations.");
                }
                return current;
            }
            current = current.next;
            i++;
        }
        System.out.println("Not found after " + i + " iterations.");
        return null;
    }

    /**
     * contains Method
     *
     * @param serialNum stores serial number to verify in list
     * @return true if list contains serial number given
     */
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
        return false;
    }

    /**
     * showContents Method
     * this displays all contents of the list
     */
    public void showContents() {
        if (head == null) {
            System.out.println("There is no content to the list.");
            return;
        }
        CellNode current = head;
        CellNode previous = null;
        System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
        System.out.println("=====================================================================");
        while (current.next != null) {
            System.out.print(current.cellPhone.toString() + " ---> ");
            current = current.next;
        }
        System.out.println(current.cellPhone.toString() + " ---> X");
    }

    /**
     * equals Method
     *
     * @param cellList stores the list being compared
     * @return true if both lists contain same cellphones
     */
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

    /**
     * CellNode Class to store cellphone and next
     */
    public class CellNode {
        private CellPhone cellPhone;
        private CellNode next;

        /**
         * This is a default constructor
         */
        public CellNode() {
            cellPhone = null;
            next = null;
        }

        /**
         * This is a constructor to initialize a CellNode object
         *
         * @param cellPhone initial cellphone
         * @param next      initial next
         */
        public CellNode(CellPhone cellPhone, CellNode next) {
            this.cellPhone = cellPhone;
            this.next = next;
        }

        /**
         * This is a copy constructor
         *
         * @param cellNode stores the other cellNode being copied
         */
        public CellNode(CellNode cellNode) {
            cellPhone = cellNode.cellPhone.clone();
            next = cellNode.next;
        }

        /**
         * clone Method
         *
         * @return a deep copy of cellNode
         */
        public CellNode clone() {
            return new CellNode(this);
        }

        /**
         * get cellphone of the CellNode
         *
         * @return cellphone of the CellNode
         */
        public CellPhone getCellPhone() {
            return cellPhone;
        }


        /**
         * get next of the CellNode
         *
         * @return next of the CellNode
         */
        public CellNode getNext() {
            return next;
        }

        /**
         * set cellphone of the CellNode
         *
         * @param cellPhone new cellphone of the CellNode
         */
        public void setCellPhone(CellPhone cellPhone) {
            this.cellPhone = cellPhone;
        }

        /**
         * set next of the CellNode
         *
         * @param next new next of the CellNode
         */
        public void setNext(CellNode next) {
            this.next = next;
        }
    }

}
