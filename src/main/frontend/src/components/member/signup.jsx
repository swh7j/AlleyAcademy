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

                                    회원아이디 : <input id ="id_val" type="text" className="memberId"/> <br></br>
                                    회원비밀번호 : <input  id ="pw_val"type="password" className="memberPw"/> <br></br>
                                    비밀번호확인 : <input  id ="pwc_val"type="password" className="memberPwConfirm"/><br></br>
                                    회원이름 : <input  id ="name_val"type="text" className="memberName"/> <br></br>
                                    회원이메일 : <input  id ="email_val"type="text" className="memberEmail"/> <br></br>
                                    회원나이 : <input  id ="age_val"type="text" className="memberAge"/> <br></br>
                                    회원연락처 : <input  id ="phone_val"type="text" className="memberPhone"/> <br></br>
                                    회원성별 : <input  id ="gender_val"type="text" className="memberGender"/> <br></br>
                               <input id="formsubmit" type="button" class="btn btn-warning p-2 my-2"  style="float: right; width:100px;" value="Signup"/>



                            </form>
                        </div>
            		</div>
            	</div>
            </div>
        );
    }
}
export default signup;