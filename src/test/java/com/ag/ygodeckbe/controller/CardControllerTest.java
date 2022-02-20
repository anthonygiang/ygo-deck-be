package com.ag.ygodeckbe.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    /**
     * Test all cards are retrieved.
     */
    @Test
    public void testGetCards() throws Exception {

        String name1 = "Dark Magician";
        String type1 = "Normal Monster";
        String desc1 = "''The ultimate wizard in terms of attack and defense.''";
        int atk1 = 2500;
        int def1 = 2100;
        int level1 = 7;
        String race1 = "Spellcaster";
        String attribute1 = "DARK";

        String name2 = "Summoned Skull";
        String type2 = "Normal Monster";
        String desc2 = "A fiend with dark powers for confusing the enemy. Among the Fiend-Type monsters, this monster boasts considerable force.\n\n(This card is always treated as an \"Archfiend\" card.)";
        int atk2 = 2500;
        int def2 = 1200;
        int level2 = 6;
        String race2 = "Fiend";
        String attribute2 = "DARK";

        Card card1 = new Card(name1, type1, desc1, atk1, def1, level1, race1, attribute1);
        Card card2 = new Card(name2, type2, desc2, atk2, def2, level2, race2, attribute2);

        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        when(cardService.findAll()).thenReturn(cards);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cards")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))).andDo(print())
                .andExpect(jsonPath("[0].id").value(card1.getId()))
                .andExpect(jsonPath("[0].name").value(name1))
                .andExpect(jsonPath("[0].type").value(type1))
                .andExpect(jsonPath("[0].desc").value(desc1))
                .andExpect(jsonPath("[0].atk").value(atk1))
                .andExpect(jsonPath("[0].def").value(def1))
                .andExpect(jsonPath("[0].level").value(level1))
                .andExpect(jsonPath("[0].race").value(race1))
                .andExpect(jsonPath("[0].attribute").value(attribute1))
                .andExpect(jsonPath("[1].id").value(card2.getId()))
                .andExpect(jsonPath("[1].name").value(name2))
                .andExpect(jsonPath("[1].type").value(type2))
                .andExpect(jsonPath("[1].desc").value(desc2))
                .andExpect(jsonPath("[1].atk").value(atk2))
                .andExpect(jsonPath("[1].def").value(def2))
                .andExpect(jsonPath("[1].level").value(level2))
                .andExpect(jsonPath("[1].race").value(race2))
                .andExpect(jsonPath("[1].attribute").value(attribute2));
    }

}
