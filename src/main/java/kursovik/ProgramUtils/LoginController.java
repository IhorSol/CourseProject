package kursovik.ProgramUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ihor Solohub.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping
    public String loginPage(){
        return "login";     // сторінка авторизації
    }
}
