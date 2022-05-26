import React, { Component } from 'react';
import AcademyService from '../service/AcademyService';
import Map from '../components/Map';

class DetailAcademy extends Component {

    constructor(props) {
        super(props);
        this.state = {
            no: this.props.match.params.no,
            list: {},
        }
    }

    componentDidMount() {
        AcademyService.getOneAcademy(this.state.no).then( res => {
            this.setState({list: res.data});
        });
    }

    goToList() {
        this.props.history.push('/list');
        window.location.reload();
    }

    render() {
        return (
            <div>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className ="text-center"> dd </h3>
                    <div className = "card-body">
                            <div className = "row">
                                <label> Title </label> : {this.state.list.aca_NM}
                            </div>
                            <button className="btn btn-primary" onClick={this.goToList.bind(this)} style={{marginLeft:"10px"}}>학원목록</button>
                    </div>
                </div>

            </div>
        );
    }

}
export default DetailAcademy;