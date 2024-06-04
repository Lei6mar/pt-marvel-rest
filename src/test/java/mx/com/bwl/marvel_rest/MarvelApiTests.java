package mx.com.bwl.marvel_rest;

import mx.com.bwl.marvel_rest.config.CustomWebSecurityConfig;
import mx.com.bwl.marvel_rest.controller.MarvelRestController;
import mx.com.bwl.marvel_rest.service.BitacoraService;
import mx.com.bwl.marvel_rest.service.MarvelService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.internal.matchers.text.ValuePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = MarvelRestController.class)
class MarvelApiTests {

    @MockBean
    MarvelService marvelService;

    @MockBean
    BitacoraService bitacoraService;

    @MockBean
    CustomWebSecurityConfig customWebSecurityConfig;

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private MarvelRestController marvelController = new MarvelRestController(marvelService, bitacoraService);



    @Test
    void testGetCharacters() throws Exception {
       mvc.perform(MockMvcRequestBuilders.get("/marvel/api/getCharacters")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("usser", "usserPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetCharacterById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/marvel/api/getCharacters/1011136")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("usser", "usserPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(ValuePrinter::print)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
