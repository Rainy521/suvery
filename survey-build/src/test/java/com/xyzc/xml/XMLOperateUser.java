//package com.xyzc.xml;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//
//public class XMLOperateUser {
//    
//    private static final String xmlPath = "config/t2sdk-config2.xml";
//    
//    /*
//     * 查询全部xml
//     * */
//    public static List<ClientLoginUser> ListClinetLoginUser() throws Exception{
//        File dir = new File(xmlPath);        
//        if (!dir.exists()) {
//            dir.createNewFile();
//            Document dom = DocumentHelper.createDocument();
//            Element root = dom.addElement("persons");
//            String dirpath = dir+"";
//            UtilsForXml.writeToXML(dom, dirpath);
//        }
//        String dirPath = dir+"";
//        Document dom = UtilsForXml.getDocument(dirPath);
//        Element root = dom.getRootElement();        
//        List<ClientLoginUser> persons = new ArrayList<ClientLoginUser>();
//        
//        List list = root.elements();
//        for (int i = 0; i < list.size(); i++) {
//            Element person = (Element) list.get(i);
//            ClientLoginUser c = new ClientLoginUser();
//            String id = person.attributeValue("id");
////            c.setId(Integer.parseInt(id));
//            List ll = person.elements();
//            for (int j = 0; j < ll.size(); j++) {
//                Element element = (Element) ll.get(j);
////                if ("publishername".equals(element.getName())) {
////                    String publisherName = element.getText();
////                    c.setPublisherName(publisherName);
////                }
////                if ("serverurl".equals(element.getName())) {
////                    String serverurl = element.getText();
////                    c.setServerUrl(serverurl);
////                }
////                if ("username".equals(element.getName())) {
////                    String username = element.getText();
////                    c.setUserName(username);
////                }
////                if ("password".equals(element.getName())) {
////                    String password = element.getText();
////                    c.setPassword(password);
////                }
//            }
//            persons.add(c);
//        }
//        return persons;        
//    }
//    
//    /*
//     * 根据person的属性id查询xml
//     * */
//    public static ClientLoginUser QueryClinetLoginUserById(String appDir,int id) throws Exception{
//        File dir = new File(appDir+"\\persons.xml");
//        String dirPath = dir+"";        
//        Document dom = UtilsForXml.getDocument(dirPath);        
//        Element root = dom.getRootElement();        
//        ClientLoginUser person = new ClientLoginUser();
//        Element beQuery = (Element)root.selectSingleNode("//person[@id="+id+"]");
//        if(beQuery!=null){
//            person.setPublisherName(beQuery.elementText("publishername"));
//            person.setServerUrl(beQuery.elementText("serverurl"));
//            person.setUserName(beQuery.elementText("username"));
//            person.setPassword(beQuery.elementText("password"));
//            person.setId(id);
//        }
//        return person;                   
//    }
//    /*
//     * 增加xml数据
//     * */
//    public static int AddClinetLoginUser(String appDir,String publisherName,String serverUrl,String userName,String passWord) throws Exception{
//        File dir = new File(appDir+"\\persons.xml");
//        if (!dir.exists()) {
//             dir.createNewFile();
//        }
//        int id = 1;
//        String dirPath = dir+"";
//        Document dom = UtilsForXml.getDocument(dirPath);        
//        Element root = dom.getRootElement();
//        List<Element> list = root.elements("person");
//        if(!list.isEmpty()||list.size()!=0){
//            int count = list.size();
//            Element lastperson = list.get(count-1);
//            String value = lastperson.attributeValue("id");
//            id = Integer.parseInt(value)+1;
//        }        
////        int id = (int) ((Math.random()*9+1)*1000);
//        Element newPerson = root.addElement("person");
//        newPerson.addAttribute("id", id+"");
//        Element publishername = newPerson.addElement("publishername");
//        publishername.setText(publisherName);
//        Element serverurl = newPerson.addElement("serverurl");
//        serverurl.setText(serverUrl);
//        Element username = newPerson.addElement("username");
//        username.setText(userName);
//        Element password = newPerson.addElement("password");
//        password.setText(passWord);
//        UtilsForXml.writeToXML(dom, dirPath);
//        return id;
//    }
//    
//    /*
//     * 根据person属性id修改xml数据
//     * */
//    public static int UpdateClinetLoginUser(int id,String appDir,String publisherName,String serverUrl,String userName,String passWord) throws Exception{
//        File dir = new File(appDir+"\\persons.xml");
//        String dirPath = dir+"";        
//        Document dom = UtilsForXml.getDocument(dirPath);        
//        Element root = dom.getRootElement();
//        Element beQuery = (Element)root.selectSingleNode("//person[@id="+id+"]");
//        beQuery.element("publishername").setText(publisherName);
//        beQuery.element("serverurl").setText(serverUrl);
//        beQuery.element("username").setText(userName);
//        beQuery.element("password").setText(passWord);
//        UtilsForXml.writeToXML(dom, dirPath);
//        return id;
//    }
//    /*
//     * 根据person属性id删除xml数据
//     * */
//    public static void DeleteClinetLoginUser(String id) throws Exception{
//        File dir = new File(xmlPath);
//        String dirPath = dir+"";        
//        Document dom = UtilsForXml.getDocument(dirPath);        
//        Element root = dom.getRootElement();
//        Element beQuery = (Element)root.selectSingleNode("//parents[@id="+id+"]");
//        beQuery.getParent().remove(beQuery);
//        UtilsForXml.writeToXML(dom, dirPath);
//    }
//    
//    public static void main(String[] args) throws Exception {
//        String id = "t2serviceId";
//        DeleteClinetLoginUser(id);
//        //ListClinetLoginUser();
//    }
//}