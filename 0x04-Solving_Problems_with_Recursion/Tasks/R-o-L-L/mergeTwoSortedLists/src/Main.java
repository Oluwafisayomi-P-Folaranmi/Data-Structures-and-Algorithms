public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode merged = mergeTwoLists(list1, list2);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Base case: list1 is empty
        if (list1 == null) {
            return list2;
        }

        // Base case: list2 is empty
        if (list2 == null) {
            return list1;
        }

        // Choose the smaller node
        if (list1.val <= list2.val) {

            // Merge the remaining nodes
            list1.next = mergeTwoLists(list1.next, list2);

            // Return the chosen node
            return list1;

        } else {

            // Merge the remaining nodes
            list2.next = mergeTwoLists(list1, list2.next);

            // Return the chosen node
            return list2;
        }
    }
}
