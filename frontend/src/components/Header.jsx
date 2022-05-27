import React, { Component } from 'react';
import logo from '../img/logo.png';

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark">
                       <div className="container">
                               <div className="my-3 row header my-4">
                                   <div className="col-md-6 row">
                                       <div className="col-md-4">
                                           <a href="/"> <img src={logo} alt="logo" style={{'width':'50%', 'margin-left':'50px'}}></img></a>
                                       </div>
                                       <div className="col-md-8 search_box">
                                           <input type="text" placeholder="검색창" autocomplete="auto" class="form-control search"></input>
                                       </div>
                                   </div>
                                   <div className="col-md-6 d-flex justify-content-end header_menu">
                                       <span><a href="/list"><button type="button" class="btn menu">학원찾기 </button></a></span>
                                       <span><a href="/postlist"><button type="button" class="btn menu">게시판Test</button> </a></span>
                                       <span><a href="/boardlist"><button type="button" class="btn menu">게시판</button> </a></span>
                                       <span><button type="button" class="btn menu">로그인</button></span>
                                       <span><button type="button" class="btn menu">회원가입</button></span>
                                       <span> <button type="button" class="btn up menu"   style={{'background-color' : '#9AF0B2'}}>학원등록</button> </span>
                                   </div>
                               </div>
                           </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;