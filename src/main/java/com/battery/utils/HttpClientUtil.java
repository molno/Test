package com.battery.utils;

import com.battery.enums.PostTypeEnum;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by null on 2017/2/23.
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);    //日志记录
    public static final String SunX509 = "SunX509";
    public static final String JKS = "JKS";
    public static final String PKCS12 = "PKCS12";
    public static final String TLS = "TLS";

    /**
     *
     * @param strUrl
     * @return
     * @throws IOException
     */
//    public static HttpURLConnection getHttpURLConnection(String strUrl)
//            throws IOException {
//        URL url = new URL(strUrl);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url
//                .openConnection();
//        return httpURLConnection;
//    }
//
//    /**
//     *
//     * @param strUrl
//     * @return
//     * @throws IOException
//     */
//    public static HttpsURLConnection getHttpsURLConnection(String strUrl)
//            throws IOException {
//        URL url = new URL(strUrl);
//        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url
//                .openConnection();
//        return httpsURLConnection;
//    }
//
//    /**
//     *
//     * @param strUrl
//     * @return
//     */
//    public static String getURL(String strUrl) {
//
//        if(null != strUrl) {
//            int indexOf = strUrl.indexOf("?");
//            if(-1 != indexOf) {
//                return strUrl.substring(0, indexOf);
//            }
//
//            return strUrl;
//        }
//
//        return strUrl;
//
//    }
//
//    /**
//     *
//     * @param strUrl
//     * @return
//     */
//    public static String getQueryString(String strUrl) {
//
//        if(null != strUrl) {
//            int indexOf = strUrl.indexOf("?");
//            if(-1 != indexOf) {
//                return strUrl.substring(indexOf+1, strUrl.length());
//            }
//
//            return "";
//        }
//
//        return strUrl;
//    }
//
//    /**
//     *
//     * @param queryString
//     * @return
//     */
//    public static Map queryString2Map(String queryString) {
//        if(null == queryString || "".equals(queryString)) {
//            return null;
//        }
//
//        Map m = new HashMap();
//        String[] strArray = queryString.split("&");
//        for(int index = 0; index < strArray.length; index++) {
//            String pair = strArray[index];
//            HttpClientUtil.putMapByPair(pair, m);
//        }
//
//        return m;
//
//    }
//
//    /**
//     *
//     * @param pair
//     * @param m
//     */
//    public static void putMapByPair(String pair, Map m) {
//
//        if(null == pair || "".equals(pair)) {
//            return;
//        }
//
//        int indexOf = pair.indexOf("=");
//        if(-1 != indexOf) {
//            String k = pair.substring(0, indexOf);
//            String v = pair.substring(indexOf+1, pair.length());
//            if(null != k && !"".equals(k)) {
//                m.put(k, v);
//            }
//        } else {
//            m.put(pair, "");
//        }
//    }
//
//    /**
//     *
//     * @param reader
//     * @return
//     * @throws IOException
//     */
//    public static String bufferedReader2String(BufferedReader reader) throws IOException {
//        StringBuffer buf = new StringBuffer();
//        String line = null;
//        while( (line = reader.readLine()) != null) {
//            buf.append(line);
//            buf.append("\r\n");
//        }
//
//        return buf.toString();
//    }
//
//    /**
//     *
//     * @param out
//     * @param data
//     * @param len
//     * @throws IOException
//     */
//    public static void doOutput(OutputStream out, byte[] data, int len)
//            throws IOException {
//        int dataLen = data.length;
//        int off = 0;
//        while (off < data.length) {
//            if (len >= dataLen) {
//                out.write(data, off, dataLen);
//                off += dataLen;
//            } else {
//                out.write(data, off, len);
//                off += len;
//                dataLen -= len;
//            }
//
//            // ˢ�»�����
//            out.flush();
//        }
//
//    }
//
//    /**
//     *
//     * @param trustFileInputStream
//     * @param trustPasswd
//     * @param keyFileInputStream
//     * @param keyPasswd
//     * @return
//     * @throws NoSuchAlgorithmException
//     * @throws KeyStoreException
//     * @throws CertificateException
//     * @throws IOException
//     * @throws UnrecoverableKeyException
//     * @throws KeyManagementException
//     */
//    public static SSLContext getSSLContext(
//            FileInputStream trustFileInputStream, String trustPasswd,
//            FileInputStream keyFileInputStream, String keyPasswd)
//            throws NoSuchAlgorithmException, KeyStoreException,
//            CertificateException, IOException, UnrecoverableKeyException,
//            KeyManagementException {
//
//        // ca
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance(HttpClientUtil.SunX509);
//        KeyStore trustKeyStore = KeyStore.getInstance(HttpClientUtil.JKS);
//        trustKeyStore.load(trustFileInputStream, HttpClientUtil
//                .str2CharArray(trustPasswd));
//        tmf.init(trustKeyStore);
//
//        final char[] kp = HttpClientUtil.str2CharArray(keyPasswd);
//        KeyManagerFactory kmf = KeyManagerFactory.getInstance(HttpClientUtil.SunX509);
//        KeyStore ks = KeyStore.getInstance(HttpClientUtil.PKCS12);
//        ks.load(keyFileInputStream, kp);
//        kmf.init(ks, kp);
//
//        SecureRandom rand = new SecureRandom();
//        SSLContext ctx = SSLContext.getInstance(HttpClientUtil.TLS);
//        ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), rand);
//
//        return ctx;
//    }
//
//    /**
//     *
//     * @param cafile
//     * @return
//     * @throws CertificateException
//     * @throws IOException
//     */
//    public static Certificate getCertificate(File cafile)
//            throws CertificateException, IOException {
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//        FileInputStream in = new FileInputStream(cafile);
//        Certificate cert = cf.generateCertificate(in);
//        in.close();
//        return cert;
//    }
//
//    /**
//     *
//     * @param str
//     * @return
//     */
//    public static char[] str2CharArray(String str) {
//        if(null == str) return null;
//
//        return str.toCharArray();
//    }
//
//    /**
//     *
//     * @param cert
//     * @param alias
//     * @param password
//     * @param out
//     * @throws KeyStoreException
//     * @throws NoSuchAlgorithmException
//     * @throws CertificateException
//     * @throws IOException
//     */
//    public static void storeCACert(Certificate cert, String alias,
//                                   String password, OutputStream out) throws KeyStoreException,
//            NoSuchAlgorithmException, CertificateException, IOException {
//        KeyStore ks = KeyStore.getInstance("JKS");
//
//        ks.load(null, null);
//
//        ks.setCertificateEntry(alias, cert);
//
//        // store keystore
//        ks.store(out, HttpClientUtil.str2CharArray(password));
//
//    }
//
//    public static InputStream String2Inputstream(String str) {
//        return new ByteArrayInputStream(str.getBytes());
//    }
//
//    /**
//     *
//     * @param in
//     * @return
//     * @throws IOException
//     */
//    public static byte[] InputStreamTOByte(InputStream in) throws IOException{
//
//        int BUFFER_SIZE = 4096;
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        byte[] data = new byte[BUFFER_SIZE];
//        int count = -1;
//
//        while((count = in.read(data,0,BUFFER_SIZE)) != -1)
//            outStream.write(data, 0, count);
//
//        data = null;
//        byte[] outByte = outStream.toByteArray();
//        outStream.close();
//
//        return outByte;
//    }
//
//    /**
//     *
//     * @param in
//     * @param encoding
//     * @return
//     * @throws IOException
//     */
//    public static String InputStreamTOString(InputStream in,String encoding) throws IOException{
//
//        return new String(InputStreamTOByte(in),encoding);
//
//    }
//
//
//
//    public static String executeBySslPost(String url, String body,String certificatePath,String password) throws Exception {
//        String result = "";
//        //商户id
//        //指定读取证书格式为PKCS12
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        //读取本机存放的PKCS12证书文件
//        FileInputStream instream = new FileInputStream(new File(certificatePath));
//        try {
//            //指定PKCS12的密码(商户ID)
//            keyStore.load(instream, password.toCharArray());
//        } finally {
//            instream.close();
//        }
//        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
//        //指定TLS版本
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//        //设置httpclient的SSLSocketFactory
//        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//        try {
//            HttpPost httppost = new HttpPost(url);
//            StringEntity reqEntity = new StringEntity(body, "UTF-8");
//            httppost.setEntity(reqEntity);
//
//            //System.out.println("Executing request: " + httppost.getRequestLine());
//            CloseableHttpResponse response = null;
//            try {
//                response = httpclient.execute(httppost);
//                result = EntityUtils.toString(response.getEntity(),"UTF-8");
//            } catch (Exception e) {
//                e.printStackTrace();
//
//                throw new RuntimeException(e);
//            } finally {
//                try {
//                    response.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }





















    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param jsonParam     参数
     * @return
     */
    public static String post(String url, String jsonParam, PostTypeEnum type) throws IOException {
        //post请求返回结果
        HttpClient httpClient =  HttpClients.createDefault();
        String jsonResult = null;
        HttpPost method = new HttpPost(url);
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                if (type == PostTypeEnum.JSON){
                    entity.setContentType("application/json");
                }
                if (type == PostTypeEnum.XML){
                    entity.setContentType("application/xml");
                }

                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";

                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    System.out.print(str);
                    return new String(str.getBytes("ISO-8859-1"),"UTF-8");
                    /**把json字符串转换成json对象**/
               //     jsonResult = JSONObject.toJSONString(str);
        }
        return jsonResult;
    }





    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static String get(String url) throws IOException {
        String responseString = null;

            HttpClient httpClient =  HttpClients.createDefault();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                return EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
            } else {
                logger.error("get请求提交失败:" + url);
            }
        return responseString;
    }

    /**
     * 发送xml数据
     * @param url
     * @param xmlData
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResponse sendXMLDataByPost(String url, String xmlData)
            throws ClientProtocolException, IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        StringEntity entity = new StringEntity(xmlData);
        httppost.setEntity(entity);
        httppost.setHeader("Content-Type", "text/xml;charset=UTF-8");
        HttpResponse response = httpClient.execute(httppost);
        return response;
    }



//    @Test
//    public void getTest() throws IOException {
//        System.out.println(get("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=9_0LWvdQyDRxpTfRIGoRXpOKyeE1nCl4fJZveQluXb6TubamkCrR2_IPDfpjh1WJk7I5pII6KPsbFmhAoMP1g1MaNQ-rNFmMRM3EDmC8-iOxgzjmOoOO8C4PpxaUEeA-RA9lvFb-bEUrj7aKUMBOAgAFAFSE&type=jsapi"));
//    }

}
