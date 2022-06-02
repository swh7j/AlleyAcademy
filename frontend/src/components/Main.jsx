import React, { Component } from 'react';
import { Carousel } from "react-bootstrap";
import main1 from '../img/main_1.png';
import main2 from '../img/main_2.png';
import main3 from '../img/main_3.png';
import main4 from '../img/main_4.png';
import main5 from '../img/main_5.png';
import lesson from '../img/lesson.png';
import item from '../img/icon.png';

class Main extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div>
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
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> (서울)강남구
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> (서울)강북
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> (서울)강서
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> (서울)강동
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> 인천
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> 경기도
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> 부산
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> 충청도
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> 전라도
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> 경상도
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
                                                    <div className="card-body"> 강원도
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-1 col-sm-6 col  item2">
                                                <div className="card border-white">
                                                    <img className="car-img-top" alt="" src={item} />
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