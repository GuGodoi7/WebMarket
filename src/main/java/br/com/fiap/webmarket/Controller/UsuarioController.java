package br.com.fiap.webmarket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class UsuarioController {

    @RequestMapping(
        method = RequestMethod.GET,
        path =  "/usuario", 
        produces = "application/json"
    )
    
    @ResponseBody
    public String index() {
        return """  
            {
                "id": 1,
                "email": "abc1234@gmail.com",
                "nome": "Gustavo",
            }
            """;
 
                
    }
    
}
