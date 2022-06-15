import axios from 'axios';


const ACADEMY_API_BASE_URL = "http://localhost:80/api/list";

class AcademyService {

    getAcademy_list(p_num) {
        return axios.get(ACADEMY_API_BASE_URL + "?p_num="+ p_num);
    }
    getAcademy_alllist() {
        return axios.get(ACADEMY_API_BASE_URL+"2");
    }
    getOneAcademy(no) {
        return axios.get(ACADEMY_API_BASE_URL + "/" + no);
    }
}
export default new AcademyService();