package app.Entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@Entity @Table(name = "board")
@Setter @Getter
@ToString(exclude ="categoryEntity")
@NoArgsConstructor
public class BoardEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    @Column(name = "boardTitle")
    private String boardTitle;

    @Column(name = "boardContents")
    private String boardContents;

    @Column(name = "memberNo")
    private Integer memberNo;

    @Column(name = "boardLike")
    private Integer boardLike;

    @Column(name = "boardView")
    private Integer boardView;


    @ManyToOne @JoinColumn(name = "categoryNo")
    private CategoryEntity categoryEntity;

    @Builder
    public BoardEntity(Integer bid, String boardTitle, String boardContents, Integer memberNo, Integer boardLike, Integer boardView, CategoryEntity categoryEntity) {
        this.bid = bid;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.memberNo = memberNo;
        this.boardLike = boardLike;
        this.boardView = boardView;
        this.categoryEntity = categoryEntity;
    }
}