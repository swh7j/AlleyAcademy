import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class ReadBoard extends Component {
    constructor(props) {
        super(props);

        this.state = {
            no: this.props.match.params.no,
            board: {}
        }

    }

    componentDidMount() {
        BoardService.getOneBoard(this.state.no).then( res => {
            this.setState({board: res.data});
        });
    }

    returnBoardType(typeNo) {
        let type = null;
        if (typeNo == 1) {
            type = "자유게시판";

        } else if (typeNo == 2 ) {
            type = "질문과 답변 게시판";

        } else {
            type = "카테고리 미지정";
        }

        return (
            <div className = "row">
                <label> Board Type : </label> {type}
            </div>
        )

    }

    returnDate(cTime, uTime) {
        return (
            <div className = "row">
                <label>생성일 : [ {cTime} ] / 최종 수정일 : [ {uTime} ] </label>
            </div>
        )
    }

    goToList() {
        this.props.history.push('/Boardlist');
        window.location.reload();

    }
     goToUpdate = (event) => {
        event.preventDefault();
        this.props.history.push(`/Boardwrite/${this.state.no}`);
        window.location.reload();
    }
    deleteView = async function () {
        if(window.confirm("정말로 글을 삭제하시겠습니까?")) {
            BoardService.deleteBoard(this.state.no).then( res => {
                console.log("delete result => "+ JSON.stringify(res));
                if (res.status == 200) {
                    this.props.history.push('/Boardlist');
                     window.location.reload();
                } else {
                    alert("글 삭제가 실패했습니다.");
                }
            });

        }
    }
    render() {
        return (
            <div>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className ="text-center"> dd </h3>
                    <div className = "card-body">
                            {this.returnBoardType(this.state.board.type)}
                            <div className = "row">
                                <label> Title </label> : {this.state.board.title}
                            </div>

                            <div className = "row">
                                <label> Contents </label> : <br></br>
                                <textarea value={this.state.board.contents} readOnly/>
                            </div >

                            <div className = "row">
                                <label> MemberNo  </label>:
                                {this.state.board.memberNo}
                            </div>

                            {this.returnDate(this.state.board.createdTime, this.state.board.updatedTime) }
                            <button className="btn btn-danger" onClick={() => this.deleteView()} style={{marginLeft:"10px"}}>삭제</button>
                            <button className="btn btn-info" onClick={this.goToUpdate} style={{marginLeft:"10px"}}>수정</button>
                            <button className="btn btn-primary" onClick={this.goToList.bind(this)} style={{marginLeft:"10px"}}>목록</button>
                    </div>
                </div>

            </div>
        );
    }
}

export default ReadBoard;