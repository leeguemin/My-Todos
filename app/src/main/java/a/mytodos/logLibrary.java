package a.mytodos;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 2016-05-29.
 */
public class logLibrary {
    static  String tag = "debugging";

    public static void print(String msg){
        Log.d(tag, msg);
    }

    public static void print(int num){
        Log.d(tag, "" + num);
    }
    //자동으로

    public static void error(String msg){
        Log.e(tag, "*******ERROR*******");
        Log.e(tag, msg);
        Log.e(tag, "*******************");
    }
    public static void error(int num){
        Log.e(tag, "*******ERROR*******");
        Log.e(tag, "" + num);
        Log.e(tag, "*******************");
    }
    public  static void error(){
        Log.e(tag, "**********ERROR**********");
    }

    public static void print(){
        Log.d(tag, ".");
    }

    //배열을 한줄씩 프린트 해준다
    public static void printEach(int [] arr){
        Log.d(tag, "---printing a integer array---");
        for(int i : arr){
            Log.d(tag, "" + i);
        }
        /* for문으로 하는법
        for(int i = 0; i < arr.length; i++){
            Log.d(tag,"index" + i + ": " +  arr[i]);
        }
         */
        Log.d(tag, "-------finished printing-------");
    }
    public static void printEach(String [] arr){
        Log.d(tag, "---printing a integer array---");
        for(int i = 0; i < arr.length; i++){
            Log.d(tag,"index" + i + ": " +  arr[i]);
        }
        Log.d(tag, "-------finished printing-------");
    }
    public static void printEach(double [] arr){
        Log.d(tag, "---printing a integer array---");
        for(int i = 0; i < arr.length; i++){
            Log.d(tag,"index" + i + ": " +  arr[i]);
        }
        Log.d(tag, "-------finished printing-------");
    }
    public static void printEach(ArrayList arrList){
        Log.d(tag, "---printing a integer array---");
        for(int i = 0; i < arrList.size(); i++){
            Log.d(tag,"index" + i + ": " +  arrList);
        }
        Log.d(tag, "-------finished printing-------");
    }
    public static void printWhole(int [] arr){
        Log.w(tag, "---printing an integer array---");
        Log.d(tag, "" + Arrays.toString(arr));
        Log.w(tag, "-------finished printing-------");
    }
    public static void printWhole(String [] arr){
        Log.w(tag, "---printing an integer array---");
        Log.d(tag, "" + Arrays.toString(arr));
        Log.w(tag, "-------finished printing-------");
    }
    public static void printWhole(double [] arr){
        Log.w(tag, "---printing an integer array---");
        Log.d(tag, "" + Arrays.toString(arr));
        Log.w(tag, "-------finished printing-------");
    }
    public static void printWhole(ArrayList arrList){
        Log.w(tag, "---printing an integer array---");
        Log.d(tag, "" + arrList);
        Log.w(tag, "-------finished printing-------");
    }
}
