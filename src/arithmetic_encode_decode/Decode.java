package arithmetic_encode_decode;

import com.sun.xml.internal.ws.util.StreamUtils;
import com.sun.xml.internal.ws.util.StringUtils;

import javax.rmi.CORBA.Util;
import java.util.HashMap;

public class Decode {

    public String decode(double inputNum, HashMap<Character,double[]> map,int stringLen){

        String res = "";
        for (int i =0;i<stringLen;i++){
            for(Character key:map.keySet()){
                if(inputNum<map.get(key)[1]&&inputNum>=map.get(key)[0]){
                    res = res + key;
                    double range = map.get(key)[1] - map.get(key)[0];
                    inputNum = (inputNum - map.get(key)[0]) / range;
                    break;
                }
            }
        }
        return  res;
    }


}
