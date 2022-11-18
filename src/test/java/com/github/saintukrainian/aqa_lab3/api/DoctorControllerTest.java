package com.github.saintukrainian.aqa_lab3.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.saintukrainian.aqa_lab3.entity.Doctor;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class DoctorControllerTest {

  private static final String DOCTORS_PATH = "/doctors/";

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  void shouldFindAllDoctors() throws Exception {
    // when
    MvcResult mvcResult = performRequest(DOCTORS_PATH);

    List<Doctor> doctors = mapper.readValue(mvcResult.getResponse().getContentAsString(),
        List.class);

    // then
    assertThat(doctors)
        .isNotEmpty()
        .hasSize(2);
  }

  private MvcResult performRequest(String path) throws Exception {
    return mockMvc.perform(get(path))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(200)).andReturn();
  }
}
