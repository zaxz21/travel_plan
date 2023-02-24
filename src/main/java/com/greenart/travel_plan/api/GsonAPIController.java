package com.greenart.travel_plan.api;

import com.greenart.travel_plan.vo.TravelPlaceVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.repository.TravelPlaceRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Tag(name = "관광지데이터 파싱 컨트롤러", description = "한국관광정보API에서 관광지 데이터를 파싱해옵니다.")
@RestController
@RequestMapping("/api/gson")
@RequiredArgsConstructor
public class GsonAPIController {
    private final TravelPlaceRepository travelPlaceRepository;
    @Operation(summary = "로드/저장")
    @Transactional
    @GetMapping("/save")
    public void loadData() throws Exception{
        String urlBuilder = "https://apis.data.go.kr/B551011/KorService/areaBasedList" + "?" + URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("s6zQW6MqTihXOeY3Tcw4nD4/ovPoQj4KVPauz4I5jqBn0M6XqUXUHSCFdD7kj22litzI3JDyVgIgDqBBLOQ4zg==", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("100", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("0", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("MobileOS", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("ETC", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("MobileApp", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("travelplan", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("_type", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("json", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("listYN", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("Y", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("areaCode", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("35", StandardCharsets.UTF_8) +
                "&" + URLEncoder.encode("sigunguCode", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("2", StandardCharsets.UTF_8);
        URL url = new URL(urlBuilder);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), StandardCharsets.UTF_8));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        // System.out.println(sb.toString());

        JSONParser parser = new JSONParser();
        JSONObject rootObj = (JSONObject)parser.parse(sb.toString());
        JSONObject responseObj = (JSONObject)rootObj.get("response");
        JSONObject bodyObj = (JSONObject)responseObj.get("body");
        JSONObject itemsObj = (JSONObject)bodyObj.get("items");
        JSONArray itemsArr = (JSONArray)itemsObj.get("item");


        for (Object o : itemsArr) {
            System.out.println("===================================================================");
            // System.out.println(itemsArr.get(i));
            String title = (String) ((JSONObject) o).get("title");
            String addr1 = (String) ((JSONObject) o).get("addr1");
            String mapx = (String) ((JSONObject) o).get("mapx");
            String mapy = (String) ((JSONObject) o).get("mapy");
            String firstimage = (String) ((JSONObject) o).get("firstimage");
            String cat3 = (String) ((JSONObject) o).get("cat3");
            // System.out.println("이름 : " + title);
            // System.out.println("주소 : " + addr1);
            // System.out.println("위도 : " + mapy);
            // System.out.println("경도 : " + mapx);
            // System.out.println("이미지url : " + firstimage);
            // System.out.println("카테고리코드 : " + cat3);
            TravelPlaceEntity data = TravelPlaceEntity.builder()
            .tpName(title)
            .tpAdress(addr1)
            .tpLongitude(mapx)
            .tpLatitude(mapy)
            .tpImage(firstimage)
            .tpCate(cat3)
            .build();
            // System.out.println(data);
            travelPlaceRepository.save(data);
        }

        // JsonParser gsonParser = new JsonParser();
        // JsonObject obj = gsonParser.parse(sb.toString()).getAsJsonObject();

        // JsonArray arr = obj.get("response").getAsJsonObject()
        //             .get("body").getAsJsonObject()
        //             .get("items").getAsJsonObject()
        //             .get("item").getAsJsonArray();

        // for (Object o : itemsArr) {
        //     // TravelPlaceEntity travelPlaceEntity = TravelPlaceRepository.findById(Long.parseLong(String.valueOf(i))).orElseThrow(NullPointerException::new);

        //     TravelPlaceRepository.save(TravelPlaceVO.builder()
        //                         .tpName((String) ((JSONObject) o).get("title"))
        //                         .tpAdress((String) ((JSONObject) o).get("addr1"))
        //                         .tpLongitude((String) ((JSONObject) o).get("mapx"))
        //                         .tpLatitude((String) ((JSONObject) o).get("mapy"))
        //                         .tpImage((String) ((JSONObject) o).get("firstimage"))
        //                         .tpCate((String) ((JSONObject) o).get("cat3"))
        //                         .build()
        //     );
        // }


//            for (JsonElement jsonElement : itemsArr) {
//                JsonObject temp = jsonElement.getAsJsonObject();
//                // TravelPlaceEntity travelPlaceEntity = TravelPlaceRepository.findById(Long.parseLong(String.valueOf(i))).orElseThrow(NullPointerException::new);
//
//                TravelPlaceRepository.save(
//                    TravelPlaceVO.builder()
//                        .tpName(temp.get("title").getAsString())
//                        .tpAdress(temp.get("addr1") == null? "-":temp.get("addr1").getAsString().split(" ")[0])
//                        .tpLatitude(temp.get("mapx").getAsDouble())
//                        .tpLongitude(temp.get("mapy").getAsDouble())
//                        .tpImage(temp.get("firstimage").getAsString())
//                        .tpCate(temp.get("cat3").getAsString())
//                        .build());
//            }
        // conn.setRequestMethod("POST");

    }
}
