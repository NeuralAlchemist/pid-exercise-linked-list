package se.sdaproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;


class LinkedListTests {
    LinkedList list;
    void setupLinkedList(){
        list = new LinkedList();
        list.add(21);
        list.add(87);
        list.add(67);
        list.add(43);
    }


    @Test
    void addsTwoNumbers() {
        Assertions.assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }

    @Test
    void addANumberToList() {
        LinkedList list = new LinkedList();
        list.add(5);
        String expected = "LinkedList(5)";
        Assertions.assertEquals( expected, list.toString(), "this works");
    }

    @Test
    @DisplayName("add more than 1 number to list")
    void addMoreThan1NumberToList() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(6);
        String expected = "LinkedList(5,6)";
        Assertions.assertEquals( expected, list.toString());
    }

    @Test
    void testToStringOfEmptyList() {
        LinkedList list = new LinkedList();
        String expected = "LinkedList()";
        Assertions.assertEquals( expected, list.toString());
    }

    @Test
    @DisplayName("find all occurrences of integer 7 in a linked list of ascending numbers")
    void findAllOccurrencesInteger7InALinkedListOfAscendingNumbers() {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(7);
        ArrayList<Integer> expected = new ArrayList<>(2);
        expected.add(3);
        expected.add(4);
        ArrayList<Integer> result = list.indicesOf(7);
        Assertions.assertEquals(expected.get(0), result.get(0));
        Assertions.assertEquals(expected.get(1), result.get(1));
    }

    @Test
    @DisplayName("find the index of integer 87 in a random order linked list")
    void findTheIndexOfInteger87InARandomOrderLinkedList() {
        setupLinkedList();
        Assertions.assertEquals(1, list.search(87));
    }

    @Test
    @DisplayName("return the element at the last index of a non empty linked list")
    void returnTheElementAtTheLastIndexOfANonEmptyLinkedList() {
        setupLinkedList();
        Assertions.assertEquals(43, list.get(3));
    }

    @Test
    @DisplayName("returns not found when getting any element of an empty linked list")
    void returnsNotFoundWhenGettingAnyElementOfAnEmptyLinkedList() {
        LinkedList list = new LinkedList();
        Assertions.assertAll(() -> Assertions.assertEquals(-1,list.get(0)),
        () -> Assertions.assertEquals(-1, list.get(4)));
    }

    @Test
    @DisplayName("returns the first element of a non empty linked list")
    void returnsTheFirstElementOfANonEmptyLinkedList() {
        setupLinkedList();
        Assertions.assertEquals(21, list.get(0));
    }

    @Test
    @DisplayName("returns the size of an empty linked list")
    void returnsTheSizeOfAnEmptyLinkedList() {
        LinkedList list = new LinkedList();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    @DisplayName("returns the size of a non empty linked list")
    void returnsTheSizeOfANonEmptyLinkedList() {
        setupLinkedList();
        Assertions.assertEquals(4, list.size());
    }

    @Test
    @DisplayName("remove an element that is not at the end or at the first of a linked list")
    void removeAnElementThatIsNotAtTheEndOrAtTheFirstOfALinkedList() {
        setupLinkedList();
        list.remove(87);
        String expected = "LinkedList(21,67,43)";
        Assertions.assertEquals(expected, list.toString());
    }

    @Test
    @DisplayName("remove the first element of a linked list")
    void removeTheFirstElementOfALinkedList() {
        setupLinkedList();
        list.remove(list.get(0));
        String expected = "LinkedList(87,67,43)";
        Assertions.assertEquals(expected, list.toString());
    }

    @Test
    @DisplayName("remove the last element of a linked list with size of atleast two")
    void removeTheLastElementOfALinkedListWithSizeOfAtleastTwo() {
        setupLinkedList();
        list.remove(list.get(list.size()-1));
        String expected = "LinkedList(21,87,67)";
        Assertions.assertEquals(expected, list.toString());
    }

    @Test
    @DisplayName("remove last element of a linked list of size two")
    void removeLastElementOfALinkedListOfSizeTwo() {
        LinkedList example = new LinkedList();
        example.add(23);
        example.add(34);
        example.remove(34);
        String expected = "LinkedList(23)";
        Assertions.assertEquals(expected, example.toString());
    }

    @Test
    @DisplayName("remove the first/last element of a linked list of size one")
    void removeTheFirstLastElementOfALinkedListOfSizeOne() {
        LinkedList example = new LinkedList();
        example.add(23);
        example.remove(23);
        Assertions.assertEquals("LinkedList()",example.toString());
    }

    @Test
    @DisplayName("remove any element of a empty linked list")
    void removeAnyElementOfAEmptyLinkedList() {
        LinkedList example = new LinkedList();
        boolean result = example.remove(23);
        Assertions.assertEquals("LinkedList()",example.toString());
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("remove a non existent element of a non empty linked list")
    void removeANonExistentElementOfANonEmptyLinkedList() {
        setupLinkedList();
        boolean result = list.remove(12);
        Assertions.assertEquals("LinkedList(21,87,67,43)", list.toString());
        Assertions.assertEquals(false, result);
    }

    //test remove for empty cases
}
