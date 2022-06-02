package app.Controller;

import app.Entity.AcademyEntity;
import app.Entity.BoardEntity;
import app.Service.AcademyService;
import app.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AcademyController {

    @Autowired
    private AcademyService academyService;


    // get all board
//    @GetMapping("/list")
//    public List<AcademyEntity> academy_list() {
//        List<AcademyEntity> list = academyService.get();
//        return list;
//    }
    @GetMapping("/list")
    public ResponseEntity<Map> getAllacademy(@RequestParam(value = "p_num", required=false) Integer p_num) {
        if (p_num == null || p_num <= 0) {
            p_num = 1;
        }
        System.out.println(academyService.getac(p_num));
        return  academyService.getac(p_num);
    }
    @GetMapping("/list/{no}")
    public ResponseEntity<AcademyEntity> getAcademyByNo(
            @PathVariable Double no) {
        return academyService.getAcademyByNo(no);
    }

}