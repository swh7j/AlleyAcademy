import React, { Component } from 'react';
import logo from '../img/logo.png';
import { Navbar } from "react-bootstrap";
import { Container } from "react-bootstrap";
import { Nav } from "react-bootstrap";
import { NavDropdown } from "react-bootstrap";
import main5 from '../img/main_5.png';

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }
    render() {
        const imgsize = {
            height: "60px"
        }
        return (
            <div>
                <header>
                   <Navbar collapseOnSelect expand="sm" bg="white" variant="light" fixed="top"  >
                     <Container>
                     <Navbar.Brand href="#home" className="me-5"> <img style={imgsize} src={logo}/> </Navbar.Brand>
                     <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                     <Navbar.Collapse id="responsive-navbar-nav">
                       <Nav className="me-auto">

                         <NavDropdown className="mx-1" title={ <div className="my-auto"> <div><h5>입시</h5></div> <div> 유 / 초 / 중 / 고 </div> </div>  } >
                           <NavDropdown.Item href="/list">학원목록</NavDropdown.Item>
                           <NavDropdown.Item href="/boardlist">게시판</NavDropdown.Item>
                           <NavDropdown.Item href="#">중학생</NavDropdown.Item>
                           <NavDropdown.Item href="#">고등학생</NavDropdown.Item>
                         </NavDropdown>

                          <NavDropdown className="mx-1" title={ <div className="my-auto"> <div><h5>취업</h5></div> <div> IT / 자격증 / 직업훈련 외 </div> </div>  } >
                            <NavDropdown.Item href="#">유치원생</NavDropdown.Item>
                            <NavDropdown.Item href="#">초등학생</NavDropdown.Item>
                            <NavDropdown.Item href="#">중학생</NavDropdown.Item>
                            <NavDropdown.Item href="#">고등학생</NavDropdown.Item>
                          </NavDropdown>

                         <NavDropdown className="mx-1" title={ <div className="my-auto"> <div><h5>취미</h5></div> <div> 운동 / 미술 / 음악 외 </div> </div>  } >
                           <NavDropdown.Item href="#">유치원생</NavDropdown.Item>
                           <NavDropdown.Item href="#">초등학생</NavDropdown.Item>
                           <NavDropdown.Item href="#">중학생</NavDropdown.Item>
                           <NavDropdown.Item href="#">고등학생</NavDropdown.Item>
                         </NavDropdown>

                         <NavDropdown  className="mx-1" title={ <div className="my-auto"> <div><h5>공무원</h5></div> <div> 고시 / 행정 / 소방 외  </div> </div>  } >
                           <NavDropdown.Item href="#">유치원생</NavDropdown.Item>
                           <NavDropdown.Item href="#">초등학생</NavDropdown.Item>
                           <NavDropdown.Item href="#">중학생</NavDropdown.Item>
                           <NavDropdown.Item href="#">고등학생</NavDropdown.Item>
                         </NavDropdown>

                       </Nav>

                       <Nav>
                         <Nav.Link href="/Login"> 로그인 </Nav.Link>
                         <a href="/oauth2/authorization/naver">네이버로그인</a>
                         <a href="/oauth2/authorization/kakao">카카오로그인</a>
                          <Nav.Link href="/signup"> 회원가입 </Nav.Link>
                         <Nav.Link eventKey={2} href="#memes"> 고객센터 </Nav.Link>
                         <Nav.Link eventKey={2} href="#memes"> 학원센터 </Nav.Link>
                       </Nav>
                     </Navbar.Collapse>
                     </Container>
                   </Navbar>
                </header>
                 <br></br>
                 <br></br>
                 <div className="mainimg">
                        <img src={main5} alt="5" style={{'width':'100%'}} />
                 </div>


            </div>
        );
    }
}

export default HeaderComponent;