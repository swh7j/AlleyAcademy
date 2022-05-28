package app.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryNo;
    @Column(name="c_type")
    private int categoryType;

/*  @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private List<BoardEntity> boardEntityList = new ArrayList<>();*/
}
