import React, { Component } from 'react';

class Login extends Component {

    componentDidMount() {
      /*   // Naver sdk import
        const naverScript = document.createElement("script");
        naverScript.src =
          "https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js";
        naverScript.type = "text/javascript";
        document.head.appendChild(naverScript);

        // Naver sdk 스크립트 로드 완료시
        naverScript.onload = () => {
          const naverLogin = new window.naver.LoginWithNaverId({
            clientId: "VFMgSLT07NHRL1_Q35Eq",
            callbackUrl: "http://localhost:3000",
            callbackHandle: true,
            isPopup: false, // 로그인 팝업여부
            loginButton: {
              color: "green", // 색상(white, green)
              type: 3, // 버튼타입(1,2,3)
              height: 60, // 배너 및 버튼 높이
            },
          });
          naverLogin.init();
          naverLogin.getLoginStatus((status) => {
            console.log("Naver 로그인 상태" + status);

            if (status) {
              console.log("Naver 로그인 상태", naverLogin.user);
              sessionStorage.setItem("id", naverLogin.user.getEmail());
            }
          });
        };*/
      }
    render() {
        return (
            <div>
                <div className="row">
                    <div className="col-md-4 offset-4">
                        <h3 className="text-center">LOGIN</h3>
                            <button class="w-100 py-2 mb-2 btn btn-outline-success rounded-4" type="submit">
                               <a href="/oauth2/authorization/naver">네이버로그인</a>
                           </button>
                           <button class="w-100 py-2 mb-2 btn btn-outline-warning rounded-4" type="submit">
                               <a href="/oauth2/authorization/kakao">카카오로그인</a>
                           </button>


            		</div>
            	</div>
            </div>
        );
    }
}
export default Login;