package arithmetic_encode_decode;

import java.util.HashMap;
import java.util.Scanner;

public class TestCode {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.next();

        Encode encode = new Encode(input);

        Double code = encode.encodeString();
        System.out.println("编码为:" + code);


        HashMap<Character,double[]> resMap = encode.getRes_map();
        System.out.println("每个字符的概率区间为：");
        for(Character key:resMap.keySet()){

            System.out.print(key + "     " +  resMap.get(key)[0] + "     "+resMap.get(key)[1]);
            System.out.println();
        }
        int stringLen = encode.getStringLen();
        System.out.println("字符总长度" + stringLen);
        Decode decode = new Decode();
        String resString = decode.decode(code,resMap,stringLen);
        System.out.println("解码为:"+ resString);

    }
}
