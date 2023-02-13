package com.greenart.travel_plan.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("0", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*XML/JSON 여부*/
        urlBuilder.append("&" + URLEncoder.encode("trrsrtNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광지명*/
        urlBuilder.append("&" + URLEncoder.encode("trrsrtSe","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광지구분*/
        urlBuilder.append("&" + URLEncoder.encode("rdnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지도로명주소*/
        urlBuilder.append("&" + URLEncoder.encode("lnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지지번주소*/
        urlBuilder.append("&" + URLEncoder.encode("latitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*위도*/
        urlBuilder.append("&" + URLEncoder.encode("longitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*경도*/
        urlBuilder.append("&" + URLEncoder.encode("ar","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*면적*/
        urlBuilder.append("&" + URLEncoder.encode("cnvnncFclty","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*공공편익시설정보*/
        urlBuilder.append("&" + URLEncoder.encode("stayngInfo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*숙박시설정보*/
        urlBuilder.append("&" + URLEncoder.encode("mvmAmsmtFclty","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*운동및오락시설정보*/
        urlBuilder.append("&" + URLEncoder.encode("recrtClturFclty","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*휴양및문화시설정보*/
        urlBuilder.append("&" + URLEncoder.encode("hospitalityFclty","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*접객시설정보*/
        urlBuilder.append("&" + URLEncoder.encode("sportFclty","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지원시설정보*/
        urlBuilder.append("&" + URLEncoder.encode("appnDate","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지정일자*/
        urlBuilder.append("&" + URLEncoder.encode("aceptncCo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*수용인원수*/
        urlBuilder.append("&" + URLEncoder.encode("prkplceCo","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*주차가능수*/
        urlBuilder.append("&" + URLEncoder.encode("trrsrtIntrcn","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광지소개*/
        urlBuilder.append("&" + URLEncoder.encode("phoneNumber","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관리기관전화번호*/
        urlBuilder.append("&" + URLEncoder.encode("institutionNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관리기관명*/
        urlBuilder.append("&" + URLEncoder.encode("referenceDate","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*데이터기준일자*/
        urlBuilder.append("&" + URLEncoder.encode("instt_code","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관코드*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}