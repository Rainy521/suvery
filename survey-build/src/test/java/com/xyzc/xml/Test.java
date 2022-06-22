//package com.xyzc.xml;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.dom4j.Attribute;
//import org.dom4j.Document;
//import org.dom4j.Element;
//
//import com.xyzc.domain.environment.T2XmlData;
//import com.xyzc.util.T2XmlUtil;
//
//public class Test {
//
//    private static final String xmlPath = "config/t2sdk-config2.xml";
//    
//    public static void query(Document doc) {
//      //获取根节点
//        Element root = doc.getRootElement();
//      //获取student 的节点
//        Element parents = root.element("parents");
//        List<Element> list = parents.elements();
//        
//        List<T2XmlData> resuleList = new ArrayList<>();
//        for(Element temp : list) {
//            T2XmlData data = new T2XmlData();
//            String parentName = getAttributeValue(temp,"parentName");
//            data.setParentName(parentName);
//            
//            String safeLevel = getAttributeValue(temp,"safeLevel");
//            data.setSafeLevel(safeLevel);
//            
//            Element limitElement = temp.element("limit");
//            String licenseFile = getAttributeValue(limitElement, "licenseFile");
//            data.setLicenseFile(licenseFile);
//            
//            String encrypt = getAttributeValue(limitElement, "encrypt");
//            data.setEncrypt(encrypt);
//            
//            Element memberElement = temp.element("members").element("member");
//            String address = getAttributeValue(memberElement, "address");
//            data.setMemberAddress(address);
//            
//            String port = getAttributeValue(memberElement, "port");
//            data.setMemberPort(port);
//            
//            resuleList.add(data);
//        }
//        for(T2XmlData data : resuleList) {
//            System.out.println("parentName:" + data.getParentName());
//            System.out.println("safeLevel:" + data.getSafeLevel());
//            System.out.println("licenseFile:" + data.getLicenseFile());
//            System.out.println("encrypt:" + data.getEncrypt());
//            System.out.println("address:" + data.getMemberAddress());
//            System.out.println("port:" + data.getMemberPort());
//            System.out.println("------------------------------");
//        }
//    }
//    
//    private static String getAttributeValue(Element element,String attrName) {
//        Attribute attr = element.attribute(attrName);
//        if (null != attr && null != attr.getValue()) {
//            return attr.getValue();
//        }
//        return StringUtils.EMPTY;
//    }
//    
//    public static void remove(Document doc, String name) throws Exception {
//        //获取根节点
//        Element root = doc.getRootElement();
//        //获取第二个 student节点 
//        Element stu = (Element) root.elements("parents").get(0);
//
//        //移除操作
//        root.remove(stu);
//
//        UtilsForXml.writeToXML(doc, xmlPath);
//        System.out.println("删除成功");
//    }
//    
//    public static void insert(Document doc) throws Exception {
//        //获取根节点
//        Element root = doc.getRootElement();
//        Element parents = root.element("parents");
//        if (parents == null) {
//           parents = root.addElement("parents");
//        }
//        Element parent = parents.addElement("parent");
//        parent.addAttribute("parentName", "myserver");
//        parent.addAttribute("safeLevel", "NONE");
//        parent.addAttribute("noNameConnection", "true");
//        
//        Element limit = parent.addElement("limit");
//        limit.addAttribute("licenseFile", "config/client_license.dat");
//        limit.addAttribute("encrypt", "HS");
//        
//        Element members = parent.addElement("members");
//        Element member = members.addElement("member");
//        member.addAttribute("no","0");
//        member.addAttribute("address","168.61.8.12");
//        member.addAttribute("port","8260");
//        member.addAttribute("charset","gbk");
//        member.addAttribute("poolSize","3");
//
//        //回写操作
//        UtilsForXml.writeToXML(doc, xmlPath);
//
//        System.out.println("添加成功 ...");
//    }
//    
//    public static void main(String[] args) throws Exception {
//        
//        Document doc = UtilsForXml.getDocument(xmlPath);
//        //query(doc);
//        //T2XmlUtil.remove(xmlPath, "myserver2");
//        
//        T2XmlData t2Data = new T2XmlData();
//        t2Data.setParentName("myserver3");
//        t2Data.setSafeLevel("NONE");
//        t2Data.setMemberAddress("168.61.8.12");
//        t2Data.setMemberPort("8260");
//        t2Data.setLicenseFile("config/client_license.dat");
//        
//        T2XmlUtil.insert(xmlPath, t2Data);
//        //insert(doc);
//        
//    }
//}
