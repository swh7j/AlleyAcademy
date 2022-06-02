package app.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Integer boardId;

    private int boardType;

    private String boardTitle;

    private String boardContents;

    private Integer memberNo;

    private Integer boardLike;

    private Integer boardView;

    private Integer categoryNo;
}