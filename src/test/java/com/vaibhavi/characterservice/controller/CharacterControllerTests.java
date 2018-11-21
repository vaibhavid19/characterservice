package com.vaibhavi.characterservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhavi.characterservice.Entity.CharacterForBattle;
import com.vaibhavi.characterservice.service.CharacterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    CharacterService characterServiceMock;

    @Test
    public void test_generateCharacter() throws Exception {

        when(characterServiceMock.generateCharacter("Albus", "Wizard"))
                .thenReturn(new CharacterForBattle(1,"Albus","Wizard",1,1,1,1,1,1,1,1));

        mockMvc.perform(MockMvcRequestBuilders.post("/character/gen/Albus/Wizard"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.*", hasSize(11)));

        verify(characterServiceMock, times(1)).generateCharacter("Albus", "Wizard");
        verifyNoMoreInteractions(characterServiceMock);
    }
}
