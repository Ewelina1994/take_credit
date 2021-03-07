package pl.klobut.take_credit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import pl.klobut.take_credit.domain.entities.CreditEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import pl.klobut.take_credit.domain.models.Credit;
import pl.klobut.take_credit.services.CreditService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= Application.class)
@WebMvcTest(CreditService.class)
public class CreditControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CreditService creditService;

    @Test
    public void testCreateNewCredit() throws Exception {
        Credit credit = new Credit();
        credit.setCreditName("5/2021");

        String json = objectMapper.writeValueAsString(credit);
        String url="/credit";
        MvcResult mvcResult = mockMvc.perform(
                post(url)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        JSONObject obj=(JSONObject) JSONValue.parse(response);
        Integer idCredit= (Integer) obj.get("id");

        Optional<CreditEntity> credits = creditService.findById(Long.valueOf(idCredit));

        assertThat(credits.get().getCreditName()).isEqualTo(credit.getCreditName());
    }

    @Test
    public void testListCredits() throws Exception {
        List<Credit> creditList = new ArrayList<>();
        creditList.add(Credit.builder()
                .creditName("kkk/2/2021")
                .build());
        creditList.add(Credit.builder()
                .creditName("kkk/3/2021")

                .build());
        Mockito.when(creditService.getAllCredits()).thenReturn(creditList);

        String url = "http://localhost:8080/credit";

        MvcResult mvcResult = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println("Actually: " + actualJsonResponse);

        String expectedJsonResponse = objectMapper.writeValueAsString(creditList);
        System.out.println("Expected: " + expectedJsonResponse);

        assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedJsonResponse);
    }
}
