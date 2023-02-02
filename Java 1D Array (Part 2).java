import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        if(leap==0){
            for(int i=0;i<game.length;i++){
            if(game[i]==1) return false;
            if(i>=game.length-1) return true;

            }
        }
        outerloop:
        while(game[0]!=1){

            int trap = 0;
            for(int i=0;i<game.length;){

                if(i>=game.length||(i+leap)>=game.length) return true;

                if(i<0) return false;
                if(i==0&&game[i+1]==1&&game[i+leap]==1) return false;
                if(trap!=0&&i==0) return false;

                if(trap!=0){
                    if(i+leap==trap){
                        game[trap]=1;
                        trap=0;
                        continue outerloop;
                    }
                    if(game[i+leap]==0){
                        i+=leap;
                        trap=0;
                        continue;
                    }
                    else if(game[i-1]==0){
                        i--;
                        continue;
                    }
                    else if(game[i-1]==1){
                        game[trap]=1;
                        trap=0;
                        continue outerloop;
                    }
                }
                if(game[i+leap]==0){
                    i+=leap;
                    continue;
                }
                else if(game[i+1]==0){
                        i++;
                        continue;
                }
                else if(game[i+1]==1&&game[i+leap]==1){
                    trap = i;
                    if(game[i-1]==1){
                        game[i]=1;
                        continue outerloop;
                    }
                    else if(game[i-1]==0){
                        i--;
                        continue;
                    }
                }
            }
        }
        return false;    
    }
   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );

        }
        scan.close();
        }

    }