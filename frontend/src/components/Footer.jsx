import React, { Component } from 'react';

class FooterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div>
                <hr></hr>
                <footer className="footer">
                    <div className="container">
                           <div className="row py-2">
                               <div className="col-md-4">
                                   <div> <p style={{'font-weight' : 'bold', 'color': '#9AF0B2','font-size':'25px'}}>1234-1234</p> </div>
                                   <div> 평일 10:00 ~ 18:00 <br></br> (점심시간 13:00 ~ 14:00 제외 ◈ 주말 공휴일 제외) </div>
                                   <div className="nav text-center my-3">
                                       <div className="download col-md-4 offset-1 " > <i className="fab fa-google"></i>Download</div>
                                       <div className="download col-md-4 offset-1"> <i className="fab fa-google"></i>Download</div>
                                   </div>
                               </div>
                               <div className="col-md-4 offset-4 nav noti my-2">
                                   <div className="col-md-3">
                                       <ul>
                                           <li style={{'font-weight' : 'bold', 'font-decoration' : 'none'}}>고객센터</li>
                                           <li>고객센터</li>
                                           <li>고객센터</li>
                                       </ul>
                                   </div>
                                   <div className="col-md-3">
                                       <ul>
                                           <li style={{'font-weight' : 'bold', 'font-decoration' : 'none'}}>고객센터</li>
                                           <li>고객센터</li>
                                           <li>고객센터</li>
                                       </ul>
                                   </div>
                                   <div className="col-md-3">
                                       <ul>
                                           <li style={{'font-weight' : 'bold', 'font-decoration' : 'none'}}>고객센터</li>
                                           <li>고객센터</li>
                                           <li>고객센터</li>
                                       </ul>
                                   </div>
                                   <div className="col-md-3">
                                       <ul>
                                          <li style={{'font-weight' : 'bold', 'font-decoration' : 'none'}}>고객센터</li>
                                           <li>고객센터</li>
                                           <li>고객센터</li>
                                       </ul>
                                   </div>
                               </div>
                           </div>
                           <div className="row">
                               <div className="col-md-9">
                                   <div className="nav">
                                       <ul className="nav mx-2">
                                           <li >이용약관</li>
                                           <li style={{'font-weight' : 'bold', 'font-decoration' : 'none'}}>개인정보 처리방침</li>
                                           <li style={{'font-weight' : 'bold', 'font-decoration' : 'none'}}>사업자 정보관리</li>
                                       </ul>
                                   </div>
                                   <div className="nav">
                                       <ul className="nav mx-2">
                                           <li >이용약관</li>
                                           <li style={{'margin-left':'40px'}}>개인정보 처리방침</li>
                                           <li style={{'margin-left':'40px'}}>사업자 정보관리</li>
                                       </ul>
                                   </div>
                               </div>
                               <div className="col-md-3">
                                   <div className="nav">
                                       <ul className="nav mx-2">
                                           <li style={{'margin-right':'10px'}}><i className="fab fa-google fa-2x"></i></li>
                                           <li><i className="fab fa-google fa-2x"></i></li>
                                           <li style={{'margin-right':'10px'}}><i className="fab fa-google fa-2x"></i></li>
                                       </ul>
                                   </div>
                               </div>
                           </div>
                       </div>
                </footer>
            </div>
        );
    }
}

export default FooterComponent;