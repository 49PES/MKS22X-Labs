public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDeque(){
        size = 64;
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[size];
        data = d;
      }

      public MyDeque(int initialCapacity){
        size = initialCapacity;
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[size];
        data = d;
        this.start = initialCapacity / 2;
        this.end = start + 1;
        
        }

      public int size(){
        return size;
      }
      
      public String toString(){
        String list = "["; 
        System.out.println(start + " " + end);
        int index = start + 1, endIndex = end;
        System.out.println(list + " " + index + " " + endIndex);
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
        //   if(start < 0) {
        //       start = data.length - 1;
        //   }
        System.out.println(start + " " + end + " boo! ");
          data[start] = element;
          start--;
          if(start < 0) {
              start = data.length - 1;
          }
         System.out.println(start + " " + end + " boo! ");
      }
      public void addLast(E element){
        if(end >= data.length) { 
            end = 0; 
        }
        data[end] = element;
        end++;
          
      }
      // public E removeFirst(){ }
      // public E removeLast(){ }

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
            MyDeque list = new MyDeque(10);
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
