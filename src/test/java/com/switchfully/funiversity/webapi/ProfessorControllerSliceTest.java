package com.switchfully.funiversity.webapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchfully.funiversity.domain.professor.Professor;
import com.switchfully.funiversity.service.professor.ProfessorService;
import com.switchfully.funiversity.service.security.SecurityService;
import com.switchfully.funiversity.webapi.dto.professor.AddProfessorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfessorController.class)
class ProfessorControllerSliceTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProfessorService professorService;
    @MockBean
    private SecurityService securityService;

    @Test
    void givenAValidInput_thenTheControllerListensToThePostHttpRequest_andReturnsStatusIsCreated_201() throws Exception {
        Professor prof_janssen = new Professor("Eric", "Janssen", "Janssen@funiversity.com", "fun123");
        mockMvc.perform(post("/professors")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(prof_janssen))) //if you provide null instead of prof-janssen, test fails
                .andExpect(status().isCreated());
    }

    @Test
    void ifNullProfessorObjectIsGiven_thenTestReturnsBadRequest_400() throws Exception {
        mockMvc.perform(post("/professors")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenAValidInput_thenTheControllerListensToTheGetHttpRequest_andReturnsStatusIsOkForSuccessfulDeserialization_200() throws Exception {
        mockMvc.perform(get("/professors").contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void whenValidInput_thenMapsToBusinessModel() throws Exception {
        AddProfessorDTO profDTO = new AddProfessorDTO("Eric", "Janssen", "Janssen@funiversity.com", "fun123");
        mockMvc.perform(post("/professors")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(profDTO)));
        ArgumentCaptor<AddProfessorDTO> professorCaptor=ArgumentCaptor.forClass(AddProfessorDTO.class);
        verify(professorService, times(1)).save(professorCaptor.capture());
        Assertions.assertEquals("Eric",professorCaptor.getValue().getFirstName());
        Assertions.assertEquals("Janssen",professorCaptor.getValue().getLastName());
        Assertions.assertEquals("Janssen@funiversity.com",professorCaptor.getValue().getEmail());
        Assertions.assertEquals("fun123",professorCaptor.getValue().getPassword());
    }
}