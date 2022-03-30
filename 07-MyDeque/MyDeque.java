public class MyDeque<E>{
      private E[] data;
      private int size;
      private int start, end;

      public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[64];
        data = d;
        start = 32;
        end = 33;
        size = 0;
      }

      public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[initialCapacity];
        data = d;
        start = (initialCapacity + 1) / 2 ;
        end = start + 1;
        size = 0;

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

      public String toStringDebug(){
        String list = "[" + data[0] ;
        for(int i = 1; i < data.length; i++){
          list += ", " + data[i];
        }
        return list + "]";
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

      public void addFirst(E element){
        data[start] = element;
        start--;
        size++;
        readjust();
        resize();
      }

      public void addLast(E element){
        data[end] = element;
        end++;
        size++;
        readjust();
        resize();
      }



      public E removeFirst(){
        start++;
        readjust();
        size--;
        if(start == 0){
          return data[data.length - 1];
        }
        return data[start - 1];

      }
      public E removeLast(){
        end--;
        readjust();
        size--;
        if(end == data.length - 1){
          return data[0];
        }
        return data[end + 1];
      }

      public void resize(){
        if(start == end){
          @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[data.length * 2];
        int newIndex = d.length / 4;
        int index = start;
        while(true){
          if(index == data.length){
            index = 0; // Wrap around
          }

          d[newIndex] = data[index];
          newIndex++;
          index++;

          if(index == end){
            break; // terminate
          }
        }

        data = d;
        start = d.length / 4;
        end = newIndex;

      }
      }



    }
