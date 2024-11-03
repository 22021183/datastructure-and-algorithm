import java.util.Scanner;
import java.util.Arrays;

public class SortingAlgorithmGame {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Create array to store 10 integers
            int[] arr = new int[10];

            System.out.println("Sorting Game!!!");
            // Prompt user to enter 10 integers
            System.out.println("Enter 10 integers:");
            for (int i = 0; i < 10; i++) {
                while (true) {
                //If the user input is not a valid integer (like "abc" or "12.34"), this method will throw a NumberFormatException.    
                    try {
                        arr[i] = Integer.parseInt(scan.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                }
            }

            // Display menu for sorting algorithm selection
            System.out.println("\nChoose a sorting algorithm:");
            System.out.println("1.Bubble Sort");
            System.out.println("2.Insertion Sort");
            System.out.println("3.Selection Sort");
            System.out.println("4.Quick Sort");
            System.out.println("5.Merge Sort");
            System.out.print("Enter your choice (1-5): ");

            int choice = 0;
            while (choice < 1 || choice > 5) {
                try {
                    choice = Integer.parseInt(scan.nextLine());
                    if (choice < 1 || choice > 5) {
                        System.out.print("Invalid choice. Please enter a number between 1 and 5: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a number between 1 and 5: ");
                }
            }

            // Call appropriate sorting method based on user selection
            switch (choice) {
                case 1:
                     bubbleSort(arr);
                    break;
                case 2:
                     insertionSort(arr);
                    break;
                case 3:
                     selectionSort(arr);
                    break;
                case 4:
                     quickSort(arr, 0, arr.length - 1);
                    break;
                case 5:
                     mergeSort(arr, 0, arr.length - 1);
                    break;
            }

            System.out.println("\nFinal sorted array:");
            displayArray(arr);

            System.out.print("\nDo you want to sort another array? (yes/no): ");
            String answer = scan.nextLine();
            if (!answer.equals("yes")) {
                System.out.println("Thank you for playing!");
                break;
            }
        }
        scan.close();
    }

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        System.out.println("\nBubble Sort:");
        if (isSorted(arr)) {
            System.out.println("Array is already sorted. " + Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.print("Pass " + (i + 1) + ": ");
            displayArray(arr);
            if (!swapped) {
                break;
            }
        }
    }

    // Insertion Sort implementation
    public static void insertionSort(int[] arr) {
        System.out.println("\nInsertion Sort:");
        if (isSorted(arr)) {
            System.out.println("Array is already sorted: " + Arrays.toString(arr));
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            if (j >= 0 && arr[j] > key) {
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
            System.out.print("Pass " + (i + 1) + ": ");
            displayArray(arr);
        }
    }

    // Selection Sort implementation
    public static void selectionSort(int[] arr) {
        System.out.println("\nSelection Sort:");
        if (isSorted(arr)) {
            System.out.println("Array is already sorted. " + Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
            System.out.print("Pass " + (i + 1) + ": ");
            displayArray(arr);
        }
    }


    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Check if the subarray is already sorted
            if (isSorted(arr)) {
                System.out.println("Subarray already sorted: ");
                displayArray(arr);
                return;
            }
            
            int pi = partition(arr, low, high);
            System.out.print("Partition at index " + pi + ": ");
            displayArray(arr);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    // Partition helper method for Quick Sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i + 1] and pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    // Merge Sort implementation
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
              // Before continuing, check if the array is already sorted
        if (isSorted(arr)) {
           return;
        }
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
            System.out.print("Merge (" + left + ", " + middle + ", " + right + "): ");
            displayArray(arr);
        }
    }

    // Merge helper method for Merge Sort
    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // check if the array is already sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) { 
                return false;
            }
        }
        return true;
    }

    // Helper method to display array
    private static void displayArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
  
}
