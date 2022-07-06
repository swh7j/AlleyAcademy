/* global kakao */
import React, { Component   } from 'react';
import { useParams } from 'react-router-dom';
import AcademyService from '../../service/AcademyService';
import MapContainer from "../kakaoMap/MapContainer";

class DetailAcademy extends Component {

    constructor(props) {
        super(props);
        this.state = {
            no: withParams(),
            list: {},
        }
    }

    componentDidMount() {
        AcademyService.getOneAcademy(this.state.id).then( res => {
            this.setState({list: res.data});
        });

    }

    goToList() {
        this.props.history.push('/main');
        window.location.reload();
    }

    render() {
        return (

            <div>
                <div className = "">
                    <h3 className ="text-center"> {this.state.list.aca_NM} </h3>
                    <div className="row">
                        <div className="col-md-8">
                           <MapContainer searchPlace={this.state.list} />
                        </div>
                        <div className="col-md-4">
                            <button className="btn btn-primary" onClick={this.goToList.bind(this)} style={{marginLeft:"10px"}}>학원목록</button>
                            <button className="btn btn-primary" onClick={this.goToList.bind(this)} style={{marginLeft:"10px"}}>글작성</button>
                            <table className="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>글 번호</th>
                                    <th>제목 </th>
                                    <th>작성일 </th>
                                    <th>조회수</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>

                        </div>

                    </div>
                </div>

            </div>
        );
    }

}
export default DetailAcademy;