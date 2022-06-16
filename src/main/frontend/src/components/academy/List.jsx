import React, { Component } from 'react';
import AcademyService from '../../service/AcademyService';

class List extends Component {

    constructor(props) {
        super(props)
        this.state = {
            p_num: 1,
            paging: {},
            lists:[]
        }
    }

    componentDidMount() {
        AcademyService.getAcademy_list(this.state.p_num).then((res) => {
            this.setState({
                p_num: res.data.pagingData.currentPageNum,
                paging: res.data.pagingData,
                lists: res.data.list
            });
        });
    }

    listAcademy(p_num) {
        console.log("pageNum : "+ p_num);
        AcademyService.getAcademy_list(p_num).then((res) => {
            console.log(res.data);
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
            <a className="page-link" onClick = {() => this.listAcademy(page)}>{page}</a>
        </li>
        ));
    }
    isPagingPrev(){
        if (this.state.paging.prev) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listAcademy( (this.state.paging.currentPageNum - 1) )} tabindex="-1">이전페이지</a>
                </li>
            );
        }
    }

    isPagingNext(){
        if (this.state.paging.next) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listAcademy( (this.state.paging.currentPageNum + 1) )} tabIndex="-1">다음페이지</a>
                </li>
            );
        }
    }

    isMoveToFirstPage() {
        if (this.state.p_num !== 1) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listAcademy(1)} tabIndex="-1">첫페이지</a>
                </li>
            );
        }
    }


    isMoveToLastPage() {
        if (this.state.p_num !== this.state.paging.pageNumCountTotal) {
            return (
                <li className="page-item">
                    <a className="page-link" onClick = {() => this.listAcademy( (this.state.paging.pageNumCountTotal) )} tabIndex="-1">마지막페이지({this.state.paging.pageNumCountTotal})</a>
                </li>
            );
        }
    }
    readAC(no) {
            this.props.history.push(`/DetailAcademy/${no}`);
            window.location.reload();
    }
    render() {
        return (
            <div>
                <h2 className="text-center">학원 목록</h2>
                <div className ="row">
                    <table className="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th> 이름</th>
                                <th> 담당 교육청 </th>
                                <th> 교습과정목록명 </th>
                            </tr>
                        </thead>
                       <tbody>
                        {
                           this.state.lists.map(
                                   (list) =>
                                    <tr key = {list} onClick = {() => this.readAC(list.id)}>
                                       <td> {list.aca_NM} </td>
                                       <td> {list.atpt_OFCDC_SC_NM} </td>
                                       <td> {list.realm_SC_NM} </td>
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
            </div>

        );
    }
}

export default List;