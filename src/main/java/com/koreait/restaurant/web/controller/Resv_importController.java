package com.koreait.restaurant.web.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@Controller
public class Resv_importController {

    private IamportClient api;

    public Resv_importController() {

        // REST API 키와 REST API secret
        this.api = new IamportClient("8663540250674387",
                "m2I82XnYYSG1MKf1VxQ7hOL3r4bFf3U1eWsVyJxFwvN5nRhGu5GUUzhbNXo29X27lmkqvUEsUkWpWRQZ");
    }

    @ResponseBody
    @RequestMapping(value="/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(
            Model model
            , Locale locale
            , HttpSession session
            , @PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException
    {
        return api.paymentByImpUid(imp_uid);
    }

}