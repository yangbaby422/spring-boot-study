package com.soft1721.jianyue.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by 洋酱 on 2019/4/6.
 */
public class DaoJishi {
    public void dateDiff(String startTime, String endTime, String format) {
        //按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000*24*60*60;//一天的毫秒数
        long nh = 1000*60*60;//一小时的毫秒数
        long nm = 1000*60;//一分钟的毫秒数
        long ns = 1000;//一秒钟的毫秒数
        long diff;
        try {
            //获得两个时间的毫秒时间差异
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            long day = diff/nd;//计算差多少天
            long hour = diff%nd/nh;//计算差多少小时
            long min = diff%nd%nh/nm;//计算差多少分钟
            long sec = diff%nd%nh%nm/ns;//计算差多少秒
            //输出结果
            System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
