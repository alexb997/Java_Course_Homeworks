
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SecondMax {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce the Array: ");
        String[] input = in.nextLine().split(" ");
        in.close();
        try{
            int[] elementsArr = convertToIntArr(input);
            getSecondMax(elementsArr);
        }catch (NoSuchElementException e) {
            System.out.println("The input array is invalid, expected integers. Please try again!\n Example input: 24 13 -3 22113");
        }
    }

    public static int[] convertToIntArr(String[] strArr) throws NoSuchElementException {
        int[] intArr= new int[strArr.length];
        int length=0;
        for(String element: strArr) {
            try{
                if(isValid(element))
                    intArr[length++]=Integer.parseInt(element);
            }catch (NumberFormatException e){
                throw new NoSuchElementException();
            }
        }
        return intArr;
    }

    private static boolean isValid(String element){
        String toBeChecked;
        if (element.startsWith("-")) {
            toBeChecked = element.substring(1);
        } else {
            toBeChecked=element;
        }
        return toBeChecked.chars().allMatch(Character::isDigit);
    }

    public static void getSecondMax(int[] arr){
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int element: arr) {
            sortedSet.add(element);
        }
        if(sortedSet.size()==1){
            System.out.println("No second max value was found");
        }else {
            try {
                sortedSet.remove(sortedSet.last());
                System.out.println(sortedSet.last());
            }catch (NoSuchElementException e){
                System.out.println("The input array is invalid, expected integers. Please try again! \nExample input: 24 13 -3 22113");
            }
        }
    }
}