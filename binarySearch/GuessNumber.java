package binarySearch;

public class GuessNumber {
    public static void main(String[] args) {



    }

}

 class Solution374 {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid;
        while(low<=high){
            mid = low+((high-low)>>1);
            int guess = guess(mid);
            if(guess == 0){
                return mid;
            }else if(guess <0){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return -1;


    }

    private int guess(int num){


        return 0;
    }

}