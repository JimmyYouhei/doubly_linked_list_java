package com.jimmyyouhei.doubly_linked_list;

// my doublyLinkedList from sratch
public class DoublyLinkedList {

    // variable to count number of node
    private int count = 0;
    // pointer to point to the head Node
    private Node head;
    // pointer to point to the tail node
    private Node tail;

    // return the head node
    public Node getHead() {
        return head;
    }

    // return the tail node
    public Node getTail() {
        return tail;
    }

    // return the number of node in the list
    public int countNode() {
        return count;
    }

    // print out the node at the position
    public void   peekAtPosition(int position){

        // if position < 0 throw error
        try {
            if (position < 0){
                throw new NullPointerException("there is no such position");
            }

            // pointer to start point at the head node
            Node targetNode = this.head;
            // loop through the node to the desired position
            for (int i = 0 ; i < position ; i++){
                targetNode = targetNode.nextNode;

            }

            // print out the node
            System.out.println(targetNode);

            // handle the exception
        } catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    // remove First Node method
    public void removeFirstNode(){
        // temporary pointer to the head node to remove
        Node nodeToRemove = this.head;
        // point the head pointer to the new head node
        this.head = this.head.nextNode;
        // remove both the pointer for 2 nodes
        this.head.previousNode = null;
        nodeToRemove.nextNode = null;
        // decrease count
        count--;
    }

    // remove last node method
    public void removeLastNode(){
        // temporary pointer to tail node to remove
        Node nodeToRemove = this.tail;
        // point the tail pointer to the right node
        this.tail = this.tail.previousNode;
        // remove both the pointer of 2 node
        this.tail.nextNode = null;
        nodeToRemove.previousNode = null;
        // decrease count
        count--;
    }

    public void insertToLast(Object anObject){
        // init a node from the data
        Node nodeToAdd = new Node(anObject);

        // if the List is empty
        if (this.head == null){
            // point both head and tail to the new node above
            this.head = nodeToAdd;
            this.tail = nodeToAdd;
            // increase count from 0 to 1;
            count = 1;

            // if there is already at least 1 node
        } else{
            // update the pointers of both 2 node
            this.tail.nextNode = nodeToAdd;
            nodeToAdd.previousNode = this.tail;
            // point the tail to the right node
            this.tail = nodeToAdd;
            // increase count by 1
            count++;
        }

    }

    public void insertToFirst(Object anObject){
        // init a node from the data
        Node nodeToAdd = new Node(anObject);

        // if the list is empty
        if (this.head == null){
            // point both head and tail to the new node above
            this.head = nodeToAdd;
            this.tail = nodeToAdd;
            // increase count from 0 to 1;
            count = 1;
        } else{
            // update the pointers of both 2 node
            this.head.previousNode = nodeToAdd;
            nodeToAdd.nextNode = this.head;
            // point the head to the right node
            this.head = nodeToAdd;
            // increase count by 1
            count++;
        }

    }

    public void printNode(){
        // print the introduction
        System.out.println("Here are the elements:");

        // tempory pointer start from the head node
        Node loopNode = this.head;

        // loop and print out all node
        while (loopNode!= null){
            System.out.println(loopNode);
            loopNode = loopNode.nextNode;
        }
    }

    // inner class node
    private class Node{
        // contain the Node data
        Object data;
        // have pointer to point to both previous and nextNode
        Node previousNode;
        Node nextNode;

        // constructor
        public Node(Object data) {
            this.data = data;
        }

        // ovverride the toString for easy print
        @Override
        public String toString() {
            return data.toString();
        }
    }

}
