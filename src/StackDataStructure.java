public class StackDataStructure {

   static class Node<K>{
        private K value;
        private Node prevValue;

        Node(K item){
            this.value = item;
        }

    }

   static class Stack<T>{

        private Node firstValue;
        private Node lastValue;

        public Stack(){
            this.firstValue = null;
            this.lastValue = null;
        }
        public void push(T item){
            Node<T> newValue = new Node<T>(item);

            if(firstValue == null){
                firstValue = newValue;
                lastValue = newValue;
            }else{
                Node<T> temp = lastValue;
                lastValue = newValue;
                lastValue.prevValue = temp;
            }
        }
       public T pop(){
           Node<T> temp = lastValue.prevValue;
           Node<T> temp2 = lastValue;
           lastValue = temp;
           return temp2.value;
        }
    }

    public static void main(String[] args) {
        Stack<String> nit = new Stack();
        nit.push("first");
        nit.push("second");
        nit.push("third");
        nit.push("fourth");
        nit.push("fifth");
        nit.push("sixth");


        System.out.println(nit.pop());
        System.out.println(nit.pop());
        System.out.println(nit.pop());
        System.out.println(nit.pop());
        System.out.println(nit.pop());
        System.out.println(nit.pop());
    }
}
