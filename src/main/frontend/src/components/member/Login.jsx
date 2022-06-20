import React, { Component } from 'react';
import { withRouter, Link } from 'react-router-dom';


class Login extends Component {

     goToMain = () => {
        this.props.history.push('/main');
      };
constructor() {
      constructor(props){
        super(props);
        this.state = {
          memberId: '',
          memberPw: '',
        };


    handleInput = e => {
      const { name, value } = e.target;
      this.setState({
        [name] : value
      });
    };
};

    render(){
    const { memberId, memberPw } = this.state;
          const checkId = /^\w[\w\-.]*@\w+\.\w{2,}/;
        return (
            <div>
                <div className="row">
                    <div className="col-md-4 offset-4">
                        <h3 className="text-center">LOGIN</h3>
                            <button class="w-100 py-2 mb-2 btn btn-outline-success rounded-4">
                               <a href="/oauth2/authorization/naver">네이버로그인</a>
                           </button>
                           <button class="w-100 py-2 mb-2 btn btn-outline-warning rounded-4" >
                               <a href="/oauth2/authorization/kakao">카카오로그인</a>
                           </button>
                         <form className="login-form">
                          <div className="login-form__input-box">
                            <input
                              type="text" name="memberId"
                              value={memberId} onChange={this.handleInput.bind(this)}
                              placeholder="전화번호, 사용자 이름 또는 이메일"/>
                            <input
                              type="password" name="memberPw"
                              value={memberPw} onChange={this.handleInput.bind(this)}
                              placeholder="비밀번호"/>
                          </div>
                            <button
                               type="button"
                               onClick={this.goToMain}
                           disabled={!(checkId.test(memberId) && memberPw.length > 5)}
                             ></button>
                        </form>

            		</div>
            	</div>
            </div>
    );
   }
 }

export default withRouter(Login);