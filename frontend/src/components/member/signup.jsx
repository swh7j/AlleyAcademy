import React, { Component } from 'react';

class signup extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }
    render() {
        return (
            <div>
                <div className="row">
                    <div className="col-md-4 offset-4">
                        <h3 className="text-center">signup</h3>
                        <div id="signup">
                            <form method="post" name="frm">

                                    회원아이디 : <input type="text" className="memberId"/> <br></br>
                                    회원비밀번호 : <input type="password" className="memberPw"/> <br></br>
                                    비밀번호확인 : <input type="password" className="memberPwConfirm"/><br></br>
                                    회원이름 : <input type="text" className="memberName"/> <br></br>
                                    회원이메일 : <input type="text" className="memberEmail"/> <br></br>
                                    회원나이 : <input type="text" className="memberAge"/> <br></br>
                                    회원연락처 : <input type="text" className="memberPhone"/> <br></br>
                                    회원성별 : <input type="text" className="memberGender"/> <br></br>

                            </form>
                        </div>
            		</div>
            	</div>
            </div>
        );
    }
}
export default signup;