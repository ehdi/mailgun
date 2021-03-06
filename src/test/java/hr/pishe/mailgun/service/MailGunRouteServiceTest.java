package hr.pishe.mailgun.service;

import hr.pishe.mailgun.service.dto.request.MailGunCreateRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetAllRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetRouteByIdRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunCreateRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetAllRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetRouteByIdResponseDTO;
import hr.pishe.mailgun.service.error.MailGunException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailGunRouteServiceTest {

    @Autowired
    public MailGunRouteService service;

    @Test
    public void createRoute(){
        MailGunCreateRouteRequestDTO requestDTO = new MailGunCreateRouteRequestDTO();
        requestDTO.setMatchRecipient("postmaster@mg.avand.io");
        requestDTO.setDescription("Hi Test");
        requestDTO.setForwardTo("http://testbed.avand.io:8080/api/message");
        try {
            MailGunCreateRouteResponseDTO responseDTO = service.createRoute(requestDTO);
            System.out.println(responseDTO);
        } catch (MailGunException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRouteById(){
        MailGunGetRouteByIdRequestDTO requestDTO = new MailGunGetRouteByIdRequestDTO();
        requestDTO.setRouteId("5b6f17296295740001de5159");
        try {
            MailGunGetRouteByIdResponseDTO responseDTO = service.getRouteById(requestDTO);
            System.out.println(responseDTO);
        } catch (MailGunException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllRoute(){
        MailGunGetAllRouteRequestDTO requestDTO = new MailGunGetAllRouteRequestDTO();
        requestDTO.setSkip("1");
        requestDTO.setLimit("2");
        try {
            MailGunGetAllRouteResponseDTO responseDTO = service.getAllRoute(requestDTO);
            System.out.println(responseDTO);
        } catch (MailGunException e) {
            e.printStackTrace();
        }
    }

}
