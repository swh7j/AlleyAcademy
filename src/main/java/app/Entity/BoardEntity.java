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
public class BoardEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;

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

    @Column(name = "boardCreateTime")
    private Date boardCreateTime;

    @Column(name = "boardUpdateTime")
    private Date boardUpdateTime;

    @ManyToOne @JoinColumn(name = "categoryNo")
    private CategoryEntity categoryEntity;

    @Builder
    public BoardEntity(Integer boardId, String boardTitle, String boardContents, Integer memberNo, Integer boardLike, Integer boardView, Date boardCreateTime, Date boardUpdateTime, CategoryEntity categoryEntity) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.memberNo = memberNo;
        this.boardLike = boardLike;
        this.boardView = boardView;
        this.boardCreateTime = boardCreateTime;
        this.boardUpdateTime = boardUpdateTime;
        this.categoryEntity = categoryEntity;
    }
}
