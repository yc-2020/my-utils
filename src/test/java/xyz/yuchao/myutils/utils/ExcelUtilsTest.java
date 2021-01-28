package xyz.yuchao.myutils.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:yc
 * @Date:2021/1/28 11:43
 */
public class ExcelUtilsTest {

    @Test
    public void createExcel() throws IOException {
        ExcelUtils.createExcel("/home/test/1.xls",getDataList());
    }


    private static List<Map<String,Object>> getDataList(){
        List<Map<String,Object>> dataList=new ArrayList<>();
        for(int i=0;i<10;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name","name"+i);
            map.put("age",i);
            dataList.add(map);
        }
        return dataList;
    }


}
