import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class Boardwrite extends Component {

    constructor(props) {
        super(props);

        this.state = {
            no: this.props.match.params.no,
            type: 0,
            title: '',
            contents: '',
            memberNo: ''
        }
        this.changeTypeHandler = this.changeTypeHandler.bind(this);
        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeContentsHandler = this.changeContentsHandler.bind(this);
        this.changeMemberNoHandler = this.changeMemberNoHandler.bind(this);
        this.createBoard = this.createBoard.bind(this);
    }

    changeTypeHandler = (event) => {
        this.setState({type: event.target.value});
    }
    changeTitleHandler = (event) => {
        this.setState({title: event.target.value});
    }
    changeContentsHandler = (event) => {
        this.setState({contents: event.target.value});
    }
    changeMemberNoHandler = (event) => {
        this.setState({memberNo: event.target.value});
    }

    createBoard = (event) => {
        event.preventDefault();
        let board = {
            type: this.state.type,
            title: this.state.title,
            contents: this.state.contents,
            memberNo: this.state.memberNo
        };

        console.log("게시글  => "+ JSON.stringify(board));

        if (this.state.no === '_create') {
            BoardService.createBoard(board).then(res => {
                this.props.history.push('/Boardlist');
                window.location.reload();
            });
        }
        else {
            BoardService.updateBoard(this.state.no, board).then(res => {
                this.props.history.push('/Boardlist');
                window.location.reload();
            });
        }
    }

    cancel() {
        this.props.history.push('/Boardlist');
        window.location.reload();
    }
    componentDidMount() {
        if (this.state.no === '_create') {
            return
        } else {
            BoardService.getOneBoard(this.state.no).then( (res) => {
                let board = res.data;
                console.log("게시글  => "+ JSON.stringify(board));

                this.setState({
                        type: board.type,
                        title: board.title,
                        contents: board.contents,
                        memberNo: board.memberNo
                });
            });
        }
    }
    render() {
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">게시판 글쓰기</h3>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> 카테고리 </label>
                                        <select placeholder="type" name="type" className="form-control"
                                        value={this.state.type} onChange={this.changeTypeHandler}>
                                            <option value="1">공지사항</option>
                                            <option value="2">질문과 답변</option>
                                            <option value="3">일반게시판</option>
                                        </select>
                                    </div>
                                    <div className = "form-group">
                                        <label> 제목 </label>
                                        <input type="text" placeholder="title" name="title" className="form-control"
                                        value={this.state.title} onChange={this.changeTitleHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> 내용  </label>
                                        <textarea placeholder="contents" name="contents" className="form-control"
                                        value={this.state.contents} onChange={this.changeContentsHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> 아이디 (차후에 회원 시스템 대비) </label>
                                        <input placeholder="memberNo" name="memberNo" className="form-control"
                                        value={this.state.memberNo} onChange={this.changeMemberNoHandler}/>
                                    </div>
                                    <button className="btn btn-primary" onClick={this.createBoard}>완료</button>
                                    <button type="button" onClick={this.cancel.bind(this)} class="btn btn-danger menu">취소</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Boardwrite;