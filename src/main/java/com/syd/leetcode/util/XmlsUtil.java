package com.syd.leetcode.util;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


public class XmlsUtil {

    public void generateXml(ThreeLevelXmlDto threeLevelXml) throws FileNotFoundException {
        Document document = XmlUtil.createXml();
        //固定格式
        Element rootDocument = document.createElement("Document");
        rootDocument.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
        rootDocument.setAttribute("xsi:noNamespaceSchemaLocation","关联关系XML Schema-3.0.xsd");
        rootDocument.setAttribute("License","");
        Element events = document.createElement("Events");
        events.setAttribute("version","3.0");
        Element event = document.createElement("Event");
        event.setAttribute("name","RelationCreate");

        //根据用户输入生成：非固定
        Element relation = document.createElement("Relation");
        relation.setAttribute("productCode",threeLevelXml.getProductCode());
        relation.setAttribute("subTypeNo",threeLevelXml.getSubTypeNo());
        relation.setAttribute("cascade",threeLevelXml.getCascade());
        relation.setAttribute("packageSpec",threeLevelXml.getPackageSpec());
        relation.setAttribute("comment",threeLevelXml.getComment());

        Element batch = document.createElement("Batch");
        batch.setAttribute("batchNo",threeLevelXml.getBatchNo());
        batch.setAttribute("madeDate",LocalDate.now().toString());
        batch.setAttribute("validateDate",threeLevelXml.getValidateDate());
        batch.setAttribute("workshop",threeLevelXml.getWorkshop());
        batch.setAttribute("lineName",threeLevelXml.getLineName());
        batch.setAttribute("lineManager",threeLevelXml.getLineManager());

        String cascade = threeLevelXml.getCascade();
        String [] nums = cascade.split(":");
        //三、二、一级码个数
        int thirdNums = Integer.parseInt(nums[0]);
        int secondNums = Integer.parseInt(nums[1]);
        int firstNums = Integer.parseInt(nums[2]);
        //存放三二一级码element
        List<Element> thirdElements = new ArrayList<>();
        List<Element> secondElements = new ArrayList<>();
        List<Element> firstElements = new ArrayList<>();

        AtomicLong sysMillis = new AtomicLong(System.currentTimeMillis());

        for(int i = 0 ; i < thirdNums ; i ++){
            Element thirdElement = document.createElement("Code");
            String thirdCode = String.valueOf(sysMillis.addAndGet(1));
            thirdElement.setAttribute("curCode", thirdCode);
            thirdElement.setAttribute("packLayer", "3");
            thirdElement.setAttribute("parentCode", "");
            thirdElement.setAttribute("flag", "0");
            thirdElements.add(thirdElement);
            for(int j = 0 ; j < secondNums ; j ++){
                Element secondElement = document.createElement("Code");
                String secondCode = String.valueOf(sysMillis.addAndGet(1));
                secondElement.setAttribute("curCode", secondCode);
                secondElement.setAttribute("packLayer", "2");
                secondElement.setAttribute("parentCode", thirdCode);
                secondElement.setAttribute("flag", "0");
                secondElements.add(secondElement);
                for(int k = 0 ; k < firstNums ; k ++){
                    Element firstElement = document.createElement("Code");
                    String firstCode = String.valueOf(sysMillis.addAndGet(1));
                    firstElement.setAttribute("curCode", firstCode);
                    firstElement.setAttribute("packLayer", "1");
                    firstElement.setAttribute("parentCode", secondCode);
                    firstElement.setAttribute("flag", "0");
                    firstElements.add(firstElement);
                }
            }
        }

        //填充
        document.appendChild(rootDocument);
        rootDocument.appendChild(events);
        events.appendChild(event);
        event.appendChild(relation);
        relation.appendChild(batch);
        thirdElements.forEach(third -> {
            batch.appendChild(third);
        });
        secondElements.forEach(second -> {
            batch.appendChild(second);
        });
        firstElements.forEach(first -> {
            batch.appendChild(first);
        });
        XmlUtil.toStr(document);
        //写出到文件
        FileOutputStream xmlOut = new FileOutputStream(new File("D://syd.xml"));
        XmlUtil.write(document, xmlOut, "GB2312", 1);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Long start = System.currentTimeMillis();
        ThreeLevelXmlDto threeLevelXmlDto = new ThreeLevelXmlDto();
        threeLevelXmlDto.setBatchNo("syd-001");
        threeLevelXmlDto.setCascade("10:10:30");
        threeLevelXmlDto.setComment("测试生成三级xml");
        threeLevelXmlDto.setLineManager("车间主任");
        threeLevelXmlDto.setProductCode("MAT-001");
        threeLevelXmlDto.setPackageSpec("盒1支");
        threeLevelXmlDto.setWorkshop("甲肝车间");
        threeLevelXmlDto.setValidateDate("2023-01-06");
        threeLevelXmlDto.setSubTypeNo("9111457001");
        XmlsUtil xmlsUtil = new XmlsUtil();
        xmlsUtil.generateXml(threeLevelXmlDto);
        Long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}
