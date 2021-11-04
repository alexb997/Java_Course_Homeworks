
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SecondMax {
    public static void main(String[] args) {
        int leng=0;
        boolean invalid=false;
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce the Array: ");
        String[] input = in.nextLine().split(" ");
        in.close();
        if(input.length==0){
            System.out.print("The input array is invalid, expected integers. Please try again");
            return;
        }
        int[] elementsArr = new int[input.length];
        String temp;
        for(String element: input) {
            if(element.length()==0){
                invalid=true;
                break;
            }else {
                if (element.startsWith("-")) {
                    temp = element.substring(1);
                    if (temp.chars().allMatch(Character::isDigit)) {
                        try {
                            elementsArr[leng++] = Integer.parseInt(element);
                        } catch (NumberFormatException e) {
                            System.out.println("Input value is out of Integer bounds");
                            invalid=true;
                            break;
                        }
                    } else {
                        invalid = true;
                        break;
                    }
                } else {
                    if (element.chars().allMatch(Character::isDigit)) {
                        try {
                            elementsArr[leng++] = Integer.parseInt(element);
                        } catch (NumberFormatException e) {
                            System.out.println("Input value is out of Integer bounds");
                            invalid=true;
                            break;
                        }
                    } else {
                        invalid = true;
                        break;
                    }
                }
            }
        }
        if(invalid){
            System.out.print("The input array is invalid, expected integers. Please try again ");
        }else {
            getSecondMax(elementsArr);
        }
    }
    public static void getSecondMax(int[] arr){
        SortedSet<Integer> set = new TreeSet<Integer>();
        for (int element: arr) {
            set.add(element);
        }
        if(set.size()==1){
            System.out.println("No second max value was found");
        }else {
            set.remove(set.last());
            System.out.println(set.last());
        }
    }
}