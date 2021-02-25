package xyz.yuchao.myutils.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:yc
 * @Date:2021/1/28 10:19
 */
public class ExcelUtils {

    public static void createExcel(String outExcelFilePath,List<Map<String,Object>> valueList) throws IOException {
        Assert.notEmpty(valueList,"valueList Can't not empty");
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Sheet1");
        List<String> heads = new ArrayList<>(valueList.get(0).keySet());
        int rowNum=0;
        HSSFRow headRow = sheet.createRow(rowNum++);
        for(int i=0;i<heads.size();i++){
            HSSFCell cell = headRow.createCell(i);
            cell.setCellValue(String.valueOf(heads.get(i)));
        }
        for(Map map:valueList){
            HSSFRow row=sheet.createRow(rowNum++);
            for(int i=0;i<heads.size();i++){
                HSSFCell cell=row.createCell(i);
                cell.setCellValue(String.valueOf(map.get(heads.get(i))));
            }
        }
        OutputStream out = new FileOutputStream(outExcelFilePath);
        wb.write(out);
        wb.close();
        out.flush();
        out.close();
    }


    public static void createExcel(String outExcelFilePath,List<Map<String,Object>> valueList,Map<String,String> headNameMap){
        Assert.notEmpty(valueList,"valueList Can't not empty");
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Sheet1");
        List<String> heads = new ArrayList<>(headNameMap.keySet());
        int rowNum=0;
        HSSFRow headRow = sheet.createRow(rowNum++);
        for(int i=0;i<heads.size();i++){
            HSSFCell cell = headRow.createCell(i);
            cell.setCellValue(String.valueOf(headNameMap.get(heads.get(i))));
        }
    }


}
