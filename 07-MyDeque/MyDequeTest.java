public class MyDequeTest<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDequeTest(){
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[size];
        data = d;
        size = 0;
      }

      public MyDequeTest(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[initialCapacity];
        data = d;
        this.start = initialCapacity / 2;
        this.end = start + 1;
        size = 0;
        }

      public int size(){
        return size;
      }

      // Fixing start and end for the add / removers
      public void readjust(){
        if(start < 0) {
          start = data.length - 1;
        }

        if(end < 0){
          end = data.length - 1;
        }

        if(end >= data.length){
          end = 0;
        }

        if(start >= data.length){
          start = 0;
        }
      }

      public String toString(){
        String list = "[" + data[start + 1];
        int index = start + 2, endIndex = end;
        list += data[index];
        while(true){
           if(index == data.length){
             index = 0;
           }
           if(index == endIndex){break;}
           list += data[index] + ", ";
           index++;
        }
        return list + "]";
      }

      public void addFirst(E element){
        @SuppressWarnings("unchecked")
        data[start] = element;
        start--;
        size++;
        if(start < 0){
          start = data.length - 1;
        }
      }

      public void addLast(E element){
        data[end] = element;
        end++;
        size++;
        readjust();
      }
      // public E removeFirst(){ size--;}
      // public E removeLast(){ size--; }
      //
      public E getFirst(){
        if(start + 1 == data.length)
          return data[0]; // Wrap around
        else
          return data[start + 1];
      }
      public E getLast(){
        if(end == 0)
          return data[data.length - 1]; // Wrap around
        else
          return data[end - 1];
      }

        public static void main(String[] args){
            MyDequeTest list = new MyDequeTest(10);
            System.out.println(list.start + " " + list.end);
            list.addFirst(new String("foo") );
            // list.addFirst(new String("boo") );
            // list.addFirst(new String("moo") );
            // list.addLast(new String("too") );
            // System.out.println(list.toString() );
            // System.out.println(list.getFirst() );
            // System.out.println(list.start + " " + list.end);
        }

    }
