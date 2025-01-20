package com.github.hojoungjang.tekkencombomaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hojoungjang.tekkencombomaker.domain.Combo;
import com.github.hojoungjang.tekkencombomaker.dto.CreateComboRequest;
import com.github.hojoungjang.tekkencombomaker.repository.ComboRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ComboControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    ComboRepository comboRepo;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        comboRepo.deleteAll();
    }

    @DisplayName("createCombo: 콤보 데이터 추가에 성공한다.")
    @Test
    public void createCombo() throws Exception {
        // given
        final String url = "/api/v1/combo";
        final String name = "Phoenix Smasher";
        final String command = "236RP";
        final CreateComboRequest request = new CreateComboRequest(name, command);

        final String requestBody = objectMapper.writeValueAsString(request);

        // when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result.andExpect(status().isCreated());
        List<Combo> combos = comboRepo.findAll();

        assertThat(combos.size()).isEqualTo(1);
        assertThat(combos.get(0).getName()).isEqualTo(name);
        assertThat(combos.get(0).getCommand()).isEqualTo(command);
    }

    @DisplayName("getComboById: 콤보 데이터를 불러오는데 성공.")
    @Test
    public void getComboById() throws Exception {
        //given
        final String url = "/api/v1/combo/{id}";
        final String name = "Phoenix Smasher";
        final String command = "236RP";

        Combo combo = comboRepo.save(Combo.builder()
                .name(name)
                .command(command)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(get(url, combo.getId()));

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.command").value(command));
    }
}