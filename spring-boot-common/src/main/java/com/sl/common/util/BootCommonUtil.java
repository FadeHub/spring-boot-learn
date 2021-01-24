package com.sl.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shuliangzhao
 * @Title: BootCommonUtil
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/24 17:11
 */
public class BootCommonUtil {

    /**
     * 大list拆分为小list
     * @param list
     * @param subNum
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splistList(List<T> list, int subNum) {
        List<List<T>> tNewList = new ArrayList<List<T>>();
        int priIndex = 0;
        int lastPriIndex = 0;
        int insertTimes = list.size()/subNum;
        List<T> subList = new ArrayList<>();
        for (int i = 0;i <= insertTimes;i++) {
            priIndex = subNum*i;
            lastPriIndex = priIndex + subNum;
            if (i == insertTimes) {
                subList = list.subList(priIndex,list.size());
            } else {
                subList = list.subList(priIndex,lastPriIndex);
            }
            if (subList.size() > 0) {
                tNewList.add(subList);
            }
        }
        return tNewList;
    }

    /**
     * 驼峰转换为下划线
     * TDmAmbs -> T_Dm_Ambs
     * @param str
     * @return
     */
    public static String decamelize(String str) {
       if (StringUtils.isBlank(str))  {
            return null;    
       }
        char c = str.charAt(0);
       return c + str.substring(1).replaceAll("[A-Z]","_$0");
    }

    /**
     * 下划线转驼峰
     * t_dm_ambs 转 TDmAmbs
     * true 代表转大写 /false 小写
     * @param str
     * @param smaller
     * @return
     */
    public static String camelize(String str,boolean smaller) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (smaller&& matcher.start()==0) {
                sb.append(Character.toLowerCase(group.charAt(0)));
            }else {
                sb.append(Character.toUpperCase(group.charAt(0)));
            }
            int index = group.lastIndexOf('_');
            if (index > 0) {
                sb.append(group.substring(1, index).toLowerCase());
            } else {
                sb.append(group.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "TDmAmbs";
        char c = str.charAt(0);
        String s = c + str.substring(1).replaceAll("[A-Z]", "_$0");
        System.out.println(s);
        String camelize = camelize("t_dm_ambsa", true);
        System.out.println(camelize);
    }
}
