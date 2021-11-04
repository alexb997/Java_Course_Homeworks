
import java.util.*;

public class SecondMax {
    private static final String ERROR_MESSAGE = "The input array is invalid, expected integers." +
            " Please try again! \nExample input: 24 13 -3 22113";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce the Array: ");
        String[] input = in.nextLine().split(" ");
        in.close();
        try {
            List<Integer> integerArray = convertToIntArray(input);
            if(input.length==integerArray.size()) {
                getSecondMax(integerArray);
            }else{
                System.out.println(ERROR_MESSAGE);
            }
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    private static List<Integer> convertToIntArray(String[] stringArray) {
        List<Integer> intArray = new ArrayList<>();
        for (String element : stringArray) {
            if (isValid(element)) {
                intArray.add(Integer.parseInt(element));
            }
        }
        return intArray;
    }

    private static boolean isValid(String element) {
        String toBeChecked;
        if (element.startsWith("-")) {
            toBeChecked = element.substring(1);
        } else {
            toBeChecked = element;
        }
        return toBeChecked.chars().allMatch(Character::isDigit);
    }

    private static void getSecondMax(List<Integer> array) {
        SortedSet<Integer> sortedSet = new TreeSet<>(array);
        if (sortedSet.size() == 1) {
            System.out.println("No second max value was found");
        } else {
            try {
                sortedSet.remove(sortedSet.last());
                System.out.println(sortedSet.last());
            } catch (NoSuchElementException e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    private static void getSecondMaxAlternative(List<Integer> array) {
        int size = array.size();
        int temp;
        if(array.size()==1){
            System.out.println("No second max value was found");
        }else {
            for (int indexI = 0; indexI < size; indexI++) {
                for (int indexJ = indexI + 1; indexJ < size; indexJ++) {
                    if (array.get(indexI) > array.get(indexJ)) {
                        temp = array.get(indexI);
                        array.set(indexI, array.get(indexJ));
                        array.set(indexJ, temp);
                    }
                }
            }
            try{
                System.out.println(array.get(size-2));
            }catch (IndexOutOfBoundsException e){
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}