package app.Entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@Entity @Table(name = "board")
@Setter @Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer b_id;

    @Column(name = "b_type")
    private int type;

    @Column(name = "b_title")
    private String title;

    @Column(name = "b_contents")
    private String contents;

    @Column(name = "memberNo")
    private Integer memberNo;


    @Column(name = "b_like")
    private Integer b_like;

    @Column(name = "b_view")
    private Integer b_view;


   /* @ManyToOne @JoinColumn(name = "categoryNo")
    private CategoryEntity categoryEntity;*/
}
