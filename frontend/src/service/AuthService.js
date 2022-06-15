import axios from 'axios';


const API_URL = "http://localhost:8081/api/auth/";

class AuthService {
    register(memberId, memberEmail, memberPw){
        return axios.post(API_URL + "signup",
        memberId,
        memberEmail,
        memberPw
        )};
    }

    login(memberId, memberPw){
        return axios.post(API_URL + "signin",{
            memberId,
            memberPw
        })
        .then(response => {
            if(response.data.accessToken){
                localStorage.setItem("member", JSON.stringify(tesponse.data));
            }
            return response.data;

        });

    logout(){
        localStorage.removeItem('member');
    }

    getCurrentUser(){
        return JSON.parse(localStorage.getItem('member'));
    }

    }





}
export default new AuthService();