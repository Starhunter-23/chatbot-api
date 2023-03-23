package cn.magi.chatbot.api.infrastructure;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName ApiTest
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/22 20:48
 * @Version 1.0
 */

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885881241141/topics?scope=all&count=20");
        get.addHeader("cookie", "zsxq_access_token=F4184D71-62C4-6D99-7364-9C45082369EE_11DE56A3CE03D224; zsxqsessionid=dba3688203f9826f87311a37fe5aafc0; abtest_env=beta");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException
    {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412541888551258/answer");
        post.addHeader("cookie", "zsxq_access_token=F4184D71-62C4-6D99-7364-9C45082369EE_11DE56A3CE03D224; zsxqsessionid=dba3688203f9826f87311a37fe5aafc0; abtest_env=beta");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我不会\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
        {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
