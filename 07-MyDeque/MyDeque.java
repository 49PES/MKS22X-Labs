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
      }

      public int size(){
        return size;
      }
      public String toString(){
        String list = ""; int index = start, endIndex = end;
        while(true){
           if(index == data.length){
             index = 0;
           }
           if(index == endIndex){break;}
           list += data[index] + " ";
        }
        return list;
      }

      // public void addFirst(E element){ }
      // public void addLast(E element){ }
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



    }
