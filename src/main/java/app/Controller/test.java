package app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {

    @GetMapping("/boardlist")
    public String boardlist(){
        return "/boardlist.jsx";
    }
}

