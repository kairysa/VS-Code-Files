class Node {
  constructor(data){
      this.data=data;
      this.next=null;
  }
}

class LinkedList {
  constructor() {
      this.head = null;
  }
  addFront(val) {
    // Creating a new node object with the value provided
    let new_node = new Node(val);
    // Checking to see if the current list does not have a head node (if the list is empty)
    // If the list is empty, place the new node as the head 
    if(!this.head) {
        this.head = new_node;
        return this;
    }
    // If the list is not empty, assign the head to be the next node to the new node (Blue Arrow in picture above)
    new_node.next = this.head;
    // Then finally assign the new_node to be the new head of the list (Red Arrow in picture above)
    this.head = new_node;
    return this;
}
}

// FRONTS ASSIGNMENT //


class SLL {
  constructor() {
    this.head = null;
    }

    addFront(value) {
      let newNode = new Node(value);
      if(!this.head) {
        this.head = newNode;
        return this;
      }
      newNode.next = this.head;
      this.head = newNode;
      return this;
    }

    removeFront() {
      let removedNode = this.head;
      if(!this.head) {
        return null;
      }
      this.head = removedNode.next;
      return this;
    }

    front() {
      if(!this.head) {
        return null;
      }
      return this.head.data;
    }

    display() {
      if(!this.head) {
        return null;
      }
      let runner = this.head;
      let myList = [];
      while(runner !== null) {
        myList.push(runner.data);
      }
      console.log(myList);
      return myList;
    }
  }

  SLL1 = new SLL();

  SLL1.addFront(18);

  console.log(SLL1);

  SLL1.addFront(29);

  console.log(SLL1);

  console.log(SLL1.removeFront());

  console.log(SLL1.front());

  SLL1.display();