package app.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryNo;
    
    @Column(name = "b_type")
    private int type;

    /*@OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private List<BoardEntity> b_list = new ArrayList<>();*/
}
