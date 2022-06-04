import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class BoardList extends Component {


    constructor(props) {
        super(props)
        this.state = { lists:[]}
        this.createBoard = this.createBoard.bind(this);
    }

    componentDidMount() {
        BoardService.get_boardlist().then((res) => { this.setState({ lists: res.data }); });
    }
    createBoard() {
        this.props.history.push('/BoardWrite/_create');
        window.location.reload();
    }



    readBoard(no) {
        this.props.history.push(`/ReadBoard/${no}`);
        window.location.reload();
    }
    render() {
        return (
            <div>
                <h2 className="text-center">게시판</h2>
                <div className = "row">
                    <div className = "col-md-11">

                    </div>
                    <div className = "col-md-1">
                          <button className="btn btn-primary menu" onClick={this.createBoard}>글 쓰기</button>
                    </div>
                </div>
                    <table className="table table-striped table-bordered">
                        <thead>
                             <tr>
                                <th>글 번호</th>
                                <th>제목 </th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                       <tbody>
                        {console.log( this.state.lists)}
                           {
                               this.state.lists.map(
                                   (list) =>
                                   <tr key = {list} onClick = {() => this.readBoard(list.boardId)}>
                                       <td> {list.boardId} </td>
                                       <td> {list.boardTitle} </td>
                                       <td> {list.boardView} </td>
                                        {

                                        }
                                   </tr>
                               )
                           }
                       </tbody>
                   </table>
            </div>
        );
    }
}

export default BoardList;