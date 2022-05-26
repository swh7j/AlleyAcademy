import React, { Component } from 'react';
import { Carousel } from "react-bootstrap";
import main1 from '../img/main_1.png';
import main2 from '../img/main_2.png';
import main3 from '../img/main_3.png';
import main4 from '../img/main_4.png';
import main5 from '../img/main_5.png';
import lesson from '../img/lesson.png';
import item from '../img/item.png';

class Main extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div className="container text-center">
                <div className = "ROW">
                    <Carousel>
                      <Carousel.Item>
                         <img src={main1} alt="1" style={{'width':'80%'}} />
                      </Carousel.Item>
                      <Carousel.Item>
                         <img src={main2} alt="2" style={{'width':'80%'}} />
                      </Carousel.Item>
                      <Carousel.Item>
                         <img src={main3} alt="3" style={{'width':'80%'}} />
                      </Carousel.Item>
                      <Carousel.Item>
                         <img src={main4} alt="4" style={{'width':'80%'}} />
                      </Carousel.Item>
                      <Carousel.Item>
                        <img src={main5} alt="5" style={{'width':'80%'}} />
                        </Carousel.Item>
                    </Carousel>
                    <button className="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
                        <span className="carousel-control-prev-icon"></span>
                    </button>

                    <button className="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
                        <span className="carousel-control-next-icon"></span>
                    </button>
                </div>
                <br/>
                <br/>
                <div>
                    <h2 style={{'font-weight':'bold'}} className="">지금 바로 원하는 학원을 찾아보세요!</h2>
                </div>
                <br/>
                 <br/>
                <div className="row">
                    <div className="col-md-3 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item} />
                            <div className="card-body">
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3 col-sm-6 col  item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item} />
                            <div className="card-body">
                                <p className="item">
                                    <span> 서버 배우기 </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3 col-sm-6 col item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item} />
                            <div className="card-body">
                                <p className="item">
                                    <span> 서버 배우기 </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3 col-sm-6 col item2">
                        <div className="card border-white">
                            <img className="car-img-top" alt="" src={item} />
                            <div className="card-body">
                                <p className="item">
                                    <span> 서버 배우기 </span>
                                </p>
                                <p className="item">
                                    <span style={{'font-weight':'bold'}}>  10,000원 </span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        );
    }
}

export default Main;