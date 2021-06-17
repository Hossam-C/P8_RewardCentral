package com.P8.rewardCentral;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class P8RewarcCentralControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void RewardCentralHome() throws Exception {
        Locale.setDefault(Locale.US);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }

    @Test
    public void RewardCentralControllerResponseOK () throws Exception {

        Locale.setDefault(Locale.US);

        UUID userId = UUID.randomUUID();
        UUID attractionId = UUID.randomUUID();

        mockMvc.perform(get("/attractionrewardpoints?userId="+userId+"&attractionId="+attractionId))
                .andExpect(status().isOk());
    }

    @Test
    public void RewardCentralControllerUserIdEmpty () throws Exception {

        Locale.setDefault(Locale.US);

        UUID attractionId = UUID.randomUUID();

        mockMvc.perform(get("/attractionrewardpoints?userId=&attractionId="+attractionId))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void RewardCentralControllerAttractionIdEmpty () throws Exception {

        Locale.setDefault(Locale.US);

        UUID userId = UUID.randomUUID();

        mockMvc.perform(get("/attractionrewardpoints?userId="+userId+"&attractionId="))
                .andExpect(status().isBadRequest());
    }

}
