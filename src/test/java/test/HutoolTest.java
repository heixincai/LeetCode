package test;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.junit.jupiter.api.Test;

public class HutoolTest {
    @Test
    public void test(){
        //链式构建请求
        try{
            HttpResponse result2 = HttpRequest.get("http://localhost:9101/api/barcode/scanCodeDetail?barcode=P22021091300001")
                    .header("X-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MzE1MzExMzIsInN1YiI6IntcInJlZnJlc2hUdGxcIjpcIjE2MzE1MzQ3MzI4MTNcIixcInR5cGVcIjpcIjFcIixcInVzZXJJZFwiOlwiMTQzMzM0NzIwNDgyMjYzMDQwMVwifSIsImlzcyI6Im1pbmdkdSIsImF1ZCI6IndtcyIsImV4cCI6MTYzMTUzODMzMiwibmJmIjoxNjMxNTMxMTMyfQ.klG08fpgCnySeiSWqwm5oosfVTz4VA513iqhg4mkdQ0")//头信息，多个头信息多次调用此方法即可
                    .timeout(20000)//超时，毫秒
                    .execute();
            System.out.println(result2.isOk());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
