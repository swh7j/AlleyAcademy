import axios from 'axios';


const MEMBER_API_BASE_URL = "http://localhost:8081/api/LOGIN";

class MemberService {
     getlogin() {
            return axios.get(MEMBER_API_BASE_URL);
        }
}
export default new MemberService();