package se.sdaproject;


import java.util.ArrayList;

class Node {
    int elem;
    Node next;

    Node(int num) {
        this.elem = num;
        this.next = null;
    }
}


public class LinkedList {

    private Node first = null;

    public void add(int num) {
        if (first == null) {
            Node node = new Node(num);
            first = node;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            Node node = new Node(num);
            current.next = node;
        }

    }

    // Returns the index at which param num exists
    public int search(int num){
        Node current = first;
        boolean foundInt = false;
        int index = 0;
        while(current != null){
            if(current.elem == num){
                foundInt = true;
                break;
            }else{
                current = current.next;
            }
            index++;
            System.out.println(index);
        }
        return foundInt ? index : -1;
    }

    public ArrayList<Integer> indicesOf(int num){
        Node current = first;
        ArrayList<Integer> listOfIndices = new ArrayList<>(100);
        int linkedListIndex = 0;
        while(current != null){
            if(current.elem == num){
                listOfIndices.add(linkedListIndex);
            }
            current = current.next;
            linkedListIndex++;
        }
        return listOfIndices;
    }

    // Returns the element in that index
    public int get(int index){
        Node current = first;
        int result;
        if(current != null){
            while(index > 0){
                current = current.next;
                index--;
            }
            result = current.elem;
        }else{
            result = -1;
        }
        return result;
    }

    public int size(){
        Node current = first;
        int size = 0;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    public void oldRemove(int num){
        System.out.println("enters");
        int removeIndex = this.search(num);
        System.out.println("removeIndex: "+removeIndex);
        if(removeIndex == 0){
            first = (removeIndex == this.size()-1) ? null : first.next;
        } else if(removeIndex > 0 && removeIndex <= this.size()-1) {
            int prevIndex = removeIndex--;
            Node previous = first;
            Node current = previous.next;
            for(int i = 1; i < prevIndex; i++){
                previous = previous.next;
                current = current.next;
            }
            if(removeIndex < this.size()-1){
                previous.next = current.next;
                current.next = null; //redundant step redo tests
            } else {
                previous.next = null;
            }
        }
    }

    public boolean workingRemove(int num){
        boolean result = false;
        // If list is empty
        if(first == null){
            System.out.println("enters");
            result = false;
        } else {
            Node prev, current;
            prev = first;
            current = first;

            // If element to be removed is the first element
            if(current.elem == num){
                first = (first.next == null) ? null : first.next;
            } else {
                while(current != null && current.elem != num ){
                    prev = current;
                    current = current.next;
                }
                // If linked list is over before the element can be found
                if(current == null){
                    result = false;
                }else{
                    prev.next = current.next;
                    current.next = null; // Is this step necessary?
                    result = true;
                }
            }

        }
        return result;
    }

    public boolean remove(int num){
        boolean result = false;
        // If list is empty
        Node prev, current;
        try{
            prev = first;
            current = first;
            if(current.elem == num){
                first = (first.next == null) ? null : first.next;
            } else {
                while(current != null && current.elem != num ){
                    prev = current;
                    current = current.next;
                }
                // If linked list is over before the element can be found
                if(current == null){
                    result = false;
                }else{
                    prev.next = current.next;
                    current.next = null; // Is this step necessary?
                    result = true;
                }
            }
        }catch (NullPointerException e){
            System.out.println("Linked list is empty!");
            e.printStackTrace();
        }
        return result;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList(");
        if (first == null) {

        } else {
            Node current = first;
            builder.append("" + current.elem);
            while (current.next != null) {
                current = current.next;
                builder.append("," + current.elem);
            }
        }
        builder.append(")");
        return builder.toString();
    }
}