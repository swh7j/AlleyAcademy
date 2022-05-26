package app.Entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board")
@DynamicInsert
@DynamicUpdate
@Setter @Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer b_id;

    @Column(name = "b_type")
    private int type;

    @Column(name = "b_title")
    private String title;

    @Column(name = "b_contents")
    private String contents;

    @Column(name = "m_num")
    private Integer m_num;

    @Column(name = "b_create_time")
    private Date create_time;

    @Column(name = "b_update_time")
    private Date update_time;

    @Column(name = "b_like")
    private Integer b_like;

    @Column(name = "b_view")
    private Integer b_view;

}
