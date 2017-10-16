package com.hong.admin.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syline on 2017/7/9.
 */
public class MessageUtil {
    //xml转化map集合
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);
        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();

        return map;
    }

//    // 将文本消息对象转化为XML
//    public static String textMessageToXml(TextMessage textMessage) {
//        XStream xstream = new XStream();
//        xstream.alias("xml", textMessage.getClass());
//        return xstream.toXML(textMessage);
//    }
}
