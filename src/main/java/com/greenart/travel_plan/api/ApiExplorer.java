// package com.greenart.travel_plan.api;

// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.net.URLEncoder;

// import com.google.gson.JsonArray;
// import com.google.gson.JsonElement;
// import com.google.gson.JsonObject;
// import com.google.gson.JsonParser;
// import com.greenart.travel_plan.entity.TravelPlaceEntity;
// import com.greenart.travel_plan.repository.TravelPlaceRepository;
// import com.greenart.travel_plan.vo.TravelPlaceVO;

// import java.io.BufferedReader;
// import java.io.IOException;

// public class ApiExplorer {
//     public static void main(String[] args) throws IOException {
//         StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api"); /*URL*/
//         urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode("s6zQW6MqTihXOeY3Tcw4nD4%2FovPoQj4KVPauz4I5jqBn0M6XqUXUHSCFdD7kj22litzI3JDyVgIgDqBBLOQ4zg%3D%3D", "UTF-8"));
//             urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
//             urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8"));
//             urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
//             urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=" + URLEncoder.encode("travelplan", "UTF-8"));
//             urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
//             urlBuilder.append("&" + URLEncoder.encode("listYN", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
//         URL url = new URL(urlBuilder.toString());
//         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//         conn.setRequestMethod("GET");
//         conn.setRequestProperty("Content-type", "application/json");
//         System.out.println("Response code: " + conn.getResponseCode());
//         BufferedReader rd;
//         if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//             rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//         } else {
//             rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//         }
//         StringBuilder sb = new StringBuilder();
//         String line;
//         while ((line = rd.readLine()) != null) {
//             sb.append(line);
//         }
//         rd.close();
//         conn.disconnect();
//         System.out.println(sb.toString());
//         JsonParser parser = new JsonParser();
//             JsonObject obj = parser.parse(sb.toString()).getAsJsonObject();

//             JsonArray arr = obj.get("response").getAsJsonObject()
//                     .get("body").getAsJsonObject()
//                     .get("items").getAsJsonObject()
//                     .get("item").getAsJsonArray();

//             for (JsonElement jsonElement : arr) {
//                 JsonObject temp = jsonElement.getAsJsonObject();
//                 TravelPlaceEntity travelPlaceEntity = TravelPlaceRepository.findById(Long.parseLong(String.valueOf(i))).orElseThrow(NullPointerException::new);

//                 TravelPlaceRepository.save(
//                     TravelPlaceVO.builder()
//                         .tpName(temp.get("title").getAsString())
//                         .tpAdress(temp.get("addr1") == null? "-":temp.get("addr1").getAsString().split(" ")[0])
//                         .tpLatitude(temp.get("mapx").getAsDouble())
//                         .tpLongitude(temp.get("mapy").getAsDouble())
//                         .tpImage(temp.get("firstimage").getAsString())
//                         .tpCate(temp.get("cat3").getAsString())
//                         .build());
//             }
//     }
// }