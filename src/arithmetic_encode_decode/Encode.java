package arithmetic_encode_decode;

import java.util.HashMap;
import java.util.Map;

public class Encode {

    private String fixString = null;

    public HashMap<Character, double[]> getRes_map() {
        return res_map;
    }

    public int getStringLen(){
        return fixString.length();
    }

    private HashMap<Character,double[]> res_map;

    public Encode(String inputString){
        this.fixString = inputString;
    }


    //计算每个字符出现的概率
    public void computePossibility(){
        Map<Character,Double> map = new HashMap<>();
        res_map = new HashMap<>();
        for(int i =0;i<fixString.length();i++){

            if(!map.containsKey(fixString.charAt(i))){
                map.put(fixString.charAt(i),1.0);
            }
            else {
                double new_value = map.get(fixString.charAt(i)) + 1;
               map.put(fixString.charAt(i),new_value);
            }
        }

        for(Character key:map.keySet()){

            map.put(key,map.get(key)/fixString.length());
        }


        double start = 0.0;
        double end = 0.0;

        for(Character key:map.keySet()){
            start = end;
            end = end + map.get(key);
            res_map.put(key,new double[]{start,end});
        }
    }

    private double lowRange(char input){
        return res_map.get(input)[0];
    }

    private double highRange(char input){
        return res_map.get(input)[1];
    }

    public double encodeString(){


//        res_map = new HashMap<>();
//        res_map.put('A',new double[]{0,0.1});
//        res_map.put('B',new double[]{0.1,0.5});
//        res_map.put('C',new double[]{0.5,0.7});
//        res_map.put('D',new double[]{0.7,1.0});
        //correct answer [0.51439， 0.5143948]
        this.computePossibility();
        double low = 0.0;
        double high = 1.0;
        for(int i =0;i<fixString.length();i++){
            double codeRange = high - low;
            high = low + codeRange * highRange(fixString.charAt(i));
            low = low + codeRange * lowRange(fixString.charAt(i));
        }

        return low;
    }

//    public static void main(String[] args) {
//
//        String inputString = "CADACDB";
//        Encode encode = new Encode(inputString);
//        System.out.println(encode.encodeString());
//    }

}
