package com.igate.igateapi.controller;


import com.igate.igateapi.model.network.CustomerRequestDTO;
import com.igate.igateapi.model.network.MessageResponseDTO;
import com.igate.igateapi.model.network.ResultMessage;
import com.igate.igateapi.model.network.Body;
import com.igate.igateapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerApiController {


    private final CustomerService customerService;


    @GetMapping("/{customerId}")
    public ResponseEntity read(@PathVariable Long customerId, @RequestBody Body request) {

        List<Body> bodyList = new ArrayList<>();

        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();

        Body messageBody = Body.builder()
                .dataBody(messageResponseDTO)
                .dataHeader(request.getDataHeader())
                .build();
        Body body = customerService.read(customerId, request).getBody();

        System.out.println(request.getDataHeader());

        body.setDataHeader(request.getDataHeader());

        bodyList.add(body);
        bodyList.add(messageBody);
//        bodyList.add(body);

        String temp = "    {\n" +
                "        \"DataHeader\": {\n" +
                "            \"DataType\": \"IO\",\n" +
                "            \"DataLength\": \"00000000\",\n" +
                "            \"ServiceID\": \"SV_HUB_0020\",\n" +
                "            \"ScreenID\": \"\",\n" +
                "            \"FormCount\": \"00\"\n" +
                "        },\n" +
                "        \"DataBody\": {\n" +
                "            \"customerId\": 1,\n" +
                "            \"firstName\": \"MARY\",\n" +
                "            \"lastName\": \"SMITH\",\n" +
                "            \"email\": \"MARY.SMITH@sakilacustomer.org\",\n" +
                "            \"active\": 1,\n" +
                "            \"createDate\": \"2006-02-14\",\n" +
                "            \"lastUpdate\": \"2006-02-15T04:57:20\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"DataHeader\": {\n" +
                "            \"DataType\": \"IO\",\n" +
                "            \"DataLength\": \"00000000\",\n" +
                "            \"ServiceID\": \"SV_HUB_0020\",\n" +
                "            \"ScreenID\": \"\",\n" +
                "            \"FormCount\": \"00\"\n" +
                "        },\n" +
                "        \"DataBody\": {\n" +
                "            \"MessageCode\": \"test\",\n" +
                "            \"MessageCount\": \"1\",\n" +
                "            \"MessageContent\": [\n" +
                "                \"test message\"\n" +
                "            ]\n" +
                "        }\n" +
                "    }";

        HashMap<String, Body> map = new HashMap<String, Body>();


        map.put("Message_0", messageBody);
        map.put("SV_HUB_0020_1", body);


//        return ResponseEntity.ok(bodyList);
//        return ResponseEntity.ok(temp);
//        return ResponseEntity.ok(map);
        return customerService.read(customerId, request);
    }

    @PostMapping("")
    public ResponseEntity<Body<ResultMessage>> create(@RequestBody Body<CustomerRequestDTO> request) {
        System.out.println("post");
        return customerService.create(request);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Body<ResultMessage>> update(@PathVariable Long customerId, @RequestBody Body<CustomerRequestDTO> request) {
        return customerService.update(customerId, request);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Body<ResultMessage>> delete(@PathVariable Long customerId, @RequestBody Body request) {
        return customerService.delete(customerId, request);
    }
}
