package cn.xiaowenjie.spider;

import lombok.SneakyThrows;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.X509Certificate;

/**
 * @Description TODO
 * @Date 2021/1/12 0012
 * @Author 晓风轻 https://github.com/xwjie
 */
public class JsoupUtil {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36";

    public static Document get(String url) throws IOException {
        Document doc = Jsoup.connect(url)
            .userAgent(USER_AGENT)
            .timeout(30000)
            .sslSocketFactory(sslScocketFactory)
            .get();
        return doc;
    }

    private final static SSLSocketFactory sslScocketFactory = defaultSSLScocketFactory();

    @SneakyThrows
    private static SSLSocketFactory defaultSSLScocketFactory() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        SSLSocketFactory socketFactory = sc.getSocketFactory();
        HttpsURLConnection.setDefaultSSLSocketFactory(
            socketFactory);

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        return socketFactory;

    }

}
