public class PermutePlayground{
  public static void permute(String[][] lists, String sentence, int current){
    if(current == lists.length - 1){
      for(String str : lists[current]){
        System.out.println(sentence + " " + str);
      }
    }

    else{
      for(String str : lists[current]){
        permute(lists, sentence + " " + str, current + 1);
      }
    }
  }

  public static void main(String[] args){
      String[][]wordlists = {
        {"The dog", "The pro skater"},
        {"plays" , "empathises with" },
        {"chess", "ball", "the voiceless masses"}
      };
      permute(wordlists, "" , 0);
  }
}
