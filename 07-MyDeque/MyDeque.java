public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[64];
        this.data = d;
        this.start = 32;
        this.end = 33;
        this.size = 0;
      }

      public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[initialCapacity];
        this.data = d;
        this.start = (initialCapacity + 1) / 2 ;
        this.end = this.start + 1;
        this.size = 0;

        }

      public int size(){
        return size;
      }

      // Wrapping start and end around for the add / removers
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
        while(true){
           if(index == data.length){
             index = 0;
           }

           if(index == endIndex){
             break;
           }

           list += ", " + data[index];
           index++;
        }
        return list + "]";
      }

      public void addFirst(E element){
        data[start] = element;
        start--;
        size++;
        readjust();
      }

      public void addLast(E element){
        data[end] = element;
        end++;
        size++;
        readjust();
      }

      // public E removeFirst(){
      //   start++;
      //   readjust();
      //   size--;
      // }
      // public E removeLast(){
      //   end--;
      //   readjust();
      //   size--;
      // }

      public void resize(){
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[data.length * 2];
        int newIndex = d.length / 4;
        int index = start + 1;
        while(true){
          if(index == end){
            break; // terminate
          }

          if(index == data.length){
            index = 0; // Wrap around
          }

          d[newIndex] = data[index];
          newIndex++;
          index++;
        }

        this.data = d;
      }

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
            MyDeque<E> list = new MyDeque<E>(10);
            System.out.println(list.start + " " + list.end);
            list.addFirst(new String("foo") );
            list.addFirst(new String("boo") );
            list.addFirst(new String("moo") );
            list.addLast(new String("too") );
            System.out.println(list.toString() );
            // System.out.println(list.getFirst() );
            // System.out.println(list.start + " " + list.end);
        }

    }