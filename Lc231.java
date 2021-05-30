package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author Kuma
 * @date 2021年5月30日
 * 231. 2 的幂
 */
public class Lc231 {
    public boolean isPowerOfTwo(int n) {
//        lowbit
        return n > 0 && n -(n & -n) == 0;
    }
}
