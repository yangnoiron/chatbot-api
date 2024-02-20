package org.cuc.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("Content-Type", "application/json");
        get.addHeader("cookie", "zsxq_access_token=A27DD0BC-3C74-ACF6-7317-13081C239A9F_A2834E92E96B585E; zsxqsessionid=3567ba9da41bbd5df497cabaeaffa5e2; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218d7f0137c4b0b-0cf702993fb396-1e525637-1484784-18d7f0137c511d6%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkN2YwMTM3YzRiMGItMGNmNzAyOTkzZmIzOTYtMWU1MjU2MzctMTQ4NDc4NC0xOGQ3ZjAxMzdjNTExZDYifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218d7f0137c4b0b-0cf702993fb396-1e525637-1484784-18d7f0137c511d6%22%7D; abtest_env=product");

        CloseableHttpResponse response = httpclient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/211154512454521/comments");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("cookie", "zsxq_access_token=A27DD0BC-3C74-ACF6-7317-13081C239A9F_A2834E92E96B585E; zsxqsessionid=3567ba9da41bbd5df497cabaeaffa5e2; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218d7f0137c4b0b-0cf702993fb396-1e525637-1484784-18d7f0137c511d6%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkN2YwMTM3YzRiMGItMGNmNzAyOTkzZmIzOTYtMWU1MjU2MzctMTQ4NDc4NC0xOGQ3ZjAxMzdjNTExZDYifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218d7f0137c4b0b-0cf702993fb396-1e525637-1484784-18d7f0137c511d6%22%7D; abtest_env=product");

        String Param = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"测试回复 again\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(Param, ContentType.create("application/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpclient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
