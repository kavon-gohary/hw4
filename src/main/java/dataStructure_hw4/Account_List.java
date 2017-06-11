package dataStructure_hw4;

interface Comparable {int compareTo(Object o);}

public class Account_List {

    private Link head;

    public Account_List()
    {head=null;}

    private class Link
    {
        private Link next;
        private Object balance;
        private String accountHolder;

        public Link(Object data, String name)
        {
            this.balance = data;
            this.accountHolder = name;
        }
    }

    public void insertFirst(Object data, String name)
    {
        Link newLink = new Link(data, name);
        newLink.next = this.head;
        this.head = newLink;
    }

    public void displayList()
    {
        Link current = this.head;
        while (current!=null)
        {
            System.out.println(current.accountHolder + ": " + (Integer) current.balance);
            current = current.next;
        }
        //System.out.println("");                                                       //we make the above statement a println and comment out this bc each link is a different
    }

    class Account extends Account_List  implements Comparable                           //when i tried to make this private, the code broke, so leave it as public for now
    {
        private String name;
        private Integer amount;
        public Account(String nm, Integer amt)                    //contructor, sets the value of variables "name" and "amount" to the user inputs
        {
            name = nm;
            amount = amt;
        }

        public Account account(String nm, Integer amt)            //calling the "account" method will return an "Account" object.
        {   return new Account(nm, amt); }

        public String name() { return name; }                     //name method returns a strING
        public Integer amount() { return amount; }

        public boolean equals(Object x)                           //check if the names of the account and the sent object match
        {
            if ( x == null ) return false;
            else if ( getClass() != x.getClass() ) return false;
            else return name.equals( ((Account)x).name);
        }

        //return -1 to sort this account before x, else 1
        //@Override
        public int compareTo(Object x)
        {

            return 1;
            //System.out.println("ypo");

        }

        public String toString() {
            return ( "(" + this.name + " " + this.amount + ")"); }
    }

//----------------------------------------------------------------------------------------------------------------------------------------------



    public static void main(String [] args)
    {
        //----------------------------------------Test to Make sure this merge implementation works
        // AccountList list1 = new AccountList();
        // list1.insertFirst(Integer.valueOf(69));
        // list1.insertFirst(Integer.valueOf(30));
        // list1.insertFirst(Integer.valueOf(70));
        // list1.insertFirst(Integer.valueOf(5));
        // list1.displayList();
        // Link newLink = list1.recSort(list1.head);
        // // newLink.displayList();
        // System.out.print(newLink.data + " ");
        // System.out.print(newLink.next.data + " ");
        // System.out.print(newLink.next.next.data + " ");
        // System.out.println(newLink.next.next.next.data);
        // //--------------------------------------------
        //
        // String letter1 = "a";
        // String letter2 = "c";
        // System.out.println(letter1.compareTo(letter2));
        //--------------------------------------------------

        Account_List noUpdates = new Account_List();
        noUpdates.insertFirst(Integer.valueOf(500), "Arbiter");
        noUpdates.insertFirst(Integer.valueOf(100), "Flintstone");
        noUpdates.displayList();

    }
}
