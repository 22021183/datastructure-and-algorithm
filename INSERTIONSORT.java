
public class INSERTIONSORT
{
    public static void main(String[]args){
        int arr[]={1,45,56,7,11};
         insertionsort(arr);
        for(int i:arr){
            System.out.println(i);
        
        
    
    }}
public static void insertionsort(int arr[]){
    int n = arr.length;
    
    for(int i=1;i<n;++i){
       int temp = arr[i];
       int j = i-1;
    
       while(j>=0 && arr[j]>temp){
        arr[j+1]=arr[j];
        j=j+1;
    }
    
     arr[j+1]=temp;
    
    
}}
}
 