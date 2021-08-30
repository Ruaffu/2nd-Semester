import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String [] navn = {"Peter","Valborg","nikolaj", "Martin", "Asger", "Rabee","Valborg", "Christian", "Inga", "Christian"};
        String [] andreNavne = {"Peter","Valborg","nikolaj","lille ole", "Martin", "Asger", "Rabee","Valborg", "Christian", "Inga", "Christian"};

        List<String> stringList = new ArrayList<>(Arrays.asList(navn));
        stringList.add("nikolaj");
        for (String s : stringList) {
            System.out.println(s);
        }
//        System.out.println("\n\n hashset :");
//        Set<String> strings = new HashSet<>(stringList);
//
//        for (String string : strings) {
//            System.out.println(string);
//        }
//
//        System.out.println("\n\n Treeset :");
//        Set<String> stringTree = new TreeSet<>(stringList);
//
//        for (String s : stringTree) {
//            System.out.println(s);
//        }

        System.out.println("\n\n Listeset :");


        Set<String> navneSet = new LinkedHashSet<>(stringList);

        for (String s : navneSet) {
            System.out.println(s);
        }

        Set<String> andreNavneSet = new LinkedHashSet<>(Arrays.asList(andreNavne));

        System.out.println("\n\ntreakker et set fra et andet");

        andreNavneSet.removeAll(navneSet);

        for (String s : andreNavneSet) {
            System.out.println(s);
        }


    }//end of main
}
