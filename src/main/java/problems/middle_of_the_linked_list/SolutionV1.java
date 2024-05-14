package problems.middle_of_the_linked_list;

public class SolutionV1 {

  public ListNode middleNode(ListNode head) {
    ListNode iterator1 = head;
    ListNode iterator2 = null;
    ListNode result = head;

    while(iterator1 != null && iterator1.next != null) {
      if (iterator2 == null) {
        iterator2 = iterator1.next;
      }
      result = result.next;

      if (iterator2 != null && (iterator2.next == null || iterator2.next.next == null)) {
        break;
      } else {
        iterator1 = iterator1.next;
        iterator2 = iterator2.next.next;
      }
    }

    return result;
  }
}
