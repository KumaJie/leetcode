package leetcode.zhousai;

/**
 * @author Kuma
 * @date 2021年1月24日
 * 5661.替换隐藏数字得到的最晚时间
 */
public class Lczs5661 {
    public String maximumTime(String time) {
        String[] t = time.split(":");
        String h = t[0];
        String m = t[1];
        StringBuffer rH = new StringBuffer();
        for (int i = 0; i < h.length(); i++) {
            if(h.charAt(i) == '?'){
                if(i == 0){
                    rH.append('2');
                }else {
                    if(rH.charAt(0) == '2'){
                        rH.append('3');
                    }else {
                        rH.append('9');
                    }
                }
                continue;
            }
            if(rH.length() != 0 && rH.charAt(0) == '2' && h.charAt(i) > '3'){
                rH.replace(0,1,"1");
            }
            rH.append(h.charAt(i));
        }
        StringBuffer rM = new StringBuffer();
        for (int i = 0; i < m.length(); i++) {
            if(m.charAt(i) == '?'){
                if(i == 0){
                    rM.append('5');
                }else {
                    rM.append('9');
                }
                continue;
            }
            rM.append(m.charAt(i));
        }
        rH.append(":"+rM.toString());
        return rH.toString();
    }

}
