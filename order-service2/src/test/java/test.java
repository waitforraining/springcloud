import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test {
    public static void main(String[] args) throws IOException {
        System.setProperty("proxyHost", "127.0.0.1"); // 代理的IP地址
        System.setProperty("proxyPort", "10809"); // 代理的端口号

        String apiEndpoint = "https://api.openai.com/v1/engines/text-davinci-003/completions";
        String apiKey = "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"; // 这里是第二步生成的apiKey
        String prompt = "'你在哪里？'翻译成英文";
        int maxTokens = 150;

        URL url = new URL(apiEndpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

// 设置HTTP请求头
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + apiKey);

// 设置HTTP请求体
        String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": " + maxTokens + "}";
        con.setDoOutput(true);
        con.getOutputStream().write(requestBody.getBytes());

// 发送HTTP请求并读取响应
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response += inputLine;
        }
        in.close();

// 处理响应
        System.out.println("Response code: " + responseCode);
        System.out.println("Response body: " + response);
    }
}
