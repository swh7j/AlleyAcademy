package app.Service;


import app.Entity.AcademyEntity;
import app.Exception.ResourceNotFoundException;
import app.Repository.AcademyRepository;
import app.util.PagingUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Transactional
@Service
public class AcademyService {

    @Autowired
    private AcademyRepository AR;

//    @Transactional
//    public List<AcademyEntity> get() {
//
//        System.out.println("학원목록 모두 불러오기");
//        List<AcademyEntity> AL = AR.findAll();
//
//        return AL;
//    }
    @Transactional
    public int findAllCount() {
        return (int) AR.count();
    }

    // get paging boards data
    @Transactional
    public ResponseEntity<Map> getac(Integer p_num) {
        Map result = null;

        PagingUtil pu = new PagingUtil(p_num, 20, 5); // ($1:표시할 현재 페이지, $2:한페이지에 표시할 글 수, $3:한 페이지에 표시할 페이지 버튼의 수 )
        List<AcademyEntity> list = AR.findFromTo(pu.getObjectStartNum(), pu.getObjectCountPerPage());
        pu.setObjectCountTotal(findAllCount());
        pu.setCalcForPaging();
        System.out.println("p_num : "+p_num);
        System.out.println(pu.toString());

        if (list == null || list.size() == 0) {
            return null;
        }

        result = new HashMap<>();
        result.put("pagingData", pu);
        result.put("list", list);

        return ResponseEntity.ok(result);
    }

    public ResponseEntity<AcademyEntity> getAcademyByNo(Long no) {
        AcademyEntity academy = AR.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));
        return ResponseEntity.ok(academy);
    }

}