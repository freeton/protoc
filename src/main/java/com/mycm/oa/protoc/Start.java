package com.mycm.oa.protoc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 说明：
 *
 * @author zhangwei
 * @date 2018/3/21 11:13
 */
public class Start {

    public static void main(String[] args) throws IOException {
        PersonMsg.Person.Builder builder=PersonMsg.Person.newBuilder();
        builder.setId(1);
        builder.setEmail("123@mycm.com");
        builder.setName("haha");

        PersonMsg.Person person=builder.build();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        person.writeTo(output);


        byte[] byteArray = output.toByteArray();

        // -------------- 分割线：下面是接收方，将数据接收后反序列化 ---------------

        // 接收到流并读取，如网络输入流，这里用ByteArrayInputStream来代替
        ByteArrayInputStream input = new ByteArrayInputStream(byteArray);

        // 反序列化
        PersonMsg.Person xxg2 = PersonMsg.Person.parseFrom(input);
        System.out.println("ID:" + xxg2.getId());
        System.out.println("name:" + xxg2.getName());
        System.out.println("email:" + xxg2.getEmail());
        System.out.println("friend:");
        List<String> friends = xxg2.getFriendsList();
        for(String friend : friends) {
            System.out.println(friend);
        }


    }

}
