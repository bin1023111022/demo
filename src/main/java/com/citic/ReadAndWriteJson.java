package com.citic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadAndWriteJson {
	public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	public static void main(String[] args) throws  IOException {  
        // TODO Auto-generated method stub  
  
        // String s = ReadFile("./src/test.json");  
        // System.out.println(s);  
        List<ClockInfo> cls = new ArrayList<ClockInfo>();
        ClockInfo cl1 = new ClockInfo(),
        		  cl2 = new ClockInfo(),
        		  cl3 = new ClockInfo(),
        		  cl4 = new ClockInfo();
        cl1.setId(1L);
        cl2.setId(2L);
        cl3.setId(3L);
        cl4.setId(4L);
        
        cls.add(cl1);
        cls.add(cl2);
        cls.add(cl3);
        cls.add(cl4);
        
        ClockInfoList cil = new ClockInfoList();
        cil.setCilList(cls);
        
        String json=gson.toJson(cil);
        writeFile("./src/test.json", json);
        
        String rjson = ReadFile("./src/test.json");
        ClockInfoList lttc = gson.fromJson(rjson,ClockInfoList.class);
        
        List<ClockInfo> rls = lttc.getCilList();
        System.out.println(rls);
    }  
  
    public static void writeFile(String filePath, String sets)  
            throws IOException {  
        FileWriter fw = new FileWriter(filePath);  
        PrintWriter out = new PrintWriter(fw);  
        out.write(sets);  
        out.println();  
        fw.close();  
        out.close();  
    }  
  
    public static String ReadFile(String path) {  
        File file = new File(path);  
        BufferedReader reader = null;  
        String laststr = "";  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {  
                laststr = laststr + tempString;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return laststr;  
    }  
}
