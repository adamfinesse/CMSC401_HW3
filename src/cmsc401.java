import java.util.Scanner;
import java.util.Hashtable;
public class cmsc401 {
    private static final Scanner scanner = new Scanner(System.in);
    private static Hashtable<String, Integer> hashTable = new Hashtable<String, Integer>();
    public static void main(String[] args) {
    options();
    }

    public static void options(){
        // will we be given a case where we reuse the same variable? like x1 = 2, x2 = 3, x3 = x1 + x2, x1 = x3 * x2
        // I think not since the first error case
        ////do I need to add case where I reassign a variable? or do I assume all calculations are unique?
        String optionString = readString();
        String[] options = optionString.split(" ");

        if(options[0].equalsIgnoreCase("QUIT")){
            System.exit(0);
        }

        if(hashTable.containsKey(options[0])){
            System.out.println("ERROR");
            System.exit(0);
        }
        else if(optionString.contains("+")){
            if (!hashTable.containsKey(options[2]) || !hashTable.containsKey(options[4])) {
                System.out.println("ERROR");
                System.exit(0);
            }
            hashTable.put(options[0], hashTable.get(options[2])+hashTable.get(options[4]));
            System.out.println(hashTable.get(options[0]));
        }
        else if(optionString.contains("-")){
            if (!hashTable.containsKey(options[2]) || !hashTable.containsKey(options[4])) {
                System.out.println("ERROR");
                System.exit(0);
            }
            hashTable.put(options[0], hashTable.get(options[2])-hashTable.get(options[4]));
            System.out.println(hashTable.get(options[0]));
        }
        else if(optionString.contains("*")){
            if (!hashTable.containsKey(options[2]) || !hashTable.containsKey(options[4])) {
                System.out.println("ERROR");
                System.exit(0);
            }
            hashTable.put(options[0], hashTable.get(options[2])*hashTable.get(options[4]));
            System.out.println(hashTable.get(options[0]));
        }
        else if(options.length == 3){
            hashTable.put(options[0],Integer.parseInt(options[2]));
            System.out.println(hashTable.get(options[0]));
        }
        options();
    }

    private static String readString() {
        return scanner.nextLine();
    }
}