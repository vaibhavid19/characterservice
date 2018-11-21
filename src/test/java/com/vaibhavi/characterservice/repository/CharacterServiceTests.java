package com.vaibhavi.characterservice.repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhavi.characterservice.Entity.CharacterForBattle;
import com.vaibhavi.characterservice.Repository.CharacterRepository;
import com.vaibhavi.characterservice.service.CharacterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CharacterServiceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Mock
    CharacterRepository characterRepositoryMock;

    @InjectMocks
    CharacterService characterService;

    @Test
    public void test_generateCharacter() throws Exception {
        CharacterForBattle testCharacter = new CharacterForBattle(1,"Snape","Wizard",1,1,1,1,1,1,1,1);
        when(characterRepositoryMock.save(testCharacter))
                .thenReturn(testCharacter);
        characterService.generateCharacter("Snape", "Wizard");
        verify(characterRepositoryMock, times(1)).save(isA(CharacterForBattle.class));
        verifyNoMoreInteractions(characterRepositoryMock);
    }
}

