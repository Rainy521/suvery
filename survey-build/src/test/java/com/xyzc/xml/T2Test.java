//package com.xyzc.xml;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.hundsun.t2sdk.interfaces.IClient;
//import com.hundsun.t2sdk.interfaces.share.event.IEvent;
//import com.xyzc.t2.config.GatewayResponse;
//import com.xyzc.t2.config.T2Util;
//
//public class T2Test {
//    
//    public static void main(String[] args) throws Exception {
//        IClient client = T2Util.getClient("myserver");
//        
//        Map<Object,Object> param = new HashMap<>();
//        param.put("op_branch_no", "1");
//        param.put("operator_no", "1001");
//        param.put("op_password", "123123");
//        param.put("branch_no", "1");
//        param.put("client_id", "01005178");
//        param.put("fund_account", "1005178");
//        param.put("password", "123123");
//        param.put("exchange_type", "1");
//        param.put("stock_account", "B883082322");
//        param.put("stock_code", "600008");
//        param.put("stock_price", "12");
//        param.put("occur_amount", "1000");
//        IEvent result = T2Util.sendT2Request(0, "210008", param, client);
//        
//        GatewayResponse a = T2Util.getResponse("210008", result);
//        System.out.println(a);
//    }
//}
