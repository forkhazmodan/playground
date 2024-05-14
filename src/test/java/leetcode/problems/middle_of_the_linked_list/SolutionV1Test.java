package leetcode.problems.middle_of_the_linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionV1Test {

  @Test
  public void middleNode_case1() {
    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode expected = new ListNode(3, new ListNode(4, new ListNode(5)));

    Assertions.assertEquals(expected, new SolutionV1().middleNode(listNode));
  }

  @Test
  public void middleNode_case2() {
    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    ListNode expected = new ListNode(4, new ListNode(5, new ListNode(6)));

    Assertions.assertEquals(expected, new SolutionV1().middleNode(listNode));
  }


  @Test
  public void middleNode_case3() {
    ListNode listNode = new ListNode(1);
    ListNode expected = new ListNode(1);

    Assertions.assertEquals(expected, new SolutionV1().middleNode(listNode));
  }
}
