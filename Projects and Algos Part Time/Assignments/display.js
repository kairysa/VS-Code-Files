class Node {
  constructor(data){
      this.data=data;
      this.next=null;
  }
}

class SLL {
  constructor() {
    this.head = null;
    }

    addFront(value) {
      let newNode = new Node(value);
      if(!this.head) {
        this.head = newNode;
        console.log(this);
        return this;
      }
      newNode.next = this.head;
      this.head = newNode;
      console.log(this);
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
      console.log(this.head.data);
      return this.head.data;
    }

    contains(value) {
      if(!this.head) {
        return null;
      }
      let runner = this.head;
      while(runner !== null) {
        if(runner.data == value) {
          console.log(true);
          return true;
        }
        else {
          runner = runner.next;
        }
      }
      console.log(false);
      return false;
    }

    length() {
      if(!this.head) {
        console.log(0);
        return 0;
      }
      let runner = this.head;
      let length = 0;
      while(runner !== null) {
      length += 1;
      runner = runner.next;
      }
      console.log(length);
      return length;
    }

    display() {
      if(!this.head) {
        return null;
      }
      
      let myList = "";
      let runner = this.head;
      while (runner !== null) {
        myList += (runner.data + ", ");
        runner = runner.next;
      }
      console.log(myList);
      return myList;
    }
  }

  SLL1 = new SLL();

  SLL1.addFront(20);
  SLL1.addFront(3);
  SLL1.addFront(39);
  SLL1.addFront(34);

  SLL1.display();