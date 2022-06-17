import React, { Component } from 'react';
import { Carousel } from "react-bootstrap";
import lesson from '../img/main/lesson.png';

import item1 from '../img/main/강남.png';
import item2 from '../img/main/강동.png';
import item3 from '../img/main/강북.png';
import item4 from '../img/main/강서.png';
import item5 from '../img/main/강원도.png';
import item6 from '../img/main/경기도.png';
import item7 from '../img/main/경상도.png';
import item8 from '../img/main/부산.png';
import item9 from '../img/main/인천.png';
import item10 from '../img/main/전라도.png';
import item11 from '../img/main/제주도.png';
import item12 from '../img/main/충청도.png';

class Main extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }
    render() {
        return (

            <div>
             <br></br>
                    <br></br>
                   <div className="one">
                     <h1>우리동네 골목학원</h1>
                   </div>
                        <div className="row my-3">
                             <div className="container h-100">
                               <div className="d-flex justify-content-center h-100">
                                 <div className="searchbar">
                                   <input className="search_input" type="text" name="" placeholder="찾고자하는 지역명을 입력해주세요."/>
                                   <a href="#" className="search_icon"><img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"/></a>
                                 </div>
                               </div>
                             </div>
                        </div>

                <div className="row my-3">

                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item1} />
                            <div className="card-body"> (서울)강남구
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item3} />
                            <div className="card-body"> (서울)강북
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item4} />
                            <div className="card-body"> (서울)강서
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item2} />
                            <div className="card-body"> (서울)강동
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item9} />
                            <div className="card-body"> 인천
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item6} />
                            <div className="card-body"> 경기도
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item8} />
                            <div className="card-body"> 부산
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item12} />
                            <div className="card-body"> 충청도
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item10} />
                            <div className="card-body"> 전라도
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item7} />
                            <div className="card-body"> 경상도
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item5} />
                            <div className="card-body"> 강원도
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item11} />
                            <div className="card-body"> 제주도
                            </div>
                        </div>
                    </div>

                </div>

                <div className="one">
                    <h1> 추천 과목 </h1>
                </div>

                <div className="one">
                    <h1> 문의 하기 </h1>
                </div>
            </div>
        );
    }
}

export default Main;