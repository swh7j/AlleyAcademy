package app.Entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@Entity @Table(name = "board")
@Setter @Getter @Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNo;

    @Column(name = "categoryType")
    private int categoryType;

    @Column(name = "boardTitle")
    private String boardTitle;

    @Column(name = "boardContents")
    private String boardContents;

    @Column(name = "boardImg")
    private String boardImg;

    @Column(name = "memberNo")
    private int memberNo;

    @Column(name = "boardlike")
    private int boardlike;

    @Column(name = "boardview")
    private int boardview;


    @ManyToOne @JoinColumn(name = "cateno")
    private CategoryEntity categoryEntity;


}
