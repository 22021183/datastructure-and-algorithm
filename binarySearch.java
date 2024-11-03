import java.util.*;
public class binarySearch{
    public static void main(String[]args){
        
        Scanner roy= new Scanner(System.in);
        int arr[] = {45,11,33,22,90};
        System.out.print("enter the number");
        int target= roy.nextInt();
        int answer =binarysearchsort(arr,target);
        
        if(target!=1){
            System.out.println(answer);
        }
        else{
            System.out.println("Not available");
        }
    }
    public static int binarysearchsort(int[] numbers,int numbersTofind){
        int min=0;
        int max=numbers.length-1;
        while(min<=max){
            int middleposition = (min+max)/2;
            int middlenumber = numbers[middleposition];
            if(numbersTofind == middlenumber){
            return middleposition;
            
        }
    if (numbersTofind < middlenumber){
        max=middleposition-1;
        
    }
    else{
        min = middleposition + 1;
    }
    return -1;
    }
}}