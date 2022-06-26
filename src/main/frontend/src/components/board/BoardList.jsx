import React, { Component } from 'react';
import BoardService from '../../service/BoardService';

class BoardList extends Component {


    constructor(props) {
        super(props)
        this.state = {
            p_num: 1,
            paging: {},
            lists:[]
        }
        this.createBoard = this.createBoard.bind(this);
    }

    componentDidMount() {
        BoardService.get_boardlist(this.state.p_num).then((res) => {
            this.setState({
                p_num: res.data.pagingData.currentPageNum,
                paging: res.data.pagingData,
                lists: res.data.list
            });
        });
    }
    listBoard(p_num) {
        BoardService.get_boardlist(p_num).then((res) => {
            this.setState({
                p_num: res.data.pagingData.currentPageNum,
                paging: res.data.pagingData,
                lists: res.data.list
            });
        });
    }
    viewPaging() {
        const pageNums = [];

        for (let i = this.state.paging.pageNumStart; i <= this.state.paging.pageNumEnd; i++ ) {
            pageNums.push(i);
        }

        return (pageNums.map((page) =>
        <li className="page-item" key={page.toString()} >
            <a className="page-link" onClick = {() => this.listBoard(page)}>{page}</a>
        </li>
        ));
    }
    isPagingPrev(){
        if (this.state.paging.prev) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listBoard( (this.state.paging.currentPageNum - 1) )} tabindex="-1">이전페이지</a>
                </li>
            );
        }
    }

    isPagingNext(){
        if (this.state.paging.next) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listBoard( (this.state.paging.currentPageNum + 1) )} tabIndex="-1">다음페이지</a>
                </li>
            );
        }
    }

    isMoveToFirstPage() {
        if (this.state.p_num !== 1) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listBoard(1)} tabIndex="-1">첫페이지</a>
                </li>
            );
        }
    }


    isMoveToLastPage() {
        if (this.state.p_num !== this.state.paging.pageNumCountTotal) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listBoard( (this.state.paging.pageNumCountTotal) )} tabIndex="-1">마지막페이지({this.state.paging.pageNumCountTotal})</a>
                </li>
            );
        }
    }
    createBoard() {
        window.location.href='/Boardwrite/_create';
    }
    readBoard(no) {
        this.props.navigate.push(`/Readboard/${no}`);
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
                                <th>작성일 </th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                       <tbody>
                           {
                               console.log(this.state.lists) }{
                               this.state.lists.map(
                                   (list) =>
                                 <tr key = {list} onClick = {() => this.readBoard(list.bid)}>
                                    <td> {list.bid} </td>
                                    <td> {list.boardTitle} </td>
                                     <td> {list.createTime} </td>
                                    <td> {list.boardView} </td>
                                </tr>
                               )
                           }
                       </tbody>
                   </table>
                   <nav aria-label="Page navigation example">
                      <ul className="pagination justify-content-center">
                          {
                              this.isMoveToFirstPage()
                          }
                          {
                              this.isPagingPrev()
                          }
                          {
                              this.viewPaging()
                          }
                          {
                              this.isPagingNext()
                          }
                          {
                              this.isMoveToLastPage()
                          }
                      </ul>
                  </nav>
            </div>
        );
    }
}

export default BoardList;