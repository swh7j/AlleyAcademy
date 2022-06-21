package app.Controller;

import app.Entity.AcademyEntity;
import app.Entity.BoardEntity;
import app.Service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class AcademyController {

    @Autowired
    private AcademyService academyService;

    @GetMapping("/list")
    public ResponseEntity<Map> getAllacademy(@RequestParam(value = "p_num", required=false) Integer p_num) {
        if (p_num == null || p_num <= 0) {
            p_num = 1;
        }
        return  academyService.getac(p_num);
    }
    @GetMapping("/list/{no}")
    public ResponseEntity<AcademyEntity> getAcademyByNo(
            @PathVariable Double no) {
        return academyService.getAcademyByNo(no);
    }

    @GetMapping("/list2")
    public List<AcademyEntity> board_list() {

        List<AcademyEntity> all_list = academyService.getall();
        return all_list;
    }
}