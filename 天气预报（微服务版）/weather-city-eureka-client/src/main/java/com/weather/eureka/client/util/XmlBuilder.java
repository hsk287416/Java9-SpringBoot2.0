package com.weather.eureka.client.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlBuilder {
    /**
     * 将XML转为指定的对象
     * @param clazz
     * @param xmlStr
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T xmlStrToObject(Class<T> clazz, String xmlStr) throws Exception {
        T xmlObj = null;

        try (Reader reader = new StringReader(xmlStr)) {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            xmlObj = (T)unmarshaller.unmarshal(reader);
        }

        return xmlObj;
    }
}
